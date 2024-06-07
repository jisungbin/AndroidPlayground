package land.sungbin.androidplayground;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"},
   d2 = {"Lland/sungbin/androidplayground/DebugPopupPositionProvider;", "Lland/sungbin/androidplayground/PopupPositionProvider;", "()V", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "rootSize", "Landroidx/compose/ui/unit/IntSize;", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "popupContentSize", "density", "Landroidx/compose/ui/unit/Density;", "calculatePosition-JCqRrFk", "(JLandroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/Density;)J", "app_debug"}
)
@StabilityInferred(
   parameters = 1
)
@SourceDebugExtension({"SMAP\nDebugPopupPositionProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugPopupPositionProvider.kt\nland/sungbin/androidplayground/DebugPopupPositionProvider\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,22:1\n154#2:23\n154#2:24\n*S KotlinDebug\n*F\n+ 1 DebugPopupPositionProvider.kt\nland/sungbin/androidplayground/DebugPopupPositionProvider\n*L\n17#1:23\n18#1:24\n*E\n"})
public final class DebugPopupPositionProvider implements PopupPositionProvider {
   @NotNull
   public static final DebugPopupPositionProvider INSTANCE = new DebugPopupPositionProvider();
   public static final int $stable;

   private DebugPopupPositionProvider() {
   }

   public long calculatePosition_JCqRrFk/* $FF was: calculatePosition-JCqRrFk*/(long rootSize, @NotNull IntRect anchorBounds, long popupContentSize, @NotNull Density density) {
      Intrinsics.checkNotNullParameter(anchorBounds, "anchorBounds");
      Intrinsics.checkNotNullParameter(density, "density");
      int var8 = false;
      int var10000 = IntSize.getWidth-impl(rootSize) - IntSize.getWidth-impl(popupContentSize);
      int $this$dp$iv = LiveLiterals$DebugPopupPositionProviderKt.INSTANCE.Int$$$this$call-$get-dp$$$$this$call-roundToPx$arg-0$call-minus$$$this$call-coerceAtLeast$arg-0$call-IntOffset$fun-$anonymous$$arg-1$call-with$fun-calculatePosition$class-DebugPopupPositionProvider();
      int $i$f$getDp = false;
      var10000 = RangesKt.coerceAtLeast(var10000 - density.roundToPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv)), LiveLiterals$DebugPopupPositionProviderKt.INSTANCE.Int$arg-0$call-coerceAtLeast$arg-0$call-IntOffset$fun-$anonymous$$arg-1$call-with$fun-calculatePosition$class-DebugPopupPositionProvider());
      $this$dp$iv = LiveLiterals$DebugPopupPositionProviderKt.INSTANCE.Int$$$this$call-$get-dp$$$$this$call-roundToPx$arg-1$call-IntOffset$fun-$anonymous$$arg-1$call-with$fun-calculatePosition$class-DebugPopupPositionProvider();
      $i$f$getDp = false;
      return IntOffsetKt.IntOffset(var10000, density.roundToPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv)));
   }

   static {
      $stable = LiveLiterals$DebugPopupPositionProviderKt.INSTANCE.Int$class-DebugPopupPositionProvider();
   }
}
