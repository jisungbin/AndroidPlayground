package land.sungbin.androidplayground;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
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
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/ComposableSingletons$PlaygroundActivityKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n+ 7 Row.kt\nandroidx/compose/foundation/layout/RowKt\n*L\n1#1,51:1\n113#2:52\n113#2:53\n118#2:54\n113#2:130\n113#2:131\n113#2:132\n113#2:133\n70#3:55\n67#3,9:56\n77#3:141\n79#4,6:65\n86#4,3:80\n89#4,2:89\n79#4,6:103\n86#4,3:118\n89#4,2:127\n93#4:136\n93#4:140\n347#5,9:71\n356#5:91\n347#5,9:109\n356#5:129\n357#5,2:134\n357#5,2:138\n4206#6,6:83\n4206#6,6:121\n99#7:92\n95#7,10:93\n106#7:137\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/ComposableSingletons$PlaygroundActivityKt\n*L\n28#1:52\n30#1:53\n31#1:54\n37#1:130\n38#1:131\n43#1:132\n44#1:133\n25#1:55\n25#1:56,9\n25#1:141\n25#1:65,6\n25#1:80,3\n25#1:89,2\n33#1:103,6\n33#1:118,3\n33#1:127,2\n33#1:136\n25#1:140\n25#1:71,9\n25#1:91\n33#1:109,9\n33#1:129\n33#1:134,2\n25#1:138,2\n25#1:83,6\n33#1:121,6\n33#1:92\n33#1:93,10\n33#1:137\n*E\n"})
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
      ComposerKt.sourceInformation($composer, "C28@1051L21,24@934L547:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2023832317, $changed, -1, "land.sungbin.androidplayground.ComposableSingletons$PlaygroundActivityKt.lambda$2023832317.<anonymous> (PlaygroundActivity.kt:24)");
         }

         Modifier var10000 = WindowInsetsPadding_androidKt.statusBarsPadding((Modifier)Modifier.Companion);
         int var2 = 100;
         int var3 = false;
         var10000 = ScrollKt.horizontalScroll$default(SizeKt.width-3ABfNKs(var10000, Dp.constructor-impl((float)var2)), ScrollKt.rememberScrollState(0, $composer, 0, 1), false, (FlingBehavior)null, false, 14, (Object)null);
         var2 = 50;
         var3 = false;
         var10000 = PaddingKt.padding-qDBjuR0$default(var10000, Dp.constructor-impl((float)var2), 0.0F, 0.0F, 0.0F, 14, (Object)null);
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
         ComposerKt.sourceInformationMarkerStart($composer, -1620985172, "C32@1165L308:PlaygroundActivity.kt#qshby3");
         int var32 = 0;
         int var33 = false;
         ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
         Modifier var34 = (Modifier)Modifier.Companion;
         Horizontal var35 = Arrangement.INSTANCE.getStart();
         Vertical var36 = Alignment.Companion.getTop();
         MeasurePolicy var37 = RowKt.rowMeasurePolicy(var35, var36, $composer, 14 & var32 >> 3 | 112 & var32 >> 3);
         int var39 = 112 & var32 << 3;
         int var40 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
         int var41 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var42 = $composer.getCurrentCompositionLocalMap();
         Modifier var43 = ComposedModifierKt.materializeModifier($composer, var34);
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
         int var56 = 6 | 112 & var32 >> 6;
         RowScope var66 = (RowScope)RowScopeInstance.INSTANCE;
         int var59 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -1484774302, "C33@1181L135,39@1327L136:PlaygroundActivity.kt#qshby3");
         Modifier var10001 = (Modifier)Modifier.Companion;
         int var60 = 300;
         int var61 = false;
         var10001 = SizeKt.width-3ABfNKs(var10001, Dp.constructor-impl((float)var60));
         int var67 = 1;
         var61 = false;
         TextKt.Text--4IGK_g("1", BorderKt.border-xT4_qwU$default(var10001, Dp.constructor-impl((float)var67), Color.Companion.getBlue-0d7_KjU(), (Shape)null, 4, (Object)null), 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 54, 0, 131068);
         var10001 = (Modifier)Modifier.Companion;
         var67 = 100;
         var61 = false;
         var10001 = SizeKt.width-3ABfNKs(var10001, Dp.constructor-impl((float)var67));
         var67 = 1;
         var61 = false;
         TextKt.Text--4IGK_g("2", BorderKt.border-xT4_qwU$default(var10001, Dp.constructor-impl((float)var67), Color.Companion.getGreen-0d7_KjU(), (Shape)null, 4, (Object)null), 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 54, 0, 131068);
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
