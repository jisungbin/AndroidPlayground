package land.sungbin.androidplayground

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf

/*
@Metadata(
    mv = {1, 7, 1},
    k = 2,
    xi = 50,
    d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"},
    d2 = {"numberHolder", "Lland/sungbin/androidplayground/Counter;", "RecompositionTest", "", "(Landroidx/compose/runtime/Composer;I)V", "app_debug"}
)
public final class Recomposition_testKt {
    @NotNull
    private static final Counter numberHolder = new Counter();

    @Composable
    @ComposableTarget(
        applier = "androidx.compose.ui.UiComposable"
    )
    public static final void RecompositionTest(@Nullable Composer $composer, final int $changed) {
        $composer = $composer.startRestartGroup(1858906296);
        ComposerKt.sourceInformation($composer, "C(RecompositionTest)*21@490L225:recomposition-test.kt#qshby3");
        if ($changed == 0 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1858906296, $changed, -1, "land.sungbin.androidplayground.RecompositionTest (recomposition-test.kt:19)");
            }

            Function0 onClickLambda = (Function0)null.INSTANCE;
            int var5 = false;
            int var6 = onClickLambda.hashCode();
            System.out.println(var6);
            ButtonKt.Button(onClickLambda, (Modifier)null, false, (MutableInteractionSource)null, (ButtonElevation)null, (Shape)null, (BorderStroke)null, (ButtonColors)null, (PaddingValues)null, ComposableSingletons$Recomposition_testKt.INSTANCE.getLambda-1$app_debug(), $composer, 805306368, 510);
            Unit var3 = Unit.INSTANCE;
            var5 = false;
            System.out.println(LiveLiterals$Recomposition_testKt.INSTANCE.String$arg-0$call-println$fun-$anonymous$$arg-0$call-also$fun-RecompositionTest());
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        ScopeUpdateScope var10000 = $composer.endRestartGroup();
        if (var10000 != null) {
            var10000.updateScope((Function2)(new Function2() {
                public final void invoke(@Nullable Composer $composer, int $force) {
                Recomposition_testKt.RecompositionTest($composer, $changed | 1);
            }
            }));
        }

    }
}
*/

class Counter {
    val list = emptyList<Any>()
    val number = mutableStateOf(1)

    fun increaseNumber() {
        number.value++
    }
}

private val numberHolder = Counter()

@Composable
fun RecompositionTest() {
    val onClickLambda = { numberHolder.increaseNumber() }
    Button(
        onClick = onClickLambda.also {
            println(it.hashCode())
        }
    ) {
        Text(
            text = numberHolder.number.value.toString(),
        ).also { println("Text recomposition") }
    }.also { println("Button recomposition") }
}
