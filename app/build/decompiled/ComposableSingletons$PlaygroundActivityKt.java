package land.sungbin.androidplayground;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.shadow.Shadow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/ComposableSingletons$PlaygroundActivityKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n*L\n1#1,56:1\n113#2:57\n113#2:58\n113#2:59\n188#2:60\n113#2:64\n113#2:65\n113#2:66\n113#2:67\n188#2:68\n113#2:72\n113#2:73\n113#2:74\n53#3,3:61\n53#3,3:69\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/ComposableSingletons$PlaygroundActivityKt\n*L\n32#1:57\n34#1:58\n36#1:59\n36#1:60\n37#1:64\n38#1:65\n43#1:66\n45#1:67\n45#1:68\n46#1:72\n47#1:73\n51#1:74\n36#1:61,3\n45#1:69,3\n*E\n"})
public final class ComposableSingletons$PlaygroundActivityKt {
   @NotNull
   public static final ComposableSingletons$PlaygroundActivityKt INSTANCE = new ComposableSingletons$PlaygroundActivityKt();
   @NotNull
   private static Function2 lambda$2023832317 = (Function2)ComposableLambdaKt.composableLambdaInstance(2023832317, false, ComposableSingletons$PlaygroundActivityKt::lambda_2023832317$lambda$0);

   @NotNull
   public final Function2 getLambda$2023832317$app_debug() {
      return lambda$2023832317;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit lambda_2023832317$lambda$0(Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C26@1030L795:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2023832317, $changed, -1, "land.sungbin.androidplayground.ComposableSingletons$PlaygroundActivityKt.lambda$2023832317.<anonymous> (PlaygroundActivity.kt:26)");
         }

         Modifier var10000 = SizeKt.wrapContentSize$default(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), Color.Companion.getWhite-0d7_KjU(), (Shape)null, 2, (Object)null), (Alignment)null, false, 3, (Object)null);
         int var2 = 80;
         int var3 = false;
         var10000 = SizeKt.size-3ABfNKs(var10000, Dp.constructor-impl((float)var2));
         var2 = 12;
         var3 = false;
         Shape var10001 = (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var2));
         int var4 = 0;
         int var5 = false;
         float var15 = Dp.constructor-impl((float)var4);
         int var16 = 6;
         int var6 = false;
         float var17 = Dp.constructor-impl((float)var16);
         var6 = false;
         int var9 = false;
         long var10 = (long)Float.floatToRawIntBits(var15);
         long var12 = (long)Float.floatToRawIntBits(var17);
         long var14 = DpOffset.constructor-impl(var10 << 32 | var12 & 4294967295L);
         var16 = 12;
         var6 = false;
         var15 = Dp.constructor-impl((float)var16);
         int var18 = 3;
         int var7 = false;
         var17 = Dp.constructor-impl((float)var18);
         long var19 = Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.08F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         var10000 = ShadowKt.dropShadow(var10000, var10001, new Shadow(var15, var19, var17, var14, 0.0F, 0, 48, (DefaultConstructorMarker)null));
         var2 = 12;
         var3 = false;
         var10001 = (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var2));
         var4 = 0;
         var5 = false;
         var15 = Dp.constructor-impl((float)var4);
         var16 = 8;
         var6 = false;
         var17 = Dp.constructor-impl((float)var16);
         var6 = false;
         var9 = false;
         var10 = (long)Float.floatToRawIntBits(var15);
         var12 = (long)Float.floatToRawIntBits(var17);
         var14 = DpOffset.constructor-impl(var10 << 32 | var12 & 4294967295L);
         var16 = 16;
         var6 = false;
         var15 = Dp.constructor-impl((float)var16);
         var18 = 0;
         var7 = false;
         var17 = Dp.constructor-impl((float)var18);
         var19 = Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.2F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
         var10000 = ShadowKt.dropShadow(var10000, var10001, new Shadow(var15, var19, var17, var14, 0.0F, 0, 48, (DefaultConstructorMarker)null));
         long var20 = Color.Companion.getWhite-0d7_KjU();
         var2 = 12;
         var3 = false;
         BoxKt.Box(BackgroundKt.background-bw27NRU(var10000, var20, (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)var2))), $composer, 0);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      } else {
         $composer.skipToGroupEnd();
      }

      return Unit.INSTANCE;
   }
}
