package land.sungbin.androidplayground;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\u001a\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0014J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003JM\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J \u0010\u0011\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\b\u0010.\u001a\u00020/H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00060"},
   d2 = {"Lland/sungbin/androidplayground/DebugUiCache;", "", "size", "Landroidx/compose/ui/geometry/Size;", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "title", "Landroidx/compose/ui/text/TextLayoutResult;", "contents", "", "source", "Lland/sungbin/androidplayground/DebugData;", "(JLandroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/text/TextLayoutResult;Ljava/util/List;Lland/sungbin/androidplayground/DebugData;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnchorBounds", "()Landroidx/compose/ui/unit/IntRect;", "getContents", "()Ljava/util/List;", "positionInRoot", "Landroidx/compose/ui/unit/IntOffset;", "getSize-NH-jbRc", "()J", "J", "getSource", "()Lland/sungbin/androidplayground/DebugData;", "getTitle", "()Landroidx/compose/ui/text/TextLayoutResult;", "component1", "component1-NH-jbRc", "component2", "component3", "component4", "component5", "copy", "copy-_93gMUo", "(JLandroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/text/TextLayoutResult;Ljava/util/List;Lland/sungbin/androidplayground/DebugData;)Lland/sungbin/androidplayground/DebugUiCache;", "equals", "", "other", "hashCode", "", "rootSize", "Landroidx/compose/ui/unit/IntSize;", "density", "Landroidx/compose/ui/unit/Density;", "positionInRoot-5SAbXVA", "(JLandroidx/compose/ui/unit/Density;)J", "toString", "", "app_debug"}
)
@StabilityInferred(
   parameters = 0
)
@SourceDebugExtension({"SMAP\nDebugUiCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugUiCache.kt\nland/sungbin/androidplayground/DebugUiCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,44:1\n1#2:45\n*E\n"})
public final class DebugUiCache {
   private final long size;
   @NotNull
   private final IntRect anchorBounds;
   @Nullable
   private final TextLayoutResult title;
   @NotNull
   private final List contents;
   @NotNull
   private final DebugData source;
   @Nullable
   private IntOffset positionInRoot;
   public static final int $stable;

   private DebugUiCache(long size, IntRect anchorBounds, TextLayoutResult title, List contents, DebugData source) {
      Intrinsics.checkNotNullParameter(anchorBounds, "anchorBounds");
      Intrinsics.checkNotNullParameter(contents, "contents");
      Intrinsics.checkNotNullParameter(source, "source");
      super();
      this.size = size;
      this.anchorBounds = anchorBounds;
      this.title = title;
      this.contents = contents;
      this.source = source;
      if (((Collection)this.contents).isEmpty()) {
         int var7 = false;
         String var8 = LiveLiterals$DebugUiCacheKt.INSTANCE.String$fun-$anonymous$$arg-1$call-require$init$class-DebugUiCache();
         throw new IllegalArgumentException(var8.toString());
      }
   }

   public final long getSize_NH_jbRc/* $FF was: getSize-NH-jbRc*/() {
      return this.size;
   }

   @NotNull
   public final IntRect getAnchorBounds() {
      return this.anchorBounds;
   }

   @Nullable
   public final TextLayoutResult getTitle() {
      return this.title;
   }

   @NotNull
   public final List getContents() {
      return this.contents;
   }

   @NotNull
   public final DebugData getSource() {
      return this.source;
   }

   public final long positionInRoot_5SAbXVA/* $FF was: positionInRoot-5SAbXVA*/(long rootSize, @NotNull Density density) {
      Intrinsics.checkNotNullParameter(density, "density");
      if (this.positionInRoot == null) {
         this.positionInRoot = IntOffset.box-impl(DebugViewOptions.INSTANCE.getPositionProvider().calculatePosition-JCqRrFk(rootSize, this.anchorBounds, IntSizeKt.IntSize(MathKt.roundToInt(Size.getWidth-impl(this.size)), MathKt.roundToInt(Size.getHeight-impl(this.size))), density));
      }

      IntOffset var10000 = this.positionInRoot;
      Intrinsics.checkNotNull(var10000);
      return var10000.unbox-impl();
   }

