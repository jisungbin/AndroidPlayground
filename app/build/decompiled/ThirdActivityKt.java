package land.sungbin.androidplayground;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"},
   d2 = {"ThirdComposable", "", "(Landroidx/compose/runtime/Composer;I)V", "app_debug"}
)
@SourceDebugExtension({"SMAP\nThirdActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThirdActivity.kt\nland/sungbin/androidplayground/ThirdActivityKt\n+ 2 Effects.kt\nandroidx/compose/runtime/EffectsKt\n+ 3 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 4 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 5 Effects.kt\nandroidx/compose/runtime/EffectsKt$rememberCoroutineScope$1\n*L\n1#1,38:1\n486#2,4:39\n490#2,2:47\n494#2:53\n25#3:43\n1097#4,3:44\n1100#4,3:50\n486#5:49\n*S KotlinDebug\n*F\n+ 1 ThirdActivity.kt\nland/sungbin/androidplayground/ThirdActivityKt\n*L\n36#1:39,4\n36#1:47,2\n36#1:53\n36#1:43\n36#1:44,3\n36#1:50,3\n36#1:49\n*E\n"})
public final class ThirdActivityKt {
   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void ThirdComposable(@Nullable Composer $composer, final int $changed) {
      $composer = $composer.startRestartGroup(-522464339);
      ComposerKt.sourceInformation($composer, "C(ThirdComposable)35@1041L24,36@1068L56:ThirdActivity.kt#qshby3");
      if ($changed == 0 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-522464339, $changed, -1, "land.sungbin.androidplayground.ThirdComposable (ThirdActivity.kt:34)");
         }

         int $changed$iv = false;
         int $i$f$rememberCoroutineScope = false;
         $composer.startReplaceableGroup(773894976);
         ComposerKt.sourceInformation($composer, "CC(rememberCoroutineScope)488@20446L144:Effects.kt#9igjgp");
         int $changed$iv$iv = false;
         int $i$f$remember = false;
         $composer.startReplaceableGroup(-492369756);
         ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
         boolean invalid$iv$iv$iv = false;
         int $i$f$cache = false;
         Object it$iv$iv$iv = $composer.rememberedValue();
         int var12 = false;
         Object var10000;
         if (it$iv$iv$iv == Composer.Companion.getEmpty()) {
            int var13 = false;
            int var14 = false;
            CoroutineScope var17 = EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, $composer);
            Object value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(var17);
            $composer.updateRememberedValue(value$iv$iv$iv);
            var10000 = value$iv$iv$iv;
         } else {
            var10000 = it$iv$iv$iv;
         }

         Object var15 = var10000;
         $composer.endReplaceableGroup();
         CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller)var15;
         CoroutineScope var18 = wrapper$iv.getCoroutineScope();
         $composer.endReplaceableGroup();
         TextKt.Text--4IGK_g(LiveLiterals$ThirdActivityKt.INSTANCE.String$0$str$arg-0$call-Text$fun-ThirdComposable() + CoroutineScopeKt.isActive(var18), (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131070);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var20 = $composer.endRestartGroup();
      if (var20 != null) {
         var20.updateScope((Function2)(new Function2() {
            public final void invoke(@Nullable Composer $composer, int $force) {
               ThirdActivityKt.ThirdComposable($composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
         }));
      }

   }
}
