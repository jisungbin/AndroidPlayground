package land.sungbin.androidplayground;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.semantics.SemanticsNode;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001aB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000e\u0010\u0011\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b\u0012J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"},
   d2 = {"Lland/sungbin/androidplayground/DebugData;", "", "name", "", "contents", "", "raw", "Landroidx/compose/ui/semantics/SemanticsNode;", "(Ljava/lang/String;Ljava/util/List;Landroidx/compose/ui/semantics/SemanticsNode;)V", "getContents", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getRaw$app_debug", "()Landroidx/compose/ui/semantics/SemanticsNode;", "component1", "component2", "component3", "component3$app_debug", "copy", "equals", "", "other", "hashCode", "", "toString", "Resolver", "app_debug"}
)
@StabilityInferred(
   parameters = 0
)
@SourceDebugExtension({"SMAP\nDebugData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugData.kt\nland/sungbin/androidplayground/DebugData\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,21:1\n1#2:22\n*E\n"})
public final class DebugData {
   @NotNull
   private final String name;
   @NotNull
   private final List contents;
   @NotNull
   private final SemanticsNode raw;
   public static final int $stable;

   public DebugData(@NotNull String name, @NotNull List contents, @NotNull SemanticsNode raw) {
      Intrinsics.checkNotNullParameter(name, "name");
      Intrinsics.checkNotNullParameter(contents, "contents");
      Intrinsics.checkNotNullParameter(raw, "raw");
      super();
      this.name = name;
      this.contents = contents;
      this.raw = raw;
      if (((Collection)this.contents).isEmpty()) {
         int var4 = false;
         String var5 = LiveLiterals$DebugDataKt.INSTANCE.String$fun-$anonymous$$arg-1$call-require$init$class-DebugData();
         throw new IllegalArgumentException(var5.toString());
      }
   }

   // $FF: synthetic method
   public DebugData(String var1, List var2, SemanticsNode var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 1) != 0) {
         var1 = LiveLiterals$DebugDataKt.INSTANCE.String$param-name$class-DebugData();
      }

      this(var1, var2, var3);
   }

   @NotNull
   public final String getName() {
      return this.name;
   }

   @NotNull
   public final List getContents() {
      return this.contents;
   }

   @NotNull
   public final SemanticsNode getRaw$app_debug() {
      return this.raw;
   }

   @NotNull
   public final String component1() {
      return this.name;
   }

   @NotNull
   public final List component2() {
      return this.contents;
   }

   @NotNull
   public final SemanticsNode component3$app_debug() {
      return this.raw;
   }

   @NotNull
   public final DebugData copy(@NotNull String name, @NotNull List contents, @NotNull SemanticsNode raw) {
      Intrinsics.checkNotNullParameter(name, "name");
      Intrinsics.checkNotNullParameter(contents, "contents");
      Intrinsics.checkNotNullParameter(raw, "raw");
      return new DebugData(name, contents, raw);
   }

   // $FF: synthetic method
   public static DebugData copy$default(DebugData var0, String var1, List var2, SemanticsNode var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.name;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.contents;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.raw;
      }

      return var0.copy(var1, var2, var3);
   }

   @NotNull
   public String toString() {
      String var10000 = LiveLiterals$DebugDataKt.INSTANCE.String$0$str$fun-toString$class-DebugData();
      return var10000 + LiveLiterals$DebugDataKt.INSTANCE.String$1$str$fun-toString$class-DebugData() + this.name + LiveLiterals$DebugDataKt.INSTANCE.String$3$str$fun-toString$class-DebugData() + LiveLiterals$DebugDataKt.INSTANCE.String$4$str$fun-toString$class-DebugData() + this.contents + LiveLiterals$DebugDataKt.INSTANCE.String$6$str$fun-toString$class-DebugData() + LiveLiterals$DebugDataKt.INSTANCE.String$7$str$fun-toString$class-DebugData() + this.raw + LiveLiterals$DebugDataKt.INSTANCE.String$9$str$fun-toString$class-DebugData();
   }

   public int hashCode() {
      int result = this.name.hashCode();
      result = result * LiveLiterals$DebugDataKt.INSTANCE.Int$arg-0$call-times$$this$call-plus$set-result$fun-hashCode$class-DebugData() + this.contents.hashCode();
      result = result * LiveLiterals$DebugDataKt.INSTANCE.Int$arg-0$call-times$$this$call-plus$set-result-1$fun-hashCode$class-DebugData() + this.raw.hashCode();
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return LiveLiterals$DebugDataKt.INSTANCE.Boolean$branch$when$fun-equals$class-DebugData();
      } else if (!(other instanceof DebugData)) {
         return LiveLiterals$DebugDataKt.INSTANCE.Boolean$branch$when-1$fun-equals$class-DebugData();
      } else {
         DebugData var2 = (DebugData)other;
         if (!Intrinsics.areEqual(this.name, var2.name)) {
            return LiveLiterals$DebugDataKt.INSTANCE.Boolean$branch$when-2$fun-equals$class-DebugData();
         } else if (!Intrinsics.areEqual(this.contents, var2.contents)) {
            return LiveLiterals$DebugDataKt.INSTANCE.Boolean$branch$when-3$fun-equals$class-DebugData();
         } else {
            return !Intrinsics.areEqual(this.raw, var2.raw) ? LiveLiterals$DebugDataKt.INSTANCE.Boolean$branch$when-4$fun-equals$class-DebugData() : LiveLiterals$DebugDataKt.INSTANCE.Boolean$fun-equals$class-DebugData();
         }
      }
   }

   static {
      $stable = LiveLiterals$DebugDataKt.INSTANCE.Int$class-DebugData();
   }

   @Metadata(
      mv = {1, 9, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"},
      d2 = {"Lland/sungbin/androidplayground/DebugData$Resolver;", "", "resolve", "Lland/sungbin/androidplayground/DebugData;", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "app_debug"}
   )
   public interface Resolver {
      @NotNull
      DebugData resolve(@NotNull SemanticsNode var1);
   }
}
