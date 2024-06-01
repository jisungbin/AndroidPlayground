package land.sungbin.androidplayground;

import android.graphics.BlurMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001ad\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"},
   d2 = {"dropShadow", "Landroidx/compose/ui/Modifier;", "borderRadius", "Landroidx/compose/ui/unit/Dp;", "spreadRadius", "blurRadius", "color", "Landroidx/compose/ui/graphics/Color;", "offsetLeft", "offsetTop", "offsetBottom", "offsetRight", "dropShadow-oh6pGx0", "(Landroidx/compose/ui/Modifier;FFFJFFFF)Landroidx/compose/ui/Modifier;", "app_debug"}
)
@SourceDebugExtension({"SMAP\nDropShadow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DropShadow.kt\nland/sungbin/androidplayground/DropShadowKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,54:1\n154#2:55\n154#2:56\n154#2:57\n154#2:58\n154#2:59\n*S KotlinDebug\n*F\n+ 1 DropShadow.kt\nland/sungbin/androidplayground/DropShadowKt\n*L\n17#1:55\n20#1:56\n21#1:57\n22#1:58\n23#1:59\n*E\n"})
public final class DropShadowKt {
   @Stable
   @NotNull
   public static final Modifier dropShadow_oh6pGx0/* $FF was: dropShadow-oh6pGx0*/(@NotNull Modifier $this$dropShadow_u2doh6pGx0, final float borderRadius, final float spreadRadius, final float blurRadius, final long color, final float offsetLeft, final float offsetTop, final float offsetBottom, final float offsetRight) {
      Intrinsics.checkNotNullParameter($this$dropShadow_u2doh6pGx0, "$this$dropShadow");
      return DrawModifierKt.drawBehind($this$dropShadow_u2doh6pGx0, (Function1)(new Function1() {
         public final void invoke(@NotNull DrawScope $this$drawBehind) {
            Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
            float var3 = borderRadius;
            float var4 = spreadRadius;
            float var5 = offsetLeft;
            float var6 = offsetTop;
            float var7 = offsetBottom;
            float var8 = offsetRight;
            long var9 = color;
            float var11 = blurRadius;
            int $i$f$drawIntoCanvas = false;
            Canvas canvas = $this$drawBehind.getDrawContext().getCanvas();
            int var14 = false;
            Paint var15 = AndroidPaint_androidKt.Paint();
            int var17 = false;
            android.graphics.Paint var18 = var15.asFrameworkPaint();
            int var20 = false;
            var18.setColor(ColorKt.toArgb-8_81llA(var9));
            int $this$dp$iv = LiveLiterals$DropShadowKt.INSTANCE.Int$$$this$call-$get-dp$$arg-1$call-EQEQ$$this$call-not$cond$if$fun-$anonymous$$arg-0$call-apply$fun-$anonymous$$arg-0$call-also$val-paint$fun-$anonymous$$arg-0$call-drawIntoCanvas$fun-$anonymous$$arg-0$call-drawBehind$fun-dropShadow();
            int $i$f$getDp = false;
            if (!Dp.equals-impl0(var11, Dp.constructor-impl((float)$this$dp$iv))) {
               var18.setMaskFilter((MaskFilter)(new BlurMaskFilter($this$drawBehind.toPx-0680j_4(var11), Blur.NORMAL)));
            }

            Paint paint = var15;
            float borderPx = $this$drawBehind.toPx-0680j_4(var3);
            float spreadPx = $this$drawBehind.toPx-0680j_4(var4);
            float leftPx = LiveLiterals$DropShadowKt.INSTANCE.Float$$this$call-minus$$this$call-plus$val-leftPx$fun-$anonymous$$arg-0$call-drawIntoCanvas$fun-$anonymous$$arg-0$call-drawBehind$fun-dropShadow() - spreadPx + $this$drawBehind.toPx-0680j_4(var5);
            float topPx = LiveLiterals$DropShadowKt.INSTANCE.Float$$this$call-minus$$this$call-plus$val-topPx$fun-$anonymous$$arg-0$call-drawIntoCanvas$fun-$anonymous$$arg-0$call-drawBehind$fun-dropShadow() - spreadPx + $this$drawBehind.toPx-0680j_4(var6);
            float bottomPx = Size.getHeight-impl($this$drawBehind.getSize-NH-jbRc()) + spreadPx + $this$drawBehind.toPx-0680j_4(var7);
            float rightPx = Size.getWidth-impl($this$drawBehind.getSize-NH-jbRc()) + spreadPx + $this$drawBehind.toPx-0680j_4(var8);
            canvas.drawRoundRect(leftPx, topPx, rightPx, bottomPx, borderPx, borderPx, paint);
         }
      }));
   }

   // $FF: synthetic method
   public static Modifier dropShadow_oh6pGx0$default/* $FF was: dropShadow-oh6pGx0$default*/(Modifier var0, float var1, float var2, float var3, long var4, float var6, float var7, float var8, float var9, int var10, Object var11) {
      int $this$dp$iv;
      boolean $i$f$getDp;
      if ((var10 & 2) != 0) {
         $this$dp$iv = LiveLiterals$DropShadowKt.INSTANCE.Int$$$this$call-$get-dp$$param-spreadRadius$fun-dropShadow();
         $i$f$getDp = false;
         var2 = Dp.constructor-impl((float)$this$dp$iv);
      }

      if ((var10 & 4) != 0) {
         var3 = var2;
      }

      if ((var10 & 8) != 0) {
         var4 = Color.copy-wmQWz5c$default(Color.Companion.getDarkGray-0d7_KjU(), LiveLiterals$DropShadowKt.INSTANCE.Float$arg-0$call-copy$param-color$fun-dropShadow(), 0.0F, 0.0F, 0.0F, 14, (Object)null);
      }

      if ((var10 & 16) != 0) {
         $this$dp$iv = LiveLiterals$DropShadowKt.INSTANCE.Int$$$this$call-$get-dp$$param-offsetLeft$fun-dropShadow();
         $i$f$getDp = false;
         var6 = Dp.constructor-impl((float)$this$dp$iv);
      }

      if ((var10 & 32) != 0) {
         $this$dp$iv = LiveLiterals$DropShadowKt.INSTANCE.Int$$$this$call-$get-dp$$param-offsetTop$fun-dropShadow();
         $i$f$getDp = false;
         var7 = Dp.constructor-impl((float)$this$dp$iv);
      }

      if ((var10 & 64) != 0) {
         $this$dp$iv = LiveLiterals$DropShadowKt.INSTANCE.Int$$$this$call-$get-dp$$param-offsetBottom$fun-dropShadow();
         $i$f$getDp = false;
         var8 = Dp.constructor-impl((float)$this$dp$iv);
      }

      if ((var10 & 128) != 0) {
         $this$dp$iv = LiveLiterals$DropShadowKt.INSTANCE.Int$$$this$call-$get-dp$$param-offsetRight$fun-dropShadow();
         $i$f$getDp = false;
         var9 = Dp.constructor-impl((float)$this$dp$iv);
      }

      return dropShadow-oh6pGx0(var0, var1, var2, var3, var4, var6, var7, var8, var9);
   }
}
