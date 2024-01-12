@file:Suppress("KDocUnresolvedReference", "SpellCheckingInspection")

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableLongState
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember

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
ㅌ * handle the default arguments without generating an additional function since we do not need to
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
      val ms = remember { mutableLongStateOf(System.currentTimeMillis()) }
      Content(ms)
    }
  }
}

/*
{ // BLOCK
  { // BLOCK
    val tmp0_safe_receiver: ScopeUpdateScope? = $composer.endRestartGroup()
    when {
      EQEQ(arg0 = tmp0_safe_receiver, arg1 = null) -> null
      else -> tmp0_safe_receiver.updateScope(block = local fun <anonymous>($composer: Composer?, $force: Int) {
        return Content(ms = ms, $composer = $composer, $changed = updateChangedFlags(flags = $changed.or(other = 1)))
      })
    }
  }
}

BLOCK type=kotlin.Unit origin=null
  BLOCK type=kotlin.Unit origin=SAFE_CALL
    VAR IR_TEMPORARY_VARIABLE name:tmp0_safe_receiver type:androidx.compose.runtime.ScopeUpdateScope? [val]
      CALL 'public abstract fun endRestartGroup (): androidx.compose.runtime.ScopeUpdateScope? declared in androidx.compose.runtime.Composer' type=androidx.compose.runtime.ScopeUpdateScope? origin=null
        $this: GET_VAR '$composer: androidx.compose.runtime.Composer? [assignable] declared in land.sungbin.androidplayground.Content' type=androidx.compose.runtime.Composer? origin=null
    WHEN type=kotlin.Unit origin=IF
      BRANCH
        if: CALL 'public final fun EQEQ (arg0: kotlin.Any?, arg1: kotlin.Any?): kotlin.Boolean declared in kotlin.internal.ir' type=kotlin.Boolean origin=null
          arg0: GET_VAR 'val tmp0_safe_receiver: androidx.compose.runtime.ScopeUpdateScope? [val] declared in land.sungbin.androidplayground.Content' type=androidx.compose.runtime.ScopeUpdateScope? origin=null
          arg1: CONST Null type=kotlin.Any? value=null
        then: CONST Null type=kotlin.Any? value=null
      BRANCH
        if: CONST Boolean type=kotlin.Boolean value=true
        then: CALL 'public abstract fun updateScope (block: kotlin.Function2<androidx.compose.runtime.Composer, kotlin.Int, kotlin.Unit>): kotlin.Unit declared in androidx.compose.runtime.ScopeUpdateScope' type=kotlin.Unit origin=null
          $this: GET_VAR 'val tmp0_safe_receiver: androidx.compose.runtime.ScopeUpdateScope? [val] declared in land.sungbin.androidplayground.Content' type=androidx.compose.runtime.ScopeUpdateScope? origin=null
          block: FUN_EXPR type=kotlin.Function2<androidx.compose.runtime.Composer?, kotlin.Int, kotlin.Unit> origin=LAMBDA
            FUN LOCAL_FUNCTION_FOR_LAMBDA name:<anonymous> visibility:local modality:FINAL <> ($composer:androidx.compose.runtime.Composer?, $force:kotlin.Int) returnType:kotlin.Unit
              VALUE_PARAMETER name:$composer index:0 type:androidx.compose.runtime.Composer?
              VALUE_PARAMETER name:$force index:1 type:kotlin.Int
              BLOCK_BODY
                RETURN type=kotlin.Nothing from='local final fun <anonymous> ($composer: androidx.compose.runtime.Composer?, $force: kotlin.Int): kotlin.Unit declared in land.sungbin.androidplayground.Content'
                  CALL 'public final fun Content (ms: androidx.compose.runtime.MutableLongState, $composer: androidx.compose.runtime.Composer?, $changed: kotlin.Int): kotlin.Unit declared in land.sungbin.androidplayground' type=kotlin.Unit origin=null
                    ms: GET_VAR 'ms: androidx.compose.runtime.MutableLongState declared in land.sungbin.androidplayground.Content' type=androidx.compose.runtime.MutableLongState origin=null
                    $composer: GET_VAR '$composer: androidx.compose.runtime.Composer? declared in land.sungbin.androidplayground.Content.<anonymous>' type=androidx.compose.runtime.Composer? origin=null
                    $changed: CALL 'internal final fun updateChangedFlags (flags: kotlin.Int): kotlin.Int declared in androidx.compose.runtime.RecomposeScopeImplKt' type=kotlin.Int origin=null
                      flags: CALL 'public final fun or (other: kotlin.Int): kotlin.Int [infix] declared in kotlin.Int' type=kotlin.Int origin=null
                        $this: GET_VAR '$changed: kotlin.Int declared in land.sungbin.androidplayground.Content' type=kotlin.Int origin=null
                        other: CONST Int type=kotlin.Int value=1
 */

@Composable
fun Content(ms: MutableLongState) {
  Button(onClick = { ms.longValue = System.currentTimeMillis() }) {}
  Display(text = ms.longValue.toString())
}

@Composable
private fun Display(text: String) {
  Text(text = text)
}
