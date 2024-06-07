package land.sungbin.androidplayground;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"},
   d2 = {"Lland/sungbin/androidplayground/DebugPopupPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "()V", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "app_debug"}
)
@StabilityInferred(
   parameters = 1
)
public final class DebugPopupPositionProvider implements PopupPositionProvider {
   @NotNull
   public static final DebugPopupPositionProvider INSTANCE = new DebugPopupPositionProvider();
   public static final int $stable;

   private DebugPopupPositionProvider() {
   }

   public long calculatePosition_llwVHH4/* $FF was: calculatePosition-llwVHH4*/(@NotNull IntRect anchorBounds, long windowSize, @NotNull LayoutDirection layoutDirection, long popupContentSize) {
      Intrinsics.checkNotNullParameter(anchorBounds, "anchorBounds");
      Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
      int candidateX = false;
      int candidateY = false;
      int candidateX = RangesKt.coerceAtLeast(anchorBounds.getLeft() - IntSize.getWidth-impl(popupContentSize) / LiveLiterals$DebugPopupPositionProviderKt.INSTANCE.Int$arg-0$call-div$arg-0$call-minus$$$this$call-coerceAtLeast$set-candidateX$fun-calculatePosition$class-DebugPopupPositionProvider(), LiveLiterals$DebugPopupPositionProviderKt.INSTANCE.Int$arg-0$call-coerceAtLeast$set-candidateX$fun-calculatePosition$class-DebugPopupPositionProvider());
      if (candidateX + IntSize.getWidth-impl(popupContentSize) > IntSize.getWidth-impl(windowSize)) {
         candidateX = RangesKt.coerceAtLeast(IntSize.getWidth-impl(windowSize) - IntSize.getWidth-impl(popupContentSize), LiveLiterals$DebugPopupPositionProviderKt.INSTANCE.Int$arg-0$call-coerceAtLeast$set-candidateX$branch$if$fun-calculatePosition$class-DebugPopupPositionProvider());
      }

      int candidateY = RangesKt.coerceAtLeast(anchorBounds.getTop() - IntSize.getHeight-impl(popupContentSize), LiveLiterals$DebugPopupPositionProviderKt.INSTANCE.Int$arg-0$call-coerceAtLeast$set-candidateY$fun-calculatePosition$class-DebugPopupPositionProvider());
      if (candidateY + IntSize.getHeight-impl(popupContentSize) > IntSize.getHeight-impl(windowSize)) {
         candidateY = RangesKt.coerceAtLeast(IntSize.getHeight-impl(windowSize) - IntSize.getHeight-impl(popupContentSize), LiveLiterals$DebugPopupPositionProviderKt.INSTANCE.Int$arg-0$call-coerceAtLeast$set-candidateY$branch$if-1$fun-calculatePosition$class-DebugPopupPositionProvider());
      }

      return IntOffsetKt.IntOffset(candidateX, candidateY);
   }

   static {
      $stable = LiveLiterals$DebugPopupPositionProviderKt.INSTANCE.Int$class-DebugPopupPositionProvider();
   }
}
