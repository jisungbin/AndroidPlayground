package land.sungbin.androidplayground;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DurationBasedAnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Brush.Companion;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnitKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\b¨\u0006\t²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u0084\u0002"},
   d2 = {"RainbowAnimatedText", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "RainbowTextPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "offset", ""}
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivityKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 Offset.kt\nandroidx/compose/ui/geometry/OffsetKt\n+ 4 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n+ 5 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 6 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 7 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 8 Composer.kt\nandroidx/compose/runtime/Updater\n+ 9 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,120:1\n1282#2,6:121\n1282#2,3:127\n1285#2,3:138\n30#3:130\n30#3:134\n53#4,3:131\n53#4,3:135\n70#5:141\n68#5,8:142\n77#5:180\n79#6,6:150\n86#6,3:165\n89#6,2:174\n93#6:179\n347#7,9:156\n356#7,3:176\n4206#8,6:168\n85#9:181\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivityKt\n*L\n67#1:121,6\n87#1:127,3\n87#1:138,3\n90#1:130\n91#1:134\n90#1:131,3\n91#1:135,3\n113#1:141\n113#1:142,8\n113#1:180\n113#1:150,6\n113#1:165,3\n113#1:174,2\n113#1:179\n113#1:156,9\n113#1:176,3\n113#1:168,6\n76#1:181\n*E\n"})
public final class PlaygroundActivityKt {
   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void RainbowAnimatedText(@NotNull String text, @Nullable Modifier modifier, @Nullable Composer $composer, int $changed, int var4) {
      Intrinsics.checkNotNullParameter(text, "text");
      $composer = $composer.startRestartGroup(1131697729);
      ComposerKt.sourceInformation($composer, "C(RainbowAnimatedText)N(text,modifier)66@2544L131,74@2733L61,75@2830L270,86@3165L168,102@3538L86:PlaygroundActivity.kt#qshby3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(text) ? 4 : 2);
      }

      if ((var4 & 2) != 0) {
         $dirty |= 48;
      } else if (($changed & 48) == 0) {
         $dirty |= $composer.changed(modifier) ? 32 : 16;
      }

      if ($composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
         if ((var4 & 2) != 0) {
            modifier = (Modifier)Modifier.Companion;
         }

         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1131697729, $dirty, -1, "land.sungbin.androidplayground.RainbowAnimatedText (PlaygroundActivity.kt:64)");
         }

         ComposerKt.sourceInformationMarkerStart($composer, 934796036, "CC(remember):PlaygroundActivity.kt#9igjgp");
         boolean var9 = false;
         int var10 = false;
         Object var11 = $composer.rememberedValue();
         int var12 = false;
         boolean var13;
         Object var10000;
         if (var11 == Composer.Companion.getEmpty()) {
            var13 = false;
            Color[] var14 = new Color[]{Color.box-impl(Color.Companion.getRed-0d7_KjU()), Color.box-impl(Color.Companion.getMagenta-0d7_KjU()), Color.box-impl(Color.Companion.getBlue-0d7_KjU()), Color.box-impl(Color.Companion.getCyan-0d7_KjU()), Color.box-impl(Color.Companion.getGreen-0d7_KjU()), Color.box-impl(Color.Companion.getYellow-0d7_KjU()), Color.box-impl(Color.Companion.getRed-0d7_KjU())};
            Object var31 = CollectionsKt.listOf(var14);
            $composer.updateRememberedValue(var31);
            var10000 = var31;
         } else {
            var10000 = var11;
         }

         List var7 = (List)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         List rainbowColors = var7;
         InfiniteTransition infiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition("rainbow_text_transition", $composer, 6, 0);
         State offset$delegate = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0F, 2000.0F, AnimationSpecKt.infiniteRepeatable-9IiC70o$default((DurationBasedAnimationSpec)AnimationSpecKt.tween$default(3000, 0, EasingKt.getLinearEasing(), 2, (Object)null), RepeatMode.Restart, 0L, 4, (Object)null), "rainbow_offset", $composer, 25008 | InfiniteTransition.$stable | InfiniteRepeatableSpec.$stable << 9, 0);
         float var28 = RainbowAnimatedText$lambda$1(offset$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, 934815945, "CC(remember):PlaygroundActivity.kt#9igjgp");
         var13 = $composer.changed(var28);
         int var32 = false;
         Object var15 = $composer.rememberedValue();
         int var16 = false;
         if (!var13 && var15 != Composer.Companion.getEmpty()) {
            var10000 = var15;
         } else {
            int var17 = false;
            Companion var33 = Brush.Companion;
            float var18 = RainbowAnimatedText$lambda$1(offset$delegate);
            float var19 = 0.0F;
            int var20 = false;
            int var21 = false;
            long var22 = (long)Float.floatToRawIntBits(var18);
            long var24 = (long)Float.floatToRawIntBits(var19);
            long var10002 = Offset.constructor-impl(var22 << 32 | var24 & 4294967295L);
            var18 = RainbowAnimatedText$lambda$1(offset$delegate) + 500.0F;
            var19 = 0.0F;
            var20 = false;
            var21 = false;
            var22 = (long)Float.floatToRawIntBits(var18);
            var24 = (long)Float.floatToRawIntBits(var19);
            Object var26 = Companion.linearGradient-mHitzGk$default(var33, rainbowColors, var10002, Offset.constructor-impl(var22 << 32 | var24 & 4294967295L), 0, 8, (Object)null);
            $composer.updateRememberedValue(var26);
            var10000 = var26;
         }

         Brush var30 = (Brush)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         TextStyle rainbowTextStyle = TextStyle.copy-Ns73l9s$default(TextStyle.Companion.getDefault(), var30, 0.0F, TextUnitKt.getSp(40), FontWeight.Companion.getBold(), (FontStyle)null, (FontSynthesis)null, (FontFamily)null, (String)null, 0L, (BaselineShift)null, (TextGeometricTransform)null, (LocaleList)null, 0L, (TextDecoration)null, (Shadow)null, (DrawStyle)null, 0, 0, 0L, (TextIndent)null, (PlatformTextStyle)null, (LineHeightStyle)null, 0, 0, (TextMotion)null, 33554418, (Object)null);
         BasicTextKt.BasicText-RWo7tUw(text, modifier, rainbowTextStyle, (Function1)null, 0, false, 0, 0, (ColorProducer)null, (TextAutoSize)null, $composer, 14 & $dirty | 112 & $dirty, 1016);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      } else {
         $composer.skipToGroupEnd();
      }

      ScopeUpdateScope var34 = $composer.endRestartGroup();
      if (var34 != null) {
         var34.updateScope(PlaygroundActivityKt::RainbowAnimatedText$lambda$3);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void RainbowTextPreview(@Nullable Composer $composer, int $changed) {
      $composer = $composer.startRestartGroup(387887630);
      ComposerKt.sourceInformation($composer, "C(RainbowTextPreview)112@3688L135:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute($changed != 0, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(387887630, $changed, -1, "land.sungbin.androidplayground.RainbowTextPreview (PlaygroundActivity.kt:111)");
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
         ComposerKt.sourceInformationMarkerStart($composer, -767618826, "C116@3782L37:PlaygroundActivity.kt#qshby3");
         RainbowAnimatedText("Hello Rainbow!", (Modifier)null, $composer, 6, 2);
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

      ScopeUpdateScope var31 = $composer.endRestartGroup();
      if (var31 != null) {
         var31.updateScope(PlaygroundActivityKt::RainbowTextPreview$lambda$1);
      }

   }

   private static final float RainbowAnimatedText$lambda$1(State $offset$delegate) {
      Object var2 = null;
      KProperty var3 = null;
      int var4 = false;
      return ((Number)$offset$delegate.getValue()).floatValue();
   }

   private static final Unit RainbowAnimatedText$lambda$3(String $text, Modifier $modifier, int $$changed, int $$default, Composer $composer, int $force) {
      RainbowAnimatedText($text, $modifier, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1), $$default);
      return Unit.INSTANCE;
   }

   private static final Unit RainbowTextPreview$lambda$1(int $$changed, Composer $composer, int $force) {
      RainbowTextPreview($composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }
}
