@file:OptIn(
  ExperimentalTextApi::class,
  ExperimentalFoundationApi::class
)
@file:NoLiveLiterals
@file:Suppress(
  "LocalVariableName",
  "UNUSED_VARIABLE",
  "KotlinRedundantDiagnosticSuppress",
  "UnnecessaryOptInAnnotation",
)

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.unit.Constraints

/**
 * This IR Transform is responsible for the main transformations of the body of a composable
 * function.
 *
 * 1. Control-Flow Group Generation
 * 2. Default arguments
 * 3. Composable Function Skipping
 * 4. Comparison Propagation
 * 5. Recomposability
 * 6. Source location information (when enabled)
 *
 * Control-Flow Group Generation
 * =============================
 *
 * This transform will insert groups inside of the bodies of Composable functions
 * depending on the control-flow structures that exist inside of them.
 *
 * There are 3 types of groups in Compose:
 *
 * 1. Replaceable Groups
 * 2. Movable Groups
 * 3. Restart Groups
 *
 * Generally speaking, every composable function *must* emit a single group when it executes.
 * Every group can have any number of children groups. Additionally, we analyze each executable
 * block and apply the following rules:
 *
 * 1. If a block executes exactly 1 time always, no groups are needed
 * 2. If a set of blocks are such that exactly one of them is executed exactly once (for example,
 * the result blocks of a when clause), then we insert a replaceable group around each block.
 * 3. A movable group is only needed if the immediate composable call in the group has a Pivotal
 * property.
 *
 * Default Arguments
 * =================
 *
 * Composable functions need to have the default expressions executed inside of the group of the
 * function. In order to accomplish this, composable functions handle default arguments
 * themselves, instead of using the default handling of kotlin. This is also a win because we can
 * handle the default arguments without generating an additional function since we do not need to
 * worry about callers from java. Generally speaking though, compose handles default arguments
 * similarly to kotlin in that we generate a $default bitmask parameter which maps each parameter
 * index to a bit on the int. A value of "1" for a given parameter index indicated that that
 * value was *not* provided at the callsite, and the default expression should be used instead.
 *
 *     @Composable fun A(x: Int = 0) {
 *       f(x)
 *     }
 *
 * gets transformed into
 *
 *     @Composable fun A(x: Int, $default: Int) {
 *       val x = if ($default and 0b1 != 0) 0 else x
 *       f(x)
 *     }
 *
 * Note: This transform requires [ComposerParamTransformer] to also be run in order to work
 * properly.
 *
 * Composable Function Skipping
 * ============================
 *
 * Composable functions can "skip" their execution if certain conditions are met. This is done by
 * appealing to the composer and storing previous values of functions and determining if we can
 * skip based on whether or not they have changed.
 *
 *     @Composable fun A(x: Int) {
 *       f(x)
 *     }
 *
 * gets transformed into
 *
 *     @Composable fun A(x: Int, $composer: Composer<*>, $changed: Int) {
 *       var $dirty = $changed
 *       if ($changed and 0b0110 === 0) {
 *         $dirty = $dirty or if ($composer.changed(x)) 0b0010 else 0b0100
 *       }
 *      if (%dirty and 0b1011 !== 0b1010 || !$composer.skipping) {
 *        f(x)
 *      } else {
 *        $composer.skipToGroupEnd()
 *      }
 *     }
 *
 * Note that this makes use of bitmasks for the $changed and $dirty values. These bitmasks work
 * in a different bit-space than the $default bitmask because three bits are needed to hold the
 * six different possible states of each parameter. Additionally, the lowest bit of the bitmask
 * is a special bit which forces execution of the function.
 *
 * This means that for the ith parameter of a composable function, the bit range of i*3 + 1 to
 * i*3 + 3 are used to store the state of the parameter.
 *
 * The states are outlines by the [ParamState] class.
 *
 * Comparison Propagation
 * ======================
 *
 * Because we detect changes in parameters of composable functions and have that data available
 * in the body of a composable function, if we pass values to another composable function, it
 * makes sense for us to pass on whatever information about that value we can determine at the
 * time. This type of propagation of information through composable functions is called
 * Comparison Propagation.
 *
 * Essentially, this comes down to us passing in useful values into the `$changed` parameter of
 * composable functions.
 *
 * When a composable function executes, we have the current known states of all of the function's
 * parameters in the $dirty variable. We can take bits off of this variable and pass them into a
 * composable function in order to tell that function what we know.
 *
 *     @Composable fun A(x: Int) {
 *       B(x, 123)
 *     }
 *
 * gets transformed into
 *
 *     @Composable fun A(x: Int, $composer: Composer<*>, $changed: Int) {
 *       var $dirty = ...
 *       // ...
 *       B(
 *           x,
 *           123,
 *           $composer,
 *           (0b110 and $dirty) or   // 1st param has same state that our 1st param does
 *           0b11000                 // 2nd parameter is "static"
 *       )
 *     }
 *
 * Recomposability
 * ===============
 *
 * Restartable composable functions get wrapped with "restart groups". Restart groups are like
 * other groups except the end call is more complicated, as it returns a null value if and
 * only if a subscription to that scope could not have occurred. If the value returned is
 * non-null, we generate a lambda that teaches the runtime how to "restart" that group. At a high
 * level, this transform comes down to:
 *
 *     @Composable fun A(x: Int) {
 *       f(x)
 *     }
 *
 * getting transformed into
 *
 *     @Composable fun A(x: Int, $composer: Composer<*>, $changed: Int) {
 *       $composer.startRestartGroup()
 *       // ...
 *       f(x)
 *       $composer.endRestartGroup()?.updateScope { next -> A(x, next, $changed or 0b1) }
 *     }
 *
 * Source information
 * ==================
 * To enable Android Studio and similar tools to inspect a composition, source information is
 * optionally generated into the source to indicate where call occur in a block. The first group
 * of every function is also marked to correspond to indicate that the group corresponds to a call
 * and the source location of the caller can be determined from the containing group.
 */
class PlaygroundActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Layout(
        modifier = Modifier.fillMaxWidth(),
        content = {
          Box(
            Modifier
              .layoutId("A")
              .background(color = Color(0xFFF6CD91)),
          )
          Box(
            Modifier
              .layoutId("B")
              .background(color = Color(0xFFFCEA2B))
          )
          Box(
            Modifier
              .layoutId("C")
              .background(color = Color(0xFF9747FF)),
          )
          Box(
            Modifier
              .layoutId("D")
              .background(color = Color(0xFFFF8800)),
          )
          Box(
            Modifier
              .layoutId("Center")
              .background(color = Color(0xFFFC1B1B)),
          )
        },
      ) { measurables, constraints ->
        val A = measurables.first { it.layoutId == "A" }
        val B = measurables.first { it.layoutId == "B" }
        val C = measurables.first { it.layoutId == "C" }
        val D = measurables.first { it.layoutId == "D" }
        val Center = measurables.first { it.layoutId == "Center" }

        val maxWidth = constraints.maxWidth
        val centerWidth = maxWidth / 5

        val centerConstraints = Constraints.fixed(width = centerWidth, height = centerWidth)

        val aConstraints = Constraints.fixed(width = centerWidth * 3, height = centerWidth * 2)
        val bConstraints = Constraints.fixed(width = centerWidth * 2, height = centerWidth * 3)
        val cConstraints = Constraints.fixed(width = centerWidth * 3, height = centerWidth * 2)
        val dConstraints = Constraints.fixed(width = centerWidth * 2, height = centerWidth * 3)

        val aPlaceable = A.measure(aConstraints)
        val bPlaceable = B.measure(bConstraints)
        val cPlaceable = C.measure(cConstraints)
        val dPlaceable = D.measure(dConstraints)
        val centerPlaceable = Center.measure(centerConstraints)

        layout(width = maxWidth, height = maxWidth) {
          aPlaceable.place(x = 0, y = 0)
          bPlaceable.place(x = centerWidth * 3, y = 0)
          cPlaceable.place(x = centerWidth * 2, y = centerWidth * 3)
          dPlaceable.place(x = 0, y = centerWidth * 2)
          centerPlaceable.place(x = centerWidth * 2, y = centerWidth * 2)
        }
      }
    }
  }
}

@Composable
fun Test() {
  BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
    constraints
  }
}

// [Composition] Measurement -> Placement -> Laid out
// Recomposition: Composition 한번 더 + 위치 메모이제이션 + 명득성

// [Measurement] measurable, constraints
// 컴포저블이 어떻게 그려질지 제약 사항을 전달하는 단계
// measurable: 아직 제약 사항이 전달되지 않은 컴포저블 노드
// constraints: 제약 사항, 내 컴포저블이 UI에 어떻게 그려져야 하는지를 나타냄

// [Placement] placeable
// placeable: 제약 사항이 전달된 measurable

// [Laid out]
// placeable을 실제 좌표에 배치함
// Compose UI에서 모든 좌표는 TopStart를 기준으로 함
