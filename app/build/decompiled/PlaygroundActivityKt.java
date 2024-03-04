package land.sungbin.androidplayground;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"},
   d2 = {"View", "", "src", "", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "app_debug"}
)
public final class PlaygroundActivityKt {
   @Composable
   public static final void View(@NotNull final Object src, @Nullable Composer $composer, final int $changed) {
      Intrinsics.checkNotNullParameter(src, "src");
      $composer = $composer.startRestartGroup(-1845411220);
      ComposerKt.sourceInformation($composer, "C(View)186@7135L25:PlaygroundActivity.kt#qshby3");
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventStart(-1845411220, $changed, -1, "land.sungbin.androidplayground.View (PlaygroundActivity.kt:185)");
      }

      BasicTextKt.BasicText-VhcvRP8(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-BasicText$fun-View() + src, (Modifier)null, (TextStyle)null, (Function1)null, 0, false, 0, 0, (ColorProducer)null, $composer, 0, 510);
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventEnd();
      }

      ScopeUpdateScope var10000 = $composer.endRestartGroup();
      if (var10000 != null) {
         var10000.updateScope((Function2)(new Function2() {
            public final void invoke(@Nullable Composer $composer, int $force) {
               PlaygroundActivityKt.View(src, $composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
         }));
      }

   }
}
