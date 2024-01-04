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
   private static int Int$val-target$fun-main;
   @Nullable
   private static State State$Int$val-target$fun-main;

   @LiveLiteralInfo(
      key = "Int$val-target$fun-main",
      offset = 68
   )
   public final int Int$val_target$fun_main/* $FF was: Int$val-target$fun-main*/() {
      if (!LiveLiteralKt.isLiveLiteralsEnabled()) {
         return Int$val-target$fun-main;
      } else {
         State var10000 = State$Int$val-target$fun-main;
         if (var10000 == null) {
            State var1 = LiveLiteralKt.liveLiteral("Int$val-target$fun-main", Int$val-target$fun-main);
            State$Int$val-target$fun-main = var1;
            var10000 = var1;
         }

         return ((Number)var10000.getValue()).intValue();
      }
   }
}
