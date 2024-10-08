package land.sungbin.androidplayground;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DeferredTargetAnimation;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ApproachMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.LookaheadScopeKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable.PlacementScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

@Metadata(
   mv = {2, 0, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a#\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"},
   d2 = {"animating", "Landroidx/compose/ui/Modifier;", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "surfacing", "color", "Landroidx/compose/ui/graphics/Color;", "inColumn", "", "surfacing-bw27NRU", "(Landroidx/compose/ui/Modifier;JZ)Landroidx/compose/ui/Modifier;", "app_debug"}
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivityKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,156:1\n149#2:157\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivityKt\n*L\n155#1:157\n*E\n"})
public final class PlaygroundActivityKt {
   private static final Modifier animating(Modifier $this$animating, final LookaheadScope lookaheadScope) {
      return ComposedModifierKt.composed$default($this$animating, (Function1)null, (Function3)(new Function3() {
         @Composable
         public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
            $composer.startReplaceGroup(1697784985);
            ComposerKt.sourceInformation($composer, "C93@3301L24,94@3348L61,95@3434L63,98@3555L226,106@3819L370,117@4195L1101:PlaygroundActivity.kt#qshby3");
            if (ComposerKt.isTraceInProgress()) {
               ComposerKt.traceEventStart(1697784985, $changed, -1, "land.sungbin.androidplayground.animating.<anonymous> (PlaygroundActivity.kt:93)");
            }

            int $changed$iv = false;
            int $i$f$rememberCoroutineScope = false;
            ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer, -954367824, "CC(remember):Effects.kt#9igjgp");
            boolean invalid$ivxx = false;
            int $i$f$cachex = false;
            Object it$ivxx = $composer.rememberedValue();
            int var13 = false;
            boolean var14;
            boolean var15;
            Object var10000;
            if (it$ivxx == Composer.Companion.getEmpty()) {
               var14 = false;
               var15 = false;
               CoroutineScope var22 = EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, $composer);
               Object value$iv$iv = new CompositionScopedCoroutineScopeCanceller(var22);
               $composer.updateRememberedValue(value$iv$iv);
               var10000 = value$iv$iv;
            } else {
               var10000 = it$ivxx;
            }

            CompositionScopedCoroutineScopeCanceller var16 = (CompositionScopedCoroutineScopeCanceller)var10000;
            ComposerKt.sourceInformationMarkerEnd($composer);
            CoroutineScope var38 = var16.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.startReplaceGroup(-667249167);
            ComposerKt.sourceInformation($composer, "CC(remember):PlaygroundActivity.kt#9igjgp");
            boolean invalid$iv = false;
            int invalid$ivx = false;
            Object it$iv = $composer.rememberedValue();
            $i$f$cachex = false;
            boolean $i$f$cache;
            if (it$iv == Composer.Companion.getEmpty()) {
               $i$f$cache = false;
               Object value$iv = new DeferredTargetAnimation(VectorConvertersKt.getVectorConverter(IntSize.Companion));
               $composer.updateRememberedValue(value$iv);
               var10000 = value$iv;
            } else {
               var10000 = it$iv;
            }

            DeferredTargetAnimation var23 = (DeferredTargetAnimation)var10000;
            $composer.endReplaceGroup();
            $composer.startReplaceGroup(-667246413);
            ComposerKt.sourceInformation($composer, "CC(remember):PlaygroundActivity.kt#9igjgp");
            invalid$ivx = false;
            invalid$ivxx = false;
            Object it$ivx = $composer.rememberedValue();
            $i$f$cache = false;
            if (it$ivx == Composer.Companion.getEmpty()) {
               var13 = false;
               Object value$ivx = new DeferredTargetAnimation(VectorConvertersKt.getVectorConverter(IntOffset.Companion));
               $composer.updateRememberedValue(value$ivx);
               var10000 = value$ivx;
            } else {
               var10000 = it$ivx;
            }

            DeferredTargetAnimation var24 = (DeferredTargetAnimation)var10000;
            $composer.endReplaceGroup();
            Modifier var40 = $this$composed;
            $composer.startReplaceGroup(-667242378);
            ComposerKt.sourceInformation($composer, "CC(remember):PlaygroundActivity.kt#9igjgp");
            invalid$ivxx = $composer.changedInstance(var23) | $composer.changedInstance(var38);
            $i$f$cachex = false;
            it$ivxx = $composer.rememberedValue();
            var13 = false;
            Function1 var10001;
            Object var39;
            if (!invalid$ivxx && it$ivxx != Composer.Companion.getEmpty()) {
               var39 = it$ivxx;
            } else {
               var14 = false;
               var10001 = <undefinedtype>::invoke$lambda$3$lambda$2;
               var40 = $this$composed;
               Object value$ivxx = var10001;
               $composer.updateRememberedValue(value$ivxx);
               var39 = value$ivxx;
            }

            Function1 var26 = (Function1)var39;
            $composer.endReplaceGroup();
            var10001 = var26;
            $composer.startReplaceGroup(-667233786);
            ComposerKt.sourceInformation($composer, "CC(remember):PlaygroundActivity.kt#9igjgp");
            invalid$ivxx = $composer.changedInstance(lookaheadScope) | $composer.changedInstance(var24) | $composer.changedInstance(var38);
            LookaheadScope var32 = lookaheadScope;
            $i$f$cache = false;
            Object it$ivxxx = $composer.rememberedValue();
            var14 = false;
            Object var10002;
            Modifier var18;
            if (!invalid$ivxx && it$ivxxx != Composer.Companion.getEmpty()) {
               var10002 = it$ivxxx;
            } else {
               var18 = var40;
               var15 = false;
               Function2 var20 = <undefinedtype>::invoke$lambda$6$lambda$5;
               var40 = var18;
               var10001 = var26;
               $composer.updateRememberedValue(var20);
               var10002 = var20;
            }

            Function2 var27 = (Function2)var10002;
            $composer.endReplaceGroup();
            Function2 var41 = var27;
            $composer.startReplaceGroup(-667221023);
            ComposerKt.sourceInformation($composer, "CC(remember):PlaygroundActivity.kt#9igjgp");
            invalid$ivxx = $composer.changedInstance(var23) | $composer.changedInstance(var38) | $composer.changedInstance(lookaheadScope) | $composer.changedInstance(var24);
            var32 = lookaheadScope;
            $i$f$cache = false;
            it$ivxxx = $composer.rememberedValue();
            var14 = false;
            Object var10003;
            if (!invalid$ivxx && it$ivxxx != Composer.Companion.getEmpty()) {
               var10003 = it$ivxxx;
            } else {
               Function1 var19 = var10001;
               var18 = var40;
               var15 = false;
               Function3 var21 = <undefinedtype>::invoke$lambda$11$lambda$10;
               var40 = var18;
               var10001 = var19;
               var41 = var27;
               $composer.updateRememberedValue(var21);
               var10003 = var21;
            }

            Function3 var28 = (Function3)var10003;
            $composer.endReplaceGroup();
            Modifier var25 = LookaheadScopeKt.approachLayout(var40, var10001, var41, var28);
            if (ComposerKt.isTraceInProgress()) {
               ComposerKt.traceEventEnd();
            }

            $composer.endReplaceGroup();
            return var25;
         }

         private static final boolean invoke$lambda$3$lambda$2(DeferredTargetAnimation $sizeAnimation, CoroutineScope $coroutineScope, IntSize lookaheadSize) {
            $sizeAnimation.updateTarget(lookaheadSize, $coroutineScope, (FiniteAnimationSpec)AnimationSpecKt.spring$default(0.0F, 50.0F, (Object)null, 5, (Object)null));
            return !$sizeAnimation.isIdle();
         }

         private static final boolean invoke$lambda$6$lambda$5(LookaheadScope $lookaheadScope, DeferredTargetAnimation $offsetAnimation, CoroutineScope $coroutineScope, PlacementScope $this$approachLayout, LayoutCoordinates lookaheadCoordinates) {
            Intrinsics.checkNotNullParameter($this$approachLayout, "$this$approachLayout");
            Intrinsics.checkNotNullParameter(lookaheadCoordinates, "lookaheadCoordinates");
            int var8 = false;
            long target = LookaheadScope.localLookaheadPositionOf-au-aQtc$default($lookaheadScope, $lookaheadScope.getLookaheadScopeCoordinates($this$approachLayout), lookaheadCoordinates, 0L, false, 6, (Object)null);
            $offsetAnimation.updateTarget(IntOffset.box-impl(IntOffsetKt.round-k-4lQ0M(target)), $coroutineScope, (FiniteAnimationSpec)AnimationSpecKt.spring$default(0.0F, 50.0F, (Object)null, 5, (Object)null));
            return !$offsetAnimation.isIdle();
         }

         private static final Unit invoke$lambda$11$lambda$10$lambda$9(LookaheadScope $lookaheadScope, DeferredTargetAnimation $offsetAnimation, CoroutineScope $coroutineScope, Placeable $placeable, PlacementScope $this$layout) {
            Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
            LayoutCoordinates coordinates = $this$layout.getCoordinates();
            if (coordinates != null) {
               int var9 = false;
               long target = LookaheadScope.localLookaheadPositionOf-au-aQtc$default($lookaheadScope, $lookaheadScope.getLookaheadScopeCoordinates($this$layout), coordinates, 0L, false, 6, (Object)null);
               long animatedOffset = ((IntOffset)$offsetAnimation.updateTarget(IntOffset.box-impl(IntOffsetKt.round-k-4lQ0M(target)), $coroutineScope, (FiniteAnimationSpec)AnimationSpecKt.spring$default(0.0F, 50.0F, (Object)null, 5, (Object)null))).unbox-impl();
               int var13 = false;
               long placementOffset = LayoutCoordinates.localPositionOf-S_NoaFU$default($lookaheadScope.getLookaheadScopeCoordinates($this$layout), coordinates, 0L, false, 6, (Object)null);
               long var12 = IntOffset.minus-qkQi6aY(animatedOffset, IntOffsetKt.round-k-4lQ0M(placementOffset));
               int var15 = false;
               int x = IntOffset.getX-impl(var12);
               int var16 = false;
               int y = IntOffset.getY-impl(var12);
               PlacementScope.place$default($this$layout, $placeable, x, y, 0.0F, 4, (Object)null);
            } else {
               PlacementScope.place$default($this$layout, $placeable, 0, 0, 0.0F, 4, (Object)null);
            }

            return Unit.INSTANCE;
         }

         private static final MeasureResult invoke$lambda$11$lambda$10(DeferredTargetAnimation $sizeAnimation, CoroutineScope $coroutineScope, LookaheadScope $lookaheadScope, DeferredTargetAnimation $offsetAnimation, ApproachMeasureScope $this$approachLayout, Measurable measurable, Constraints constraints) {
            Intrinsics.checkNotNullParameter($this$approachLayout, "$this$approachLayout");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            long var7 = ((IntSize)$sizeAnimation.updateTarget(IntSize.box-impl($this$approachLayout.getLookaheadSize-YbymL2g()), $coroutineScope, (FiniteAnimationSpec)AnimationSpecKt.spring$default(0.0F, 50.0F, (Object)null, 5, (Object)null))).unbox-impl();
            int var10 = false;
            int targetWidth = IntSize.getWidth-impl(var7);
            int var11 = false;
            int targetHeight = IntSize.getHeight-impl(var7);
            long animatedConstraints = Constraints.Companion.fixed-JhjzzOo(targetWidth, targetHeight);
            Placeable placeable = measurable.measure-BRTryo0(animatedConstraints);
            return MeasureScope.layout$default((MeasureScope)$this$approachLayout, placeable.getWidth(), placeable.getHeight(), (Map)null, <undefinedtype>::invoke$lambda$11$lambda$10$lambda$9, 4, (Object)null);
         }
      }), 1, (Object)null);
   }

   private static final Modifier surfacing_bw27NRU/* $FF was: surfacing-bw27NRU*/(Modifier $this$surfacing_u2dbw27NRU, long color, boolean inColumn) {
      Modifier var10000 = BackgroundKt.background-bw27NRU$default(ClipKt.clip($this$surfacing_u2dbw27NRU, (Shape)RoundedCornerShapeKt.RoundedCornerShape(15)), color, (Shape)null, 2, (Object)null);
      float var10001;
      byte $this$dp$iv;
      boolean $i$f$getDp;
      if (inColumn) {
         $this$dp$iv = 100;
         $i$f$getDp = false;
         var10001 = Dp.constructor-impl((float)$this$dp$iv);
      } else {
         $this$dp$iv = 50;
         $i$f$getDp = false;
         var10001 = Dp.constructor-impl((float)$this$dp$iv);
      }

      return SizeKt.size-3ABfNKs(var10000, var10001);
   }

   // $FF: synthetic method
   public static final Modifier access$surfacing_bw27NRU/* $FF was: access$surfacing-bw27NRU*/(Modifier $receiver, long color, boolean inColumn) {
      return surfacing-bw27NRU($receiver, color, inColumn);
   }

   // $FF: synthetic method
   public static final Modifier access$animating(Modifier $receiver, LookaheadScope lookaheadScope) {
      return animating($receiver, lookaheadScope);
   }
}
