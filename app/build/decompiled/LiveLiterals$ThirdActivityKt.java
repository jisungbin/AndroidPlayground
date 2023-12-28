package land.sungbin.androidplayground;

import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.LiveLiteralFileInfo;
import androidx.compose.runtime.internal.LiveLiteralInfo;
import androidx.compose.runtime.internal.LiveLiteralKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@LiveLiteralFileInfo(
   file = "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/ThirdActivity.kt"
)
@Metadata(
   mv = {1, 9, 0},
   k = 3,
   xi = 48
)
public final class LiveLiterals$ThirdActivityKt {
   @NotNull
   public static final LiveLiterals$ThirdActivityKt INSTANCE = new LiveLiterals$ThirdActivityKt();
   private static int Int$class-ThirdActivity;
   @Nullable
   private static State State$Int$class-ThirdActivity;

   @LiveLiteralInfo(
      key = "Int$class-ThirdActivity",
      offset = -1
   )
   public final int Int$class_ThirdActivity/* $FF was: Int$class-ThirdActivity*/() {
      if (!LiveLiteralKt.isLiveLiteralsEnabled()) {
         return Int$class-ThirdActivity;
      } else {
         State var10000 = State$Int$class-ThirdActivity;
         if (var10000 == null) {
            State var1 = LiveLiteralKt.liveLiteral("Int$class-ThirdActivity", Int$class-ThirdActivity);
            State$Int$class-ThirdActivity = var1;
            var10000 = var1;
         }

         return ((Number)var10000.getValue()).intValue();
      }
   }
}
