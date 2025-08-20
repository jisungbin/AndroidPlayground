package land.sungbin.androidplayground;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\r\u0010\u0005\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"},
   d2 = {"Test", "", "a", "", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;II)V", "A", "(Landroidx/compose/runtime/Composer;I)V", "app_debug"}
)
public final class PlaygroundActivityKt {
   @Composable
   public static final void Test(@Nullable Object a, @Nullable Composer $composer, int $changed, int var3) {
      $composer = $composer.startRestartGroup(480742367);
      ComposerKt.sourceInformation($composer, "C(Test):PlaygroundActivity.kt#qshby3");
      if (($changed & 1) == 0 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if ((var3 & 1) != 0) {
            a = 1;
         }

         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(480742367, $changed, -1, "land.sungbin.androidplayground.Test (PlaygroundActivity.kt:18)");
         }

         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var10000 = $composer.endRestartGroup();
      if (var10000 != null) {
         var10000.updateScope(PlaygroundActivityKt::Test$lambda$0);
      }

   }

   @Composable
   public static final void A(@Nullable Composer $composer, int $changed) {
      $composer = $composer.startRestartGroup(-1556754418);
      ComposerKt.sourceInformation($composer, "C(A)23@498L6:PlaygroundActivity.kt#qshby3");
      if ($changed == 0 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1556754418, $changed, -1, "land.sungbin.androidplayground.A (PlaygroundActivity.kt:22)");
         }

         Test((Object)null, $composer, 0, 1);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var10000 = $composer.endRestartGroup();
      if (var10000 != null) {
         var10000.updateScope(PlaygroundActivityKt::A$lambda$1);
      }

   }

   private static final Unit Test$lambda$0(Object $a, int $$changed, int $$default, Composer $composer, int $force) {
      Test($a, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1), $$default);
      return Unit.INSTANCE;
   }

   private static final Unit A$lambda$1(int $$changed, Composer $composer, int $force) {
      A($composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }
}
