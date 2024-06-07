package land.sungbin.androidplayground;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR+\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014*\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"},
   d2 = {"Lland/sungbin/androidplayground/DebugViewOptions;", "", "()V", "Semantics", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "", "getSemantics", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "_enabled", "Landroidx/compose/runtime/MutableState;", "", "get_enabled$app_debug", "()Landroidx/compose/runtime/MutableState;", "<set-?>", "enabled", "getEnabled$delegate", "(Lland/sungbin/androidplayground/DebugViewOptions;)Ljava/lang/Object;", "getEnabled", "()Z", "setEnabled", "(Z)V", "resolver", "Lland/sungbin/androidplayground/DebugData$Resolver;", "getResolver", "()Lland/sungbin/androidplayground/DebugData$Resolver;", "setResolver", "(Lland/sungbin/androidplayground/DebugData$Resolver;)V", "app_debug"}
)
@StabilityInferred(
   parameters = 0
)
@SourceDebugExtension({"SMAP\nDebugViewOptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugViewOptions.kt\nland/sungbin/androidplayground/DebugViewOptions\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,28:1\n81#2:29\n107#2,2:30\n*S KotlinDebug\n*F\n+ 1 DebugViewOptions.kt\nland/sungbin/androidplayground/DebugViewOptions\n*L\n13#1:29\n13#1:30,2\n*E\n"})
public final class DebugViewOptions {
   @NotNull
   public static final DebugViewOptions INSTANCE = new DebugViewOptions();
   @NotNull
   private static final MutableState _enabled = SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy)null, 2, (Object)null);
   @NotNull
   private static DebugData.Resolver resolver;
   @NotNull
   private static final SemanticsPropertyKey Semantics;
   public static final int $stable;

   private DebugViewOptions() {
   }

   @NotNull
   public final MutableState get_enabled$app_debug() {
      return _enabled;
   }

   public final boolean getEnabled() {
      State $this$getValue$iv = (State)_enabled;
      KProperty property$iv = null;
      int $i$f$getValue = false;
      return (Boolean)$this$getValue$iv.getValue();
   }

   public final void setEnabled(boolean var1) {
      MutableState $this$setValue$iv = _enabled;
      Object var3 = null;
      Object value$iv = var1;
      int $i$f$setValue = false;
      $this$setValue$iv.setValue(value$iv);
   }

   private static Object getEnabled$delegate(DebugViewOptions var0) {
      return _enabled;
   }

   @NotNull
   public final DebugData.Resolver getResolver() {
      return resolver;
   }

   public final void setResolver(@NotNull DebugData.Resolver var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      resolver = var1;
   }

   @NotNull
   public final SemanticsPropertyKey getSemantics() {
      return Semantics;
   }

   private static final DebugData resolver$lambda$0(SemanticsNode node) {
      Intrinsics.checkNotNullParameter(node, "node");
      String var10002 = String.valueOf(node.getId());
      String[] var1 = new String[]{"id: " + node.getId(), "size: " + IntSize.toString-impl(node.getSize-YbymL2g()), "position: " + Offset.toString-impl(node.getPositionInRoot-F1C5BW0())};
      return new DebugData(var10002, CollectionsKt.listOf(var1), node);
   }

   static {
      DebugViewOptions var10000 = INSTANCE;
      MutableState var0 = _enabled;
      resolver = DebugViewOptions::resolver$lambda$0;
      Semantics = new SemanticsPropertyKey("DebugView", (Function2)null, 2, (DefaultConstructorMarker)null);
      $stable = LiveLiterals$DebugViewOptionsKt.INSTANCE.Int$class-DebugViewOptions();
   }
}
