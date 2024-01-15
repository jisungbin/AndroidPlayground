package land.sungbin.androidplayground;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Stack;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"},
   d2 = {"Lland/sungbin/androidplayground/Main;", "", "()V", "stack", "Ljava/util/Stack;", "getStack", "()Ljava/util/Stack;", "app_debug"}
)
@StabilityInferred(
   parameters = 0
)
public final class Main {
   @NotNull
   public static final Main INSTANCE = new Main();
   @NotNull
   private static final Stack stack = new Stack();
   public static final int $stable = 8;

   private Main() {
   }

   @NotNull
   public final Stack getStack() {
      return stack;
   }
}
