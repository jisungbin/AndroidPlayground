package land.sungbin.androidplayground;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"},
   d2 = {"Lland/sungbin/androidplayground/TextStyleWrapper;", "", "value", "Landroidx/compose/ui/text/TextStyle;", "(Landroidx/compose/ui/text/TextStyle;)V", "getValue", "()Landroidx/compose/ui/text/TextStyle;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"}
)
@StabilityInferred(
   parameters = 1
)
public final class TextStyleWrapper {
   @NotNull
   private final TextStyle value;
   public static final int $stable;

   public TextStyleWrapper(@NotNull TextStyle value) {
      Intrinsics.checkNotNullParameter(value, "value");
      super();
      this.value = value;
      System.out.println(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-println$class-TextStyleWrapper() + this.value.hashCode());
      System.out.println(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-println-1$class-TextStyleWrapper() + this.hashCode());
   }

   @NotNull
   public final TextStyle getValue() {
      return this.value;
   }

   @NotNull
   public final TextStyle component1() {
      return this.value;
   }

   @NotNull
   public final TextStyleWrapper copy(@NotNull TextStyle value) {
      Intrinsics.checkNotNullParameter(value, "value");
      return new TextStyleWrapper(value);
   }

   // $FF: synthetic method
   public static TextStyleWrapper copy$default(TextStyleWrapper var0, TextStyle var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = var0.value;
      }

      return var0.copy(var1);
   }

   @NotNull
   public String toString() {
      String var10000 = LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$fun-toString$class-TextStyleWrapper();
      return var10000 + LiveLiterals$PlaygroundActivityKt.INSTANCE.String$1$str$fun-toString$class-TextStyleWrapper() + this.value + LiveLiterals$PlaygroundActivityKt.INSTANCE.String$3$str$fun-toString$class-TextStyleWrapper();
   }

   public int hashCode() {
      return this.value.hashCode();
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$branch$when$fun-equals$class-TextStyleWrapper();
      } else if (!(other instanceof TextStyleWrapper)) {
         return LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$branch$when-1$fun-equals$class-TextStyleWrapper();
      } else {
         TextStyleWrapper var2 = (TextStyleWrapper)other;
         return !Intrinsics.areEqual(this.value, var2.value) ? LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$branch$when-2$fun-equals$class-TextStyleWrapper() : LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$fun-equals$class-TextStyleWrapper();
      }
   }

   static {
      $stable = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$class-TextStyleWrapper();
   }
}
