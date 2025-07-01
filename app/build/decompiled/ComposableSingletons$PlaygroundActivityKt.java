package land.sungbin.androidplayground;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
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
   private static Function4 lambda$1672179226;
   @NotNull
   private static Function2 lambda$2023832317;

   @NotNull
   public final Function4 getLambda$1672179226$app_debug() {
      return lambda$1672179226;
   }

   @NotNull
   public final Function2 getLambda$2023832317$app_debug() {
      return lambda$2023832317;
   }

   static {
      lambda$1672179226 = (Function4)ComposableLambdaKt.composableLambdaInstance(1672179226, false, null.INSTANCE);
      lambda$2023832317 = (Function2)ComposableLambdaKt.composableLambdaInstance(2023832317, false, null.INSTANCE);
   }
}
