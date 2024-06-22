package land.sungbin.androidplayground;

import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002²\u0006\n\u0010\u0003\u001a\u00020\u0004X\u008a\u008e\u0002"},
   d2 = {"main", "", "app_debug", "a", ""}
)
@SourceDebugExtension({"SMAP\nmain.kt\nKotlin\n*S Kotlin\n*F\n+ 1 main.kt\nland/sungbin/androidplayground/MainKt\n+ 2 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot\n+ 3 SnapshotFloatState.kt\nandroidx/compose/runtime/PrimitiveSnapshotStateKt__SnapshotFloatStateKt\n*L\n1#1,15:1\n129#2,5:16\n76#3:21\n109#3,2:22\n*S KotlinDebug\n*F\n+ 1 main.kt\nland/sungbin/androidplayground/MainKt\n*L\n14#1:16,5\n9#1:21\n9#1:22,2\n*E\n"})
public final class MainKt {
   public static final void main() {
      MutableFloatState a$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(LiveLiterals$MainKt.INSTANCE.Float$arg-0$call-mutableFloatStateOf$val-a$delegate$fun-main());
      Snapshot snapshot = Companion.takeSnapshot$default(Snapshot.Companion, (Function1)null, 1, (Object)null);
      main$lambda$1(a$delegate, LiveLiterals$MainKt.INSTANCE.Float$arg-0$call-$set-a$$fun-main());
      float var2 = main$lambda$0(a$delegate);
      System.out.println(var2);
      int $i$f$enter = false;
      Snapshot previous$iv = snapshot.makeCurrent();

      try {
         int var5 = false;
         float var6 = main$lambda$0(a$delegate);
         System.out.println(var6);
         Unit var9 = Unit.INSTANCE;
      } finally {
         snapshot.restoreCurrent(previous$iv);
      }

   }

   // $FF: synthetic method
   public static void main(String[] args) {
      main();
   }

   private static final float main$lambda$0(MutableFloatState $a$delegate) {
      FloatState $this$getValue$iv = (FloatState)$a$delegate;
      Object var2 = null;
      KProperty property$iv = null;
      int $i$f$getValue = false;
      return $this$getValue$iv.getFloatValue();
   }

   private static final void main$lambda$1(MutableFloatState $a$delegate, float value) {
      Object var3 = null;
      KProperty property$iv = null;
      int $i$f$setValue = false;
      $a$delegate.setFloatValue(value);
   }
}
