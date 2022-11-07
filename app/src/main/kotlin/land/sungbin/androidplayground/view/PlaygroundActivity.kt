@file:Suppress(
    "MayBeConstant", "UNUSED_ANONYMOUS_PARAMETER", "UNUSED_VARIABLE",
    "KotlinRedundantDiagnosticSuppress", "UnnecessaryOptInAnnotation"
)
@file:NoLiveLiterals
@file:OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialApi::class)

package land.sungbin.androidplayground.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExplicitGroupsComposable
import androidx.compose.runtime.NoLiveLiterals
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoroutineScopeContent {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            launch {
                                suspend {
                                    // Do something
                                }.invoke()
                            }
                        },
                )
            }
        }
    }
}

@Composable
fun Screen(vm: AwesomeViewModel) = CoroutineScopeContent {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                launch {
                    suspend {
                        // Do something
                    }.invoke()
                }
            },
    )
}

interface CoroutineScopeContent {
    val coroutineScope: CoroutineScope
}

@Suppress("NOTHING_TO_INLINE")
inline fun CoroutineScopeContent.launch(noinline action: suspend CoroutineScope.() -> Unit): Job {
    return coroutineScope.launch(block = action)
}

@Composable
@ExplicitGroupsComposable
inline fun CoroutineScopeContent(
    content: @Composable CoroutineScopeContent.() -> Unit,
) {
    object : CoroutineScopeContent {
        override val coroutineScope = rememberCoroutineScope()
    }.content()
}
