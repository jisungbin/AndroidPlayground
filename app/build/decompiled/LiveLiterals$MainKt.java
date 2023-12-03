package land.sungbin.androidplayground;

import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.LiveLiteralFileInfo;
import androidx.compose.runtime.internal.LiveLiteralInfo;
import androidx.compose.runtime.internal.LiveLiteralKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@LiveLiteralFileInfo(
   file = "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/main.kt"
)
@Metadata(
   mv = {1, 9, 0},
   k = 3,
   xi = 48
)
public final class LiveLiterals$MainKt {
   @NotNull
   public static final LiveLiterals$MainKt INSTANCE = new LiveLiterals$MainKt();
   private static int Int$arg-0$call-mutableStateOf$$this$call-$get-value$$val-state$fun-main;
   @Nullable
   private static State State$Int$arg-0$call-mutableStateOf$$this$call-$get-value$$val-state$fun-main;

   @LiveLiteralInfo(
      key = "Int$arg-0$call-mutableStateOf$$this$call-$get-value$$val-state$fun-main",
      offset = 169
   )
   public final int Int$arg_0$call_mutableStateOf$$this$call_$get_value$$val_state$fun_main/* $FF was: Int$arg-0$call-mutableStateOf$$this$call-$get-value$$val-state$fun-main*/() {
      if (!LiveLiteralKt.isLiveLiteralsEnabled()) {
         return Int$arg-0$call-mutableStateOf$$this$call-$get-value$$val-state$fun-main;
      } else {
         State var10000 = State$Int$arg-0$call-mutableStateOf$$this$call-$get-value$$val-state$fun-main;
         if (var10000 == null) {
            State var1 = LiveLiteralKt.liveLiteral("Int$arg-0$call-mutableStateOf$$this$call-$get-value$$val-state$fun-main", Int$arg-0$call-mutableStateOf$$this$call-$get-value$$val-state$fun-main);
            State$Int$arg-0$call-mutableStateOf$$this$call-$get-value$$val-state$fun-main = var1;
            var10000 = var1;
         }

         return ((Number)var10000.getValue()).intValue();
      }
   }
}
