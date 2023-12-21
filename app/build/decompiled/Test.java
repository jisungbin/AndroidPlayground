package land.sungbin.androidplayground;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"},
   d2 = {"Lland/sungbin/androidplayground/Test;", "", "a", "Lland/sungbin/androidplayground/A;", "(Lland/sungbin/androidplayground/A;)V", "getA", "()Lland/sungbin/androidplayground/A;", "app_debug"}
)
@StabilityInferred(
   parameters = 1
)
public final class Test {
   @NotNull
   private final A a;
   public static final int $stable;

   public Test(@NotNull A a) {
      Intrinsics.checkNotNullParameter(a, "a");
      super();
      this.a = a;
   }

   @NotNull
   public final A getA() {
      return this.a;
   }

   static {
      $stable = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$class-Test();
   }
}
