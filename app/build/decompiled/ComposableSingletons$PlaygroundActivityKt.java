package land.sungbin.androidplayground;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical;
import androidx.compose.foundation.layout.Arrangement.Vertical;
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
import androidx.compose.ui.Alignment.Horizontal;
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
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/ComposableSingletons$PlaygroundActivityKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n+ 7 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,70:1\n113#2:71\n113#2:72\n113#2:106\n113#2:107\n113#2:108\n113#2:109\n113#2:116\n113#2:117\n113#2:118\n113#2:119\n113#2:120\n87#3,6:73\n94#3:130\n79#4,6:79\n86#4,3:94\n89#4,2:103\n93#4:129\n347#5,9:85\n356#5:105\n357#5,2:127\n4206#6,6:97\n1282#7,6:110\n1282#7,6:121\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/ComposableSingletons$PlaygroundActivityKt\n*L\n45#1:71\n61#1:72\n37#1:106\n38#1:107\n39#1:108\n40#1:109\n50#1:116\n53#1:117\n54#1:118\n55#1:119\n56#1:120\n30#1:73,6\n30#1:130\n30#1:79,6\n30#1:94,3\n30#1:103,2\n30#1:129\n30#1:85,9\n30#1:105\n30#1:127,2\n30#1:97,6\n41#1:110,6\n57#1:121,6\n*E\n"})
public final class ComposableSingletons$PlaygroundActivityKt {
   @NotNull
   public static final ComposableSingletons$PlaygroundActivityKt INSTANCE = new ComposableSingletons$PlaygroundActivityKt();
   @NotNull
   private static Function4 lambda$180332743 = (Function4)ComposableLambdaKt.composableLambdaInstance(180332743, false, ComposableSingletons$PlaygroundActivityKt::lambda_180332743$lambda$0);
   @NotNull
   private static Function4 lambda$987417918 = (Function4)ComposableLambdaKt.composableLambdaInstance(987417918, false, ComposableSingletons$PlaygroundActivityKt::lambda_987417918$lambda$0);
   @NotNull
   private static Function2 lambda$2023832317 = (Function2)ComposableLambdaKt.composableLambdaInstance(2023832317, false, ComposableSingletons$PlaygroundActivityKt::lambda_2023832317$lambda$0);

   @NotNull
   public final Function4 getLambda$180332743$app_debug() {
      return lambda$180332743;
   }

   @NotNull
   public final Function4 getLambda$987417918$app_debug() {
      return lambda$987417918;
   }

