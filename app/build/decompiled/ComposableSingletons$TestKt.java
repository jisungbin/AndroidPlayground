package androidx.compose.foundation.demos.text;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 3,
   xi = 48
)
public final class ComposableSingletons$TestKt {
   @NotNull
   public static final ComposableSingletons$TestKt INSTANCE = new ComposableSingletons$TestKt();
   @NotNull
   private static Function3 lambda$-1973353338 = (Function3)ComposableLambdaKt.composableLambdaInstance(-1973353338, false, ComposableSingletons$TestKt::lambda__1973353338$lambda$0);
   @NotNull
   private static Function3 lambda$560503471 = (Function3)ComposableLambdaKt.composableLambdaInstance(560503471, false, ComposableSingletons$TestKt::lambda_560503471$lambda$0);

   @NotNull
   public final Function3 getLambda$_1973353338$app_debug/* $FF was: getLambda$-1973353338$app_debug*/() {
      return lambda$-1973353338;
   }

   @NotNull
   public final Function3 getLambda$560503471$app_debug() {
      return lambda$560503471;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit lambda__1973353338$lambda$0(RowScope $this$Button, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
      ComposerKt.sourceInformation($composer, "C120@4163L10:Test.kt#4udlp7");
      if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1973353338, $changed, -1, "androidx.compose.foundation.demos.text.ComposableSingletons$TestKt.lambda$-1973353338.<anonymous> (Test.kt:120)");
         }

         TextKt.Text--4IGK_g("Go", (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 6, 0, 131070);
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
   private static final Unit lambda_560503471$lambda$0(RowScope $this$Button, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
      ComposerKt.sourceInformation($composer, "C130@4359L13:Test.kt#4udlp7");
      if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(560503471, $changed, -1, "androidx.compose.foundation.demos.text.ComposableSingletons$TestKt.lambda$560503471.<anonymous> (Test.kt:130)");
         }

         TextKt.Text--4IGK_g("Reset", (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 6, 0, 131070);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      } else {
         $composer.skipToGroupEnd();
      }

      return Unit.INSTANCE;
   }
}
