package land.sungbin.androidplayground;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/ComposableSingletons$PlaygroundActivityKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n*L\n1#1,54:1\n113#2:55\n113#2:56\n113#2:57\n113#2:94\n113#2:131\n70#3:58\n68#3,8:59\n70#3:95\n68#3,8:96\n77#3:135\n77#3:139\n79#4,6:67\n86#4,3:82\n89#4,2:91\n79#4,6:104\n86#4,3:119\n89#4,2:128\n93#4:134\n93#4:138\n347#5,9:73\n356#5:93\n347#5,9:110\n356#5:130\n357#5,2:132\n357#5,2:136\n4206#6,6:85\n4206#6,6:122\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/ComposableSingletons$PlaygroundActivityKt\n*L\n29#1:55\n30#1:56\n31#1:57\n38#1:94\n45#1:131\n24#1:58\n24#1:59,8\n36#1:95\n36#1:96,8\n36#1:135\n24#1:139\n24#1:67,6\n24#1:82,3\n24#1:91,2\n36#1:104,6\n36#1:119,3\n36#1:128,2\n36#1:134\n24#1:138\n24#1:73,9\n24#1:93\n36#1:110,9\n36#1:130\n36#1:132,2\n24#1:136,2\n24#1:85,6\n36#1:122,6\n*E\n"})
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
      ComposerKt.sourceInformation($composer, "C23@877L787:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2023832317, $changed, -1, "land.sungbin.androidplayground.ComposableSingletons$PlaygroundActivityKt.lambda$2023832317.<anonymous> (PlaygroundActivity.kt:23)");
         }

         Modifier var10000 = SizeKt.wrapContentSize$default(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), ColorKt.Color(4294309365L), (Shape)null, 2, (Object)null), (Alignment)null, false, 3, (Object)null);
         int var2 = 2;
         int var3 = false;
         var10000 = BorderKt.border-xT4_qwU$default(var10000, Dp.constructor-impl((float)var2), Color.Companion.getBlack-0d7_KjU(), (Shape)null, 4, (Object)null);
         var2 = 50;
         var3 = false;
         var10000 = PaddingKt.padding-3ABfNKs(var10000, Dp.constructor-impl((float)var2));
         int var62 = 300;
         var3 = false;
         Modifier var63 = BackgroundKt.background-bw27NRU$default(SizeKt.size-3ABfNKs(var10000, Dp.constructor-impl((float)var62)), Color.Companion.getGray-0d7_KjU(), (Shape)null, 2, (Object)null);
         Alignment var64 = Alignment.Companion.getCenter();
         int var6 = 54;
         int var7 = false;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
         boolean var4 = false;
         MeasurePolicy var8 = BoxKt.maybeCachedBoxMeasurePolicy(var64, var4);
         int var10 = 112 & var6 << 3;
         int var11 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
         int var12 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var13 = $composer.getCurrentCompositionLocalMap();
         Modifier var14 = ComposedModifierKt.materializeModifier($composer, var63);
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
         BoxScope var65 = (BoxScope)BoxScopeInstance.INSTANCE;
         int var30 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -1620982320, "C35@1256L400:PlaygroundActivity.kt#qshby3");
         var10000 = (Modifier)Modifier.Companion;
         int var31 = 200;
         int var32 = false;
         Modifier var66 = BackgroundKt.background-bw27NRU$default(SizeKt.size-3ABfNKs(var10000, Dp.constructor-impl((float)var31)), ColorKt.Color(4284440575L), (Shape)null, 2, (Object)null);
         Alignment var67 = Alignment.Companion.getCenter();
         int var34 = 54;
         int var35 = false;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
         boolean var36 = false;
         MeasurePolicy var37 = BoxKt.maybeCachedBoxMeasurePolicy(var67, var36);
         int var39 = 112 & var34 << 3;
         int var40 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
         int var41 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var42 = $composer.getCurrentCompositionLocalMap();
         Modifier var43 = ComposedModifierKt.materializeModifier($composer, var66);
         Function0 var44 = ComposeUiNode.Companion.getConstructor();
         int var45 = 6 | 896 & var39 << 6;
         int var46 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var44);
         } else {
            $composer.useNode();
         }

         Composer var47 = Updater.constructor-impl($composer);
         int var48 = false;
         Updater.set-impl(var47, var37, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var47, var42, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var49 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var50 = false;
         int var52 = false;
         if (var47.getInserting() || !Intrinsics.areEqual(var47.rememberedValue(), var41)) {
            var47.updateRememberedValue(var41);
            var47.apply(var41, var49);
         }

         Updater.set-impl(var47, var43, ComposeUiNode.Companion.getSetModifier());
         int var53 = 14 & var45 >> 6;
         int var55 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
         int var56 = 6 | 112 & var34 >> 6;
         var65 = (BoxScope)BoxScopeInstance.INSTANCE;
         int var59 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -1081023760, "C42@1476L170:PlaygroundActivity.kt#qshby3");
         var10000 = (Modifier)Modifier.Companion;
         int var60 = 100;
         int var61 = false;
         BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.size-3ABfNKs(var10000, Dp.constructor-impl((float)var60)), ColorKt.Color(4278236928L), (Shape)null, 2, (Object)null), $composer, 6);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endNode();
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
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
}
