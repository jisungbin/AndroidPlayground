package land.sungbin.androidplayground;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 1, 0},
   k = 3,
   xi = 48
)
public final class ComposableSingletons$PlaygroundActivityKt {
   @NotNull
   public static final ComposableSingletons$PlaygroundActivityKt INSTANCE = new ComposableSingletons$PlaygroundActivityKt();
   @NotNull
   private static Function3 lambda$789504108;

   @NotNull
   public final Function3 getLambda$789504108$app_debug() {
      return lambda$789504108;
   }

   static {
      lambda$789504108 = (Function3)ComposableLambdaKt.composableLambdaInstance(789504108, false, null.INSTANCE);
   }
}
