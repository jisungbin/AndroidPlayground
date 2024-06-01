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
import androidx.compose.ui.unit.Dp;
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
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ2\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"},
   d2 = {"Lland/sungbin/androidplayground/RoundedTicketShape;", "Landroidx/compose/ui/graphics/Shape;", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "remainingTextLayoutSize", "Landroidx/compose/ui/unit/IntSize;", "punchholeRadius", "Landroidx/compose/ui/unit/Dp;", "(JJFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "F", "TicketShape", "Landroidx/compose/ui/graphics/Path;", "size", "Landroidx/compose/ui/geometry/Size;", "density", "Landroidx/compose/ui/unit/Density;", "TicketShape-d8vpnys", "(JLandroidx/compose/ui/unit/Density;JF)Landroidx/compose/ui/graphics/Path;", "createOutline", "Landroidx/compose/ui/graphics/Outline$Generic;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline$Generic;", "app_debug"}
)
@StabilityInferred(
   parameters = 1
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/RoundedTicketShape\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,179:1\n1#2:180\n154#3:181\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/RoundedTicketShape\n*L\n149#1:181\n*E\n"})
public final class RoundedTicketShape implements Shape {
   private final long cornerRadius;
   private final long remainingTextLayoutSize;
   private final float punchholeRadius;
   public static final int $stable;

   private RoundedTicketShape(long cornerRadius, long remainingTextLayoutSize, float punchholeRadius) {
      this.cornerRadius = cornerRadius;
      this.remainingTextLayoutSize = remainingTextLayoutSize;
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
      var7 = this.TicketShape-d8vpnys(size, density, this.remainingTextLayoutSize, this.punchholeRadius);
      int var8 = PathOperation.Companion.getIntersect-b3I0S0c();
      Path var10 = var5.combine-xh6zSI8(var8, var6, var7);
      return new Generic(var10);
   }

   private final Path TicketShape_d8vpnys/* $FF was: TicketShape-d8vpnys*/(long size, Density density, long remainingTextLayoutSize, float punchholeRadius) {
      Path var7 = AndroidPath_androidKt.Path();
      int var9 = false;
      int var11 = false;
      float punchholeRadius = density.toPx-0680j_4(punchholeRadius);
      int var13 = false;
      float var10000 = Size.getWidth-impl(size) - (float)IntSize.getWidth-impl(remainingTextLayoutSize);
      int $this$dp$iv = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$$$this$call-$get-dp$$$$this$call-toPx$$this$call-times$arg-0$call-minus$fun-$anonymous$$arg-1$call-with$val-punchholeXCenter$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape();
      int $i$f$getDp = false;
      float punchholeXCenter = var10000 - density.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv)) * (float)LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$arg-0$call-times$arg-0$call-minus$fun-$anonymous$$arg-1$call-with$val-punchholeXCenter$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape();
      var7.moveTo(LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-0$call-moveTo$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-1$call-moveTo$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape());
      var7.lineTo(punchholeXCenter - punchholeRadius, LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-1$call-lineTo$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape());
      var7.arcTo(RectKt.Rect-3MmeM6k(OffsetKt.Offset(punchholeXCenter, LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-1$call-Offset$arg-0$call-Rect$arg-0$call-arcTo$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape()), punchholeRadius), LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-1$call-arcTo$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-2$call-arcTo$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$arg-3$call-arcTo$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape());
      var7.lineTo(Size.getWidth-impl(size), LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-1$call-lineTo-1$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape());
      var7.lineTo(Size.getWidth-impl(size), Size.getHeight-impl(size));
      var7.lineTo(punchholeXCenter - punchholeRadius, Size.getHeight-impl(size));
      var7.arcTo(RectKt.Rect-3MmeM6k(OffsetKt.Offset(punchholeXCenter, Size.getHeight-impl(size)), punchholeRadius), LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-1$call-arcTo-1$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-2$call-arcTo-1$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$arg-3$call-arcTo-1$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape());
      var7.lineTo(LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-0$call-lineTo-4$fun-$anonymous$$arg-0$call-apply$fun-TicketShape$class-RoundedTicketShape(), Size.getHeight-impl(size));
      var7.close();
      return var7;
   }

   // $FF: synthetic method
   public RoundedTicketShape(long cornerRadius, long remainingTextLayoutSize, float punchholeRadius, DefaultConstructorMarker $constructor_marker) {
      this(cornerRadius, remainingTextLayoutSize, punchholeRadius);
   }

   static {
      $stable = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$class-RoundedTicketShape();
   }
}
