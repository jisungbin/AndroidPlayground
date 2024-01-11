package land.sungbin.androidplayground;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"},
   d2 = {"Content", "", "(Landroidx/compose/runtime/Composer;I)V", "app_debug"}
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivityKt\n+ 2 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,188:1\n25#2:189\n1097#3,6:190\n1097#3,6:196\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivityKt\n*L\n182#1:189\n182#1:190,6\n184#1:196,6\n*E\n"})
public final class PlaygroundActivityKt {
   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void Content(@Nullable Composer $composer, final int $changed) {
      $composer = $composer.startRestartGroup(490480294);
      ComposerKt.sourceInformation($composer, "C(Content)181@6951L59,183@7014L110:PlaygroundActivity.kt#qshby3");
      if ($changed == 0 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(490480294, $changed, -1, "land.sungbin.androidplayground.Content (PlaygroundActivity.kt:180)");
         }

         int $changed$iv = false;
         int $i$f$remember = false;
         $composer.startReplaceableGroup(-492369756);
         ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
         boolean $i$f$cache = false;
         int $i$f$cache = false;
         Object it$iv$iv = $composer.rememberedValue();
         int var9 = false;
         Object var10000;
         if (it$iv$iv == Composer.Companion.getEmpty()) {
            int var10 = false;
            Object value$iv$iv = SnapshotLongStateKt.mutableLongStateOf(System.currentTimeMillis());
            $composer.updateRememberedValue(value$iv$iv);
            var10000 = value$iv$iv;
         } else {
            var10000 = it$iv$iv;
         }

         Object var11 = var10000;
         $composer.endReplaceableGroup();
         final MutableLongState ms = (MutableLongState)var11;
         $composer.startReplaceableGroup(-1968075368);
         boolean invalid$iv = $composer.changed(ms);
         $i$f$cache = false;
         Object it$iv = $composer.rememberedValue();
         int var14 = false;
         if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
            var10000 = it$iv;
         } else {
            var9 = false;
            Object value$iv = (Function0)(new Function0() {
               public final void invoke() {
                  ms.setLongValue(System.currentTimeMillis());
               }
            });
            $composer.updateRememberedValue(value$iv);
            var10000 = value$iv;
         }

         Function0 var12 = (Function0)var10000;
         $composer.endReplaceableGroup();
         ButtonKt.Button(var12, (Modifier)null, false, (Shape)null, (ButtonColors)null, (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, (Function3)ComposableLambdaKt.composableLambda($composer, 1898239638, true, new Function3() {
            @Composable
            @ComposableTarget(
               applier = "androidx.compose.ui.UiComposable"
            )
            public final void invoke(@NotNull RowScope $this$Button, @Nullable Composer $composer, int $changed) {
               Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
               ComposerKt.sourceInformation($composer, "C184@7084L36:PlaygroundActivity.kt#qshby3");
               if (($changed & 81) == 16 && $composer.getSkipping()) {
                  $composer.skipToGroupEnd();
               } else {
                  if (ComposerKt.isTraceInProgress()) {
                     ComposerKt.traceEventStart(1898239638, $changed, -1, "land.sungbin.androidplayground.Content.<anonymous> (PlaygroundActivity.kt:184)");
                  }

                  TextKt.Text--4IGK_g(String.valueOf(ms.getLongValue()), (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131070);
                  if (ComposerKt.isTraceInProgress()) {
                     ComposerKt.traceEventEnd();
                  }
               }

            }
         }), $composer, 805306368, 510);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var17 = $composer.endRestartGroup();
      if (var17 != null) {
         var17.updateScope((Function2)(new Function2() {
            public final void invoke(@Nullable Composer $composer, int $force) {
               PlaygroundActivityKt.Content($composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
         }));
      }

   }
}
