package land.sungbin.androidplayground;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import land.sungbin.composeinvestigator.runtime.ComposableInvalidationTrackTable;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"},
   d2 = {"main", "", "app_debug"}
)
public final class MainKt {
   @NotNull
   private static final ComposableInvalidationTrackTable ComposableInvalidationTrackTableImpl$MainKt = new ComposableInvalidationTrackTable();

   public static final void main() {
      MutableState var10000 = SnapshotStateKt.mutableStateOf$default(LiveLiterals$MainKt.INSTANCE.Int$arg-0$call-mutableStateOf$$this$call-$get-value$$val-state$fun-main(), (SnapshotMutationPolicy)null, 2, (Object)null);
      Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type androidx.compose.runtime.State<*>");
      Object state = ((State)var10000).getValue();
      System.out.println(state);
   }

   // $FF: synthetic method
   public static void main(String[] args) {
      main();
   }
}
