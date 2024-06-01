package land.sungbin.androidplayground;

import android.graphics.Matrix;
import android.graphics.Paint;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.Outline.Generic;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"},
   d2 = {"dropShadow", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "scale", "", "spreadRadius", "Landroidx/compose/ui/unit/Dp;", "blurRadius", "color", "Landroidx/compose/ui/graphics/Color;", "dropShadow--MSDo_w", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;FFFJ)Landroidx/compose/ui/Modifier;", "app_debug"}
)
@SourceDebugExtension({"SMAP\nDropShadow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DropShadow.kt\nland/sungbin/androidplayground/DropShadowKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,61:1\n154#2:62\n*S KotlinDebug\n*F\n+ 1 DropShadow.kt\nland/sungbin/androidplayground/DropShadowKt\n*L\n23#1:62\n*E\n"})
public final class DropShadowKt {
   @Stable
   @NotNull
   public static final Modifier dropShadow__MSDo_w/* $FF was: dropShadow--MSDo_w*/(@NotNull Modifier $this$dropShadow_u2d_u2dMSDo_w, @NotNull final Shape shape, final float scale, float spreadRadius, float blurRadius, long color) {
      Intrinsics.checkNotNullParameter($this$dropShadow_u2d_u2dMSDo_w, "$this$dropShadow");
      Intrinsics.checkNotNullParameter(shape, "shape");
      return DrawModifierKt.drawBehind($this$dropShadow_u2d_u2dMSDo_w, (Function1)(new Function1() {
         public final void invoke(@NotNull DrawScope $this$drawBehind) {
            Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
            Outline outline = shape.createOutline-Pq9zytI($this$drawBehind.getSize-NH-jbRc(), $this$drawBehind.getLayoutDirection(), (Density)$this$drawBehind);
            if (!(outline instanceof Generic)) {
               int var14 = false;
               String var15 = LiveLiterals$DropShadowKt.INSTANCE.String$fun-$anonymous$$arg-1$call-require$fun-$anonymous$$arg-0$call-drawBehind$fun-dropShadow();
               throw new IllegalArgumentException(var15.toString());
            } else {
               float var4 = scale;
               int $i$f$drawIntoCanvas = false;
               Canvas canvas = $this$drawBehind.getDrawContext().getCanvas();
               int var7 = false;
               Paint var8 = new Paint();
               int var10 = false;
               var8.setColor(-16777216);
               var8.setStrokeWidth(LiveLiterals$DropShadowKt.INSTANCE.Float$arg-0$call-setStrokeWidth$fun-$anonymous$$arg-0$call-apply$val-paint$fun-$anonymous$$arg-0$call-drawIntoCanvas$fun-$anonymous$$arg-0$call-drawBehind$fun-dropShadow());
               Paint paint = var8;
               Matrix matrix = new Matrix();
               matrix.setScale(var4, var4);
               Path $this$asAndroidPath$iv = ((Generic)outline).getPath();
               int $i$f$asAndroidPath = false;
               if ($this$asAndroidPath$iv instanceof AndroidPath) {
                  android.graphics.Path var18 = ((AndroidPath)$this$asAndroidPath$iv).getInternalPath();
                  boolean var13 = false;
                  var18.transform(matrix);
                  android.graphics.Path scaledPath = var18;
                  float leftOffset = (float)Alignment.Companion.getCenterHorizontally().align(MathKt.roundToInt(Size.getWidth-impl($this$drawBehind.getSize-NH-jbRc())), MathKt.roundToInt(Size.getWidth-impl(Size.times-7Ah8Wj8($this$drawBehind.getSize-NH-jbRc(), var4))), $this$drawBehind.getLayoutDirection());
                  float topOffset = (float)Alignment.Companion.getCenterVertically().align(MathKt.roundToInt(Size.getHeight-impl($this$drawBehind.getSize-NH-jbRc())), MathKt.roundToInt(Size.getHeight-impl(Size.times-7Ah8Wj8($this$drawBehind.getSize-NH-jbRc(), var4))));
                  canvas.translate(-leftOffset, -topOffset);
                  AndroidCanvas_androidKt.getNativeCanvas(canvas).drawPath(scaledPath, paint);
                  canvas.translate(leftOffset, topOffset);
               } else {
                  throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
               }
            }
         }
      }));
   }

   // $FF: synthetic method
   public static Modifier dropShadow__MSDo_w$default/* $FF was: dropShadow--MSDo_w$default*/(Modifier var0, Shape var1, float var2, float var3, float var4, long var5, int var7, Object var8) {
      if ((var7 & 2) != 0) {
         var2 = LiveLiterals$DropShadowKt.INSTANCE.Float$param-scale$fun-dropShadow();
      }

      if ((var7 & 4) != 0) {
         int $this$dp$iv = LiveLiterals$DropShadowKt.INSTANCE.Int$$$this$call-$get-dp$$param-spreadRadius$fun-dropShadow();
         int $i$f$getDp = false;
         var3 = Dp.constructor-impl((float)$this$dp$iv);
      }

      if ((var7 & 8) != 0) {
         var4 = var3;
      }

      if ((var7 & 16) != 0) {
         var5 = Color.copy-wmQWz5c$default(Color.Companion.getDarkGray-0d7_KjU(), LiveLiterals$DropShadowKt.INSTANCE.Float$arg-0$call-copy$param-color$fun-dropShadow(), 0.0F, 0.0F, 0.0F, 14, (Object)null);
      }

      return dropShadow--MSDo_w(var0, var1, var2, var3, var4, var5);
   }
}
