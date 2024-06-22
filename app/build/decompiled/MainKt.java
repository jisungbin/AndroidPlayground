package land.sungbin.androidplayground;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002²\u0006\n\u0010\u0003\u001a\u00020\u0004X\u008a\u008e\u0002"},
   d2 = {"main", "", "app_debug", "a", ""}
)
@SourceDebugExtension({"SMAP\nmain.kt\nKotlin\n*S Kotlin\n*F\n+ 1 main.kt\nland/sungbin/androidplayground/MainKt\n+ 2 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot$Companion\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,35:1\n416#2,2:36\n1#3:38\n81#4:39\n107#4,2:40\n*S KotlinDebug\n*F\n+ 1 main.kt\nland/sungbin/androidplayground/MainKt\n*L\n28#1:36,2\n28#1:38\n12#1:39\n12#1:40,2\n*E\n"})
public final class MainKt {
   public static final void main() {
      MutableState a$delegate = SnapshotStateKt.mutableStateOf(LiveLiterals$MainKt.INSTANCE.Float$arg-0$call-mutableStateOf$val-a$delegate$fun-main(), (SnapshotMutationPolicy)(new SnapshotMutationPolicy() {
         public boolean equivalent(float a, float b) {
            return a == b;
         }

         @Nullable
         public Float merge(float previous, float current, float applied) {
            System.out.println(previous + LiveLiterals$MainKt.INSTANCE.String$1$str$arg-0$call-println$fun-merge$class-$no-name-provided$$arg-1$call-mutableStateOf$val-a$delegate$fun-main() + current + LiveLiterals$MainKt.INSTANCE.String$3$str$arg-0$call-println$fun-merge$class-$no-name-provided$$arg-1$call-mutableStateOf$val-a$delegate$fun-main() + applied);
            return applied;
         }
      }));
      MutableSnapshot snapshot = Companion.takeMutableSnapshot$default(Snapshot.Companion, (Function1)null, (Function1)null, 3, (Object)null);
      main$lambda$1(a$delegate, LiveLiterals$MainKt.INSTANCE.Float$arg-0$call-$set-a$$fun-main());
      float var2 = main$lambda$0(a$delegate);
      System.out.println(var2);
      Snapshot entered = snapshot.unsafeEnter();
      main$lambda$1(a$delegate, LiveLiterals$MainKt.INSTANCE.Float$arg-0$call-$set-a$-1$fun-main());
      Companion this_$iv = Snapshot.Companion;
      int $i$f$global = false;
      Snapshot previous$iv = this_$iv.removeCurrent();
      int var6 = false;
      float var7 = main$lambda$0(a$delegate);
      System.out.println(var7);
      Unit var8 = Unit.INSTANCE;
      int var10 = false;
      Snapshot.Companion.restoreCurrent(previous$iv);
      snapshot.apply().check();
      snapshot.unsafeLeave(entered);
      if (entered != null) {
         entered.dispose();
      }

      float var12 = main$lambda$0(a$delegate);
      System.out.println(var12);
   }

   // $FF: synthetic method
   public static void main(String[] args) {
      main();
   }

   private static final float main$lambda$0(MutableState $a$delegate) {
      State $this$getValue$iv = (State)$a$delegate;
      Object var2 = null;
      KProperty property$iv = null;
      int $i$f$getValue = false;
      return ((Number)$this$getValue$iv.getValue()).floatValue();
   }

   private static final void main$lambda$1(MutableState $a$delegate, float value) {
      Object var3 = null;
      Object var4 = null;
      Object value$iv = value;
      int $i$f$setValue = false;
      $a$delegate.setValue(value$iv);
   }
}
