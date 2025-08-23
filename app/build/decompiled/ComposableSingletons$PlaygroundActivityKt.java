package land.sungbin.androidplayground;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 3,
   xi = 48
)
public final class ComposableSingletons$PlaygroundActivityKt {
   @NotNull
   public static final ComposableSingletons$PlaygroundActivityKt INSTANCE;
   // $FF: synthetic field
   static final KProperty[] $$delegatedProperties;
   @NotNull
   private static Function2 lambda$2023832317;

   @NotNull
   public final Function2 getLambda$2023832317$app_debug() {
      return lambda$2023832317;
   }

   @Composable
   private static final void lambda_2023832317$lambda$1$lambda$0(Unit $aaa$delegate, Composer $composer, int $changed) {
      ComposerKt.sourceInformationMarkerStart($composer, 2124843907, "C(<get-aaa>)13@455L4:PlaygroundActivity.kt#qshby3");
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventStart(2124843907, $changed, -1, "land.sungbin.androidplayground.ComposableSingletons$PlaygroundActivityKt.lambda$2023832317.<anonymous>.<get-aaa> (PlaygroundActivity.kt:13)");
      }

      PlaygroundActivityKt.getValue($aaa$delegate, (Object)null, $$delegatedProperties[0], $composer, 54);
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventEnd();
      }

      ComposerKt.sourceInformationMarkerEnd($composer);
   }

   @Composable
   private static final Unit lambda_2023832317$lambda$1(Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C14@466L3:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2023832317, $changed, -1, "land.sungbin.androidplayground.ComposableSingletons$PlaygroundActivityKt.lambda$2023832317.<anonymous> (PlaygroundActivity.kt:13)");
         }

         Unit aaa$delegate = Unit.INSTANCE;
         lambda_2023832317$lambda$1$lambda$0(aaa$delegate, $composer, 0);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      } else {
         $composer.skipToGroupEnd();
      }

      return Unit.INSTANCE;
   }

   static {
      KProperty[] var0 = new KProperty[]{Reflection.property0((PropertyReference0)(new PropertyReference0Impl(ComposableSingletons$PlaygroundActivityKt.class, "aaa", "<v#0>", 0)))};
      $$delegatedProperties = var0;
      INSTANCE = new ComposableSingletons$PlaygroundActivityKt();
      lambda$2023832317 = (Function2)ComposableLambdaKt.composableLambdaInstance(2023832317, false, ComposableSingletons$PlaygroundActivityKt::lambda_2023832317$lambda$1);
   }
}
