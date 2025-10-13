package land.sungbin.androidplayground;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.Brush.Companion;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/ComposableSingletons$PlaygroundActivityKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n*L\n1#1,58:1\n113#2:59\n113#2:60\n113#2:98\n70#3:61\n67#3,9:62\n77#3:102\n79#4,6:71\n86#4,3:86\n89#4,2:95\n93#4:101\n347#5,9:77\n356#5:97\n357#5,2:99\n4206#6,6:89\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/ComposableSingletons$PlaygroundActivityKt\n*L\n31#1:59\n34#1:60\n38#1:98\n26#1:61\n26#1:62,9\n26#1:102\n26#1:71,6\n26#1:86,3\n26#1:95,2\n26#1:101\n26#1:77,9\n26#1:97\n26#1:99,2\n26#1:89,6\n*E\n"})
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
      ComposerKt.sourceInformation($composer, "C31@1146L21,32@1197L21,25@989L750:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2023832317, $changed, -1, "land.sungbin.androidplayground.ComposableSingletons$PlaygroundActivityKt.lambda$2023832317.<anonymous> (PlaygroundActivity.kt:25)");
         }

         Modifier var10000 = SizeKt.wrapContentSize$default(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), (Alignment)null, false, 3, (Object)null);
         int var2 = 100;
         int var3 = false;
         var10000 = ScrollKt.verticalScroll$default(ScrollKt.horizontalScroll$default(SizeKt.size-3ABfNKs(var10000, Dp.constructor-impl((float)var2)), ScrollKt.rememberScrollState(0, $composer, 0, 1), false, (FlingBehavior)null, false, 14, (Object)null), ScrollKt.rememberScrollState(0, $composer, 0, 1), false, (FlingBehavior)null, false, 14, (Object)null);
         var2 = 1;
         var3 = false;
         Modifier var33 = BorderKt.border-xT4_qwU$default(var10000, Dp.constructor-impl((float)var2), Color.Companion.getBlack-0d7_KjU(), (Shape)null, 4, (Object)null);
         int var6 = 0;
         int var7 = false;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
         Alignment var34 = Alignment.Companion.getTopStart();
         boolean var4 = false;
         MeasurePolicy var8 = BoxKt.maybeCachedBoxMeasurePolicy(var34, var4);
         int var10 = 112 & var6 << 3;
         int var11 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
         int var12 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var13 = $composer.getCurrentCompositionLocalMap();
         Modifier var14 = ComposedModifierKt.materializeModifier($composer, var33);
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
         BoxScope var35 = (BoxScope)BoxScopeInstance.INSTANCE;
         int var30 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -1620980677, "C35@1278L453:PlaygroundActivity.kt#qshby3");
         var10000 = (Modifier)Modifier.Companion;
         int var31 = 250;
         int var32 = false;
         var10000 = SizeKt.size-3ABfNKs(var10000, Dp.constructor-impl((float)var31));
         Companion var10001 = Brush.Companion;
         Color[] var36 = new Color[]{Color.box-impl(Color.Companion.getRed-0d7_KjU()), Color.box-impl(Color.Companion.getYellow-0d7_KjU()), Color.box-impl(Color.Companion.getGreen-0d7_KjU()), Color.box-impl(Color.Companion.getCyan-0d7_KjU()), Color.box-impl(Color.Companion.getBlue-0d7_KjU()), Color.box-impl(Color.Companion.getMagenta-0d7_KjU()), Color.box-impl(Color.Companion.getRed-0d7_KjU())};
         BoxKt.Box(BackgroundKt.background$default(var10000, Companion.horizontalGradient-8A-3gB4$default(var10001, CollectionsKt.listOf(var36), 0.0F, 0.0F, 0, 14, (Object)null), (Shape)null, 0.0F, 6, (Object)null), $composer, 6);
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
