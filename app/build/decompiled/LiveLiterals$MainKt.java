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
   private static float Float$arg-0$call-mutableFloatStateOf$val-a$delegate$fun-main;
   @Nullable
   private static State State$Float$arg-0$call-mutableFloatStateOf$val-a$delegate$fun-main;
   private static float Float$arg-0$call-$set-a$$fun-main = 2.0F;
   @Nullable
   private static State State$Float$arg-0$call-$set-a$$fun-main;

   @LiveLiteralInfo(
      key = "Float$arg-0$call-mutableFloatStateOf$val-a$delegate$fun-main",
      offset = 270
   )
   public final float Float$arg_0$call_mutableFloatStateOf$val_a$delegate$fun_main/* $FF was: Float$arg-0$call-mutableFloatStateOf$val-a$delegate$fun-main*/() {
      if (!LiveLiteralKt.isLiveLiteralsEnabled()) {
         return Float$arg-0$call-mutableFloatStateOf$val-a$delegate$fun-main;
      } else {
         State var10000 = State$Float$arg-0$call-mutableFloatStateOf$val-a$delegate$fun-main;
         if (var10000 == null) {
            State var1 = LiveLiteralKt.liveLiteral("Float$arg-0$call-mutableFloatStateOf$val-a$delegate$fun-main", Float$arg-0$call-mutableFloatStateOf$val-a$delegate$fun-main);
            State$Float$arg-0$call-mutableFloatStateOf$val-a$delegate$fun-main = var1;
            var10000 = var1;
         }

         return ((Number)var10000.getValue()).floatValue();
      }
   }

   @LiveLiteralInfo(
      key = "Float$arg-0$call-$set-a$$fun-main",
      offset = 321
   )
   public final float Float$arg_0$call_$set_a$$fun_main/* $FF was: Float$arg-0$call-$set-a$$fun-main*/() {
      if (!LiveLiteralKt.isLiveLiteralsEnabled()) {
         return Float$arg-0$call-$set-a$$fun-main;
      } else {
         State var10000 = State$Float$arg-0$call-$set-a$$fun-main;
         if (var10000 == null) {
            State var1 = LiveLiteralKt.liveLiteral("Float$arg-0$call-$set-a$$fun-main", Float$arg-0$call-$set-a$$fun-main);
            State$Float$arg-0$call-$set-a$$fun-main = var1;
            var10000 = var1;
         }

         return ((Number)var10000.getValue()).floatValue();
      }
   }
}