   @NotNull
   public final Function2 getLambda$2023832317$app_debug() {
      return lambda$2023832317;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit lambda_180332743$lambda$0(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$items, "$this$items");
      ComposerKt.sourceInformation($composer, "CN(it)42@1651L118:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute(($changed & 129) != 128, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(180332743, $changed, -1, "land.sungbin.androidplayground.ComposableSingletons$PlaygroundActivityKt.lambda$180332743.<anonymous> (PlaygroundActivity.kt:42)");
         }

         Modifier var10000 = (Modifier)Modifier.Companion;
         int var4 = 80;
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
   private static final Unit lambda_987417918$lambda$0(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$items, "$this$items");
      ComposerKt.sourceInformation($composer, "CN(it)58@2119L119:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute(($changed & 129) != 128, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(987417918, $changed, -1, "land.sungbin.androidplayground.ComposableSingletons$PlaygroundActivityKt.lambda$987417918.<anonymous> (PlaygroundActivity.kt:58)");
         }

         Modifier var10000 = (Modifier)Modifier.Companion;
         int var4 = 80;
         int var5 = false;
         BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.size-3ABfNKs(var10000, Dp.constructor-impl((float)var4)), Color.Companion.getBlue-0d7_KjU(), (Shape)null, 2, (Object)null), $composer, 6);
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
      ComposerKt.sourceInformation($composer, "C29@1172L1096:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2023832317, $changed, -1, "land.sungbin.androidplayground.ComposableSingletons$PlaygroundActivityKt.lambda$2023832317.<anonymous> (PlaygroundActivity.kt:29)");
         }

         Modifier var2 = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         Horizontal var3 = Alignment.Companion.getCenterHorizontally();
         HorizontalOrVertical var4 = Arrangement.INSTANCE.getCenter();
         Vertical var6 = (Vertical)var4;
         int var9 = 438;
         int var10 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
         MeasurePolicy var11 = ColumnKt.columnMeasurePolicy(var6, var3, $composer, 14 & var9 >> 3 | 112 & var9 >> 3);
         int var13 = 112 & var9 << 3;
         int var14 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
         int var15 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var16 = $composer.getCurrentCompositionLocalMap();
         Modifier var17 = ComposedModifierKt.materializeModifier($composer, var2);
         Function0 var18 = ComposeUiNode.Companion.getConstructor();
         int var19 = 6 | 896 & var13 << 6;
         int var20 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var18);
         } else {
            $composer.useNode();
         }

         Composer var21 = Updater.constructor-impl($composer);
         int var22 = false;
         Updater.set-impl(var21, var11, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var21, var16, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var23 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var24 = false;
         int var26 = false;
         if (var21.getInserting() || !Intrinsics.areEqual(var21.rememberedValue(), var15)) {
            var21.updateRememberedValue(var15);
            var21.apply(var15, var23);
         }

         Updater.set-impl(var21, var17, ComposeUiNode.Companion.getSetModifier());
         int var27 = 14 & var19 >> 6;
         int var29 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
         int var30 = 6 | 112 & var9 >> 6;
         ColumnScope var10000 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var33 = false;
         ComposerKt.sourceInformationMarkerStart($composer, 182762755, "C40@1608L183,34@1351L440,49@1800L31,56@2076L184,50@1840L420:PlaygroundActivity.kt#qshby3");
         Modifier var51 = (Modifier)Modifier.Companion;
         int var34 = 150;
         int var35 = false;
         var51 = SizeKt.width-3ABfNKs(var51, Dp.constructor-impl((float)var34));
         int var52 = 1;
         var35 = false;
         var51 = BorderKt.border-xT4_qwU$default(var51, Dp.constructor-impl((float)var52), Color.Companion.getBlack-0d7_KjU(), (Shape)null, 4, (Object)null);
         Object var10001 = null;
         var52 = 30;
         var35 = false;
         PaddingValues var10002 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl((float)var52), 0.0F, 2, (Object)null);
         boolean var10003 = false;
         var52 = 10;
         var35 = false;
         androidx.compose.foundation.layout.Arrangement.Horizontal var10004 = (androidx.compose.foundation.layout.Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var52));
         Object var10005 = null;
         Object var10006 = null;
         boolean var10007 = false;
         Object var10008 = null;
         ComposerKt.sourceInformationMarkerStart($composer, -686833590, "CC(remember):PlaygroundActivity.kt#9igjgp");
         boolean var36 = false;
         int var37 = false;
         Object var38 = $composer.rememberedValue();
         int var39 = false;
         Object var10009;
         Object var40;
         boolean var41;
         Object var42;
         Object var43;
         androidx.compose.foundation.layout.Arrangement.Horizontal var44;
         boolean var45;
         PaddingValues var46;
         Object var47;
         Modifier var48;
         boolean var49;
         Function1 var50;
         if (var38 == Composer.Companion.getEmpty()) {
            var40 = null;
            var41 = false;
            var42 = null;
            var43 = null;
            var44 = var10004;
            var45 = false;
            var46 = var10002;
            var47 = null;
            var48 = var51;
            var49 = false;
            var50 = ComposableSingletons$PlaygroundActivityKt::lambda_2023832317$lambda$0$0$0$0;
            var51 = var48;
            var10001 = var47;
            var10002 = var46;
            var10003 = var45;
            var10004 = var44;
            var10005 = var43;
            var10006 = var42;
            var10007 = var41;
            var10008 = var40;
            $composer.updateRememberedValue(var50);
            var10009 = var50;
         } else {
            var10009 = var38;
         }

         Function1 var53 = (Function1)var10009;
         ComposerKt.sourceInformationMarkerEnd($composer);
         LazyDslKt.LazyRow(var51, (LazyListState)var10001, var10002, var10003, var10004, (androidx.compose.ui.Alignment.Vertical)var10005, (FlingBehavior)var10006, var10007, (OverscrollEffect)var10008, var53, $composer, 805331334, 490);
         var51 = (Modifier)Modifier.Companion;
         var52 = 100;
         var35 = false;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var51, Dp.constructor-impl((float)var52)), $composer, 6);
         var51 = (Modifier)Modifier.Companion;
         var34 = 150;
         var35 = false;
         var51 = SizeKt.width-3ABfNKs(var51, Dp.constructor-impl((float)var34));
         var52 = 1;
         var35 = false;
         var51 = BorderKt.border-xT4_qwU$default(var51, Dp.constructor-impl((float)var52), Color.Companion.getBlack-0d7_KjU(), (Shape)null, 4, (Object)null);
         var52 = 30;
         var35 = false;
         var51 = PaddingKt.padding-VpY3zN4$default(var51, Dp.constructor-impl((float)var52), 0.0F, 2, (Object)null);
         var10001 = null;
         var10002 = null;
         var10003 = false;
         var52 = 10;
         var35 = false;
         var10004 = (androidx.compose.foundation.layout.Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)var52));
         var10005 = null;
         var10006 = null;
         var10007 = false;
         var10008 = null;
         ComposerKt.sourceInformationMarkerStart($composer, -686818613, "CC(remember):PlaygroundActivity.kt#9igjgp");
         var36 = false;
         var37 = false;
         var38 = $composer.rememberedValue();
         var39 = false;
         if (var38 == Composer.Companion.getEmpty()) {
            var40 = null;
            var41 = false;
            var42 = null;
            var43 = null;
            var44 = var10004;
            var45 = false;
            var46 = null;
            var47 = null;
            var48 = var51;
            var49 = false;
            var50 = ComposableSingletons$PlaygroundActivityKt::lambda_2023832317$lambda$0$0$1$0;
            var51 = var48;
            var10001 = var47;
            var10002 = var46;
            var10003 = var45;
            var10004 = var44;
            var10005 = var43;
            var10006 = var42;
            var10007 = var41;
            var10008 = var40;
            $composer.updateRememberedValue(var50);
            var10009 = var50;
         } else {
            var10009 = var38;
         }

         var53 = (Function1)var10009;
         ComposerKt.sourceInformationMarkerEnd($composer);
         LazyDslKt.LazyRow(var51, (LazyListState)var10001, var10002, var10003, var10004, (androidx.compose.ui.Alignment.Vertical)var10005, (FlingBehavior)var10006, var10007, (OverscrollEffect)var10008, var53, $composer, 805330950, 494);
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
      LazyListScope.items$default($this$LazyRow, 2, (Function1)null, (Function1)null, lambda$180332743, 6, (Object)null);
      return Unit.INSTANCE;
   }

   private static final Unit lambda_2023832317$lambda$0$0$1$0(LazyListScope $this$LazyRow) {
      Intrinsics.checkNotNullParameter($this$LazyRow, "$this$LazyRow");
      ComposableSingletons$PlaygroundActivityKt var10004 = INSTANCE;
      LazyListScope.items$default($this$LazyRow, 2, (Function1)null, (Function1)null, lambda$987417918, 6, (Object)null);
      return Unit.INSTANCE;
   }
}
