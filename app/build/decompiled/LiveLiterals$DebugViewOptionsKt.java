package land.sungbin.androidplayground;

import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.LiveLiteralFileInfo;
import androidx.compose.runtime.internal.LiveLiteralInfo;
import androidx.compose.runtime.internal.LiveLiteralKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@LiveLiteralFileInfo(
   file = "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/DebugViewOptions.kt"
)
@Metadata(
   mv = {1, 9, 0},
   k = 3,
   xi = 48
)
public final class LiveLiterals$DebugViewOptionsKt {
   @NotNull
   public static final LiveLiterals$DebugViewOptionsKt INSTANCE = new LiveLiterals$DebugViewOptionsKt();
   private static int Int$class-DebugViewOptions;
   @Nullable
   private static State State$Int$class-DebugViewOptions;

   @LiveLiteralInfo(
      key = "Int$class-DebugViewOptions",
      offset = -1
   )
   public final int Int$class_DebugViewOptions/* $FF was: Int$class-DebugViewOptions*/() {
      if (!LiveLiteralKt.isLiveLiteralsEnabled()) {
         return Int$class-DebugViewOptions;
      } else {
         State var10000 = State$Int$class-DebugViewOptions;
         if (var10000 == null) {
            State var1 = LiveLiteralKt.liveLiteral("Int$class-DebugViewOptions", Int$class-DebugViewOptions);
            State$Int$class-DebugViewOptions = var1;
            var10000 = var1;
         }

         return ((Number)var10000.getValue()).intValue();
      }
   }
}
