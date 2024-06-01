package land.sungbin.androidplayground;

import android.graphics.BlurMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.Outline.Generic;
import androidx.compose.ui.graphics.PathEffect.Companion;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainterKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a6\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"},
   d2 = {"dropShadow", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "blurRadius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "dropShadow-EnRY0Kc", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;FJ)Landroidx/compose/ui/Modifier;", "roundedTicketShape", "cornerRadius", "remainingTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "remainingTextLayoutHorizontalPadding", "punchholeRadius", "roundedTicketShape-u_T4Ytw", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/text/TextLayoutResult;FF)Landroidx/compose/ui/Modifier;", "app_debug"}
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivityKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,249:1\n154#2:250\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivityKt\n*L\n228#1:250\n*E\n"})
public final class PlaygroundActivityKt {
   private static final Modifier roundedTicketShape_u_T4Ytw/* $FF was: roundedTicketShape-u_T4Ytw*/(Modifier $this$roundedTicketShape_u2du_T4Ytw, final float cornerRadius, final TextLayoutResult remainingTextLayout, final float remainingTextLayoutHorizontalPadding, final float punchholeRadius) {
      return ComposedModifierKt.composed$default($this$roundedTicketShape_u2du_T4Ytw, (Function1)null, (Function3)(new Function3() {
         @Composable
         @NotNull
         public final Modifier invoke(@NotNull Modifier $this$composed, @Nullable Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
            $composer.startReplaceableGroup(-1373082239);
            ComposerKt.sourceInformation($composer, "C89@3202L7,90@3225L405:PlaygroundActivity.kt#qshby3");
            if (ComposerKt.isTraceInProgress()) {
               ComposerKt.traceEventStart(-1373082239, $changed, -1, "land.sungbin.androidplayground.roundedTicketShape.<anonymous> (PlaygroundActivity.kt:89)");
            }

            CompositionLocal this_$iv = (CompositionLocal)CompositionLocalsKt.getLocalDensity();
            int $changed$iv = false;
            int $i$f$getCurrent = false;
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object var8 = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density = (Density)var8;
            $composer.startReplaceableGroup(-299289591);
            ComposerKt.sourceInformation($composer, "CC(remember):PlaygroundActivity.kt#9igjgp");
            boolean $i$f$getDp = $composer.changed(cornerRadius) | $composer.changed(remainingTextLayout) | $composer.changed(remainingTextLayoutHorizontalPadding) | $composer.changed(punchholeRadius);
            TextLayoutResult var9 = remainingTextLayout;
            float var10 = remainingTextLayoutHorizontalPadding;
            float var11 = punchholeRadius;
            float var12 = cornerRadius;
            int $i$f$cache = false;
            Object it$iv = $composer.rememberedValue();
            int var15 = false;
            Object var32;
            if (!$i$f$getDp && it$iv != Composer.Companion.getEmpty()) {
               var32 = it$iv;
            } else {
               int var16 = false;
               int var18 = false;
               float it = density.toPx-0680j_4(var12);
               int var19 = false;
               long var10000 = CornerRadiusKt.CornerRadius(it, it);
               long var10001 = var9.getSize-YbymL2g();
               Object var21 = null;
               long var24 = var10001;
               long var26 = var10000;
               Object value$iv = new RoundedTicketShape(var26, var24, var10, var11, (DefaultConstructorMarker)var21);
               $composer.updateRememberedValue(value$iv);
               var32 = value$iv;
            }

            RoundedTicketShape var28 = (RoundedTicketShape)var32;
            $composer.endReplaceableGroup();
            Shape var33 = (Shape)var28;
            int $this$dp$iv = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$$$this$call-$get-dp$$arg-1$call-dropShadow$$$this$call-clip$$$this$call-background$$$this$call-drawWithCache$fun-$anonymous$$arg-1$call-composed$fun-roundedTicketShape();
            $i$f$getDp = false;
            Modifier var29 = DrawModifierKt.drawWithCache(BackgroundKt.background-bw27NRU(ClipKt.clip(PlaygroundActivityKt.dropShadow-EnRY0Kc$default($this$composed, var33, Dp.constructor-impl((float)$this$dp$iv), 0L, 4, (Object)null), (Shape)var28), Color.Companion.getWhite-0d7_KjU(), (Shape)var28), (Function1)(new Function1() {
               @NotNull
               public final DrawResult invoke(@NotNull CacheDrawScope $this$drawWithCache) {
                  Intrinsics.checkNotNullParameter($this$drawWithCache, "$this$drawWithCache");
                  TextLayoutResult var4 = remainingTextLayout;
                  float var5 = remainingTextLayoutHorizontalPadding;
                  int var7 = false;
                  float punchholeXCenter = Size.getWidth-impl($this$drawWithCache.getSize-NH-jbRc()) - (float)IntSize.getWidth-impl(var4.getSize-YbymL2g()) - $this$drawWithCache.toPx-0680j_4(var5) * (float)LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$arg-0$call-times$arg-0$call-minus$fun-$anonymous$$arg-0$call-run$val-punchholeXCenter$fun-$anonymous$$arg-0$call-drawWithCache$fun-$anonymous$$arg-1$call-composed$fun-roundedTicketShape();
                  final Rect remainingZone = RectKt.Rect-0a9Yr6o(OffsetKt.Offset(punchholeXCenter, LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-1$call-Offset$arg-0$call-Rect$val-remainingZone$fun-$anonymous$$arg-0$call-drawWithCache$fun-$anonymous$$arg-1$call-composed$fun-roundedTicketShape()), OffsetKt.Offset(Size.getWidth-impl($this$drawWithCache.getSize-NH-jbRc()), Size.getHeight-impl($this$drawWithCache.getSize-NH-jbRc())));
                  int $this$dp$iv = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$$$this$call-$get-dp$$val-remainingZoneLinePadding$fun-$anonymous$$arg-0$call-drawWithCache$fun-$anonymous$$arg-1$call-composed$fun-roundedTicketShape();
                  int $i$f$getDp = false;
                  final float remainingZoneLinePadding = Dp.constructor-impl((float)$this$dp$iv);
                  return $this$drawWithCache.onDrawBehind((Function1)(new Function1() {
                     public final void invoke(@NotNull DrawScope $this$onDrawBehind) {
                        Intrinsics.checkNotNullParameter($this$onDrawBehind, "$this$onDrawBehind");
                        float left$iv = remainingZone.getLeft();
                        TextLayoutResult var5 = remainingTextLayout;
                        Rect var6 = remainingZone;
                        float var7 = punchholeRadius;
                        float var8 = remainingZoneLinePadding;
                        float top$iv = 0.0F;
                        int $i$f$translate = false;
                        $this$onDrawBehind.getDrawContext().getTransform().translate(left$iv, top$iv);
                        DrawScope $this$invoke_u24lambda_u240 = $this$onDrawBehind;
                        int var11 = false;
                        TextPainterKt.drawText-d8-rzKo$default($this$onDrawBehind, var5, Color.Companion.getBlue-0d7_KjU(), OffsetKt.Offset((float)Alignment.Companion.getCenterHorizontally().align(IntSize.getWidth-impl(var5.getSize-YbymL2g()), MathKt.roundToInt(var6.getWidth()), $this$onDrawBehind.getLayoutDirection()), (float)Alignment.Companion.getCenterVertically().align(IntSize.getHeight-impl(var5.getSize-YbymL2g()), MathKt.roundToInt(Size.getHeight-impl($this$onDrawBehind.getSize-NH-jbRc())))), 0.0F, (Shadow)null, (TextDecoration)null, (DrawStyle)null, 0, 248, (Object)null);
                        long var10001 = Color.Companion.getLightGray-0d7_KjU();
                        long var10002 = OffsetKt.Offset(LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-0$call-Offset$arg-1$call-drawLine$fun-$anonymous$$arg-2$call-translate$fun-$anonymous$$arg-0$call-onDrawBehind$fun-$anonymous$$arg-0$call-drawWithCache$fun-$anonymous$$arg-1$call-composed$fun-roundedTicketShape(), $this$onDrawBehind.toPx-0680j_4(var7) + $this$onDrawBehind.toPx-0680j_4(var8));
                        long var10003 = OffsetKt.Offset(LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-0$call-Offset$arg-2$call-drawLine$fun-$anonymous$$arg-2$call-translate$fun-$anonymous$$arg-0$call-onDrawBehind$fun-$anonymous$$arg-0$call-drawWithCache$fun-$anonymous$$arg-1$call-composed$fun-roundedTicketShape(), Size.getHeight-impl($this$onDrawBehind.getSize-NH-jbRc()) - ($this$onDrawBehind.toPx-0680j_4(var7) + $this$onDrawBehind.toPx-0680j_4(var8)));
                        int $this$dp$ivx = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$$$this$call-$get-dp$$$$this$call-toPx$arg-3$call-drawLine$fun-$anonymous$$arg-2$call-translate$fun-$anonymous$$arg-0$call-onDrawBehind$fun-$anonymous$$arg-0$call-drawWithCache$fun-$anonymous$$arg-1$call-composed$fun-roundedTicketShape();
                        int $i$f$getDpx = false;
                        float var10004 = $this$onDrawBehind.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$ivx));
                        Companion var10006 = PathEffect.Companion;
                        $this$dp$ivx = 0;
                        int var28 = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$arg-0$call-$init$$arg-0$call-dashPathEffect$arg-5$call-drawLine$fun-$anonymous$$arg-2$call-translate$fun-$anonymous$$arg-0$call-onDrawBehind$fun-$anonymous$$arg-0$call-drawWithCache$fun-$anonymous$$arg-1$call-composed$fun-roundedTicketShape();
                        float[] var14 = new float[var28];
                        Companion var15 = var10006;
                        byte var16 = 0;
                        float var17 = var10004;
                        long var18 = var10003;
                        long var20 = var10002;

                        long var22;
                        for(var22 = var10001; $this$dp$ivx < var28; ++$this$dp$ivx) {
                           int $this$dp$iv = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$$$this$call-$get-dp$$$$this$call-toPx$fun-$anonymous$$arg-1$call-$init$$arg-0$call-dashPathEffect$arg-5$call-drawLine$fun-$anonymous$$arg-2$call-translate$fun-$anonymous$$arg-0$call-onDrawBehind$fun-$anonymous$$arg-0$call-drawWithCache$fun-$anonymous$$arg-1$call-composed$fun-roundedTicketShape();
                           int $i$f$getDp = false;
                           var14[$this$dp$ivx] = $this$invoke_u24lambda_u240.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv));
                        }

                        DrawScope.drawLine-NGM6Ib0$default($this$invoke_u24lambda_u240, var22, var20, var18, var17, var16, Companion.dashPathEffect$default(var15, var14, 0.0F, 2, (Object)null), 0.0F, (ColorFilter)null, 0, 464, (Object)null);
                        $this$onDrawBehind.getDrawContext().getTransform().translate(-left$iv, -top$iv);
                     }
                  }));
               }
            }));
            if (ComposerKt.isTraceInProgress()) {
               ComposerKt.traceEventEnd();
            }

            $composer.endReplaceableGroup();
            return var29;
         }
      }), 1, (Object)null);
   }

   @Stable
   @NotNull
   public static final Modifier dropShadow_EnRY0Kc/* $FF was: dropShadow-EnRY0Kc*/(@NotNull Modifier $this$dropShadow_u2dEnRY0Kc, @NotNull final Shape shape, final float blurRadius, final long color) {
      Intrinsics.checkNotNullParameter($this$dropShadow_u2dEnRY0Kc, "$this$dropShadow");
      Intrinsics.checkNotNullParameter(shape, "shape");
      return DrawModifierKt.drawBehind($this$dropShadow_u2dEnRY0Kc, (Function1)(new Function1() {
         public final void invoke(@NotNull DrawScope $this$drawBehind) {
            Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
            Shape var3 = shape;
            long var4 = color;
            float var6 = blurRadius;
            int $i$f$drawIntoCanvas = false;
            Canvas canvas = $this$drawBehind.getDrawContext().getCanvas();
            int var9 = false;
            Paint var10 = AndroidPaint_androidKt.Paint();
            int var12 = false;
            android.graphics.Paint var13 = var10.asFrameworkPaint();
            int var15 = false;
            var13.setColor(ColorKt.toArgb-8_81llA(var4));
            int $this$dp$iv = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$$$this$call-$get-dp$$arg-1$call-EQEQ$$this$call-not$cond$if$fun-$anonymous$$arg-0$call-apply$fun-$anonymous$$arg-0$call-also$val-paint$fun-$anonymous$$arg-0$call-drawIntoCanvas$fun-$anonymous$$arg-0$call-drawBehind$fun-dropShadow();
            int $i$f$getDp = false;
            if (!Dp.equals-impl0(var6, Dp.constructor-impl((float)$this$dp$iv))) {
               var13.setMaskFilter((MaskFilter)(new BlurMaskFilter($this$drawBehind.toPx-0680j_4(var6), Blur.OUTER)));
            }

            Paint paint = var10;
            Outline outline = var3.createOutline-Pq9zytI($this$drawBehind.getSize-NH-jbRc(), $this$drawBehind.getLayoutDirection(), (Density)$this$drawBehind);
            if (!(outline instanceof Generic)) {
               var12 = false;
               String var20 = LiveLiterals$PlaygroundActivityKt.INSTANCE.String$fun-$anonymous$$arg-1$call-require$fun-$anonymous$$arg-0$call-drawIntoCanvas$fun-$anonymous$$arg-0$call-drawBehind$fun-dropShadow();
               throw new IllegalArgumentException(var20.toString());
            } else {
               canvas.drawPath(((Generic)outline).getPath(), paint);
            }
         }
      }));
   }

   // $FF: synthetic method
   public static Modifier dropShadow_EnRY0Kc$default/* $FF was: dropShadow-EnRY0Kc$default*/(Modifier var0, Shape var1, float var2, long var3, int var5, Object var6) {
      if ((var5 & 2) != 0) {
         int $this$dp$iv = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$$$this$call-$get-dp$$param-blurRadius$fun-dropShadow();
         int $i$f$getDp = false;
         var2 = Dp.constructor-impl((float)$this$dp$iv);
      }

      if ((var5 & 4) != 0) {
         var3 = Color.copy-wmQWz5c$default(Color.Companion.getDarkGray-0d7_KjU(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-0$call-copy$param-color$fun-dropShadow(), 0.0F, 0.0F, 0.0F, 14, (Object)null);
      }

      return dropShadow-EnRY0Kc(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static final Modifier access$roundedTicketShape_u_T4Ytw/* $FF was: access$roundedTicketShape-u_T4Ytw*/(Modifier $receiver, float cornerRadius, TextLayoutResult remainingTextLayout, float remainingTextLayoutHorizontalPadding, float punchholeRadius) {
      return roundedTicketShape-u_T4Ytw($receiver, cornerRadius, remainingTextLayout, remainingTextLayoutHorizontalPadding, punchholeRadius);
   }
}
