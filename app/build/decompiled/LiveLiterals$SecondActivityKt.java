package land.sungbin.androidplayground;

import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.LiveLiteralFileInfo;
import androidx.compose.runtime.internal.LiveLiteralInfo;
import androidx.compose.runtime.internal.LiveLiteralKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@LiveLiteralFileInfo(
   file = "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/SecondActivity.kt"
)
@Metadata(
   mv = {1, 9, 0},
   k = 3,
   xi = 48
)
public final class LiveLiterals$SecondActivityKt {
   @NotNull
   public static final LiveLiterals$SecondActivityKt INSTANCE = new LiveLiterals$SecondActivityKt();
   @NotNull
   private static String String$0$str$arg-0$call-println$fun-$anonymous$$arg-1$call-LaunchedEffect$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-SecondActivity = "Enter with ";
   @Nullable
   private static State State$String$0$str$arg-0$call-println$fun-$anonymous$$arg-1$call-LaunchedEffect$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-SecondActivity;
   private static int Int$class-SecondActivity = 8;
   @Nullable
   private static State State$Int$class-SecondActivity;

   @LiveLiteralInfo(
      key = "String$0$str$arg-0$call-println$fun-$anonymous$$arg-1$call-LaunchedEffect$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-SecondActivity",
      offset = 1209
   )
   @NotNull
   public final String String$0$str$arg_0$call_println$fun_$anonymous$$arg_1$call_LaunchedEffect$fun_$anonymous$$arg_1$call_setContent$fun_onCreate$class_SecondActivity/* $FF was: String$0$str$arg-0$call-println$fun-$anonymous$$arg-1$call-LaunchedEffect$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-SecondActivity*/() {
      if (!LiveLiteralKt.isLiveLiteralsEnabled()) {
         return String$0$str$arg-0$call-println$fun-$anonymous$$arg-1$call-LaunchedEffect$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-SecondActivity;
      } else {
         State var10000 = State$String$0$str$arg-0$call-println$fun-$anonymous$$arg-1$call-LaunchedEffect$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-SecondActivity;
         if (var10000 == null) {
            State var1 = LiveLiteralKt.liveLiteral("String$0$str$arg-0$call-println$fun-$anonymous$$arg-1$call-LaunchedEffect$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-SecondActivity", String$0$str$arg-0$call-println$fun-$anonymous$$arg-1$call-LaunchedEffect$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-SecondActivity);
            State$String$0$str$arg-0$call-println$fun-$anonymous$$arg-1$call-LaunchedEffect$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-SecondActivity = var1;
            var10000 = var1;
         }

         return (String)var10000.getValue();
      }
   }

   @LiveLiteralInfo(
      key = "Int$class-SecondActivity",
      offset = -1
   )
   public final int Int$class_SecondActivity/* $FF was: Int$class-SecondActivity*/() {
      if (!LiveLiteralKt.isLiveLiteralsEnabled()) {
         return Int$class-SecondActivity;
      } else {
         State var10000 = State$Int$class-SecondActivity;
         if (var10000 == null) {
            State var1 = LiveLiteralKt.liveLiteral("Int$class-SecondActivity", Int$class-SecondActivity);
            State$Int$class-SecondActivity = var1;
            var10000 = var1;
         }

         return ((Number)var10000.getValue()).intValue();
      }
   }
}
