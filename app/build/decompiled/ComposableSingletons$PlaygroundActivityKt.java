package land.sungbin.androidplayground;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.Arrangement.Vertical;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
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
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/ComposableSingletons$PlaygroundActivityKt\n+ 2 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 3 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 4 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 5 Composer.kt\nandroidx/compose/runtime/Updater\n+ 6 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 7 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,65:1\n87#2:66\n83#2,10:67\n94#2:116\n79#3,6:77\n86#3,3:92\n89#3,2:101\n93#3:115\n347#4,9:83\n356#4:103\n357#4,2:113\n4206#5,6:95\n113#6:104\n113#6:111\n113#6:112\n1282#7,6:105\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/ComposableSingletons$PlaygroundActivityKt\n*L\n21#1:66\n21#1:67,10\n21#1:116\n21#1:77,6\n21#1:92,3\n21#1:101,2\n21#1:115\n21#1:83,9\n21#1:103\n21#1:113,2\n21#1:95,6\n23#1:104\n28#1:111\n32#1:112\n26#1:105,6\n*E\n"})
public final class ComposableSingletons$PlaygroundActivityKt {
   @NotNull
   public static final ComposableSingletons$PlaygroundActivityKt INSTANCE = new ComposableSingletons$PlaygroundActivityKt();
   @NotNull
   private static Function2 lambda$2023832317 = (Function2)ComposableLambdaKt.composableLambdaInstance(2023832317, false, ComposableSingletons$PlaygroundActivityKt::lambda_2023832317$lambda$3);

   @NotNull
   public final Function2 getLambda$2023832317$app_debug() {
      return lambda$2023832317;
   }

   private static final Unit lambda_2023832317$lambda$3$lambda$2$lambda$1$lambda$0(RecomposeScope $r) {
      $r.invalidate();
      return Unit.INSTANCE;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit lambda_2023832317$lambda$3(Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C20@777L417:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2023832317, $changed, -1, "land.sungbin.androidplayground.ComposableSingletons$PlaygroundActivityKt.lambda$2023832317.<anonymous> (PlaygroundActivity.kt:20)");
         }

         int var6 = 0;
         int var7 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
         Modifier var2 = (Modifier)Modifier.Companion;
         Vertical var3 = Arrangement.INSTANCE.getTop();
         Horizontal var4 = Alignment.Companion.getStart();
         MeasurePolicy var8 = ColumnKt.columnMeasurePolicy(var3, var4, $composer, 14 & var6 >> 3 | 112 & var6 >> 3);
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
         ComposerKt.sourceInformationMarkerStart($composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
         int var27 = 6 | 112 & var6 >> 6;
         ColumnScope var10000 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var30 = false;
         ComposerKt.sourceInformationMarkerStart($composer, 182746728, "C21@794L47,22@850L40,24@908L21,25@1014L18,25@938L95,27@1043L40,29@1102L9,31@1121L40,33@1177L9:PlaygroundActivity.kt#qshby3");
         SpacerKt.Spacer(WindowInsetsPadding_androidKt.statusBarsPadding((Modifier)Modifier.Companion), $composer, 0);
         Modifier var46 = (Modifier)Modifier.Companion;
         int var31 = 4;
         int var32 = false;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var46, Dp.constructor-impl((float)var31)), $composer, 6);
         RecomposeScope var48 = ComposablesKt.getCurrentRecomposeScope($composer, 0);
         String var47 = var48 + " with " + System.currentTimeMillis();
         Modifier var10001 = (Modifier)Modifier.Companion;
         boolean var10002 = false;
         Object var10003 = null;
         Object var10004 = null;
         ComposerKt.sourceInformationMarkerStart($composer, -686834939, "CC(remember):PlaygroundActivity.kt#9igjgp");
         boolean var34 = $composer.changedInstance(var48);
         int var35 = false;
         Object var36 = $composer.rememberedValue();
         int var37 = false;
         Object var10005;
         if (!var34 && var36 != Composer.Companion.getEmpty()) {
            var10005 = var36;
         } else {
            Object var38 = null;
            Object var39 = null;
            boolean var40 = false;
            Modifier var41 = var10001;
            String var42 = var47;
            int var43 = false;
            Function0 var44 = ComposableSingletons$PlaygroundActivityKt::lambda_2023832317$lambda$3$lambda$2$lambda$1$lambda$0;
            var47 = var42;
            var10001 = var41;
            var10002 = var40;
            var10003 = var39;
            var10004 = var38;
            $composer.updateRememberedValue(var44);
            var10005 = var44;
         }

         Function0 var49 = (Function0)var10005;
         ComposerKt.sourceInformationMarkerEnd($composer);
         TextKt.Text--4IGK_g(var47, ClickableKt.clickable-XHw0xAI$default(var10001, var10002, (String)var10003, (Role)var10004, var49, 7, (Object)null), 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131068);
         var46 = (Modifier)Modifier.Companion;
         int var50 = 4;
         int var33 = false;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var46, Dp.constructor-impl((float)var50)), $composer, 6);
         TestImpl.INSTANCE.Content($composer, 6);
         var46 = (Modifier)Modifier.Companion;
         var50 = 4;
         var33 = false;
         SpacerKt.Spacer(SizeKt.height-3ABfNKs(var46, Dp.constructor-impl((float)var50)), $composer, 6);
         Test2.Companion.Content($composer, 6);
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
