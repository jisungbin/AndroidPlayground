package land.sungbin.androidplayground;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(
   mv = {2, 1, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u0002H\u00010\u0005¢\u0006\u0002\b\u0006H\u0002¢\u0006\u0002\u0010\u0007¨\u0006\b"},
   d2 = {"invokeComposable", "T", "composer", "Landroidx/compose/runtime/Composer;", "composable", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "app_debug"}
)
public final class PlaygroundActivityKt {
   private static final Object invokeComposable(Composer composer, Function2 composable) {
      Intrinsics.checkNotNull(composable, "null cannot be cast to non-null type kotlin.Function2<androidx.compose.runtime.Composer, kotlin.Int, T of land.sungbin.androidplayground.PlaygroundActivityKt.invokeComposable>");
      Function2 realFn = (Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(composable, 2);
      return realFn.invoke(composer, 1);
   }

   // $FF: synthetic method
   public static final Object access$invokeComposable(Composer composer, Function2 composable) {
      return invokeComposable(composer, composable);
   }
}
