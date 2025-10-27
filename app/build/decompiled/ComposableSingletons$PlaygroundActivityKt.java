package land.sungbin.androidplayground;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.Arrangement.Horizontal;
import androidx.compose.material.TextKt;
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
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 3,
   xi = 48
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/ComposableSingletons$PlaygroundActivityKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n+ 7 Row.kt\nandroidx/compose/foundation/layout/RowKt\n*L\n1#1,41:1\n113#2:42\n118#2:43\n113#2:81\n113#2:119\n113#2:120\n70#3:44\n67#3,9:45\n77#3:128\n79#4,6:54\n86#4,3:69\n89#4,2:78\n79#4,6:92\n86#4,3:107\n89#4,2:116\n93#4:123\n93#4:127\n347#5,9:60\n356#5:80\n347#5,9:98\n356#5:118\n357#5,2:121\n357#5,2:125\n4206#6,6:72\n4206#6,6:110\n99#7:82\n96#7,9:83\n106#7:124\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/ComposableSingletons$PlaygroundActivityKt\n*L\n28#1:42\n31#1:43\n33#1:81\n34#1:119\n35#1:120\n25#1:44\n25#1:45,9\n25#1:128\n25#1:54,6\n25#1:69,3\n25#1:78,2\n33#1:92,6\n33#1:107,3\n33#1:116,2\n33#1:123\n25#1:127\n25#1:60,9\n25#1:80\n33#1:98,9\n33#1:118\n33#1:121,2\n25#1:125,2\n25#1:72,6\n33#1:110,6\n33#1:82\n33#1:83,9\n33#1:124\n*E\n"})
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
      ComposerKt.sourceInformation($composer, "C29@1088L21,24@934L480:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2023832317, $changed, -1, "land.sungbin.androidplayground.ComposableSingletons$PlaygroundActivityKt.lambda$2023832317.<anonymous> (PlaygroundActivity.kt:24)");
         }

         Modifier var10000 = WindowInsetsPadding_androidKt.statusBarsPadding((Modifier)Modifier.Companion);
         int var2 = 100;
         int var3 = false;
         var10000 = ScrollKt.horizontalScroll$default(SizeKt.width-3ABfNKs(var10000, Dp.constructor-impl((float)var2)), ScrollKt.rememberScrollState(0, $composer, 0, 1), false, (FlingBehavior)null, false, 14, (Object)null);
         double var62 = 0.5D;
         int var4 = false;
         Modifier var63 = BorderKt.border-xT4_qwU$default(var10000, Dp.constructor-impl((float)var62), Color.Companion.getBlack-0d7_KjU(), (Shape)null, 4, (Object)null);
         int var6 = 0;
         int var7 = false;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
         Alignment var64 = Alignment.Companion.getTopStart();
         var4 = false;
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
         ComposerKt.sourceInformationMarkerStart($composer, -1620987342, "C32@1168L238:PlaygroundActivity.kt#qshby3");
         var10000 = (Modifier)Modifier.Companion;
         int var31 = 50;
         int var32 = false;
         Modifier var67 = SizeKt.width-3ABfNKs(var10000, Dp.constructor-impl((float)var31));
         int var34 = 6;
         int var35 = false;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
         Horizontal var68 = Arrangement.INSTANCE.getStart();
         Vertical var36 = Alignment.Companion.getTop();
         MeasurePolicy var37 = RowKt.rowMeasurePolicy(var68, var36, $composer, 14 & var34 >> 3 | 112 & var34 >> 3);
         int var39 = 112 & var34 << 3;
         int var40 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
         int var41 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var42 = $composer.getCurrentCompositionLocalMap();
         Modifier var43 = ComposedModifierKt.materializeModifier($composer, var67);
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
         ComposerKt.sourceInformationMarkerStart($composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
         int var56 = 6 | 112 & var34 >> 6;
         RowScope var66 = (RowScope)RowScopeInstance.INSTANCE;
         int var59 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -1484778394, "C33@1246L69,34@1326L70:PlaygroundActivity.kt#qshby3");
         Modifier var10001 = (Modifier)Modifier.Companion;
         int var60 = 300;
         int var61 = false;
         var10001 = SizeKt.width-3ABfNKs(var10001, Dp.constructor-impl((float)var60));
         int var69 = 1;
         var61 = false;
         TextKt.Text--4IGK_g("1", BorderKt.border-xT4_qwU$default(var10001, Dp.constructor-impl((float)var69), Color.Companion.getBlue-0d7_KjU(), (Shape)null, 4, (Object)null), 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 54, 0, 131068);
         var10001 = (Modifier)Modifier.Companion;
         var69 = 100;
         var61 = false;
         var10001 = SizeKt.width-3ABfNKs(var10001, Dp.constructor-impl((float)var69));
         var69 = 1;
         var61 = false;
         TextKt.Text--4IGK_g("2", BorderKt.border-xT4_qwU$default(var10001, Dp.constructor-impl((float)var69), Color.Companion.getGreen-0d7_KjU(), (Shape)null, 4, (Object)null), 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 54, 0, 131068);
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
