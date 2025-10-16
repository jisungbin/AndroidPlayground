package androidx.compose.foundation.demos.text;

import android.graphics.Shader;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.Arrangement.Vertical;
import androidx.compose.material.ButtonColors;
import androidx.compose.material.ButtonElevation;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.SliderColors;
import androidx.compose.material.SliderKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.ShaderKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.AnnotatedString.Builder;
import androidx.compose.ui.text.AnnotatedString.Range;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import land.sungbin.androidplayground.Language;
import land.sungbin.androidplayground.LoKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001aM\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0007¢\u0006\u0002\u0010\r\u001aP\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u001a\u0018\u0010\u0015\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0005\u001a\u0018\u0010\u0019\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0005¨\u0006\u001a²\u0006\n\u0010\u0004\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010\u0006\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010\u0007\u001a\u00020\u0005X\u008a\u008e\u0002"},
   d2 = {"BrushAnimatingSpanDemo", "", "(Landroidx/compose/runtime/Composer;I)V", "BrushAnimatingSpanText", "preWordCount", "", "highlightWordCount", "postWordCount", "animatable", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "animatable2", "(IIILandroidx/compose/animation/core/Animatable;Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/Composer;I)V", "calculateAnnotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "text", "start", "end", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "allLeftWidth", "", "Landroidx/compose/foundation/demos/text/Segment;", "index", "allRightWidth", "app_debug"}
)
@SourceDebugExtension({"SMAP\nTest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Test.kt\nandroidx/compose/foundation/demos/text/TestKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 Effects.kt\nandroidx/compose/runtime/EffectsKt\n+ 4 Effects.kt\nandroidx/compose/runtime/EffectsKt$rememberCoroutineScope$1\n+ 5 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 6 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 7 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 8 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 9 Composer.kt\nandroidx/compose/runtime/Updater\n+ 10 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 11 AnnotatedString.kt\nandroidx/compose/ui/text/AnnotatedStringKt\n+ 12 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 13 SnapshotIntState.kt\nandroidx/compose/runtime/SnapshotIntStateKt__SnapshotIntStateKt\n*L\n1#1,311:1\n1282#2,6:312\n1282#2,6:318\n1282#2,3:331\n1285#2,3:335\n1282#2,6:338\n1282#2,6:344\n1282#2,6:350\n1282#2,6:432\n1282#2,6:438\n1282#2,6:444\n1282#2,6:450\n1282#2,6:456\n1282#2,3:470\n1285#2,3:480\n1282#2,6:483\n1282#2,6:489\n1282#2,6:495\n607#3:324\n604#3,6:325\n605#4:334\n113#5:356\n70#6:357\n67#6,9:358\n77#6:469\n79#7,6:367\n86#7,3:382\n89#7,2:391\n79#7,6:405\n86#7,3:420\n89#7,2:429\n93#7:464\n93#7:468\n347#8,9:373\n356#8:393\n347#8,9:411\n356#8:431\n357#8,2:462\n357#8,2:466\n4206#9,6:385\n4206#9,6:423\n87#10:394\n83#10,10:395\n94#10:465\n1574#11:473\n1394#11,6:474\n1573#12:501\n1604#12,4:502\n78#13:506\n111#13,2:507\n78#13:509\n111#13,2:510\n78#13:512\n111#13,2:513\n*S KotlinDebug\n*F\n+ 1 Test.kt\nandroidx/compose/foundation/demos/text/TestKt\n*L\n59#1:312,6\n60#1:318,6\n61#1:331,3\n61#1:335,3\n63#1:338,6\n64#1:344,6\n65#1:350,6\n72#1:432,6\n80#1:438,6\n88#1:444,6\n101#1:450,6\n124#1:456,6\n146#1:470,3\n146#1:480,3\n161#1:483,6\n164#1:489,6\n175#1:495,6\n61#1:324\n61#1:325,6\n61#1:334\n67#1:356\n67#1:357\n67#1:358,9\n67#1:469\n67#1:367,6\n67#1:382,3\n67#1:391,2\n68#1:405,6\n68#1:420,3\n68#1:429,2\n68#1:464\n67#1:468\n67#1:373,9\n67#1:393\n68#1:411,9\n68#1:431\n68#1:462,2\n67#1:466,2\n67#1:385,6\n68#1:423,6\n68#1:394\n68#1:395,10\n68#1:465\n149#1:473\n152#1:474,6\n234#1:501\n234#1:502,4\n63#1:506\n63#1:507,2\n64#1:509\n64#1:510,2\n65#1:512\n65#1:513,2\n*E\n"})
public final class TestKt {
   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void BrushAnimatingSpanDemo(@Nullable Composer $composer, int $changed) {
      $composer = $composer.startRestartGroup(1503536626);
      ComposerKt.sourceInformation($composer, "C(BrushAnimatingSpanDemo)58@2373L27,59@2421L27,60@2472L24,62@2520L33,63@2582L34,64@2640L33,66@2677L1713:Test.kt#4udlp7");
      if ($composer.shouldExecute($changed != 0, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1503536626, $changed, -1, "androidx.compose.foundation.demos.text.BrushAnimatingSpanDemo (Test.kt:57)");
         }

         ComposerKt.sourceInformationMarkerStart($composer, 1789687757, "CC(remember):Test.kt#9igjgp");
         boolean var5 = false;
         int var6 = false;
         Object var7 = $composer.rememberedValue();
         int var8 = false;
         boolean var9;
         Object var10000;
         if (var7 == Composer.Companion.getEmpty()) {
            var9 = false;
            Object var82 = AnimatableKt.Animatable$default(0.0F, 0.0F, 2, (Object)null);
            $composer.updateRememberedValue(var82);
            var10000 = var82;
         } else {
            var10000 = var7;
         }

         Animatable animatable2 = (Animatable)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         Animatable animatable = animatable2;
         ComposerKt.sourceInformationMarkerStart($composer, 1789689293, "CC(remember):Test.kt#9igjgp");
         var6 = false;
         int var79 = false;
         Object var81 = $composer.rememberedValue();
         var9 = false;
         boolean var10;
         if (var81 == Composer.Companion.getEmpty()) {
            var10 = false;
            Object var86 = AnimatableKt.Animatable$default(0.0F, 0.0F, 2, (Object)null);
            $composer.updateRememberedValue(var86);
            var10000 = var86;
         } else {
            var10000 = var81;
         }

         Animatable var4 = (Animatable)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         animatable2 = var4;
         var79 = false;
         var8 = false;
         ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
         ComposerKt.sourceInformationMarkerStart($composer, 683737348, "CC(remember):Effects.kt#9igjgp");
         boolean var11 = false;
         int var12 = false;
         Object var13 = $composer.rememberedValue();
         int var14 = false;
         if (var13 == Composer.Companion.getEmpty()) {
            int var15 = false;
            int var16 = false;
            Object var97 = EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, $composer);
            $composer.updateRememberedValue(var97);
            var10000 = var97;
         } else {
            var10000 = var13;
         }

