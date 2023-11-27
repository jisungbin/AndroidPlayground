package land.sungbin.androidplayground;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorProducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0006¨\u0006\u0007"},
   d2 = {"Child", "", "millis", "", "textStyle", "Lland/sungbin/androidplayground/TextStyleWrapper;", "(JLland/sungbin/androidplayground/TextStyleWrapper;Landroidx/compose/runtime/Composer;I)V", "app_debug"}
)
public final class PlaygroundActivityKt {
   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final void Child(final long millis, final TextStyleWrapper textStyle, Composer $composer, final int $changed) {
      $composer = $composer.startRestartGroup(1677350654);
      ComposerKt.sourceInformation($composer, "C(Child)212@8112L52:PlaygroundActivity.kt#qshby3");
      int $dirty = $changed;
      if (($changed & 14) == 0) {
         $dirty = $changed | ($composer.changed(millis) ? 4 : 2);
      }

      if (($changed & 112) == 0) {
         $dirty |= $composer.changed(textStyle) ? 32 : 16;
      }

      if (($dirty & 91) == 18 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1677350654, $dirty, -1, "land.sungbin.androidplayground.Child (PlaygroundActivity.kt:211)");
         }

         BasicTextKt.BasicText-VhcvRP8(String.valueOf(millis), (Modifier)null, textStyle.getValue(), (Function1)null, 0, false, 0, 0, (ColorProducer)null, $composer, 0, 506);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var10000 = $composer.endRestartGroup();
      if (var10000 != null) {
         var10000.updateScope((Function2)(new Function2() {
            public final void invoke(@Nullable Composer $composer, int $force) {
               PlaygroundActivityKt.Child(millis, textStyle, $composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
         }));
      }

   }
}