   @NotNull
   public String toString() {
      String var10000 = LiveLiterals$DebugUiCacheKt.INSTANCE.String$$this$call-plus$$this$call-plus$$this$call-plus$$this$call-plus$$this$call-plus$fun-toString$class-DebugUiCache();
      String var10001 = LiveLiterals$DebugUiCacheKt.INSTANCE.String$0$str$arg-0$call-plus$$this$call-plus$$this$call-plus$$this$call-plus$$this$call-plus$fun-toString$class-DebugUiCache();
      String var10002 = Size.toString-impl(this.size);
      String var10003 = LiveLiterals$DebugUiCacheKt.INSTANCE.String$2$str$arg-0$call-plus$$this$call-plus$$this$call-plus$$this$call-plus$$this$call-plus$fun-toString$class-DebugUiCache();
      String var10004 = LiveLiterals$DebugUiCacheKt.INSTANCE.String$0$str$arg-0$call-plus$$this$call-plus$$this$call-plus$$this$call-plus$fun-toString$class-DebugUiCache();
      IntRect var10005 = this.anchorBounds;
      String var10006 = LiveLiterals$DebugUiCacheKt.INSTANCE.String$2$str$arg-0$call-plus$$this$call-plus$$this$call-plus$$this$call-plus$fun-toString$class-DebugUiCache();
      String var10007 = LiveLiterals$DebugUiCacheKt.INSTANCE.String$0$str$arg-0$call-plus$$this$call-plus$$this$call-plus$fun-toString$class-DebugUiCache();
      TextLayoutResult var10008 = this.title;
      AnnotatedString var2;
      if (var10008 != null) {
         TextLayoutInput var1 = var10008.getLayoutInput();
         if (var1 != null) {
            var2 = var1.getText();
            return var10000 + var10001 + var10002 + var10003 + var10004 + var10005 + var10006 + var10007 + var2 + LiveLiterals$DebugUiCacheKt.INSTANCE.String$2$str$arg-0$call-plus$$this$call-plus$$this$call-plus$fun-toString$class-DebugUiCache() + LiveLiterals$DebugUiCacheKt.INSTANCE.String$0$str$arg-0$call-plus$$this$call-plus$fun-toString$class-DebugUiCache() + ListUtilsKt.fastJoinToString$default(this.contents, (CharSequence)null, (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null.INSTANCE, 31, (Object)null) + LiveLiterals$DebugUiCacheKt.INSTANCE.String$arg-0$call-plus$fun-toString$class-DebugUiCache();
         }
      }

      var2 = null;
      return var10000 + var10001 + var10002 + var10003 + var10004 + var10005 + var10006 + var10007 + var2 + LiveLiterals$DebugUiCacheKt.INSTANCE.String$2$str$arg-0$call-plus$$this$call-plus$$this$call-plus$fun-toString$class-DebugUiCache() + LiveLiterals$DebugUiCacheKt.INSTANCE.String$0$str$arg-0$call-plus$$this$call-plus$fun-toString$class-DebugUiCache() + ListUtilsKt.fastJoinToString$default(this.contents, (CharSequence)null, (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null.INSTANCE, 31, (Object)null) + LiveLiterals$DebugUiCacheKt.INSTANCE.String$arg-0$call-plus$fun-toString$class-DebugUiCache();
   }

   public final long component1_NH_jbRc/* $FF was: component1-NH-jbRc*/() {
      return this.size;
   }

   @NotNull
   public final IntRect component2() {
      return this.anchorBounds;
   }

   @Nullable
   public final TextLayoutResult component3() {
      return this.title;
   }

   @NotNull
   public final List component4() {
      return this.contents;
   }

   @NotNull
   public final DebugData component5() {
      return this.source;
   }

   @NotNull
   public final DebugUiCache copy__93gMUo/* $FF was: copy-_93gMUo*/(long size, @NotNull IntRect anchorBounds, @Nullable TextLayoutResult title, @NotNull List contents, @NotNull DebugData source) {
      Intrinsics.checkNotNullParameter(anchorBounds, "anchorBounds");
      Intrinsics.checkNotNullParameter(contents, "contents");
      Intrinsics.checkNotNullParameter(source, "source");
      return new DebugUiCache(size, anchorBounds, title, contents, source, (DefaultConstructorMarker)null);
   }

   // $FF: synthetic method
   public static DebugUiCache copy__93gMUo$default/* $FF was: copy-_93gMUo$default*/(DebugUiCache var0, long var1, IntRect var3, TextLayoutResult var4, List var5, DebugData var6, int var7, Object var8) {
      if ((var7 & 1) != 0) {
         var1 = var0.size;
      }

      if ((var7 & 2) != 0) {
         var3 = var0.anchorBounds;
      }

      if ((var7 & 4) != 0) {
         var4 = var0.title;
      }

      if ((var7 & 8) != 0) {
         var5 = var0.contents;
      }

      if ((var7 & 16) != 0) {
         var6 = var0.source;
      }

      return var0.copy-_93gMUo(var1, var3, var4, var5, var6);
   }

   public int hashCode() {
      int result = Size.hashCode-impl(this.size);
      result = result * LiveLiterals$DebugUiCacheKt.INSTANCE.Int$arg-0$call-times$$this$call-plus$set-result$fun-hashCode$class-DebugUiCache() + this.anchorBounds.hashCode();
      result = result * LiveLiterals$DebugUiCacheKt.INSTANCE.Int$arg-0$call-times$$this$call-plus$set-result-1$fun-hashCode$class-DebugUiCache() + (this.title == null ? LiveLiterals$DebugUiCacheKt.INSTANCE.Int$branch$when$arg-0$call-plus$set-result-1$fun-hashCode$class-DebugUiCache() : this.title.hashCode());
      result = result * LiveLiterals$DebugUiCacheKt.INSTANCE.Int$arg-0$call-times$$this$call-plus$set-result-2$fun-hashCode$class-DebugUiCache() + this.contents.hashCode();
      result = result * LiveLiterals$DebugUiCacheKt.INSTANCE.Int$arg-0$call-times$$this$call-plus$set-result-3$fun-hashCode$class-DebugUiCache() + this.source.hashCode();
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return LiveLiterals$DebugUiCacheKt.INSTANCE.Boolean$branch$when$fun-equals$class-DebugUiCache();
      } else if (!(other instanceof DebugUiCache)) {
         return LiveLiterals$DebugUiCacheKt.INSTANCE.Boolean$branch$when-1$fun-equals$class-DebugUiCache();
      } else {
         DebugUiCache var2 = (DebugUiCache)other;
         if (!Size.equals-impl0(this.size, var2.size)) {
            return LiveLiterals$DebugUiCacheKt.INSTANCE.Boolean$branch$when-2$fun-equals$class-DebugUiCache();
         } else if (!Intrinsics.areEqual(this.anchorBounds, var2.anchorBounds)) {
            return LiveLiterals$DebugUiCacheKt.INSTANCE.Boolean$branch$when-3$fun-equals$class-DebugUiCache();
         } else if (!Intrinsics.areEqual(this.title, var2.title)) {
            return LiveLiterals$DebugUiCacheKt.INSTANCE.Boolean$branch$when-4$fun-equals$class-DebugUiCache();
         } else if (!Intrinsics.areEqual(this.contents, var2.contents)) {
            return LiveLiterals$DebugUiCacheKt.INSTANCE.Boolean$branch$when-5$fun-equals$class-DebugUiCache();
         } else {
            return !Intrinsics.areEqual(this.source, var2.source) ? LiveLiterals$DebugUiCacheKt.INSTANCE.Boolean$branch$when-6$fun-equals$class-DebugUiCache() : LiveLiterals$DebugUiCacheKt.INSTANCE.Boolean$fun-equals$class-DebugUiCache();
         }
      }
   }

   // $FF: synthetic method
   public DebugUiCache(long size, IntRect anchorBounds, TextLayoutResult title, List contents, DebugData source, DefaultConstructorMarker $constructor_marker) {
      this(size, anchorBounds, title, contents, source);
   }

   static {
      $stable = LiveLiterals$DebugUiCacheKt.INSTANCE.Int$class-DebugUiCache();
   }
}
