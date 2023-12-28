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
   private static int Int$val-count$fun-$anonymous$$arg-1$call-runBlocking$fun-main;
   @Nullable
   private static State State$Int$val-count$fun-$anonymous$$arg-1$call-runBlocking$fun-main;
   private static int Int$set-count$fun-$anonymous$$arg-1$call-runBlocking$fun-main;
   @Nullable
   private static State State$Int$set-count$fun-$anonymous$$arg-1$call-runBlocking$fun-main;

   @LiveLiteralInfo(
      key = "Int$val-count$fun-$anonymous$$arg-1$call-runBlocking$fun-main",
      offset = 162
   )
   public final int Int$val_count$fun_$anonymous$$arg_1$call_runBlocking$fun_main/* $FF was: Int$val-count$fun-$anonymous$$arg-1$call-runBlocking$fun-main*/() {
      if (!LiveLiteralKt.isLiveLiteralsEnabled()) {
         return Int$val-count$fun-$anonymous$$arg-1$call-runBlocking$fun-main;
      } else {
         State var10000 = State$Int$val-count$fun-$anonymous$$arg-1$call-runBlocking$fun-main;
         if (var10000 == null) {
            State var1 = LiveLiteralKt.liveLiteral("Int$val-count$fun-$anonymous$$arg-1$call-runBlocking$fun-main", Int$val-count$fun-$anonymous$$arg-1$call-runBlocking$fun-main);
            State$Int$val-count$fun-$anonymous$$arg-1$call-runBlocking$fun-main = var1;
            var10000 = var1;
         }

         return ((Number)var10000.getValue()).intValue();
      }
   }

   @LiveLiteralInfo(
      key = "Int$set-count$fun-$anonymous$$arg-1$call-runBlocking$fun-main",
      offset = 237
   )
   public final int Int$set_count$fun_$anonymous$$arg_1$call_runBlocking$fun_main/* $FF was: Int$set-count$fun-$anonymous$$arg-1$call-runBlocking$fun-main*/() {
      if (!LiveLiteralKt.isLiveLiteralsEnabled()) {
         return Int$set-count$fun-$anonymous$$arg-1$call-runBlocking$fun-main;
      } else {
         State var10000 = State$Int$set-count$fun-$anonymous$$arg-1$call-runBlocking$fun-main;
         if (var10000 == null) {
            State var1 = LiveLiteralKt.liveLiteral("Int$set-count$fun-$anonymous$$arg-1$call-runBlocking$fun-main", Int$set-count$fun-$anonymous$$arg-1$call-runBlocking$fun-main);
            State$Int$set-count$fun-$anonymous$$arg-1$call-runBlocking$fun-main = var1;
            var10000 = var1;
         }

         return ((Number)var10000.getValue()).intValue();
      }
   }
}
