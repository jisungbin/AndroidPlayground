package land.sungbin.androidplayground;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 3,
   xi = 48,
   d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"},
   d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/RowScope;", "invoke", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/runtime/Composer;I)V"}
)
final class ComposableSingletons$PlaygroundActivityKt$lambda-1$1$1$2 extends Lambda implements Function3 {
   // $FF: synthetic field
   final MutableState $test$delegate;

   ComposableSingletons$PlaygroundActivityKt$lambda_1$1$1$2/* $FF was: ComposableSingletons$PlaygroundActivityKt$lambda-1$1$1$2*/(MutableState $test$delegate) {
      super(3);
      this.$test$delegate = $test$delegate;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public final void invoke(@NotNull RowScope $this$Button, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
      ComposerKt.sourceInformation($composer, "C190@7467L30:PlaygroundActivity.kt#qshby3");
      if (($changed & 81) == 16 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1589692019, $changed, -1, "land.sungbin.androidplayground.ComposableSingletons$PlaygroundActivityKt.lambda-1.<anonymous>.<anonymous>.<anonymous> (PlaygroundActivity.kt:190)");
         }

         TextKt.Text--4IGK_g(null.access$invoke$lambda$4(this.$test$delegate).getA().toString(), (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131070);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

   }
}
