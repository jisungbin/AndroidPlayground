package land.sungbin.androidplayground;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 3,
   xi = 48
)
public final class ComposableSingletons$PlaygroundActivityKt {
   @NotNull
   public static final ComposableSingletons$PlaygroundActivityKt INSTANCE = new ComposableSingletons$PlaygroundActivityKt();
   @NotNull
   public static Function3 lambda-1;
   @NotNull
   public static Function3 lambda-2;
   @NotNull
   public static Function2 lambda-3;

   @NotNull
   public final Function3 getLambda_1$app_debug/* $FF was: getLambda-1$app_debug*/() {
      return lambda-1;
   }

   @NotNull
   public final Function3 getLambda_2$app_debug/* $FF was: getLambda-2$app_debug*/() {
      return lambda-2;
   }

   @NotNull
   public final Function2 getLambda_3$app_debug/* $FF was: getLambda-3$app_debug*/() {
      return lambda-3;
   }

   static {
      lambda-1 = (Function3)ComposableLambdaKt.composableLambdaInstance(2138129123, false, null.INSTANCE);
      lambda-2 = (Function3)ComposableLambdaKt.composableLambdaInstance(1234063450, false, null.INSTANCE);
      lambda-3 = (Function2)ComposableLambdaKt.composableLambdaInstance(2023832317, false, null.INSTANCE);
   }
}
