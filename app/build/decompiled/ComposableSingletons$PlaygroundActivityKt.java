package land.sungbin.androidplayground;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.Arrangement.Horizontal;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/ComposableSingletons$PlaygroundActivityKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,34:1\n113#2:35\n1282#3,6:36\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/ComposableSingletons$PlaygroundActivityKt\n*L\n21#1:35\n22#1:36,6\n*E\n"})
public final class ComposableSingletons$PlaygroundActivityKt {
   @NotNull
   public static final ComposableSingletons$PlaygroundActivityKt INSTANCE = new ComposableSingletons$PlaygroundActivityKt();
   @NotNull
   private static Function3 lambda$-1390239302 = (Function3)ComposableLambdaKt.composableLambdaInstance(-1390239302, false, ComposableSingletons$PlaygroundActivityKt::lambda__1390239302$lambda$0);
   @NotNull
   private static Function2 lambda$2023832317 = (Function2)ComposableLambdaKt.composableLambdaInstance(2023832317, false, ComposableSingletons$PlaygroundActivityKt::lambda_2023832317$lambda$0);

   @NotNull
   public final Function3 getLambda$_1390239302$app_debug/* $FF was: getLambda$-1390239302$app_debug*/() {
      return lambda$-1390239302;
   }

   @NotNull
   public final Function2 getLambda$2023832317$app_debug() {
      return lambda$2023832317;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit lambda__1390239302$lambda$0(LazyItemScope $this$item, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$item, "$this$item");
      ComposerKt.sourceInformation($composer, "C23@829L112:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1390239302, $changed, -1, "land.sungbin.androidplayground.ComposableSingletons$PlaygroundActivityKt.lambda$-1390239302.<anonymous> (PlaygroundActivity.kt:23)");
         }

         BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), Color.Companion.getRed-0d7_KjU(), (Shape)null, 2, (Object)null), $composer, 6);
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
      ComposerKt.sourceInformation($composer, "C21@802L157,18@682L277:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2023832317, $changed, -1, "land.sungbin.androidplayground.ComposableSingletons$PlaygroundActivityKt.lambda$2023832317.<anonymous> (PlaygroundActivity.kt:18)");
         }

         Modifier var10000 = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         Object var10001 = null;
         int var2 = 30;
         int var3 = false;
         PaddingValues var10002 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl((float)var2), 0.0F, 2, (Object)null);
         boolean var10003 = false;
         Object var10004 = null;
         Object var10005 = null;
         Object var10006 = null;
         boolean var10007 = false;
         Object var10008 = null;
         ComposerKt.sourceInformationMarkerStart($composer, -717324198, "CC(remember):PlaygroundActivity.kt#9igjgp");
         boolean var4 = false;
         int var5 = false;
         Object var6 = $composer.rememberedValue();
         int var7 = false;
         Object var10009;
         if (var6 == Composer.Companion.getEmpty()) {
            Object var17 = null;
            boolean var16 = false;
            Object var15 = null;
            Object var14 = null;
            Object var13 = null;
            boolean var12 = false;
            PaddingValues var11 = var10002;
            Object var10 = null;
            Modifier var9 = var10000;
            int var8 = false;
            Function1 var18 = ComposableSingletons$PlaygroundActivityKt::lambda_2023832317$lambda$0$0$0;
            var10000 = var9;
            var10001 = var10;
            var10002 = var11;
            var10003 = var12;
            var10004 = var13;
            var10005 = var14;
            var10006 = var15;
            var10007 = var16;
            var10008 = var17;
            $composer.updateRememberedValue(var18);
            var10009 = var18;
         } else {
            var10009 = var6;
         }

         Function1 var19 = (Function1)var10009;
         ComposerKt.sourceInformationMarkerEnd($composer);
         LazyDslKt.LazyRow(var10000, (LazyListState)var10001, var10002, var10003, (Horizontal)var10004, (Vertical)var10005, (FlingBehavior)var10006, var10007, (OverscrollEffect)var10008, var19, $composer, 805306758, 506);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      } else {
         $composer.skipToGroupEnd();
      }

      return Unit.INSTANCE;
   }

   private static final Unit lambda_2023832317$lambda$0$0$0(LazyListScope $this$LazyRow) {
      Intrinsics.checkNotNullParameter($this$LazyRow, "$this$LazyRow");
      ComposableSingletons$PlaygroundActivityKt var10003 = INSTANCE;
      LazyListScope.item$default($this$LazyRow, (Object)null, (Object)null, lambda$-1390239302, 3, (Object)null);
      return Unit.INSTANCE;
   }
}
