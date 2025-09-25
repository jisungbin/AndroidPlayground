package land.sungbin.androidplayground;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.Arrangement.Horizontal;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/ComposableSingletons$PlaygroundActivityKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n+ 7 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,49:1\n113#2:50\n113#2:87\n113#2:88\n113#2:89\n113#2:90\n70#3:51\n68#3,8:52\n77#3:100\n79#4,6:60\n86#4,3:75\n89#4,2:84\n93#4:99\n347#5,9:66\n356#5:86\n357#5,2:97\n4206#6,6:78\n1282#7,6:91\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/ComposableSingletons$PlaygroundActivityKt\n*L\n40#1:50\n32#1:87\n33#1:88\n34#1:89\n35#1:90\n26#1:51\n26#1:52,8\n26#1:100\n26#1:60,6\n26#1:75,3\n26#1:84,2\n26#1:99\n26#1:66,9\n26#1:86\n26#1:97,2\n26#1:78,6\n36#1:91,6\n*E\n"})
public final class ComposableSingletons$PlaygroundActivityKt {
   @NotNull
   public static final ComposableSingletons$PlaygroundActivityKt INSTANCE = new ComposableSingletons$PlaygroundActivityKt();
   @NotNull
   private static Function4 lambda$-2034604201 = (Function4)ComposableLambdaKt.composableLambdaInstance(-2034604201, false, ComposableSingletons$PlaygroundActivityKt::lambda__2034604201$lambda$0);
   @NotNull
   private static Function2 lambda$2023832317 = (Function2)ComposableLambdaKt.composableLambdaInstance(2023832317, false, ComposableSingletons$PlaygroundActivityKt::lambda_2023832317$lambda$0);

   @NotNull
   public final Function4 getLambda$_2034604201$app_debug/* $FF was: getLambda$-2034604201$app_debug*/() {
      return lambda$-2034604201;
   }

   @NotNull
   public final Function2 getLambda$2023832317$app_debug() {
      return lambda$2023832317;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit lambda__2034604201$lambda$0(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$items, "$this$items");
      ComposerKt.sourceInformation($composer, "CN(it)37@1386L119:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute(($changed & 129) != 128, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2034604201, $changed, -1, "land.sungbin.androidplayground.ComposableSingletons$PlaygroundActivityKt.lambda$-2034604201.<anonymous> (PlaygroundActivity.kt:37)");
         }

         Modifier var10000 = (Modifier)Modifier.Companion;
         int var4 = 100;
         int var5 = false;
         BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.size-3ABfNKs(var10000, Dp.constructor-impl((float)var4)), Color.Companion.getRed-0d7_KjU(), (Shape)null, 2, (Object)null), $composer, 6);
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
      ComposerKt.sourceInformation($composer, "C25@975L560:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2023832317, $changed, -1, "land.sungbin.androidplayground.ComposableSingletons$PlaygroundActivityKt.lambda$2023832317.<anonymous> (PlaygroundActivity.kt:25)");
         }

         Modifier var2 = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         Alignment var3 = Alignment.Companion.getCenter();
         int var6 = 54;
         int var7 = false;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
         boolean var4 = false;
         MeasurePolicy var8 = BoxKt.maybeCachedBoxMeasurePolicy(var3, var4);
         int var10 = 112 & var6 << 3;
         int var11 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
         int var12 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var13 = $composer.getCurrentCompositionLocalMap();
         Modifier var14 = ComposedModifierKt.materializeModifier($composer, var2);
         Function0 var15 = ComposeUiNode.Companion.getConstructor();
         int var16 = 6 | 896 & var10 << 6;
         int var17 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var15);
         } else {
            $composer.useNode();
         }

         Composer var18 = Updater.constructor-impl($composer);
         int var19 = false;
         Updater.set-impl(var18, var8, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var18, var13, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var20 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var21 = false;
         int var23 = false;
         if (var18.getInserting() || !Intrinsics.areEqual(var18.rememberedValue(), var12)) {
            var18.updateRememberedValue(var12);
            var18.apply(var12, var20);
         }

         Updater.set-impl(var18, var14, ComposeUiNode.Companion.getSetModifier());
         int var24 = 14 & var16 >> 6;
         int var26 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
         int var27 = 6 | 112 & var6 >> 6;
         BoxScope var10000 = (BoxScope)BoxScopeInstance.INSTANCE;
         int var30 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -1620981049, "C35@1343L184,29@1086L441:PlaygroundActivity.kt#qshby3");
         Modifier var48 = (Modifier)Modifier.Companion;
         int var31 = 150;
         int var32 = false;
         var48 = SizeKt.width-3ABfNKs(var48, Dp.constructor-impl((float)var31));
         int var49 = 1;
         var32 = false;
         var48 = BorderKt.border-xT4_qwU$default(var48, Dp.constructor-impl((float)var49), Color.Companion.getBlack-0d7_KjU(), (Shape)null, 4, (Object)null);
         Object var10001 = null;
         var49 = 30;
         var32 = false;
         PaddingValues var10002 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl((float)var49), 0.0F, 2, (Object)null);
         boolean var10003 = false;
         var49 = 10;
         var32 = false;
         Horizontal var10004 = (Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var49));
         Object var10005 = null;
         Object var10006 = null;
         boolean var10007 = false;
         Object var10008 = null;
         ComposerKt.sourceInformationMarkerStart($composer, -745018405, "CC(remember):PlaygroundActivity.kt#9igjgp");
         boolean var33 = false;
         int var34 = false;
         Object var35 = $composer.rememberedValue();
         int var36 = false;
         Object var10009;
         if (var35 == Composer.Companion.getEmpty()) {
            Object var37 = null;
            boolean var38 = false;
            Object var39 = null;
            Object var40 = null;
            Horizontal var41 = var10004;
            boolean var42 = false;
            PaddingValues var43 = var10002;
            Object var44 = null;
            Modifier var45 = var48;
            int var46 = false;
            Function1 var47 = ComposableSingletons$PlaygroundActivityKt::lambda_2023832317$lambda$0$0$0$0;
            var48 = var45;
            var10001 = var44;
            var10002 = var43;
            var10003 = var42;
            var10004 = var41;
            var10005 = var40;
            var10006 = var39;
            var10007 = var38;
            var10008 = var37;
            $composer.updateRememberedValue(var47);
            var10009 = var47;
         } else {
            var10009 = var35;
         }

         Function1 var50 = (Function1)var10009;
         ComposerKt.sourceInformationMarkerEnd($composer);
         LazyDslKt.LazyRow(var48, (LazyListState)var10001, var10002, var10003, var10004, (Vertical)var10005, (FlingBehavior)var10006, var10007, (OverscrollEffect)var10008, var50, $composer, 805331334, 490);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      } else {
         $composer.skipToGroupEnd();
      }

      return Unit.INSTANCE;
   }

   private static final Unit lambda_2023832317$lambda$0$0$0$0(LazyListScope $this$LazyRow) {
      Intrinsics.checkNotNullParameter($this$LazyRow, "$this$LazyRow");
      ComposableSingletons$PlaygroundActivityKt var10004 = INSTANCE;
      LazyListScope.items$default($this$LazyRow, 2, (Function1)null, (Function1)null, lambda$-2034604201, 6, (Object)null);
      return Unit.INSTANCE;
   }
}
