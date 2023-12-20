package land.sungbin.androidplayground;

import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.LiveLiteralFileInfo;
import androidx.compose.runtime.internal.LiveLiteralInfo;
import androidx.compose.runtime.internal.LiveLiteralKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@LiveLiteralFileInfo(
   file = "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt"
)
@Metadata(
   mv = {1, 9, 0},
   k = 3,
   xi = 48
)
public final class LiveLiterals$PlaygroundActivityKt {
   @NotNull
   public static final LiveLiterals$PlaygroundActivityKt INSTANCE = new LiveLiterals$PlaygroundActivityKt();
   private static int Int$class-PlaygroundActivity;
   @Nullable
   private static State State$Int$class-PlaygroundActivity;
   private static int Int$class-A;
   @Nullable
   private static State State$Int$class-A;
   private static int Int$class-Test;
   @Nullable
   private static State State$Int$class-Test;

   @LiveLiteralInfo(
      key = "Int$class-PlaygroundActivity",
      offset = -1
   )
   public final int Int$class_PlaygroundActivity/* $FF was: Int$class-PlaygroundActivity*/() {
      if (!LiveLiteralKt.isLiveLiteralsEnabled()) {
         return Int$class-PlaygroundActivity;
      } else {
         State var10000 = State$Int$class-PlaygroundActivity;
         if (var10000 == null) {
            State var1 = LiveLiteralKt.liveLiteral("Int$class-PlaygroundActivity", Int$class-PlaygroundActivity);
            State$Int$class-PlaygroundActivity = var1;
            var10000 = var1;
         }

         return ((Number)var10000.getValue()).intValue();
      }
   }

   @LiveLiteralInfo(
      key = "Int$class-A",
      offset = -1
   )
   public final int Int$class_A/* $FF was: Int$class-A*/() {
      if (!LiveLiteralKt.isLiveLiteralsEnabled()) {
         return Int$class-A;
      } else {
         State var10000 = State$Int$class-A;
         if (var10000 == null) {
            State var1 = LiveLiteralKt.liveLiteral("Int$class-A", Int$class-A);
            State$Int$class-A = var1;
            var10000 = var1;
         }

         return ((Number)var10000.getValue()).intValue();
      }
   }

   @LiveLiteralInfo(
      key = "Int$class-Test",
      offset = -1
   )
   public final int Int$class_Test/* $FF was: Int$class-Test*/() {
      if (!LiveLiteralKt.isLiveLiteralsEnabled()) {
         return Int$class-Test;
      } else {
         State var10000 = State$Int$class-Test;
         if (var10000 == null) {
            State var1 = LiveLiteralKt.liveLiteral("Int$class-Test", Int$class-Test);
            State$Int$class-Test = var1;
            var10000 = var1;
         }

         return ((Number)var10000.getValue()).intValue();
      }
   }
}
