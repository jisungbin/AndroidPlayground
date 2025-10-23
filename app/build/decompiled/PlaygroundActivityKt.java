package land.sungbin.androidplayground;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
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
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0005"},
   d2 = {"FirstBox", "", "(Landroidx/compose/runtime/Composer;I)V", "SecondBox", "ThirdBox", "app_debug"}
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivityKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n*L\n1#1,62:1\n113#2:63\n113#2:104\n113#2:145\n70#3:64\n68#3,8:65\n77#3:103\n70#3:105\n68#3,8:106\n77#3:144\n79#4,6:73\n86#4,3:88\n89#4,2:97\n93#4:102\n79#4,6:114\n86#4,3:129\n89#4,2:138\n93#4:143\n347#5,9:79\n356#5,3:99\n347#5,9:120\n356#5,3:140\n4206#6,6:91\n4206#6,6:132\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivityKt\n*L\n35#1:63\n47#1:104\n58#1:145\n33#1:64\n33#1:65,8\n33#1:103\n45#1:105\n45#1:106,8\n45#1:144\n33#1:73,6\n33#1:88,3\n33#1:97,2\n33#1:102\n45#1:114,6\n45#1:129,3\n45#1:138,2\n45#1:143\n33#1:79,9\n33#1:99,3\n45#1:120,9\n45#1:140,3\n33#1:91,6\n45#1:132,6\n*E\n"})
public final class PlaygroundActivityKt {
   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void FirstBox(@Nullable Composer $composer, int $changed) {
      $composer = $composer.startRestartGroup(1442706244);
      ComposerKt.sourceInformation($composer, "C(FirstBox)32@944L135:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute($changed != 0, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1442706244, $changed, -1, "land.sungbin.androidplayground.FirstBox (PlaygroundActivity.kt:31)");
         }

         Modifier var10000 = (Modifier)Modifier.Companion;
         int var2 = 300;
         int var3 = false;
         Modifier var31 = BackgroundKt.background-bw27NRU$default(SizeKt.size-3ABfNKs(var10000, Dp.constructor-impl((float)var2)), Color.Companion.getGray-0d7_KjU(), (Shape)null, 2, (Object)null);
         Alignment var32 = Alignment.Companion.getCenter();
         int var6 = 54;
         int var7 = false;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
         boolean var4 = false;
         MeasurePolicy var8 = BoxKt.maybeCachedBoxMeasurePolicy(var32, var4);
         int var10 = 112 & var6 << 3;
         int var11 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
         int var12 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var13 = $composer.getCurrentCompositionLocalMap();
         Modifier var14 = ComposedModifierKt.materializeModifier($composer, var31);
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
         BoxScope var33 = (BoxScope)BoxScopeInstance.INSTANCE;
         int var30 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -1583191974, "C38@1064L11:PlaygroundActivity.kt#qshby3");
         SecondBox($composer, 0);
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

      ScopeUpdateScope var34 = $composer.endRestartGroup();
      if (var34 != null) {
         var34.updateScope(PlaygroundActivityKt::FirstBox$lambda$1);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void SecondBox(@Nullable Composer $composer, int $changed) {
      $composer = $composer.startRestartGroup(-833892508);
      ComposerKt.sourceInformation($composer, "C(SecondBox)44@1116L134:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute($changed != 0, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-833892508, $changed, -1, "land.sungbin.androidplayground.SecondBox (PlaygroundActivity.kt:43)");
         }

         Modifier var10000 = (Modifier)Modifier.Companion;
         int var2 = 200;
         int var3 = false;
         Modifier var31 = BackgroundKt.background-bw27NRU$default(SizeKt.size-3ABfNKs(var10000, Dp.constructor-impl((float)var2)), Color.Companion.getBlue-0d7_KjU(), (Shape)null, 2, (Object)null);
         Alignment var32 = Alignment.Companion.getCenter();
         int var6 = 54;
         int var7 = false;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
         boolean var4 = false;
         MeasurePolicy var8 = BoxKt.maybeCachedBoxMeasurePolicy(var32, var4);
         int var10 = 112 & var6 << 3;
         int var11 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
         int var12 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var13 = $composer.getCurrentCompositionLocalMap();
         Modifier var14 = ComposedModifierKt.materializeModifier($composer, var31);
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
         BoxScope var33 = (BoxScope)BoxScopeInstance.INSTANCE;
         int var30 = false;
         ComposerKt.sourceInformationMarkerStart($composer, 121132495, "C50@1236L10:PlaygroundActivity.kt#qshby3");
         ThirdBox($composer, 0);
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

      ScopeUpdateScope var34 = $composer.endRestartGroup();
      if (var34 != null) {
         var34.updateScope(PlaygroundActivityKt::SecondBox$lambda$1);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void ThirdBox(@Nullable Composer $composer, int $changed) {
      $composer = $composer.startRestartGroup(-438022995);
      ComposerKt.sourceInformation($composer, "C(ThirdBox)55@1285L73:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute($changed != 0, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-438022995, $changed, -1, "land.sungbin.androidplayground.ThirdBox (PlaygroundActivity.kt:54)");
         }

         Modifier var10000 = (Modifier)Modifier.Companion;
         int var2 = 100;
         int var3 = false;
         BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.size-3ABfNKs(var10000, Dp.constructor-impl((float)var2)), Color.Companion.getGreen-0d7_KjU(), (Shape)null, 2, (Object)null), $composer, 6);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      } else {
         $composer.skipToGroupEnd();
      }

      ScopeUpdateScope var4 = $composer.endRestartGroup();
      if (var4 != null) {
         var4.updateScope(PlaygroundActivityKt::ThirdBox$lambda$0);
      }

   }

   private static final Unit FirstBox$lambda$1(int $$changed, Composer $composer, int $force) {
      FirstBox($composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   private static final Unit SecondBox$lambda$1(int $$changed, Composer $composer, int $force) {
      SecondBox($composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   private static final Unit ThirdBox$lambda$0(int $$changed, Composer $composer, int $force) {
      ThirdBox($composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }
}
