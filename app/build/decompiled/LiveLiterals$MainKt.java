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
   private static int Int$class-One$class-A;
   @Nullable
   private static State State$Int$class-One$class-A;
   private static int Int$class-Two$class-A;
   @Nullable
   private static State State$Int$class-Two$class-A;
   private static int Int$class-A;
   @Nullable
   private static State State$Int$class-A;

   @LiveLiteralInfo(
      key = "Int$class-One$class-A",
      offset = -1
   )
   public final int Int$class_One$class_A/* $FF was: Int$class-One$class-A*/() {
      if (!LiveLiteralKt.isLiveLiteralsEnabled()) {
         return Int$class-One$class-A;
      } else {
         State var10000 = State$Int$class-One$class-A;
         if (var10000 == null) {
            State var1 = LiveLiteralKt.liveLiteral("Int$class-One$class-A", Int$class-One$class-A);
            State$Int$class-One$class-A = var1;
            var10000 = var1;
         }

         return ((Number)var10000.getValue()).intValue();
      }
   }

   @LiveLiteralInfo(
      key = "Int$class-Two$class-A",
      offset = -1
   )
   public final int Int$class_Two$class_A/* $FF was: Int$class-Two$class-A*/() {
      if (!LiveLiteralKt.isLiveLiteralsEnabled()) {
         return Int$class-Two$class-A;
      } else {
         State var10000 = State$Int$class-Two$class-A;
         if (var10000 == null) {
            State var1 = LiveLiteralKt.liveLiteral("Int$class-Two$class-A", Int$class-Two$class-A);
            State$Int$class-Two$class-A = var1;
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
}