         CoroutineScope var17 = (CoroutineScope)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         CoroutineScope coroutineScope = var17;
         ComposerKt.sourceInformationMarkerStart($composer, 1789692467, "CC(remember):Test.kt#9igjgp");
         var8 = false;
         var9 = false;
         Object var87 = $composer.rememberedValue();
         var11 = false;
         if (var87 == Composer.Companion.getEmpty()) {
            var12 = false;
            Object var90 = SnapshotIntStateKt.mutableIntStateOf(5);
            $composer.updateRememberedValue(var90);
            var10000 = var90;
         } else {
            var10000 = var87;
         }

         MutableIntState highlightWordCount$delegate = (MutableIntState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         MutableIntState preWordCount$delegate = highlightWordCount$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 1789694452, "CC(remember):Test.kt#9igjgp");
         var9 = false;
         var10 = false;
         Object var89 = $composer.rememberedValue();
         var12 = false;
         boolean var91;
         if (var89 == Composer.Companion.getEmpty()) {
            var91 = false;
            Object var93 = SnapshotIntStateKt.mutableIntStateOf(15);
            $composer.updateRememberedValue(var93);
            var10000 = var93;
         } else {
            var10000 = var89;
         }

         MutableIntState postWordCount$delegate = (MutableIntState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         highlightWordCount$delegate = postWordCount$delegate;
         ComposerKt.sourceInformationMarkerStart($composer, 1789696307, "CC(remember):Test.kt#9igjgp");
         var10 = false;
         var11 = false;
         Object var92 = $composer.rememberedValue();
         var91 = false;
         if (var92 == Composer.Companion.getEmpty()) {
            var14 = false;
            Object var95 = SnapshotIntStateKt.mutableIntStateOf(5);
            $composer.updateRememberedValue(var95);
            var10000 = var95;
         } else {
            var10000 = var92;
         }

         MutableIntState var83 = (MutableIntState)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         postWordCount$delegate = var83;
         Modifier var101 = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
         int var84 = 16;
         var9 = false;
         Modifier var85 = PaddingKt.padding-3ABfNKs(var101, Dp.constructor-impl((float)var84));
         int var94 = 6;
         var91 = false;
         ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
         Alignment var88 = Alignment.Companion.getTopStart();
         var10 = false;
         MeasurePolicy var96 = BoxKt.maybeCachedBoxMeasurePolicy(var88, var10);
         int var98 = 112 & var94 << 3;
         int var99 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
         int var18 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var19 = $composer.getCurrentCompositionLocalMap();
         Modifier var20 = ComposedModifierKt.materializeModifier($composer, var85);
         Function0 var21 = ComposeUiNode.Companion.getConstructor();
         int var22 = 6 | 896 & var98 << 6;
         int var23 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var21);
         } else {
            $composer.useNode();
         }

         Composer var24 = Updater.constructor-impl($composer);
         int var25 = false;
         Updater.set-impl(var24, var96, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var24, var19, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var26 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var27 = false;
         int var29 = false;
         if (var24.getInserting() || !Intrinsics.areEqual(var24.rememberedValue(), var18)) {
            var24.updateRememberedValue(var18);
            var24.apply(var18, var26);
         }

         Updater.set-impl(var24, var20, ComposeUiNode.Companion.getSetModifier());
         int var30 = 14 & var22 >> 6;
         int var32 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
         int var33 = 6 | 112 & var94 >> 6;
         BoxScope var102 = (BoxScope)BoxScopeInstance.INSTANCE;
         int var36 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -1617563834, "C67@2737L1649:Test.kt#4udlp7");
         int var38 = 0;
         int var39 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
         Modifier var40 = (Modifier)Modifier.Companion;
         Vertical var41 = Arrangement.INSTANCE.getTop();
         Horizontal var42 = Alignment.Companion.getStart();
         MeasurePolicy var43 = ColumnKt.columnMeasurePolicy(var41, var42, $composer, 14 & var38 >> 3 | 112 & var38 >> 3);
         int var45 = 112 & var38 << 3;
         int var46 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
         int var47 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
         CompositionLocalMap var48 = $composer.getCurrentCompositionLocalMap();
         Modifier var49 = ComposedModifierKt.materializeModifier($composer, var40);
         Function0 var50 = ComposeUiNode.Companion.getConstructor();
         int var51 = 6 | 896 & var45 << 6;
         int var52 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
         if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
         }

         $composer.startReusableNode();
         if ($composer.getInserting()) {
            $composer.createNode(var50);
         } else {
            $composer.useNode();
         }

         Composer var53 = Updater.constructor-impl($composer);
         int var54 = false;
         Updater.set-impl(var53, var43, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl(var53, var48, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 var55 = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var56 = false;
         int var58 = false;
         if (var53.getInserting() || !Intrinsics.areEqual(var53.rememberedValue(), var47)) {
            var53.updateRememberedValue(var47);
            var53.apply(var47, var55);
         }

         Updater.set-impl(var53, var49, ComposeUiNode.Companion.getSetModifier());
         int var59 = 14 & var51 >> 6;
         int var61 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
         int var62 = 6 | 112 & var38 >> 6;
         ColumnScope var103 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var65 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -447055375, "C68@2752L22,71@2853L34,69@2781L165,76@2954L28,79@3067L40,77@2989L177,84@3174L23,87@3277L35,85@3204L167,92@3379L224,100@3636L508,99@3610L571,123@4214L126,122@4188L192:Test.kt#4udlp7");
         TextKt.Text--4IGK_g("Pre Word Count", (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 6, 0, 131070);
         float var104 = (float)BrushAnimatingSpanDemo$lambda$3(preWordCount$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, -845703496, "CC(remember):Test.kt#9igjgp");
         boolean var67 = false;
         int var68 = false;
         Object var69 = $composer.rememberedValue();
         int var70 = false;
         Object var10001;
         float var71;
         boolean var72;
         Function1 var73;
         if (var69 == Composer.Companion.getEmpty()) {
            var71 = var104;
            var72 = false;
            var73 = TestKt::BrushAnimatingSpanDemo$lambda$11$0$0$0;
            var104 = var71;
            $composer.updateRememberedValue(var73);
            var10001 = var73;
         } else {
            var10001 = var69;
         }

         Function1 var75 = (Function1)var10001;
         ComposerKt.sourceInformationMarkerEnd($composer);
         SliderKt.Slider(var104, var75, (Modifier)null, false, RangesKt.rangeTo(0.0F, 16.0F), 16, (Function0)null, (MutableInteractionSource)null, (SliderColors)null, $composer, 196656, 460);
         TextKt.Text--4IGK_g("Highlight Word Count", (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 6, 0, 131070);
         var104 = (float)BrushAnimatingSpanDemo$lambda$6(highlightWordCount$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, -845696642, "CC(remember):Test.kt#9igjgp");
         var67 = false;
         var68 = false;
         var69 = $composer.rememberedValue();
         var70 = false;
         if (var69 == Composer.Companion.getEmpty()) {
            var71 = var104;
            var72 = false;
            var73 = TestKt::BrushAnimatingSpanDemo$lambda$11$0$1$0;
            var104 = var71;
            $composer.updateRememberedValue(var73);
            var10001 = var73;
         } else {
            var10001 = var69;
         }

         var75 = (Function1)var10001;
         ComposerKt.sourceInformationMarkerEnd($composer);
         SliderKt.Slider(var104, var75, (Modifier)null, false, RangesKt.rangeTo(0.0F, 20.0F), 16, (Function0)null, (MutableInteractionSource)null, (SliderColors)null, $composer, 196656, 460);
         TextKt.Text--4IGK_g("Post Word Count", (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 6, 0, 131070);
         var104 = (float)BrushAnimatingSpanDemo$lambda$9(postWordCount$delegate);
         ComposerKt.sourceInformationMarkerStart($composer, -845689927, "CC(remember):Test.kt#9igjgp");
         var67 = false;
         var68 = false;
         var69 = $composer.rememberedValue();
         var70 = false;
         if (var69 == Composer.Companion.getEmpty()) {
            var71 = var104;
            var72 = false;
            var73 = TestKt::BrushAnimatingSpanDemo$lambda$11$0$2$0;
            var104 = var71;
            $composer.updateRememberedValue(var73);
            var10001 = var73;
         } else {
            var10001 = var69;
         }

         var75 = (Function1)var10001;
         ComposerKt.sourceInformationMarkerEnd($composer);
         SliderKt.Slider(var104, var75, (Modifier)null, false, RangesKt.rangeTo(0.0F, 16.0F), 16, (Function0)null, (MutableInteractionSource)null, (SliderColors)null, $composer, 196656, 460);
         BrushAnimatingSpanText(BrushAnimatingSpanDemo$lambda$3(preWordCount$delegate), BrushAnimatingSpanDemo$lambda$6(highlightWordCount$delegate), BrushAnimatingSpanDemo$lambda$9(postWordCount$delegate), animatable, animatable2, $composer, Animatable.$stable << 9 | Animatable.$stable << 12);
         ComposerKt.sourceInformationMarkerStart($composer, -845677966, "CC(remember):Test.kt#9igjgp");
         var67 = $composer.changedInstance(coroutineScope) | $composer.changedInstance(animatable) | $composer.changedInstance(animatable2);
         var68 = false;
         var69 = $composer.rememberedValue();
         var70 = false;
         Function0 var74;
         if (!var67 && var69 != Composer.Companion.getEmpty()) {
            var10000 = var69;
         } else {
            var72 = false;
            var74 = TestKt::BrushAnimatingSpanDemo$lambda$11$0$3$0;
            $composer.updateRememberedValue(var74);
            var10000 = var74;
         }

         Function0 var100 = (Function0)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         ButtonKt.Button(var100, (Modifier)null, false, (MutableInteractionSource)null, (ButtonElevation)null, (Shape)null, (BorderStroke)null, (ButtonColors)null, (PaddingValues)null, ComposableSingletons$TestKt.INSTANCE.getLambda$-1973353338$app_debug(), $composer, 805306368, 510);
         ComposerKt.sourceInformationMarkerStart($composer, -845659852, "CC(remember):Test.kt#9igjgp");
         var67 = $composer.changedInstance(coroutineScope) | $composer.changedInstance(animatable) | $composer.changedInstance(animatable2);
         var68 = false;
         var69 = $composer.rememberedValue();
         var70 = false;
         if (!var67 && var69 != Composer.Companion.getEmpty()) {
            var10000 = var69;
         } else {
            var72 = false;
            var74 = TestKt::BrushAnimatingSpanDemo$lambda$11$0$4$0;
            $composer.updateRememberedValue(var74);
            var10000 = var74;
         }

         var100 = (Function0)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         ButtonKt.Button(var100, (Modifier)null, false, (MutableInteractionSource)null, (ButtonElevation)null, (Shape)null, (BorderStroke)null, (ButtonColors)null, (PaddingValues)null, ComposableSingletons$TestKt.INSTANCE.getLambda$560503471$app_debug(), $composer, 805306368, 510);
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

      ScopeUpdateScope var105 = $composer.endRestartGroup();
      if (var105 != null) {
         var105.updateScope(TestKt::BrushAnimatingSpanDemo$lambda$12);
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void BrushAnimatingSpanText(int preWordCount, int highlightWordCount, int postWordCount, @NotNull Animatable animatable, @NotNull Animatable animatable2, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(animatable, "animatable");
      Intrinsics.checkNotNullParameter(animatable2, "animatable2");
      $composer = $composer.startRestartGroup(1432506341);
      ComposerKt.sourceInformation($composer, "C(BrushAnimatingSpanText)N(preWordCount,highlightWordCount,postWordCount,animatable,animatable2)145@4644L465,160@5136L52,163@5212L238,174@5510L31,174@5454L88:Test.kt#4udlp7");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(preWordCount) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changed(highlightWordCount) ? 32 : 16;
      }

      if (($changed & 384) == 0) {
         $dirty |= $composer.changed(postWordCount) ? 256 : 128;
      }

      if (($changed & 3072) == 0) {
         $dirty |= (($changed & 4096) == 0 ? $composer.changed(animatable) : $composer.changedInstance(animatable)) ? 2048 : 1024;
      }

      if (($changed & 24576) == 0) {
         $dirty |= (($changed & '耀') == 0 ? $composer.changed(animatable2) : $composer.changedInstance(animatable2)) ? 16384 : 8192;
      }

      if ($composer.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1432506341, $dirty, -1, "androidx.compose.foundation.demos.text.BrushAnimatingSpanText (Test.kt:143)");
         }

         ComposerKt.sourceInformationMarkerStart($composer, -2045900234, "CC(remember):Test.kt#9igjgp");
         boolean var11 = ($dirty & 14) == 4 | ($dirty & 112) == 32 | ($dirty & 896) == 256;
         int var12 = false;
         Object var13 = $composer.rememberedValue();
         int var14 = false;
         boolean var15;
         Object var10000;
         boolean var16;
         boolean var17;
         boolean var18;
         boolean var21;
         if (!var11 && var13 != Composer.Companion.getEmpty()) {
            var10000 = var13;
         } else {
            var15 = false;
            var16 = false;
            var17 = false;
            var18 = false;
            Builder var19 = new Builder(0, 1, (DefaultConstructorMarker)null);
            var21 = false;
            var19.append(LoKt.loremIpsum$default((Language)null, preWordCount, (CharSequence)null, 5, (Object)null));
            int var59 = var19.getLength();
            Builder var22 = var19;
            SpanStyle var23 = new SpanStyle(0L, 0L, FontWeight.Companion.getBold(), (FontStyle)null, (FontSynthesis)null, (FontFamily)null, (String)null, 0L, (BaselineShift)null, (TextGeometricTransform)null, (LocaleList)null, 0L, (TextDecoration)null, (Shadow)null, (PlatformSpanStyle)null, (DrawStyle)null, 65531, (DefaultConstructorMarker)null);
            int var24 = false;
            int var25 = var19.pushStyle(var23);

            try {
               int var27 = false;
               var22.append(LoKt.loremIpsum$default((Language)null, highlightWordCount, (CharSequence)null, 5, (Object)null));
               Unit var26 = Unit.INSTANCE;
            } finally {
               var19.pop(var25);
            }

            int var60 = var19.getLength();
            var19.append(LoKt.loremIpsum$default((Language)null, postWordCount, (CharSequence)null, 5, (Object)null));
            AnnotatedString var28 = var19.toAnnotatedString();
            Triple var29 = new Triple(var28, var59, var60);
            $composer.updateRememberedValue(var29);
            var10000 = var29;
         }

         Triple var9 = (Triple)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         Triple var8 = var9;
         AnnotatedString text = (AnnotatedString)var9.component1();
         int start = ((Number)var8.component2()).intValue();
         int end = ((Number)var8.component3()).intValue();
         ComposerKt.sourceInformationMarkerStart($composer, -2045884903, "CC(remember):Test.kt#9igjgp");
         var15 = false;
         var16 = false;
         Object var61 = $composer.rememberedValue();
         var18 = false;
         boolean var63;
         if (var61 == Composer.Companion.getEmpty()) {
            var63 = false;
            Object var64 = SnapshotStateKt.mutableStateOf$default((Object)null, (SnapshotMutationPolicy)null, 2, (Object)null);
            $composer.updateRememberedValue(var64);
            var10000 = var64;
         } else {
            var10000 = var61;
         }

         MutableState var55;
         AnnotatedString var69;
         String var70;
         label268: {
            var55 = (MutableState)var10000;
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextLayoutResult var67 = (TextLayoutResult)var55.getValue();
            if (var67 != null) {
               TextLayoutInput var68 = var67.getLayoutInput();
               if (var68 != null) {
                  var69 = var68.getText();
                  if (var69 != null) {
                     var70 = var69.getText();
                     break label268;
                  }
               }
            }

            var70 = null;
         }

         String var56 = var70;
         ComposerKt.sourceInformationMarkerStart($composer, -2045882285, "CC(remember):Test.kt#9igjgp");
         var17 = $composer.changed(text) | $composer.changed(start) | $composer.changed(end) | $composer.changed(var56);
         var18 = false;
         Object var65 = $composer.rememberedValue();
         int var20 = false;
         if (!var17 && var65 != Composer.Companion.getEmpty()) {
            var10000 = var65;
         } else {
            var21 = false;
            Object var66 = calculateAnnotatedString(text, start, end, (TextLayoutResult)var55.getValue(), animatable, animatable2);
            $composer.updateRememberedValue(var66);
            var10000 = var66;
         }

         AnnotatedString var58 = (AnnotatedString)var10000;
         ComposerKt.sourceInformationMarkerEnd($composer);
         var69 = var58;
         Object var10001 = null;
         long var10002 = 0L;
         long var10003 = TextUnitKt.getSp(20);
         Object var10004 = null;
         Object var10005 = null;
         Object var10006 = null;
         long var10007 = 0L;
         Object var10008 = null;
         Object var10009 = null;
         long var10010 = 0L;
         byte var10011 = 0;
         boolean var10012 = false;
         byte var10013 = 0;
         byte var10014 = 0;
         Object var10015 = null;
         ComposerKt.sourceInformationMarkerStart($composer, -2045872956, "CC(remember):Test.kt#9igjgp");
         var16 = false;
         var17 = false;
         Object var62 = $composer.rememberedValue();
         var63 = false;
         Object var10016;
         if (var62 == Composer.Companion.getEmpty()) {
            Object var49 = null;
            byte var48 = 0;
            byte var47 = 0;
            boolean var46 = false;
            byte var45 = 0;
            long var43 = 0L;
            Object var42 = null;
            Object var41 = null;
            long var39 = 0L;
            Object var38 = null;
            Object var37 = null;
            Object var36 = null;
            long var34 = var10003;
            long var32 = 0L;
            Object var31 = null;
            var20 = false;
            Function1 var50 = TestKt::BrushAnimatingSpanText$lambda$3$0;
            var69 = var58;
            var10001 = var31;
            var10002 = var32;
            var10003 = var34;
            var10004 = var36;
            var10005 = var37;
            var10006 = var38;
            var10007 = var39;
            var10008 = var41;
            var10009 = var42;
            var10010 = var43;
            var10011 = var45;
            var10012 = var46;
            var10013 = var47;
            var10014 = var48;
            var10015 = var49;
            $composer.updateRememberedValue(var50);
            var10016 = var50;
         } else {
            var10016 = var62;
         }

         Function1 var57 = (Function1)var10016;
         ComposerKt.sourceInformationMarkerEnd($composer);
         TextKt.Text-IbK3jfQ(var69, (Modifier)var10001, var10002, var10003, (FontStyle)var10004, (FontWeight)var10005, (FontFamily)var10006, var10007, (TextDecoration)var10008, (TextAlign)var10009, var10010, var10011, var10012, var10013, var10014, (Map)var10015, var57, (TextStyle)null, $composer, 3072, 1572864, 196598);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      } else {
         $composer.skipToGroupEnd();
      }

      ScopeUpdateScope var71 = $composer.endRestartGroup();
      if (var71 != null) {
         var71.updateScope(TestKt::BrushAnimatingSpanText$lambda$4);
      }

   }

   @NotNull
   public static final AnnotatedString calculateAnnotatedString(@NotNull AnnotatedString text, int start, int end, @Nullable TextLayoutResult textLayoutResult, @NotNull final Animatable animatable, @NotNull final Animatable animatable2) {
      Intrinsics.checkNotNullParameter(text, "text");
      Intrinsics.checkNotNullParameter(animatable, "animatable");
      Intrinsics.checkNotNullParameter(animatable2, "animatable2");
      if (textLayoutResult == null) {
         return text;
      } else {
         int startLine = textLayoutResult.getLineForOffset(start);
         int endLine = textLayoutResult.getLineForOffset(end);
         final List lines = (List)(new ArrayList());
         float firstLineLeft = textLayoutResult.getBoundingBox(start).getLeft();
         float lastLineRight = textLayoutResult.getBoundingBox(end).getRight();
         if (startLine == endLine) {
            ((Collection)lines).add(new Segment(firstLineLeft, lastLineRight, start, end));
         } else {
            int i = startLine;
            if (startLine <= endLine) {
               while(true) {
                  Collection var12 = (Collection)lines;
                  Segment var13 = i == startLine ? new Segment(firstLineLeft, textLayoutResult.getLineRight(i), start, TextLayoutResult.getLineEnd$default(textLayoutResult, i, false, 2, (Object)null)) : (i == endLine ? new Segment(textLayoutResult.getLineLeft(i), lastLineRight, textLayoutResult.getLineStart(i), end) : new Segment(textLayoutResult.getLineLeft(i), textLayoutResult.getLineRight(i), textLayoutResult.getLineStart(i), TextLayoutResult.getLineEnd$default(textLayoutResult, i, false, 2, (Object)null)));
                  var12.add(var13);
                  if (i == endLine) {
                     break;
                  }

                  ++i;
               }
            }
         }

         Iterable var26 = (Iterable)lines;
         int var28 = false;
         Collection var15 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var26, 10)));
         int var16 = false;
         int var17 = 0;
         Iterator var18 = var26.iterator();

         while(var18.hasNext()) {
            Object var19 = var18.next();
            final int var20 = var17++;
            if (var20 < 0) {
               CollectionsKt.throwIndexOverflow();
            }

            final Segment var21 = (Segment)var19;
            int var23 = false;
            var15.add(new Range(new SpanStyle((Brush)(new ShaderBrush() {
               public Shader createShader_uvyYCjk/* $FF was: createShader-uvyYCjk*/(long var1) {
                  float animationValue = ((Number)animatable.getValue()).floatValue();
                  float animationValue2 = ((Number)animatable2.getValue()).floatValue();
                  float var5 = var21.getLeftPosition() - TestKt.allLeftWidth(lines, var20);
                  float var6 = 0.0F;
                  int var7 = false;
                  int var8 = false;
                  long var9 = (long)Float.floatToRawIntBits(var5);
                  long var11 = (long)Float.floatToRawIntBits(var6);
                  long var10000 = Offset.constructor-impl(var9 << 32 | var11 & 4294967295L);
                  var5 = var21.getRightPosition() + TestKt.allRightWidth(lines, var20);
                  var6 = 0.0F;
                  var7 = false;
                  var8 = false;
                  var9 = (long)Float.floatToRawIntBits(var5);
                  var11 = (long)Float.floatToRawIntBits(var6);
                  long var10001 = Offset.constructor-impl(var9 << 32 | var11 & 4294967295L);
                  Color[] var13 = new Color[]{Color.box-impl(Color.Companion.getBlue-0d7_KjU()), Color.box-impl(Color.Companion.getBlue-0d7_KjU()), Color.box-impl(Color.Companion.getGray-0d7_KjU()), Color.box-impl(Color.Companion.getBlack-0d7_KjU()), Color.box-impl(Color.Companion.getBlack-0d7_KjU())};
                  List var10002 = CollectionsKt.listOf(var13);
                  Float[] var14 = new Float[]{0.0F, animationValue, (animationValue + animationValue2) / (float)2, animationValue2, 1.0F};
                  return ShaderKt.LinearGradientShader-VjE6UOU$default(var10000, var10001, var10002, CollectionsKt.listOf(var14), 0, 16, (Object)null);
               }
            }), 0.0F, 0L, (FontWeight)null, (FontStyle)null, (FontSynthesis)null, (FontFamily)null, (String)null, 0L, (BaselineShift)null, (TextGeometricTransform)null, (LocaleList)null, 0L, (TextDecoration)null, (Shadow)null, (PlatformSpanStyle)null, (DrawStyle)null, 131070, (DefaultConstructorMarker)null), var21.getLeftOffset(), var21.getRightOffset()));
         }

         List brushSpans = (List)var15;
         String var27 = text.getText();
         List var29 = text.getParagraphStyles();
         List var14 = CollectionsKt.plus((Collection)text.getSpanStyles(), (Iterable)brushSpans);
         return new AnnotatedString(var27, var14, var29);
      }
   }

   public static final float allLeftWidth(@NotNull List $this$allLeftWidth, int index) {
      Intrinsics.checkNotNullParameter($this$allLeftWidth, "<this>");
      float totalWidth = 0.0F;

      for(int i = 0; i < index; ++i) {
         totalWidth += ((Segment)$this$allLeftWidth.get(index)).getRightPosition() - ((Segment)$this$allLeftWidth.get(index)).getLeftPosition();
      }

      return totalWidth;
   }

   public static final float allRightWidth(@NotNull List $this$allRightWidth, int index) {
      Intrinsics.checkNotNullParameter($this$allRightWidth, "<this>");
      float totalWidth = 0.0F;
      int i = index + 1;

      for(int var4 = $this$allRightWidth.size(); i < var4; ++i) {
         totalWidth += ((Segment)$this$allRightWidth.get(index)).getRightPosition() - ((Segment)$this$allRightWidth.get(index)).getLeftPosition();
      }

      return totalWidth;
   }

   private static final int BrushAnimatingSpanDemo$lambda$3(MutableIntState $preWordCount$delegate) {
      IntState var1 = (IntState)$preWordCount$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = false;
      return var1.getIntValue();
   }

   private static final void BrushAnimatingSpanDemo$lambda$4(MutableIntState $preWordCount$delegate, int var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = false;
      $preWordCount$delegate.setIntValue(var1);
   }

   private static final int BrushAnimatingSpanDemo$lambda$6(MutableIntState $highlightWordCount$delegate) {
      IntState var1 = (IntState)$highlightWordCount$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = false;
      return var1.getIntValue();
   }

   private static final void BrushAnimatingSpanDemo$lambda$7(MutableIntState $highlightWordCount$delegate, int var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = false;
      $highlightWordCount$delegate.setIntValue(var1);
   }

   private static final int BrushAnimatingSpanDemo$lambda$9(MutableIntState $postWordCount$delegate) {
      IntState var1 = (IntState)$postWordCount$delegate;
      Object var2 = null;
      KProperty var3 = null;
      int var4 = false;
      return var1.getIntValue();
   }

   private static final void BrushAnimatingSpanDemo$lambda$10(MutableIntState $postWordCount$delegate, int var1) {
      Object var3 = null;
      Object var4 = null;
      int var6 = false;
      $postWordCount$delegate.setIntValue(var1);
   }

   private static final Unit BrushAnimatingSpanDemo$lambda$11$0$0$0(MutableIntState $preWordCount$delegate, float it) {
      BrushAnimatingSpanDemo$lambda$4($preWordCount$delegate, MathKt.roundToInt(it));
      return Unit.INSTANCE;
   }

   private static final Unit BrushAnimatingSpanDemo$lambda$11$0$1$0(MutableIntState $highlightWordCount$delegate, float it) {
      BrushAnimatingSpanDemo$lambda$7($highlightWordCount$delegate, MathKt.roundToInt(it));
      return Unit.INSTANCE;
   }

   private static final Unit BrushAnimatingSpanDemo$lambda$11$0$2$0(MutableIntState $postWordCount$delegate, float it) {
      BrushAnimatingSpanDemo$lambda$10($postWordCount$delegate, MathKt.roundToInt(it));
      return Unit.INSTANCE;
   }

   private static final Unit BrushAnimatingSpanDemo$lambda$11$0$3$0(CoroutineScope $coroutineScope, final Animatable $animatable, final Animatable $animatable2, final MutableIntState $highlightWordCount$delegate) {
      BuildersKt.launch$default($coroutineScope, (CoroutineContext)null, (CoroutineStart)null, (Function2)(new Function2((Continuation)null) {
         int label;
         // $FF: synthetic field
         private Object L$0;

         public final Object invokeSuspend(Object $result) {
            CoroutineScope $this$launch;
            label26: {
               Object var3;
               label25: {
                  $this$launch = (CoroutineScope)this.L$0;
                  var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  Animatable var10000;
                  Float var10001;
                  Continuation var10002;
                  switch(this.label) {
                  case 0:
                     ResultKt.throwOnFailure($result);
                     var10000 = $animatable;
                     var10001 = Boxing.boxFloat(0.0F);
                     var10002 = (Continuation)this;
                     this.L$0 = $this$launch;
                     this.label = 1;
                     if (var10000.snapTo(var10001, var10002) == var3) {
                        return var3;
                     }
                     break;
                  case 1:
                     ResultKt.throwOnFailure($result);
                     break;
                  case 2:
                     ResultKt.throwOnFailure($result);
                     break label25;
                  case 3:
                     ResultKt.throwOnFailure($result);
                     break label26;
                  default:
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  var10000 = $animatable2;
                  var10001 = Boxing.boxFloat(0.0F);
                  var10002 = (Continuation)this;
                  this.L$0 = $this$launch;
                  this.label = 2;
                  if (var10000.snapTo(var10001, var10002) == var3) {
                     return var3;
                  }
               }

               BuildersKt.launch$default($this$launch, (CoroutineContext)null, (CoroutineStart)null, (Function2)(new Function2((Continuation)null) {
                  int label;

                  public final Object invokeSuspend(Object $result) {
                     Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     switch(this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);
                        Animatable var10000 = $animatable2;
                        Float var10001 = Boxing.boxFloat(1.0F);
                        AnimationSpec var10002 = (AnimationSpec)AnimationSpecKt.tween$default(TestKt.BrushAnimatingSpanDemo$lambda$6($highlightWordCount$delegate) * 100, 0, EasingKt.getLinearEasing(), 2, (Object)null);
                        Continuation var10005 = (Continuation)this;
                        this.label = 1;
                        if (Animatable.animateTo$default(var10000, var10001, var10002, (Object)null, (Function1)null, var10005, 12, (Object)null) == var2) {
                           return var2;
                        }
                        break;
                     case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                     default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     return Unit.INSTANCE;
                  }

                  public final Continuation create(Object value, Continuation $completion) {
                     return (Continuation)(new <anonymous constructor>($completion));
                  }

                  public final Object invoke(CoroutineScope p1, Continuation p2) {
                     return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                  }
               }), 3, (Object)null);
               Continuation var4 = (Continuation)this;
               this.L$0 = $this$launch;
               this.label = 3;
               if (DelayKt.delay(300L, var4) == var3) {
                  return var3;
               }
            }

            BuildersKt.launch$default($this$launch, (CoroutineContext)null, (CoroutineStart)null, (Function2)(new Function2((Continuation)null) {
               int label;

               public final Object invokeSuspend(Object $result) {
                  Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  switch(this.label) {
                  case 0:
                     ResultKt.throwOnFailure($result);
                     Animatable var10000 = $animatable;
                     Float var10001 = Boxing.boxFloat(1.0F);
                     AnimationSpec var10002 = (AnimationSpec)AnimationSpecKt.tween$default(TestKt.BrushAnimatingSpanDemo$lambda$6($highlightWordCount$delegate) * 100, 0, EasingKt.getLinearEasing(), 2, (Object)null);
                     Continuation var10005 = (Continuation)this;
                     this.label = 1;
                     if (Animatable.animateTo$default(var10000, var10001, var10002, (Object)null, (Function1)null, var10005, 12, (Object)null) == var2) {
                        return var2;
                     }
                     break;
                  case 1:
                     ResultKt.throwOnFailure($result);
                     break;
                  default:
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  return Unit.INSTANCE;
               }

               public final Continuation create(Object value, Continuation $completion) {
                  return (Continuation)(new <anonymous constructor>($completion));
               }

               public final Object invoke(CoroutineScope p1, Continuation p2) {
                  return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
               }
            }), 3, (Object)null);
            return Unit.INSTANCE;
         }

         public final Continuation create(Object value, Continuation $completion) {
            Function2 var3 = new <anonymous constructor>($completion);
            var3.L$0 = value;
            return (Continuation)var3;
         }

         public final Object invoke(CoroutineScope p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }), 3, (Object)null);
      return Unit.INSTANCE;
   }

   private static final Unit BrushAnimatingSpanDemo$lambda$11$0$4$0(CoroutineScope $coroutineScope, final Animatable $animatable, final Animatable $animatable2) {
      BuildersKt.launch$default($coroutineScope, (CoroutineContext)null, (CoroutineStart)null, (Function2)(new Function2((Continuation)null) {
         int label;

         public final Object invokeSuspend(Object $result) {
            Object var2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            Animatable var10000;
            Float var10001;
            Continuation var10002;
            switch(this.label) {
            case 0:
               ResultKt.throwOnFailure($result);
               var10000 = $animatable;
               var10001 = Boxing.boxFloat(0.0F);
               var10002 = (Continuation)this;
               this.label = 1;
               if (var10000.snapTo(var10001, var10002) == var2) {
                  return var2;
               }
               break;
            case 1:
               ResultKt.throwOnFailure($result);
               break;
            case 2:
               ResultKt.throwOnFailure($result);
               return Unit.INSTANCE;
            default:
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            var10000 = $animatable2;
            var10001 = Boxing.boxFloat(0.0F);
            var10002 = (Continuation)this;
            this.label = 2;
            if (var10000.snapTo(var10001, var10002) == var2) {
               return var2;
            } else {
               return Unit.INSTANCE;
            }
         }

         public final Continuation create(Object value, Continuation $completion) {
            return (Continuation)(new <anonymous constructor>($completion));
         }

         public final Object invoke(CoroutineScope p1, Continuation p2) {
            return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
         }
      }), 3, (Object)null);
      return Unit.INSTANCE;
   }

   private static final Unit BrushAnimatingSpanDemo$lambda$12(int $$changed, Composer $composer, int $force) {
      BrushAnimatingSpanDemo($composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }

   private static final Unit BrushAnimatingSpanText$lambda$3$0(MutableState $textLayoutResult, TextLayoutResult it) {
      Intrinsics.checkNotNullParameter(it, "it");
      $textLayoutResult.setValue(it);
      return Unit.INSTANCE;
   }

   private static final Unit BrushAnimatingSpanText$lambda$4(int $preWordCount, int $highlightWordCount, int $postWordCount, Animatable $animatable, Animatable $animatable2, int $$changed, Composer $composer, int $force) {
      BrushAnimatingSpanText($preWordCount, $highlightWordCount, $postWordCount, $animatable, $animatable2, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }
}
