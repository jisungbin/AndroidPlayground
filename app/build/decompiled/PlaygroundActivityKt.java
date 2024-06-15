package land.sungbin.androidplayground;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0082\u0001\u0010\t\u001a\u00020\n*\u00020\n2\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f\"\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2,\u0010\u0010\u001a(\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00030\u0011¢\u0006\u0002\b\u00172!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0019H\u0007¢\u0006\u0002\u0010\u001d\"\u001a\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"},
   d2 = {"PointerInputBounds", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/geometry/Rect;", "dirtyElementIds", "", "", "elementIdCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "clickableBoundingRect", "Landroidx/compose/ui/Modifier;", "keys", "", "", "semanticsEnabled", "", "rect", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Size;", "Lkotlin/ParameterName;", "name", "size", "Lkotlin/ExtensionFunctionType;", "onClick", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "offset", "", "(Landroidx/compose/ui/Modifier;[Ljava/lang/Object;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "app_debug"}
)
public final class PlaygroundActivityKt {
   @NotNull
   private static final SemanticsPropertyKey PointerInputBounds = new SemanticsPropertyKey("PointerInputBounds", (Function2)null, 2, (DefaultConstructorMarker)null);
   @NotNull
   private static final AtomicInteger elementIdCounter = new AtomicInteger(0);
   @NotNull
   private static final Set dirtyElementIds = (Set)(new LinkedHashSet());

   @Stable
   @NotNull
   public static final Modifier clickableBoundingRect(@NotNull Modifier $this$clickableBoundingRect, @NotNull Object[] keys, boolean semanticsEnabled, @NotNull Function2 rect, @NotNull Function1 onClick) {
      Intrinsics.checkNotNullParameter($this$clickableBoundingRect, "<this>");
      Intrinsics.checkNotNullParameter(keys, "keys");
      Intrinsics.checkNotNullParameter(rect, "rect");
      Intrinsics.checkNotNullParameter(onClick, "onClick");
      return $this$clickableBoundingRect.then((Modifier)(new SuspendBoundingPointerInputElement((Object)null, (Object)null, keys, rect, onClick, semanticsEnabled, 3, (DefaultConstructorMarker)null)));
   }

   // $FF: synthetic method
   public static final SemanticsPropertyKey access$getPointerInputBounds$p() {
      return PointerInputBounds;
   }

   // $FF: synthetic method
   public static final AtomicInteger access$getElementIdCounter$p() {
      return elementIdCounter;
   }

   // $FF: synthetic method
   public static final Set access$getDirtyElementIds$p() {
      return dirtyElementIds;
   }
}
