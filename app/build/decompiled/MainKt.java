package land.sungbin.androidplayground;

import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002²\u0006\n\u0010\u0003\u001a\u00020\u0004X\u008a\u008e\u0002²\u0006\n\u0010\u0005\u001a\u00020\u0006X\u008a\u008e\u0002"},
   d2 = {"main", "", "app_debug", "intState", "", "stringState", ""}
)
@SourceDebugExtension({"SMAP\nmain.kt\nKotlin\n*S Kotlin\n*F\n+ 1 main.kt\nland/sungbin/androidplayground/MainKt\n+ 2 SnapshotIntState.kt\nandroidx/compose/runtime/SnapshotIntStateKt__SnapshotIntStateKt\n+ 3 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,24:1\n75#2:25\n108#2,2:26\n81#3:28\n107#3,2:29\n*S KotlinDebug\n*F\n+ 1 main.kt\nland/sungbin/androidplayground/MainKt\n*L\n16#1:25\n16#1:26,2\n17#1:28\n17#1:29,2\n*E\n"})
public final class MainKt {
   public static final void main() {
      Snapshot.Companion.registerGlobalWriteObserver((Function1)null.INSTANCE);
      MutableIntState intState$delegate = SnapshotIntStateKt.mutableIntStateOf(LiveLiterals$MainKt.INSTANCE.Int$arg-0$call-mutableIntStateOf$val-intState$delegate$fun-main());
      MutableState stringState$delegate = SnapshotStateKt.mutableStateOf$default(LiveLiterals$MainKt.INSTANCE.String$arg-0$call-mutableStateOf$val-stringState$delegate$fun-main(), (SnapshotMutationPolicy)null, 2, (Object)null);
      int var2 = LiveLiterals$MainKt.INSTANCE.Int$arg-0$call-repeat$fun-main();

      for(int var3 = 0; var3 < var2; ++var3) {
         int var5 = false;
         int var6 = main$lambda$0(intState$delegate);
         main$lambda$1(intState$delegate, var6 + 1);
         String var10001 = main$lambda$2(stringState$delegate);
         main$lambda$3(stringState$delegate, var10001 + main$lambda$2(stringState$delegate));
      }

   }

   // $FF: synthetic method
   public static void main(String[] args) {
      main();
   }

   private static final int main$lambda$0(MutableIntState $intState$delegate) {
      IntState $this$getValue$iv = (IntState)$intState$delegate;
      Object var2 = null;
      KProperty property$iv = null;
      int $i$f$getValue = false;
      return $this$getValue$iv.getIntValue();
   }

   private static final void main$lambda$1(MutableIntState $intState$delegate, int value) {
      Object var3 = null;
      KProperty property$iv = null;
      int $i$f$setValue = false;
      $intState$delegate.setIntValue(value);
   }

   private static final String main$lambda$2(MutableState $stringState$delegate) {
      State $this$getValue$iv = (State)$stringState$delegate;
      Object var2 = null;
      KProperty property$iv = null;
      int $i$f$getValue = false;
      return (String)$this$getValue$iv.getValue();
   }

   private static final void main$lambda$3(MutableState $stringState$delegate, String value) {
      Object var3 = null;
      KProperty property$iv = null;
      int $i$f$setValue = false;
      $stringState$delegate.setValue(value);
   }
}
