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
   @NotNull
   private static String String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-registerGlobalWriteObserver$fun-main = "written: ";
   @Nullable
   private static State State$String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-registerGlobalWriteObserver$fun-main;
   private static int Int$arg-0$call-mutableIntStateOf$val-state$delegate$fun-main;
   @Nullable
   private static State State$Int$arg-0$call-mutableIntStateOf$val-state$delegate$fun-main;
   private static int Int$arg-0$call-repeat$fun-main = 10;
   @Nullable
   private static State State$Int$arg-0$call-repeat$fun-main;

   @LiveLiteralInfo(
      key = "String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-registerGlobalWriteObserver$fun-main",
      offset = 412
   )
   @NotNull
   public final String String$0$str$arg_0$call_println$fun_$anonymous$$arg_0$call_registerGlobalWriteObserver$fun_main/* $FF was: String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-registerGlobalWriteObserver$fun-main*/() {
      if (!LiveLiteralKt.isLiveLiteralsEnabled()) {
         return String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-registerGlobalWriteObserver$fun-main;
      } else {
         State var10000 = State$String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-registerGlobalWriteObserver$fun-main;
         if (var10000 == null) {
            State var1 = LiveLiteralKt.liveLiteral("String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-registerGlobalWriteObserver$fun-main", String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-registerGlobalWriteObserver$fun-main);
            State$String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-registerGlobalWriteObserver$fun-main = var1;
            var10000 = var1;
         }

         return (String)var10000.getValue();
      }
   }

   @LiveLiteralInfo(
      key = "Int$arg-0$call-mutableIntStateOf$val-state$delegate$fun-main",
      offset = 482
   )
   public final int Int$arg_0$call_mutableIntStateOf$val_state$delegate$fun_main/* $FF was: Int$arg-0$call-mutableIntStateOf$val-state$delegate$fun-main*/() {
      if (!LiveLiteralKt.isLiveLiteralsEnabled()) {
         return Int$arg-0$call-mutableIntStateOf$val-state$delegate$fun-main;
      } else {
         State var10000 = State$Int$arg-0$call-mutableIntStateOf$val-state$delegate$fun-main;
         if (var10000 == null) {
            State var1 = LiveLiteralKt.liveLiteral("Int$arg-0$call-mutableIntStateOf$val-state$delegate$fun-main", Int$arg-0$call-mutableIntStateOf$val-state$delegate$fun-main);
            State$Int$arg-0$call-mutableIntStateOf$val-state$delegate$fun-main = var1;
            var10000 = var1;
         }

         return ((Number)var10000.getValue()).intValue();
      }
   }

   @LiveLiteralInfo(
      key = "Int$arg-0$call-repeat$fun-main",
      offset = 494
   )
   public final int Int$arg_0$call_repeat$fun_main/* $FF was: Int$arg-0$call-repeat$fun-main*/() {
      if (!LiveLiteralKt.isLiveLiteralsEnabled()) {
         return Int$arg-0$call-repeat$fun-main;
      } else {
         State var10000 = State$Int$arg-0$call-repeat$fun-main;
         if (var10000 == null) {
            State var1 = LiveLiteralKt.liveLiteral("Int$arg-0$call-repeat$fun-main", Int$arg-0$call-repeat$fun-main);
            State$Int$arg-0$call-repeat$fun-main = var1;
            var10000 = var1;
         }

         return ((Number)var10000.getValue()).intValue();
      }
   }
}
