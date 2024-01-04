package land.sungbin.androidplayground;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003¨\u0006\u0007"},
   d2 = {"main", "", "copyCurrentRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "Landroidx/compose/runtime/snapshots/StateObject;", "restoreFrom", "record", "app_debug"}
)
@SourceDebugExtension({"SMAP\nmain.kt\nKotlin\n*S Kotlin\n*F\n+ 1 main.kt\nland/sungbin/androidplayground/MainKt\n+ 2 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot\n+ 3 Snapshot.kt\nandroidx/compose/runtime/snapshots/SnapshotKt\n+ 4 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n*L\n1#1,43:1\n129#2,5:44\n2279#3:49\n2172#3,2:50\n1722#3:52\n2174#3,5:54\n70#4:53\n*S KotlinDebug\n*F\n+ 1 main.kt\nland/sungbin/androidplayground/MainKt\n*L\n19#1:44,5\n36#1:49\n41#1:50,2\n41#1:52\n41#1:54,5\n41#1:53\n*E\n"})
public final class MainKt {
   public static final void main() {
      MutableIntState state = SnapshotIntStateKt.mutableIntStateOf(LiveLiterals$MainKt.INSTANCE.Int$arg-0$call-mutableIntStateOf$val-state$fun-main());
      Intrinsics.checkNotNull(state, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateObject");
      StateObject stateObject = (StateObject)state;
      StateRecord previousRecord = copyCurrentRecord(stateObject);
      state.setIntValue(state.getIntValue() + 1);
      state.getIntValue();
      MutableSnapshot safeZone = Companion.takeMutableSnapshot$default(Snapshot.Companion, (Function1)null, (Function1)null, 3, (Object)null);

      try {
         Snapshot this_$iv = (Snapshot)safeZone;
         int $i$f$enter = false;
         Snapshot previous$iv = this_$iv.makeCurrent();

         try {
            int var7 = false;
            int current = state.getIntValue();
            int var9 = false;
            restoreFrom(stateObject, previousRecord);
            int previous = state.getIntValue();
            String var10000 = LiveLiterals$MainKt.INSTANCE.String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-enter$try$fun-main();
            System.out.println(var10000 + current + LiveLiterals$MainKt.INSTANCE.String$2$str$arg-0$call-println$fun-$anonymous$$arg-0$call-enter$try$fun-main() + previous);
            Unit var11 = Unit.INSTANCE;
         } finally {
            this_$iv.restoreCurrent(previous$iv);
         }
      } finally {
         safeZone.dispose();
      }

      System.out.println(LiveLiterals$MainKt.INSTANCE.String$0$str$arg-0$call-println$fun-main() + state.getIntValue());
   }

   @NotNull
   public static final StateRecord copyCurrentRecord(@NotNull StateObject $this$copyCurrentRecord) {
      Intrinsics.checkNotNullParameter($this$copyCurrentRecord, "<this>");
      StateRecord newRecord = $this$copyCurrentRecord.getFirstStateRecord().create();
      StateRecord $this$withCurrent$iv = $this$copyCurrentRecord.getFirstStateRecord();
      int $i$f$withCurrent = false;
      StateRecord p0 = SnapshotKt.current($this$withCurrent$iv);
      int var5 = false;
      newRecord.assign(p0);
      return newRecord;
   }

   public static final void restoreFrom(@NotNull StateObject param0, @NotNull StateRecord param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   public static void main(String[] args) {
      main();
   }
}
