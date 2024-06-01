package land.sungbin.androidplayground;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.Outline.Generic;
import androidx.compose.ui.graphics.Path.Companion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ:\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J*\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\b\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"},
   d2 = {"Lland/sungbin/androidplayground/RoundedTicketShape;", "Landroidx/compose/ui/graphics/Shape;", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "remainingTextLayoutSize", "Landroidx/compose/ui/unit/IntSize;", "remainingTextLayoutHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "punchholeRadius", "(JJFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "F", "TicketShape", "Landroidx/compose/ui/graphics/Path;", "size", "Landroidx/compose/ui/geometry/Size;", "density", "Landroidx/compose/ui/unit/Density;", "TicketShape-Xo1dAY0", "(JLandroidx/compose/ui/unit/Density;JFF)Landroidx/compose/ui/graphics/Path;", "createOutline", "Landroidx/compose/ui/graphics/Outline$Generic;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline$Generic;", "app_debug"}
)
@StabilityInferred(
   parameters = 1
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/RoundedTicketShape\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,249:1\n1#2:250\n*E\n"})
public final class RoundedTicketShape implements Shape {
   private final long cornerRadius;
   private final long remainingTextLayoutSize;
   private final float remainingTextLayoutHorizontalPadding;
   private final float punchholeRadius;
   public static final int $stable;

   private RoundedTicketShape(long cornerRadius, long remainingTextLayoutSize, float remainingTextLayoutHorizontalPadding, float punchholeRadius) {
      this.cornerRadius = cornerRadius;
      this.remainingTextLayoutSize = remainingTextLayoutSize;
      this.remainingTextLayoutHorizontalPadding = remainingTextLayoutHorizontalPadding;
      this.punchholeRadius = punchholeRadius;
   }

   @NotNull
   public Generic createOutline_Pq9zytI/* $FF was: createOutline-Pq9zytI*/(long size, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
      Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
      Intrinsics.checkNotNullParameter(density, "density");
      Companion var5 = Path.Companion;
      Path var7 = AndroidPath_androidKt.Path();
      int var9 = false;
      var7.addRoundRect(RoundRectKt.RoundRect-sniSvfs(SizeKt.toRect-uvyYCjk(size), this.cornerRadius));
      Path var6 = var7;
      var7 = this.TicketShape-Xo1dAY0(size, density, this.remainingTextLayoutSize, this.remainingTextLayoutHorizontalPadding, this.punchholeRadius);
      int var8 = PathOperation.Companion.getIntersect-b3I0S0c();
      Path var10 = var5.combine-xh6zSI8(var8, var6, var7);
      return new Generic(var10);
   }

   private final Path TicketShape_Xo1dAY0/* $FF was: TicketShape-Xo1dAY0*/(long size, Density density, long remainingTextLayoutSize, float remainingTextLayoutHorizontalPadding, float punchholeRadius) {
      Path var8 = AndroidPath_androidKt.Path();
      int var10 = false;
      int var12 = false;
      float punchholeRadius = density.toPx-0680j_4(punchholeRadius);
      int var14 = false;
      float punchholeXCenter = Size.getWidth-impl(size) - (float)IntSize.getWidth-impl(remainingTextLayoutSize) - density.toPx-0680j_4(remainingTextLayoutHorizontalPadding) * (float)LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$arg-0$call-times$arg-0$call-minus$fun-$anonymous$$arg-1$call-with$val-punchholeXCenter$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape();
      var8.moveTo(LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-0$call-moveTo$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-1$call-moveTo$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape());
      var8.lineTo(punchholeXCenter - punchholeRadius, LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-1$call-lineTo$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape());
      var8.arcTo(RectKt.Rect-3MmeM6k(OffsetKt.Offset(punchholeXCenter, LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-1$call-Offset$arg-0$call-Rect$arg-0$call-arcTo$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape()), punchholeRadius), LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-1$call-arcTo$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-2$call-arcTo$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$arg-3$call-arcTo$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape());
      var8.lineTo(Size.getWidth-impl(size), LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-1$call-lineTo-1$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape());
      var8.lineTo(Size.getWidth-impl(size), Size.getHeight-impl(size));
      var8.lineTo(punchholeXCenter - punchholeRadius, Size.getHeight-impl(size));
      var8.arcTo(RectKt.Rect-3MmeM6k(OffsetKt.Offset(punchholeXCenter, Size.getHeight-impl(size)), punchholeRadius), LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-1$call-arcTo-1$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-2$call-arcTo-1$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$arg-3$call-arcTo-1$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape());
      var8.lineTo(LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-0$call-lineTo-4$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape(), Size.getHeight-impl(size));
      var8.close();
      return var8;
   }

   // $FF: synthetic method
   public RoundedTicketShape(long cornerRadius, long remainingTextLayoutSize, float remainingTextLayoutHorizontalPadding, float punchholeRadius, DefaultConstructorMarker $constructor_marker) {
      this(cornerRadius, remainingTextLayoutSize, remainingTextLayoutHorizontalPadding, punchholeRadius);
   }

   static {
      $stable = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$class-RoundedTicketShape();
   }
}
