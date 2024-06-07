package land.sungbin.androidplayground;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import androidx.annotation.MainThread;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope.DrawParams;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextPainterKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000  2\u00020\u0001:\u0003 !\"B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\t\u0010\u0018\u001a\u00020\u0019H\u0082\bJ\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0004H\u0007J\u0013\u0010\u001c\u001a\u00020\u001d*\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0082\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0018\u00010\u0006R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u0014X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"},
   d2 = {"Lland/sungbin/androidplayground/DebugPopupWindow;", "Landroid/widget/PopupWindow;", "()V", "anchor", "Lland/sungbin/androidplayground/DebugComposeView;", "contentView", "Lland/sungbin/androidplayground/DebugPopupWindow$DebugPopupView;", "currentWatcherDisposeHandle", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "target", "Lkotlin/Pair;", "Landroidx/compose/ui/geometry/Rect;", "Lland/sungbin/androidplayground/DebugData;", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "getTextMeasurer", "()Landroidx/compose/ui/text/TextMeasurer;", "textMeasurer$delegate", "Lkotlin/Lazy;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "J", "release", "", "requireOwner", "Landroidx/compose/ui/node/Owner;", "start", "host", "isRealChanged", "", "", "", "Companion", "DebugPopupView", "UiCache", "app_debug"}
)
@StabilityInferred(
   parameters = 0
)
@SourceDebugExtension({"SMAP\nDebugPopupWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugPopupWindow.kt\nland/sungbin/androidplayground/DebugPopupWindow\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,281:1\n1#2:282\n154#3:283\n154#3:284\n*S KotlinDebug\n*F\n+ 1 DebugPopupWindow.kt\nland/sungbin/androidplayground/DebugPopupWindow\n*L\n274#1:283\n275#1:284\n*E\n"})
public final class DebugPopupWindow extends PopupWindow {
   @NotNull
   private static final DebugPopupWindow.Companion Companion = new DebugPopupWindow.Companion((DefaultConstructorMarker)null);
   @Nullable
   private DebugComposeView anchor;
   @Nullable
   private DebugPopupWindow.DebugPopupView contentView;
   @Nullable
   private ObserverHandle currentWatcherDisposeHandle;
   @NotNull
   private final Lazy textMeasurer$delegate = LazyKt.lazy((Function0)(new Function0() {
      @NotNull
      public final TextMeasurer invoke() {
         DebugPopupWindow this_$iv = DebugPopupWindow.this;
         int $i$f$requireOwner = false;
         DebugComposeView var10000 = this_$iv.anchor;
         Owner var5 = var10000 != null ? var10000.getOwner$app_debug() : null;
         if (var5 == null) {
            int var4 = false;
            String var6 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$fun-$anonymous$$arg-1$call-checkNotNull$fun-requireOwner$class-DebugPopupWindow();
            throw new IllegalStateException(var6.toString());
         } else {
            Owner owner = var5;
            return new TextMeasurer(owner.getFontFamilyResolver(), owner.getDensity(), owner.getLayoutDirection(), 15);
         }
      }
   }));
   private long windowSize;
   @Nullable
   private Pair target;
   public static final int $stable;
   /** @deprecated */
   @Deprecated
   public static final int DEFAULT_CACHE_SIZE = 15;
   private static final long DEFAULT_BACKGROUND_COLOR;
   private static final float DEBUG_VIEW_PADDING;
   private static final float DEBUG_VIEW_SPACING;
   @NotNull
   private static final TextStyle DEBUG_TITLE_STYLE;
   @NotNull
   private static final TextStyle DEBUG_CONTENT_STYLE;

   public DebugPopupWindow() {
      this.windowSize = IntSize.Companion.getZero-YbymL2g();
   }

   private final TextMeasurer getTextMeasurer() {
      Lazy var1 = this.textMeasurer$delegate;
      return (TextMeasurer)var1.getValue();
   }

