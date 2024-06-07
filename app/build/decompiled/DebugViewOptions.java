package land.sungbin.androidplayground;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R+\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f*\u0004\b\n\u0010\u000b¨\u0006\u0010"},
   d2 = {"Lland/sungbin/androidplayground/DebugViewOptions;", "", "()V", "_enabled", "Landroidx/compose/runtime/MutableState;", "", "get_enabled$app_debug", "()Landroidx/compose/runtime/MutableState;", "<set-?>", "enabled", "getEnabled$delegate", "(Lland/sungbin/androidplayground/DebugViewOptions;)Ljava/lang/Object;", "getEnabled", "()Z", "setEnabled", "(Z)V", "app_debug"}
)
@StabilityInferred(
   parameters = 1
)
@SourceDebugExtension({"SMAP\nDebugViewOptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugViewOptions.kt\nland/sungbin/androidplayground/DebugViewOptions\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,12:1\n81#2:13\n107#2,2:14\n*S KotlinDebug\n*F\n+ 1 DebugViewOptions.kt\nland/sungbin/androidplayground/DebugViewOptions\n*L\n10#1:13\n10#1:14,2\n*E\n"})
public final class DebugViewOptions {
   @NotNull
   public static final DebugViewOptions INSTANCE = new DebugViewOptions();
   @NotNull
   private static final MutableState _enabled = SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy)null, 2, (Object)null);
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

   static {
      DebugViewOptions var10000 = INSTANCE;
      MutableState var0 = _enabled;
      $stable = LiveLiterals$DebugViewOptionsKt.INSTANCE.Int$class-DebugViewOptions();
   }
}
