package land.sungbin.androidplayground;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.MaterialThemeKt;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 3,
   xi = 48
)
public final class ComposableSingletons$PlaygroundActivityKt {
   @NotNull
   public static final ComposableSingletons$PlaygroundActivityKt INSTANCE = new ComposableSingletons$PlaygroundActivityKt();
   @NotNull
   private static Function2 lambda$430316241 = (Function2)ComposableLambdaKt.composableLambdaInstance(430316241, false, ComposableSingletons$PlaygroundActivityKt::lambda_430316241$lambda$0);
   @NotNull
   private static Function2 lambda$2023832317 = (Function2)ComposableLambdaKt.composableLambdaInstance(2023832317, false, ComposableSingletons$PlaygroundActivityKt::lambda_2023832317$lambda$0);

   @NotNull
   public final Function2 getLambda$430316241$app_debug() {
      return lambda$430316241;
   }

   @NotNull
   public final Function2 getLambda$2023832317$app_debug() {
      return lambda$2023832317;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit lambda_430316241$lambda$0(Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C54@2358L20:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(430316241, $changed, -1, "land.sungbin.androidplayground.ComposableSingletons$PlaygroundActivityKt.lambda$430316241.<anonymous> (PlaygroundActivity.kt:54)");
         }

         PlaygroundActivityKt.RainbowTextPreview($composer, 0);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      } else {
         $composer.skipToGroupEnd();
      }

      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit lambda_2023832317$lambda$0(Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C52@2279L21,53@2334L52:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2023832317, $changed, -1, "land.sungbin.androidplayground.ComposableSingletons$PlaygroundActivityKt.lambda$2023832317.<anonymous> (PlaygroundActivity.kt:52)");
         }

         boolean isDarkTheme = DarkThemeKt.isSystemInDarkTheme($composer, 0);
         ComposableSingletons$PlaygroundActivityKt var10003 = INSTANCE;
         MaterialThemeKt.MaterialTheme((Colors)null, (Typography)null, (Shapes)null, lambda$430316241, $composer, 3072, 7);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      } else {
         $composer.skipToGroupEnd();
      }

      return Unit.INSTANCE;
   }
}