   @MainThread
   public final void start(@NotNull final DebugComposeView host) {
      Intrinsics.checkNotNullParameter(host, "host");
      this.anchor = host;
      DebugPopupWindow.DebugPopupView var2 = new DebugPopupWindow.DebugPopupView(host);
      View p0 = (View)var2;
      int var4 = false;
      this.setContentView(p0);
      this.contentView = var2;
      this.currentWatcherDisposeHandle = Snapshot.Companion.registerApplyObserver((Function2)(new Function2() {
         public final void invoke(@NotNull Set changes, @NotNull Snapshot var2) {
            Intrinsics.checkNotNullParameter(changes, "changes");
            Intrinsics.checkNotNullParameter(var2, "<anonymous parameter 1>");
            DebugPopupWindow.DebugPopupView var10000 = DebugPopupWindow.this.contentView;
            if (var10000 != null) {
               DebugPopupWindow.DebugPopupView contentView = var10000;
               DebugPopupWindow this_$iv = DebugPopupWindow.this;
               int $i$f$isRealChanged = false;
               DebugComposeView var10001 = this_$iv.anchor;
               Intrinsics.checkNotNull(var10001);
               MutableState var18 = var10001.getDebugData$app_debug();
               Intrinsics.checkNotNull(var18, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateObject");
               if (changes.contains((StateObject)var18)) {
                  DebugPopupWindow.this.target = (Pair)host.getDebugData$app_debug().getValue();
                  Pair target = DebugPopupWindow.this.target;
                  System.out.println(LiveLiterals$DebugPopupWindowKt.INSTANCE.String$0$str$arg-0$call-println$branch$if$fun-$anonymous$$arg-0$call-registerApplyObserver$arg-0$call-$set-currentWatcherDisposeHandle$$fun-start$class-DebugPopupWindow() + target);
                  if (target != null) {
                     DebugPopupWindow.UiCache var16 = contentView.getCurrent();
                     IntSize previousUiSize = var16 != null ? IntSize.box-impl(var16.getSize-YbymL2g()) : null;
                     DebugPopupWindow.UiCache ui = contentView.calculateUi(target);
                     String var17 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$0$str$arg-0$call-println$branch$if$branch$if$fun-$anonymous$$arg-0$call-registerApplyObserver$arg-0$call-$set-currentWatcherDisposeHandle$$fun-start$class-DebugPopupWindow();
                     System.out.println(var17 + ui + LiveLiterals$DebugPopupWindowKt.INSTANCE.String$2$str$arg-0$call-println$branch$if$branch$if$fun-$anonymous$$arg-0$call-registerApplyObserver$arg-0$call-$set-currentWatcherDisposeHandle$$fun-start$class-DebugPopupWindow() + previousUiSize);
                     contentView.setLayoutParams(new LayoutParams(IntSize.getWidth-impl(ui.getSize-YbymL2g()), IntSize.getHeight-impl(ui.getSize-YbymL2g())));
                     long var7 = ui.getSize-YbymL2g();
                     if (!(previousUiSize == null ? false : IntSize.equals-impl0(previousUiSize.unbox-impl(), var7))) {
                        contentView.requestLayout();
                     } else {
                        contentView.invalidate();
                     }

                     var17 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$0$str$arg-0$call-println-1$branch$if$branch$if$fun-$anonymous$$arg-0$call-registerApplyObserver$arg-0$call-$set-currentWatcherDisposeHandle$$fun-start$class-DebugPopupWindow();
                     System.out.println(var17 + contentView.getWidth() + LiveLiterals$DebugPopupWindowKt.INSTANCE.String$2$str$arg-0$call-println-1$branch$if$branch$if$fun-$anonymous$$arg-0$call-registerApplyObserver$arg-0$call-$set-currentWatcherDisposeHandle$$fun-start$class-DebugPopupWindow() + contentView.getHeight());
                     System.out.println(LiveLiterals$DebugPopupWindowKt.INSTANCE.String$0$str$arg-0$call-println-2$branch$if$branch$if$fun-$anonymous$$arg-0$call-registerApplyObserver$arg-0$call-$set-currentWatcherDisposeHandle$$fun-start$class-DebugPopupWindow() + contentView.getVisibility());
                     System.out.println(LiveLiterals$DebugPopupWindowKt.INSTANCE.String$0$str$arg-0$call-println-3$branch$if$branch$if$fun-$anonymous$$arg-0$call-registerApplyObserver$arg-0$call-$set-currentWatcherDisposeHandle$$fun-start$class-DebugPopupWindow() + contentView.willNotDraw());
                     var7 = ui.getPopupPosition-nOcc-ac();
                     DebugPopupWindow var9 = DebugPopupWindow.this;
                     DebugComposeView var10 = host;
                     int var13 = false;
                     if (var9.isShowing()) {
                        var9.update(IntOffset.getX-impl(var7), IntOffset.getY-impl(var7), IntSize.getWidth-impl(ui.getSize-YbymL2g()), IntSize.getHeight-impl(ui.getSize-YbymL2g()), LiveLiterals$DebugPopupWindowKt.INSTANCE.Boolean$arg-4$call-update$branch$if$fun-$anonymous$$arg-0$call-let$branch$if$branch$if$fun-$anonymous$$arg-0$call-registerApplyObserver$arg-0$call-$set-currentWatcherDisposeHandle$$fun-start$class-DebugPopupWindow());
                     } else {
                        var9.showAtLocation((View)var10, 0, IntOffset.getX-impl(var7), IntOffset.getY-impl(var7));
                     }

                     var17 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$0$str$arg-0$call-println-4$branch$if$branch$if$fun-$anonymous$$arg-0$call-registerApplyObserver$arg-0$call-$set-currentWatcherDisposeHandle$$fun-start$class-DebugPopupWindow();
                     System.out.println(var17 + DebugPopupWindow.this.isShowing() + LiveLiterals$DebugPopupWindowKt.INSTANCE.String$2$str$arg-0$call-println-4$branch$if$branch$if$fun-$anonymous$$arg-0$call-registerApplyObserver$arg-0$call-$set-currentWatcherDisposeHandle$$fun-start$class-DebugPopupWindow() + DebugPopupWindow.this.getContentView());
                  } else {
                     System.out.println(LiveLiterals$DebugPopupWindowKt.INSTANCE.String$arg-0$call-println$else$if$branch$if$fun-$anonymous$$arg-0$call-registerApplyObserver$arg-0$call-$set-currentWatcherDisposeHandle$$fun-start$class-DebugPopupWindow());
                     DebugPopupWindow.this.dismiss();
                  }
               }

            }
         }
      }));
      LifecycleOwner var10000 = ViewTreeLifecycleOwner.get((View)host);
      Intrinsics.checkNotNull(var10000);
      var10000.getLifecycle().addObserver((LifecycleObserver)(new DefaultLifecycleObserver() {
         public void onDestroy(@NotNull LifecycleOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            DebugPopupWindow.this.release();
         }
      }));
   }

   private final void release() {
      ObserverHandle var10000 = this.currentWatcherDisposeHandle;
      if (var10000 != null) {
         var10000.dispose();
      }

      DebugPopupWindow.DebugPopupView var1 = this.contentView;
      if (var1 != null) {
         var1.release();
      }

      this.contentView = null;
      this.anchor = null;
   }

   private final Owner requireOwner() {
      int $i$f$requireOwner = false;
      DebugComposeView var10000 = access$getAnchor$p(this);
      Owner var3 = var10000 != null ? var10000.getOwner$app_debug() : null;
      if (var3 == null) {
         int var2 = false;
         String var4 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$fun-$anonymous$$arg-1$call-checkNotNull$fun-requireOwner$class-DebugPopupWindow();
         throw new IllegalStateException(var4.toString());
      } else {
         return var3;
      }
   }

   private final boolean isRealChanged(Set $this$isRealChanged) {
      int $i$f$isRealChanged = false;
      DebugComposeView var10001 = access$getAnchor$p(this);
      Intrinsics.checkNotNull(var10001);
      MutableState var3 = var10001.getDebugData$app_debug();
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateObject");
      return $this$isRealChanged.contains((StateObject)var3);
   }

   static {
      $stable = LiveLiterals$DebugPopupWindowKt.INSTANCE.Int$class-DebugPopupWindow();
      DEFAULT_BACKGROUND_COLOR = Color.copy-wmQWz5c$default(Color.Companion.getGray-0d7_KjU(), 0.8F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
      int $this$dp$iv = 8;
      int $i$f$getDp = false;
      DEBUG_VIEW_PADDING = Dp.constructor-impl((float)$this$dp$iv);
      $this$dp$iv = 4;
      $i$f$getDp = false;
      DEBUG_VIEW_SPACING = Dp.constructor-impl((float)$this$dp$iv);
      DEBUG_TITLE_STYLE = new TextStyle(0L, 0L, FontWeight.Companion.getBold(), (FontStyle)null, (FontSynthesis)null, (FontFamily)null, (String)null, 0L, (BaselineShift)null, (TextGeometricTransform)null, (LocaleList)null, 0L, (TextDecoration)null, (Shadow)null, (DrawStyle)null, 0, 0, 0L, (TextIndent)null, (PlatformTextStyle)null, (LineHeightStyle)null, 0, 0, (TextMotion)null, 16777211, (DefaultConstructorMarker)null);
      DEBUG_CONTENT_STYLE = TextStyle.Companion.getDefault();
   }

   @Metadata(
      mv = {1, 9, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000e\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"},
      d2 = {"Lland/sungbin/androidplayground/DebugPopupWindow$Companion;", "", "()V", "DEBUG_CONTENT_STYLE", "Landroidx/compose/ui/text/TextStyle;", "getDEBUG_CONTENT_STYLE", "()Landroidx/compose/ui/text/TextStyle;", "DEBUG_TITLE_STYLE", "getDEBUG_TITLE_STYLE", "DEBUG_VIEW_PADDING", "Landroidx/compose/ui/unit/Dp;", "getDEBUG_VIEW_PADDING-D9Ej5fM", "()F", "F", "DEBUG_VIEW_SPACING", "getDEBUG_VIEW_SPACING-D9Ej5fM", "DEFAULT_BACKGROUND_COLOR", "Landroidx/compose/ui/graphics/Color;", "getDEFAULT_BACKGROUND_COLOR-0d7_KjU", "()J", "J", "DEFAULT_CACHE_SIZE", "", "app_debug"}
   )
   private static final class Companion {
      private Companion() {
      }

      public final long getDEFAULT_BACKGROUND_COLOR_0d7_KjU/* $FF was: getDEFAULT_BACKGROUND_COLOR-0d7_KjU*/() {
         return DebugPopupWindow.DEFAULT_BACKGROUND_COLOR;
      }

      public final float getDEBUG_VIEW_PADDING_D9Ej5fM/* $FF was: getDEBUG_VIEW_PADDING-D9Ej5fM*/() {
         return DebugPopupWindow.DEBUG_VIEW_PADDING;
      }

      public final float getDEBUG_VIEW_SPACING_D9Ej5fM/* $FF was: getDEBUG_VIEW_SPACING-D9Ej5fM*/() {
         return DebugPopupWindow.DEBUG_VIEW_SPACING;
      }

      @NotNull
      public final TextStyle getDEBUG_TITLE_STYLE() {
         return DebugPopupWindow.DEBUG_TITLE_STYLE;
      }

      @NotNull
      public final TextStyle getDEBUG_CONTENT_STYLE() {
         return DebugPopupWindow.DEBUG_CONTENT_STYLE;
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }

   @Metadata(
      mv = {1, 9, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0015\u001a\u00060\u0007R\u00020\b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J0\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020%H\u0014J\u0018\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020%H\u0014J(\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020%H\u0014J\u0006\u00101\u001a\u00020\u001bJ\b\u00102\u001a\u00020\u001bH\u0016J\u0017\u00103\u001a\u00020%*\u000204H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106J\u0017\u00103\u001a\u00020%*\u000207H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u000204*\u000207H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u001a\u0010:\u001a\u000204*\u00020\u000eH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u001a\u0010:\u001a\u000204*\u00020%H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010?J\u0017\u0010@\u001a\u00020A*\u00020BH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\u0017\u0010E\u001a\u00020\u000e*\u000204H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010>J\u0017\u0010E\u001a\u00020\u000e*\u000207H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010<J\r\u0010H\u001a\u00020\u0018*\u00020IH\u0097\u0001J\u0017\u0010J\u001a\u00020B*\u00020AH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010DJ\u0017\u0010L\u001a\u000207*\u000204H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ\u001a\u0010L\u001a\u000207*\u00020\u000eH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010NJ\u001a\u0010L\u001a\u000207*\u00020%H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010PR \u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u000e8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Q"},
      d2 = {"Lland/sungbin/androidplayground/DebugPopupWindow$DebugPopupView;", "Landroid/view/View;", "Landroidx/compose/ui/unit/Density;", "host", "Lland/sungbin/androidplayground/DebugComposeView;", "(Lland/sungbin/androidplayground/DebugPopupWindow;Lland/sungbin/androidplayground/DebugComposeView;)V", "current", "Lland/sungbin/androidplayground/DebugPopupWindow$UiCache;", "Lland/sungbin/androidplayground/DebugPopupWindow;", "getCurrent", "()Lland/sungbin/androidplayground/DebugPopupWindow$UiCache;", "setCurrent", "(Lland/sungbin/androidplayground/DebugPopupWindow$UiCache;)V", "density", "", "getDensity", "()F", "drawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "fontScale", "getFontScale", "calculateUi", "target", "Lkotlin/Pair;", "Landroidx/compose/ui/geometry/Rect;", "Lland/sungbin/androidplayground/DebugData;", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "draw", "invalidate", "onDraw", "onLayout", "changed", "", "left", "", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "release", "requestLayout", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "app_debug"}
   )
   @SourceDebugExtension({"SMAP\nDebugPopupWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugPopupWindow.kt\nland/sungbin/androidplayground/DebugPopupWindow$DebugPopupView\n+ 2 DebugPopupWindow.kt\nland/sungbin/androidplayground/DebugPopupWindow\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 CanvasDrawScope.kt\nandroidx/compose/ui/graphics/drawscope/CanvasDrawScope\n+ 5 DrawScope.kt\nandroidx/compose/ui/graphics/drawscope/DrawScopeKt\n+ 6 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,281:1\n110#2:282\n110#2:284\n1#3:283\n1#3:285\n1#3:297\n542#4,9:286\n551#4,8:306\n121#5,2:295\n123#5,2:304\n33#6,6:298\n151#6,3:314\n33#6,4:317\n154#6,2:321\n38#6:323\n156#6:324\n317#6,8:325\n132#6,3:333\n33#6,4:336\n135#6,2:340\n38#6:342\n137#6:343\n*S KotlinDebug\n*F\n+ 1 DebugPopupWindow.kt\nland/sungbin/androidplayground/DebugPopupWindow$DebugPopupView\n*L\n144#1:282\n220#1:284\n144#1:283\n220#1:285\n218#1:286,9\n218#1:306,8\n225#1:295,2\n225#1:304,2\n228#1:298,6\n240#1:314,3\n240#1:317,4\n240#1:321,2\n240#1:323\n240#1:324\n245#1:325,8\n250#1:333,3\n250#1:336,4\n250#1:340,2\n250#1:342\n250#1:343\n*E\n"})
   private final class DebugPopupView extends View implements Density {
      // $FF: synthetic field
      private final Density $$delegate_0;
      @NotNull
      private final CanvasDrawScope drawScope;
      @Nullable
      private volatile DebugPopupWindow.UiCache current;

      public DebugPopupView(@NotNull DebugComposeView host) {
         Intrinsics.checkNotNullParameter(host, "host");
         super(host.getContext());
         DebugPopupWindow this_$iv = DebugPopupWindow.this;
         int $i$f$requireOwner = false;
         DebugComposeView var10001 = this_$iv.anchor;
         Owner var11 = var10001 != null ? var10001.getOwner$app_debug() : null;
         if (var11 == null) {
            int var9 = false;
            String var10 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$fun-$anonymous$$arg-1$call-checkNotNull$fun-requireOwner$class-DebugPopupWindow();
            throw new IllegalStateException(var10.toString());
         } else {
            this.$$delegate_0 = var11.getDensity();
            this.drawScope = new CanvasDrawScope();
            IntRef startX = new IntRef();
            startX.element = LiveLiterals$DebugPopupWindowKt.INSTANCE.Int$val-startX$init$class-DebugPopupView$class-DebugPopupWindow();
            IntRef startY = new IntRef();
            startY.element = LiveLiterals$DebugPopupWindowKt.INSTANCE.Int$val-startY$init$class-DebugPopupView$class-DebugPopupWindow();
            IntRef offsetX = new IntRef();
            IntRef offsetY = new IntRef();
            this.setOnTouchListener(DebugPopupWindow.DebugPopupView::_init_$lambda$0);
         }
      }

      public float getDensity() {
         return this.$$delegate_0.getDensity();
      }

      public float getFontScale() {
         return this.$$delegate_0.getFontScale();
      }

      @Stable
      public int roundToPx_0680j_4/* $FF was: roundToPx-0680j_4*/(float $this$roundToPx_u2d0680j_4) {
         return this.$$delegate_0.roundToPx-0680j_4($this$roundToPx_u2d0680j_4);
      }

      @Stable
      public int roundToPx__R2X_6o/* $FF was: roundToPx--R2X_6o*/(long $this$roundToPx_u2d_u2dR2X_6o) {
         return this.$$delegate_0.roundToPx--R2X_6o($this$roundToPx_u2d_u2dR2X_6o);
      }

      @Stable
      public float toDp_GaN1DYA/* $FF was: toDp-GaN1DYA*/(long $this$toDp_u2dGaN1DYA) {
         return this.$$delegate_0.toDp-GaN1DYA($this$toDp_u2dGaN1DYA);
      }

      @Stable
      public float toDp_u2uoSUM/* $FF was: toDp-u2uoSUM*/(float $this$toDp_u2du2uoSUM) {
         return this.$$delegate_0.toDp-u2uoSUM($this$toDp_u2du2uoSUM);
      }

      @Stable
      public float toDp_u2uoSUM/* $FF was: toDp-u2uoSUM*/(int $this$toDp_u2du2uoSUM) {
         return this.$$delegate_0.toDp-u2uoSUM($this$toDp_u2du2uoSUM);
      }

      @Stable
      public long toDpSize_k_rfVVM/* $FF was: toDpSize-k-rfVVM*/(long $this$toDpSize_u2dk_u2drfVVM) {
         return this.$$delegate_0.toDpSize-k-rfVVM($this$toDpSize_u2dk_u2drfVVM);
      }

      @Stable
      public float toPx_0680j_4/* $FF was: toPx-0680j_4*/(float $this$toPx_u2d0680j_4) {
         return this.$$delegate_0.toPx-0680j_4($this$toPx_u2d0680j_4);
      }

      @Stable
      public float toPx__R2X_6o/* $FF was: toPx--R2X_6o*/(long $this$toPx_u2d_u2dR2X_6o) {
         return this.$$delegate_0.toPx--R2X_6o($this$toPx_u2d_u2dR2X_6o);
      }

      @Stable
      @NotNull
      public Rect toRect(@NotNull DpRect $this$toRect) {
         Intrinsics.checkNotNullParameter($this$toRect, "<this>");
         return this.$$delegate_0.toRect($this$toRect);
      }

      @Stable
      public long toSize_XkaWNTQ/* $FF was: toSize-XkaWNTQ*/(long $this$toSize_u2dXkaWNTQ) {
         return this.$$delegate_0.toSize-XkaWNTQ($this$toSize_u2dXkaWNTQ);
      }

      @Stable
      public long toSp_0xMU5do/* $FF was: toSp-0xMU5do*/(float $this$toSp_u2d0xMU5do) {
         return this.$$delegate_0.toSp-0xMU5do($this$toSp_u2d0xMU5do);
      }

      @Stable
      public long toSp_kPz2Gy4/* $FF was: toSp-kPz2Gy4*/(float $this$toSp_u2dkPz2Gy4) {
         return this.$$delegate_0.toSp-kPz2Gy4($this$toSp_u2dkPz2Gy4);
      }

      @Stable
      public long toSp_kPz2Gy4/* $FF was: toSp-kPz2Gy4*/(int $this$toSp_u2dkPz2Gy4) {
         return this.$$delegate_0.toSp-kPz2Gy4($this$toSp_u2dkPz2Gy4);
      }

      @Nullable
      public final DebugPopupWindow.UiCache getCurrent() {
         return this.current;
      }

      public final void setCurrent(@Nullable DebugPopupWindow.UiCache var1) {
         this.current = var1;
      }

      public void requestLayout() {
         System.out.println(LiveLiterals$DebugPopupWindowKt.INSTANCE.String$arg-0$call-println$fun-requestLayout$class-DebugPopupView$class-DebugPopupWindow());
         super.requestLayout();
      }

      protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
         String var10000 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$0$str$arg-0$call-println$fun-onLayout$class-DebugPopupView$class-DebugPopupWindow();
         System.out.println(var10000 + changed + LiveLiterals$DebugPopupWindowKt.INSTANCE.String$2$str$arg-0$call-println$fun-onLayout$class-DebugPopupView$class-DebugPopupWindow() + left + LiveLiterals$DebugPopupWindowKt.INSTANCE.String$4$str$arg-0$call-println$fun-onLayout$class-DebugPopupView$class-DebugPopupWindow() + top + LiveLiterals$DebugPopupWindowKt.INSTANCE.String$6$str$arg-0$call-println$fun-onLayout$class-DebugPopupView$class-DebugPopupWindow() + right + LiveLiterals$DebugPopupWindowKt.INSTANCE.String$8$str$arg-0$call-println$fun-onLayout$class-DebugPopupView$class-DebugPopupWindow() + bottom);
         super.onLayout(changed, left, top, right, bottom);
      }

      public void invalidate() {
         System.out.println(LiveLiterals$DebugPopupWindowKt.INSTANCE.String$arg-0$call-println$fun-invalidate$class-DebugPopupView$class-DebugPopupWindow());
         String var10000 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$0$str$arg-0$call-println-1$fun-invalidate$class-DebugPopupView$class-DebugPopupWindow();
         System.out.println(var10000 + this.getWidth() + LiveLiterals$DebugPopupWindowKt.INSTANCE.String$2$str$arg-0$call-println-1$fun-invalidate$class-DebugPopupView$class-DebugPopupWindow() + this.getHeight());
         var10000 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$0$str$arg-0$call-println-2$fun-invalidate$class-DebugPopupView$class-DebugPopupWindow();
         System.out.println(var10000 + this.getVisibility() + LiveLiterals$DebugPopupWindowKt.INSTANCE.String$2$str$arg-0$call-println-2$fun-invalidate$class-DebugPopupView$class-DebugPopupWindow() + "0" + LiveLiterals$DebugPopupWindowKt.INSTANCE.String$4$str$arg-0$call-println-2$fun-invalidate$class-DebugPopupView$class-DebugPopupWindow());
         System.out.println(LiveLiterals$DebugPopupWindowKt.INSTANCE.String$0$str$arg-0$call-println-3$fun-invalidate$class-DebugPopupView$class-DebugPopupWindow() + this.willNotDraw());
         super.invalidate();
      }

      protected void onSizeChanged(int w, int h, int oldw, int oldh) {
         String var10000 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$0$str$arg-0$call-println$fun-onSizeChanged$class-DebugPopupView$class-DebugPopupWindow();
         System.out.println(var10000 + w + LiveLiterals$DebugPopupWindowKt.INSTANCE.String$2$str$arg-0$call-println$fun-onSizeChanged$class-DebugPopupView$class-DebugPopupWindow() + h + LiveLiterals$DebugPopupWindowKt.INSTANCE.String$4$str$arg-0$call-println$fun-onSizeChanged$class-DebugPopupView$class-DebugPopupWindow() + oldw + LiveLiterals$DebugPopupWindowKt.INSTANCE.String$6$str$arg-0$call-println$fun-onSizeChanged$class-DebugPopupView$class-DebugPopupWindow() + oldh);
         if (oldw == 0 || oldh == LiveLiterals$DebugPopupWindowKt.INSTANCE.Int$arg-1$call-EQEQ$else$cond$if$fun-onSizeChanged$class-DebugPopupView$class-DebugPopupWindow()) {
            this.invalidate();
         }

         super.onSizeChanged(w, h, oldw, oldh);
      }

      protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
         DebugPopupWindow.UiCache var10000 = this.current;
         long size = var10000 != null ? var10000.getSize-YbymL2g() : IntSize.Companion.getZero-YbymL2g();
         System.out.println(LiveLiterals$DebugPopupWindowKt.INSTANCE.String$0$str$arg-0$call-println$fun-onMeasure$class-DebugPopupView$class-DebugPopupWindow() + IntSize.toString-impl(size));
         this.setMeasuredDimension(IntSize.getWidth-impl(size), IntSize.getHeight-impl(size));
      }

      public void draw(@NotNull Canvas canvas) {
         Intrinsics.checkNotNullParameter(canvas, "canvas");
         System.out.println(LiveLiterals$DebugPopupWindowKt.INSTANCE.String$arg-0$call-println$fun-draw$class-DebugPopupView$class-DebugPopupWindow());
         super.draw(canvas);
      }

      protected void dispatchDraw(@NotNull Canvas canvas) {
         Intrinsics.checkNotNullParameter(canvas, "canvas");
         System.out.println(LiveLiterals$DebugPopupWindowKt.INSTANCE.String$arg-0$call-println$fun-dispatchDraw$class-DebugPopupView$class-DebugPopupWindow());
         super.dispatchDraw(canvas);
      }

      protected void onDraw(@NotNull Canvas canvas) {
         Intrinsics.checkNotNullParameter(canvas, "canvas");
         System.out.println(LiveLiterals$DebugPopupWindowKt.INSTANCE.String$0$str$arg-0$call-println$fun-onDraw$class-DebugPopupView$class-DebugPopupWindow() + this.current);
         DebugPopupWindow.UiCache var10000 = this.current;
         if (var10000 != null) {
            DebugPopupWindow.UiCache current = var10000;
            CanvasDrawScope this_$iv = this.drawScope;
            DebugPopupWindow this_$ivx = DebugPopupWindow.this;
            int $i$f$requireOwner = false;
            DebugComposeView var37 = this_$ivx.anchor;
            Owner var38 = var37 != null ? var37.getOwner$app_debug() : null;
            if (var38 == null) {
               int var35 = false;
               String var36 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$fun-$anonymous$$arg-1$call-checkNotNull$fun-requireOwner$class-DebugPopupWindow();
               throw new IllegalStateException(var36.toString());
            } else {
               LayoutDirection layoutDirection$iv = var38.getLayoutDirection();
               androidx.compose.ui.graphics.Canvas canvas$iv = AndroidCanvas_androidKt.Canvas(canvas);
               long size$iv = IntSizeKt.toSize-ozmzZPI(current.getSize-YbymL2g());
               int var8 = false;
               DrawParams var9 = this_$iv.getDrawParams();
               Density prevDensity$iv = var9.component1();
               LayoutDirection prevLayoutDirection$iv = var9.component2();
               androidx.compose.ui.graphics.Canvas prevCanvas$iv = var9.component3();
               long prevSize$iv = var9.component4-NH-jbRc();
               DrawParams $this$draw_yzxVdVo_u24lambda_u241$iv = this_$iv.getDrawParams();
               int var16 = false;
               $this$draw_yzxVdVo_u24lambda_u241$iv.setDensity((Density)this);
               $this$draw_yzxVdVo_u24lambda_u241$iv.setLayoutDirection(layoutDirection$iv);
               $this$draw_yzxVdVo_u24lambda_u241$iv.setCanvas(canvas$iv);
               $this$draw_yzxVdVo_u24lambda_u241$iv.setSize-uvyYCjk(size$iv);
               canvas$iv.save();
               DrawScope $this$onDraw_u24lambda_u244 = (DrawScope)this_$iv;
               int var18 = false;
               DrawScope.drawRect-n-J9OG0$default($this$onDraw_u24lambda_u244, DebugPopupWindow.Companion.getDEFAULT_BACKGROUND_COLOR-0d7_KjU(), 0L, 0L, 0.0F, (DrawStyle)null, (ColorFilter)null, 0, 126, (Object)null);
               float left$iv = $this$onDraw_u24lambda_u244.toPx-0680j_4(DebugPopupWindow.Companion.getDEBUG_VIEW_PADDING-D9Ej5fM());
               float top$iv = $this$onDraw_u24lambda_u244.toPx-0680j_4(DebugPopupWindow.Companion.getDEBUG_VIEW_PADDING-D9Ej5fM());
               int $i$f$translate = false;
               $this$onDraw_u24lambda_u244.getDrawContext().getTransform().translate(left$iv, top$iv);
               DrawScope $this$onDraw_u24lambda_u244_u24lambda_u243 = $this$onDraw_u24lambda_u244;
               int var24 = false;
               float y = 0.0F;
               y = LiveLiterals$DebugPopupWindowKt.INSTANCE.Float$val-y$fun-$anonymous$$arg-2$call-translate$fun-$anonymous$$arg-4$call-draw$fun-onDraw$class-DebugPopupView$class-DebugPopupWindow();
               TextLayoutResult var39 = current.getTitle();
               if (var39 != null) {
                  TextLayoutResult it = var39;
                  int var27 = false;
                  TextPainterKt.drawText-d8-rzKo$default($this$onDraw_u24lambda_u244, it, 0L, 0L, 0.0F, (Shadow)null, (TextDecoration)null, (DrawStyle)null, 0, 254, (Object)null);
                  y += (float)IntSize.getHeight-impl(it.getSize-YbymL2g()) + $this$onDraw_u24lambda_u244.toPx-0680j_4(DebugPopupWindow.Companion.getDEBUG_VIEW_SPACING-D9Ej5fM());
               }

               List $this$fastForEach$iv = current.getContents();
               int $i$f$fastForEach = false;
               int index$iv = 0;

               for(int var41 = $this$fastForEach$iv.size(); index$iv < var41; ++index$iv) {
                  Object item$iv = $this$fastForEach$iv.get(index$iv);
                  TextLayoutResult content = (TextLayoutResult)item$iv;
                  int var32 = false;
                  TextPainterKt.drawText-d8-rzKo$default($this$onDraw_u24lambda_u244_u24lambda_u243, content, 0L, OffsetKt.Offset(LiveLiterals$DebugPopupWindowKt.INSTANCE.Float$arg-0$call-Offset$arg-2$call-drawText$fun-$anonymous$$arg-0$call-fastForEach$fun-$anonymous$$arg-2$call-translate$fun-$anonymous$$arg-4$call-draw$fun-onDraw$class-DebugPopupView$class-DebugPopupWindow(), y), 0.0F, (Shadow)null, (TextDecoration)null, (DrawStyle)null, 0, 250, (Object)null);
                  y += (float)IntSize.getHeight-impl(content.getSize-YbymL2g()) + $this$onDraw_u24lambda_u244_u24lambda_u243.toPx-0680j_4(DebugPopupWindow.Companion.getDEBUG_VIEW_SPACING-D9Ej5fM());
               }

               $this$onDraw_u24lambda_u244.getDrawContext().getTransform().translate(-left$iv, -top$iv);
               canvas$iv.restore();
               $this$draw_yzxVdVo_u24lambda_u241$iv = this_$iv.getDrawParams();
               var16 = false;
               $this$draw_yzxVdVo_u24lambda_u241$iv.setDensity(prevDensity$iv);
               $this$draw_yzxVdVo_u24lambda_u241$iv.setLayoutDirection(prevLayoutDirection$iv);
               $this$draw_yzxVdVo_u24lambda_u241$iv.setCanvas(prevCanvas$iv);
               $this$draw_yzxVdVo_u24lambda_u241$iv.setSize-uvyYCjk(prevSize$iv);
            }
         }
      }

      @NotNull
      public final DebugPopupWindow.UiCache calculateUi(@NotNull Pair target) {
         Intrinsics.checkNotNullParameter(target, "target");
         Rect bounds = (Rect)target.component1();
         DebugData data = (DebugData)target.component2();
         TextLayoutResult title = !StringsKt.isBlank((CharSequence)data.getName()) ? TextMeasurer.measure-wNUYSr0$default(DebugPopupWindow.this.getTextMeasurer(), data.getName(), DebugPopupWindow.Companion.getDEBUG_TITLE_STYLE(), 0, false, 0, 0L, (LayoutDirection)null, (Density)null, (Resolver)null, false, 1020, (Object)null) : null;
         List $this$fastMap$iv = data.getContents();
         DebugPopupWindow var7 = DebugPopupWindow.this;
         int $i$f$fastMap = false;
         ArrayList target$iv = new ArrayList($this$fastMap$iv.size());
         List $this$fastForEach$iv$iv = $this$fastMap$iv;
         int $i$f$fastForEach = false;
         int i$iv = 0;

         int index$iv$iv;
         for(index$iv$iv = $this$fastMap$iv.size(); i$iv < index$iv$iv; ++i$iv) {
            Object item$iv$iv = $this$fastForEach$iv$iv.get(i$iv);
            int var16 = false;
            Collection var10000 = (Collection)target$iv;
            String itxxxx = (String)item$iv$iv;
            Collection var20 = var10000;
            int var18 = false;
            var20.add(TextMeasurer.measure-wNUYSr0$default(var7.getTextMeasurer(), itxxxx, DebugPopupWindow.Companion.getDEBUG_CONTENT_STYLE(), 0, false, 0, 0L, (LayoutDirection)null, (Density)null, (Resolver)null, false, 1020, (Object)null));
         }

         List contents = (List)target$iv;
         int var40 = LiveLiterals$DebugPopupWindowKt.INSTANCE.Int$$this$call-plus$$this$call-plus$arg-0$call-IntSize$val-size$fun-calculateUi$class-DebugPopupView$class-DebugPopupWindow();
         int var25 = title != null ? IntSize.getWidth-impl(title.getSize-YbymL2g()) : LiveLiterals$DebugPopupWindowKt.INSTANCE.Int$branch$when$arg-0$call-max$arg-0$call-plus$$this$call-plus$arg-0$call-IntSize$val-size$fun-calculateUi$class-DebugPopupView$class-DebugPopupWindow();
         List $this$fastMaxOfOrNull$iv = contents;
         int var44 = var40;
         int $i$f$fastMaxOfOrNull = false;
         boolean $i$f$fastForEachx;
         Comparable var41;
         if (contents.isEmpty()) {
            var41 = null;
         } else {
            TextLayoutResult itxx = (TextLayoutResult)contents.get(0);
            $i$f$fastForEachx = false;
            Comparable maxValue$iv = (Comparable)IntSize.getWidth-impl(itxx.getSize-YbymL2g());
            i$iv = 1;
            index$iv$iv = CollectionsKt.getLastIndex(contents);
            if (i$iv <= index$iv$iv) {
               while(true) {
                  TextLayoutResult itxxx = (TextLayoutResult)$this$fastMaxOfOrNull$iv.get(i$iv);
                  int var15 = false;
                  Comparable v$iv = (Comparable)IntSize.getWidth-impl(itxxx.getSize-YbymL2g());
                  if (v$iv.compareTo(maxValue$iv) > 0) {
                     maxValue$iv = v$iv;
                  }

                  if (i$iv == index$iv$iv) {
                     break;
                  }

                  ++i$iv;
               }
            }

            var41 = maxValue$iv;
         }

         Comparable var21 = var41;
         Intrinsics.checkNotNull(var21);
         int itx = ((Number)var21).intValue();
         var40 = var44 + Math.max(var25, itx) + this.roundToPx-0680j_4(DebugPopupWindow.Companion.getDEBUG_VIEW_PADDING-D9Ej5fM()) * LiveLiterals$DebugPopupWindowKt.INSTANCE.Int$arg-0$call-times$arg-0$call-plus$arg-0$call-IntSize$val-size$fun-calculateUi$class-DebugPopupView$class-DebugPopupWindow();
         itx = LiveLiterals$DebugPopupWindowKt.INSTANCE.Int$$this$call-plus$$$this$call-let$$this$call-plus$$this$call-plus$$this$call-plus$arg-1$call-IntSize$val-size$fun-calculateUi$class-DebugPopupView$class-DebugPopupWindow() + (title != null ? IntSize.getHeight-impl(title.getSize-YbymL2g()) : LiveLiterals$DebugPopupWindowKt.INSTANCE.Int$branch$when$arg-0$call-plus$$$this$call-let$$this$call-plus$$this$call-plus$$this$call-plus$arg-1$call-IntSize$val-size$fun-calculateUi$class-DebugPopupView$class-DebugPopupWindow());
         var44 = var40;
         $i$f$fastMaxOfOrNull = false;
         int var45 = title != null ? itx + this.roundToPx-0680j_4(DebugPopupWindow.Companion.getDEBUG_VIEW_SPACING-D9Ej5fM()) : itx;
         int $i$f$fastSumBy = false;
         int sum$iv = 0;
         List $this$fastForEach$iv$ivx = contents;
         $i$f$fastForEachx = false;
         index$iv$iv = 0;

         for(int var38 = contents.size(); index$iv$iv < var38; ++index$iv$iv) {
            Object item$iv$ivx = $this$fastForEach$iv$ivx.get(index$iv$iv);
            int var42 = false;
            TextLayoutResult it = (TextLayoutResult)item$iv$ivx;
            int var19 = false;
            int var23 = IntSize.getHeight-impl(it.getSize-YbymL2g());
            sum$iv += var23;
         }

         long size = IntSizeKt.IntSize(var44, var45 + sum$iv + this.roundToPx-0680j_4(DebugPopupWindow.Companion.getDEBUG_VIEW_SPACING-D9Ej5fM()) * (contents.size() - LiveLiterals$DebugPopupWindowKt.INSTANCE.Int$arg-0$call-minus$arg-0$call-times$arg-0$call-plus$$this$call-plus$arg-1$call-IntSize$val-size$fun-calculateUi$class-DebugPopupView$class-DebugPopupWindow()) + this.roundToPx-0680j_4(DebugPopupWindow.Companion.getDEBUG_VIEW_PADDING-D9Ej5fM()) * LiveLiterals$DebugPopupWindowKt.INSTANCE.Int$arg-0$call-times$arg-0$call-plus$arg-1$call-IntSize$val-size$fun-calculateUi$class-DebugPopupView$class-DebugPopupWindow());
         DebugPopupWindow.UiCache var26 = DebugPopupWindow.this.new UiCache(size, IntRectKt.roundToIntRect(bounds), title, contents, (DefaultConstructorMarker)null);
         $i$f$fastMaxOfOrNull = false;
         this.current = var26;
         return var26;
      }

      public final void release() {
         this.current = null;
      }

      private static final boolean _init_$lambda$0(IntRef $startX, IntRef $startY, IntRef $offsetX, IntRef $offsetY, DebugPopupWindow this$0, View var5, MotionEvent event) {
         Intrinsics.checkNotNullParameter($startX, "$startX");
         Intrinsics.checkNotNullParameter($startY, "$startY");
         Intrinsics.checkNotNullParameter($offsetX, "$offsetX");
         Intrinsics.checkNotNullParameter($offsetY, "$offsetY");
         Intrinsics.checkNotNullParameter(this$0, "this$0");
         switch(event.getAction()) {
         case 0:
            $startX.element = MathKt.roundToInt(event.getX());
            $startY.element = MathKt.roundToInt(event.getY());
         case 1:
         default:
            break;
         case 2:
            $offsetX.element = MathKt.roundToInt(event.getRawX()) - $startX.element;
            $offsetY.element = MathKt.roundToInt(event.getRawY()) - $startY.element;
            this$0.update($offsetX.element, $offsetY.element, LiveLiterals$DebugPopupWindowKt.INSTANCE.Int$arg-2$call-update$branch-1$when$fun-$anonymous$$arg-0$call-setOnTouchListener$init$class-DebugPopupView$class-DebugPopupWindow(), LiveLiterals$DebugPopupWindowKt.INSTANCE.Int$arg-3$call-update$branch-1$when$fun-$anonymous$$arg-0$call-setOnTouchListener$init$class-DebugPopupView$class-DebugPopupWindow(), LiveLiterals$DebugPopupWindowKt.INSTANCE.Boolean$arg-4$call-update$branch-1$when$fun-$anonymous$$arg-0$call-setOnTouchListener$init$class-DebugPopupView$class-DebugPopupWindow());
         }

         return LiveLiterals$DebugPopupWindowKt.INSTANCE.Boolean$fun-$anonymous$$arg-0$call-setOnTouchListener$init$class-DebugPopupView$class-DebugPopupWindow();
      }
   }

   @Metadata(
      mv = {1, 9, 0},
      k = 1,
      xi = 48,
      d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\u0010\nJ\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\u00020\u00108Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"},
      d2 = {"Lland/sungbin/androidplayground/DebugPopupWindow$UiCache;", "", "size", "Landroidx/compose/ui/unit/IntSize;", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "title", "Landroidx/compose/ui/text/TextLayoutResult;", "contents", "", "(Lland/sungbin/androidplayground/DebugPopupWindow;JLandroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/text/TextLayoutResult;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnchorBounds", "()Landroidx/compose/ui/unit/IntRect;", "getContents", "()Ljava/util/List;", "popupPosition", "Landroidx/compose/ui/unit/IntOffset;", "getPopupPosition-nOcc-ac", "()J", "getSize-YbymL2g", "J", "getTitle", "()Landroidx/compose/ui/text/TextLayoutResult;", "toString", "", "app_debug"}
   )
   @SourceDebugExtension({"SMAP\nDebugPopupWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugPopupWindow.kt\nland/sungbin/androidplayground/DebugPopupWindow$UiCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DebugPopupWindow.kt\nland/sungbin/androidplayground/DebugPopupWindow\n*L\n1#1,281:1\n1#2:282\n1#2:284\n110#3:283\n*S KotlinDebug\n*F\n+ 1 DebugPopupWindow.kt\nland/sungbin/androidplayground/DebugPopupWindow$UiCache\n*L\n130#1:284\n130#1:283\n*E\n"})
   private final class UiCache {
      private final long size;
      @NotNull
      private final IntRect anchorBounds;
      @Nullable
      private final TextLayoutResult title;
      @NotNull
      private final List contents;

      private UiCache(long size, IntRect anchorBounds, TextLayoutResult title, List contents) {
         Intrinsics.checkNotNullParameter(anchorBounds, "anchorBounds");
         Intrinsics.checkNotNullParameter(contents, "contents");
         super();
         this.size = size;
         this.anchorBounds = anchorBounds;
         this.title = title;
         this.contents = contents;
         if (((Collection)this.contents).isEmpty()) {
            int var7 = false;
            String var8 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$fun-$anonymous$$arg-1$call-require$init$class-UiCache$class-DebugPopupWindow();
            throw new IllegalArgumentException(var8.toString());
         }
      }

      public final long getSize_YbymL2g/* $FF was: getSize-YbymL2g*/() {
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

      public final long getPopupPosition_nOcc_ac/* $FF was: getPopupPosition-nOcc-ac*/() {
         DebugPopupPositionProvider var10000 = DebugPopupPositionProvider.INSTANCE;
         IntRect var10001 = this.anchorBounds;
         long var10002 = DebugPopupWindow.this.windowSize;
         DebugPopupWindow this_$iv = DebugPopupWindow.this;
         int $i$f$requireOwner = false;
         DebugComposeView var10003 = this_$iv.anchor;
         Owner var4 = var10003 != null ? var10003.getOwner$app_debug() : null;
         if (var4 == null) {
            int var3 = false;
            String var5 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$fun-$anonymous$$arg-1$call-checkNotNull$fun-requireOwner$class-DebugPopupWindow();
            throw new IllegalStateException(var5.toString());
         } else {
            return var10000.calculatePosition-llwVHH4(var10001, var10002, var4.getLayoutDirection(), this.size);
         }
      }

      @NotNull
      public String toString() {
         String var10000 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$$this$call-plus$$this$call-plus$$this$call-plus$$this$call-plus$$this$call-plus$fun-toString$class-UiCache$class-DebugPopupWindow();
         String var10001 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$0$str$arg-0$call-plus$$this$call-plus$$this$call-plus$$this$call-plus$$this$call-plus$fun-toString$class-UiCache$class-DebugPopupWindow();
         String var10002 = IntSize.toString-impl(this.size);
         String var10003 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$2$str$arg-0$call-plus$$this$call-plus$$this$call-plus$$this$call-plus$$this$call-plus$fun-toString$class-UiCache$class-DebugPopupWindow();
         String var10004 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$0$str$arg-0$call-plus$$this$call-plus$$this$call-plus$$this$call-plus$fun-toString$class-UiCache$class-DebugPopupWindow();
         IntRect var10005 = this.anchorBounds;
         String var10006 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$2$str$arg-0$call-plus$$this$call-plus$$this$call-plus$$this$call-plus$fun-toString$class-UiCache$class-DebugPopupWindow();
         String var10007 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$0$str$arg-0$call-plus$$this$call-plus$$this$call-plus$fun-toString$class-UiCache$class-DebugPopupWindow();
         String var10008 = IntOffset.toString-impl(this.getPopupPosition-nOcc-ac());
         String var10009 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$2$str$arg-0$call-plus$$this$call-plus$$this$call-plus$fun-toString$class-UiCache$class-DebugPopupWindow();
         String var10010 = LiveLiterals$DebugPopupWindowKt.INSTANCE.String$0$str$arg-0$call-plus$$this$call-plus$fun-toString$class-UiCache$class-DebugPopupWindow();
         TextLayoutResult var10011 = this.title;
         AnnotatedString var2;
         if (var10011 != null) {
            TextLayoutInput var1 = var10011.getLayoutInput();
            if (var1 != null) {
               var2 = var1.getText();
               return var10000 + var10001 + var10002 + var10003 + var10004 + var10005 + var10006 + var10007 + var10008 + var10009 + var10010 + var2 + LiveLiterals$DebugPopupWindowKt.INSTANCE.String$arg-0$call-plus$fun-toString$class-UiCache$class-DebugPopupWindow();
            }
         }

         var2 = null;
         return var10000 + var10001 + var10002 + var10003 + var10004 + var10005 + var10006 + var10007 + var10008 + var10009 + var10010 + var2 + LiveLiterals$DebugPopupWindowKt.INSTANCE.String$arg-0$call-plus$fun-toString$class-UiCache$class-DebugPopupWindow();
      }

      // $FF: synthetic method
      public UiCache(long size, IntRect anchorBounds, TextLayoutResult title, List contents, DefaultConstructorMarker $constructor_marker) {
         this(size, anchorBounds, title, contents);
      }
   }
}
