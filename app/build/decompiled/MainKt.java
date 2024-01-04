package land.sungbin.androidplayground;

import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002²\u0006\n\u0010\u0003\u001a\u00020\u0004X\u008a\u008e\u0002"},
   d2 = {"main", "", "app_debug", "state", ""}
)
@SourceDebugExtension({"SMAP\nmain.kt\nKotlin\n*S Kotlin\n*F\n+ 1 main.kt\nland/sungbin/androidplayground/MainKt\n+ 2 SnapshotIntState.kt\nandroidx/compose/runtime/SnapshotIntStateKt__SnapshotIntStateKt\n*L\n1#1,20:1\n75#2:21\n108#2,2:22\n*S KotlinDebug\n*F\n+ 1 main.kt\nland/sungbin/androidplayground/MainKt\n*L\n15#1:21\n15#1:22,2\n*E\n"})
public final class MainKt {
   public static final void main() {
      Snapshot.Companion.registerGlobalWriteObserver((Function1)null.INSTANCE);
      MutableIntState state$delegate = SnapshotIntStateKt.mutableIntStateOf(LiveLiterals$MainKt.INSTANCE.Int$arg-0$call-mutableIntStateOf$val-state$delegate$fun-main());
      int var1 = LiveLiterals$MainKt.INSTANCE.Int$arg-0$call-repeat$fun-main();

      for(int var2 = 0; var2 < var1; ++var2) {
         int var4 = false;
         int var5 = main$lambda$0(state$delegate);
         main$lambda$1(state$delegate, var5 + 1);
      }

   }

   // $FF: synthetic method
   public static void main(String[] args) {
      main();
   }

   private static final int main$lambda$0(MutableIntState $state$delegate) {
      IntState $this$getValue$iv = (IntState)$state$delegate;
      Object var2 = null;
      KProperty property$iv = null;
      int $i$f$getValue = false;
      return $this$getValue$iv.getIntValue();
   }

   private static final void main$lambda$1(MutableIntState $state$delegate, int value) {
      Object var3 = null;
      KProperty property$iv = null;
      int $i$f$setValue = false;
      $state$delegate.setIntValue(value);
   }
}
