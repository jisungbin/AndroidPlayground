package land.sungbin.androidplayground;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnPlacedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsOwnerKt;
import androidx.compose.ui.text.PlatformTextStyle;
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
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.Lifecycle.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.android.HandlerDispatcherKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001BB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010(\u001a\u00020\fH\u0017¢\u0006\u0002\u0010)J*\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0017H\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101J\b\u00102\u001a\u00020\fH\u0002J\u0010\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020\fH\u0014J\t\u0010;\u001a\u00020\u001aH\u0082\bJ\u001e\u0010<\u001a\u00020\f2\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\r¢\u0006\u0002\u0010=J\f\u0010>\u001a\u00020\u001c*\u00020\u0012H\u0002J\u0013\u0010?\u001a\u00020\u001c*\b\u0012\u0004\u0012\u00020A0@H\u0082\bR!\u0010\t\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c@RX\u0094\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006C"},
   d2 = {"Lland/sungbin/androidplayground/DebugComposeView;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "content", "Landroidx/compose/runtime/MutableState;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "debugNodeCollectorThread", "Ljava/lang/Thread;", "debugNodes", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "Landroidx/compose/ui/semantics/SemanticsNode;", "debugUi", "Lland/sungbin/androidplayground/DebugUiCache;", "debugUiConstraints", "Landroidx/compose/ui/node/Ref;", "Landroidx/compose/ui/unit/Constraints;", "debugUiTextConstraints", "owner", "Landroidx/compose/ui/node/Owner;", "<set-?>", "", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow$annotations", "()V", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "getTextMeasurer", "()Landroidx/compose/ui/text/TextMeasurer;", "textMeasurer$delegate", "Lkotlin/Lazy;", "Content", "(Landroidx/compose/runtime/Composer;I)V", "calculateUi", "bounds", "Landroidx/compose/ui/geometry/Rect;", "data", "Lland/sungbin/androidplayground/DebugData;", "textConstraints", "calculateUi-3p2s80s", "(Landroidx/compose/ui/geometry/Rect;Lland/sungbin/androidplayground/DebugData;J)Lland/sungbin/androidplayground/DebugUiCache;", "collectDebugNodesOrClearIfDestroyed", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getAccessibilityClassName", "", "layoutBoundsDrawingModifier", "Landroidx/compose/ui/Modifier;", "onAttachedToWindow", "requireOwner", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "isInDebugView", "isRealChanged", "", "", "Companion", "app_debug"}
)
@StabilityInferred(
   parameters = 0
)
@SourceDebugExtension({"SMAP\nDebugComposeView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugComposeView.kt\nland/sungbin/androidplayground/DebugComposeView\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 DebugData.kt\nland/sungbin/androidplayground/DebugDataKt\n+ 6 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,368:1\n285#1:380\n151#2,3:369\n33#2,4:372\n154#2,2:376\n38#2:378\n156#2:379\n317#2,8:382\n132#2,3:391\n33#2,4:394\n135#2,2:398\n38#2:400\n137#2:401\n33#2,6:405\n1#3:381\n1#3:390\n288#4,2:402\n20#5:404\n154#6:411\n154#6:412\n*S KotlinDebug\n*F\n+ 1 DebugComposeView.kt\nland/sungbin/androidplayground/DebugComposeView\n*L\n194#1:380\n190#1:369,3\n190#1:372,4\n190#1:376,2\n190#1:378\n190#1:379\n198#1:382,8\n203#1:391,3\n203#1:394,4\n203#1:398,2\n203#1:400\n203#1:401\n297#1:405,6\n194#1:381\n264#1:402,2\n267#1:404\n318#1:411\n319#1:412\n*E\n"})
public final class DebugComposeView extends AbstractComposeView {
   @NotNull
   private static final DebugComposeView.Companion Companion = new DebugComposeView.Companion((DefaultConstructorMarker)null);
   @Nullable
   private Owner owner;
   @NotNull
   private final Lazy textMeasurer$delegate;
   @NotNull
   private final SnapshotStateMap debugNodes;
   @NotNull
   private final MutableState debugUi;
   @NotNull
   private final Ref debugUiConstraints;
   @NotNull
   private final Ref debugUiTextConstraints;
   @NotNull
   private final MutableState content;
   @Nullable
   private Thread debugNodeCollectorThread;
   private boolean shouldCreateCompositionOnAttachedToWindow;
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

   public DebugComposeView(@NotNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
      Intrinsics.checkNotNullParameter(context, "context");
      super(context, attrs, defStyleAttr);
      this.textMeasurer$delegate = LazyKt.lazy((Function0)(new Function0() {
         @NotNull
         public final TextMeasurer invoke() {
            DebugComposeView this_$iv = DebugComposeView.this;
            int $i$f$requireOwner = false;
            Owner var10000 = this_$iv.owner;
            if (var10000 == null) {
               int var4 = false;
               String var5 = LiveLiterals$DebugComposeViewKt.INSTANCE.String$fun-$anonymous$$arg-1$call-checkNotNull$fun-requireOwner$class-DebugComposeView();
               throw new IllegalStateException(var5.toString());
            } else {
               Owner owner = var10000;
               return new TextMeasurer(owner.getFontFamilyResolver(), owner.getDensity(), owner.getLayoutDirection(), 15);
            }
         }
      }));
      this.debugNodes = SnapshotStateKt.mutableStateMapOf();
      this.debugUi = SnapshotStateKt.mutableStateOf$default((Object)null, (SnapshotMutationPolicy)null, 2, (Object)null);
      this.debugUiConstraints = new Ref();
      this.debugUiTextConstraints = new Ref();
      this.content = SnapshotStateKt.mutableStateOf$default((Object)null, (SnapshotMutationPolicy)null, 2, (Object)null);
   }

   // $FF: synthetic method
   public DebugComposeView(Context var1, AttributeSet var2, int var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = LiveLiterals$DebugComposeViewKt.INSTANCE.Int$param-defStyleAttr$class-DebugComposeView();
      }

      this(var1, var2, var3);
   }

   private final TextMeasurer getTextMeasurer() {
      Lazy var1 = this.textMeasurer$delegate;
      return (TextMeasurer)var1.getValue();
   }

   protected boolean getShouldCreateCompositionOnAttachedToWindow() {
      return this.shouldCreateCompositionOnAttachedToWindow;
   }

   /** @deprecated */
   // $FF: synthetic method
   protected static void getShouldCreateCompositionOnAttachedToWindow$annotations() {
   }

   @Composable
   public void Content(@Nullable Composer $composer, final int $changed) {
      $composer = $composer.startRestartGroup(-503666316);
      ComposerKt.sourceInformation($composer, "C(Content)98@3902L8:DebugComposeView.kt#qshby3");
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventStart(-503666316, $changed, -1, "land.sungbin.androidplayground.DebugComposeView.Content (DebugComposeView.kt:97)");
      }

      Function2 var10000 = (Function2)this.content.getValue();
      if (var10000 != null) {
         var10000.invoke($composer, 0);
      }

      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventEnd();
      }

      ScopeUpdateScope var3 = $composer.endRestartGroup();
      if (var3 != null) {
         var3.updateScope((Function2)(new Function2() {
            public final void invoke(@Nullable Composer $composer, int $force) {
               DebugComposeView.this.Content($composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
         }));
      }

   }

   @NotNull
   public String getAccessibilityClassName() {
      String var10000 = this.getClass().getName();
      Intrinsics.checkNotNullExpressionValue(var10000, "getName(...)");
      return var10000;
   }

   @ComposableInferredTarget(
      scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]"
   )
   public final void setContent(@NotNull final Function2 content) {
      Intrinsics.checkNotNullParameter(content, "content");
      this.shouldCreateCompositionOnAttachedToWindow = LiveLiterals$DebugComposeViewKt.INSTANCE.Boolean$arg-0$call-$set-shouldCreateCompositionOnAttachedToWindow$$fun-setContent$class-DebugComposeView();
      this.content.setValue(ComposableLambdaKt.composableLambdaInstance(1384190133, true, new Function2() {
         @Composable
         @ComposableTarget(
            applier = "androidx.compose.ui.UiComposable"
         )
         public final void invoke(@Nullable Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C110@4314L1987:DebugComposeView.kt#qshby3");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
               $composer.skipToGroupEnd();
            } else {
               if (ComposerKt.isTraceInProgress()) {
                  ComposerKt.traceEventStart(1384190133, $changed, -1, "land.sungbin.androidplayground.DebugComposeView.setContent.<anonymous> (DebugComposeView.kt:107)");
               }

               $composer.startReplaceableGroup(264345604);
               ComposerKt.sourceInformation($composer, "107@4257L7");
               boolean $i$f$requireOwner;
               boolean propagateMinConstraints$iv;
               if (DebugComposeView.this.owner == null) {
                  DebugComposeView var10000 = DebugComposeView.this;
                  CompositionLocal this_$ivx = (CompositionLocal)AndroidCompositionLocals_androidKt.getLocalView();
                  $i$f$requireOwner = false;
                  propagateMinConstraints$iv = false;
                  ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                  Object var7 = $composer.consume(this_$ivx);
                  ComposerKt.sourceInformationMarkerEnd($composer);
                  Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type androidx.compose.ui.node.Owner");
                  var10000.owner = (Owner)var7;
               }

               $composer.endReplaceableGroup();
               DebugComposeView this_$iv = DebugComposeView.this;
               $i$f$requireOwner = false;
               Owner var49 = this_$iv.owner;
               if (var49 == null) {
                  propagateMinConstraints$iv = false;
                  String var47 = LiveLiterals$DebugComposeViewKt.INSTANCE.String$fun-$anonymous$$arg-1$call-checkNotNull$fun-requireOwner$class-DebugComposeView();
                  throw new IllegalStateException(var47.toString());
               }

               final Owner owner = var49;
               Modifier modifier$iv = OnPlacedModifierKt.onPlaced(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), (Function1)(new Function1() {
                  public final void invoke(@NotNull LayoutCoordinates coordinates) {
                     Intrinsics.checkNotNullParameter(coordinates, "coordinates");
                     if (DebugComposeView.this.debugUiConstraints.getValue() == null || DebugComposeView.this.debugUiTextConstraints.getValue() == null) {
                        DebugComposeView.this.debugUiConstraints.setValue(Constraints.box-impl(ConstraintsKt.Constraints$default(0, MathKt.roundToInt((float)IntSize.getWidth-impl(coordinates.getSize-YbymL2g()) * LiveLiterals$DebugComposeViewKt.INSTANCE.Float$arg-0$call-times$$$this$call-roundToInt$arg-1$call-Constraints$arg-0$call-$set-value$$branch$if$fun-$anonymous$$arg-0$call-onPlaced$$this$call-then$arg-0$call-Box$fun-$anonymous$$arg-0$call-$set-value$$fun-setContent$class-DebugComposeView()), 0, MathKt.roundToInt((float)IntSize.getHeight-impl(coordinates.getSize-YbymL2g()) * LiveLiterals$DebugComposeViewKt.INSTANCE.Float$arg-0$call-times$$$this$call-roundToInt$arg-3$call-Constraints$arg-0$call-$set-value$$branch$if$fun-$anonymous$$arg-0$call-onPlaced$$this$call-then$arg-0$call-Box$fun-$anonymous$$arg-0$call-$set-value$$fun-setContent$class-DebugComposeView()), 5, (Object)null)));
                        DebugComposeView.this.debugUiTextConstraints.setValue(Constraints.box-impl(ConstraintsKt.Constraints$default(0, MathKt.roundToInt((float)IntSize.getWidth-impl(coordinates.getSize-YbymL2g()) * LiveLiterals$DebugComposeViewKt.INSTANCE.Float$arg-0$call-times$$$this$call-roundToInt$arg-1$call-Constraints$arg-0$call-$set-value$-1$branch$if$fun-$anonymous$$arg-0$call-onPlaced$$this$call-then$arg-0$call-Box$fun-$anonymous$$arg-0$call-$set-value$$fun-setContent$class-DebugComposeView()), 0, 0, 13, (Object)null)));
                     }

                  }
               })).then(DebugViewOptions.INSTANCE.getEnabled() ? DebugComposeView.this.layoutBoundsDrawingModifier() : (Modifier)Modifier.Companion);
               Function2 var48 = content;
               DebugComposeView var8 = DebugComposeView.this;
               int $changed$ivx = 0;
               int $i$f$Box = false;
               $composer.startReplaceableGroup(733328855);
               ComposerKt.sourceInformation($composer, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
               Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
               propagateMinConstraints$iv = false;
               MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, propagateMinConstraints$iv, $composer, 14 & $changed$ivx >> 3 | 112 & $changed$ivx >> 3);
               int $changed$iv$iv = 112 & $changed$ivx << 3;
               int $i$f$Layout = false;
               $composer.startReplaceableGroup(-1323940314);
               ComposerKt.sourceInformation($composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
               int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
               CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
               Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
               Function3 skippableUpdate$iv$iv$iv = LayoutKt.modifierMaterializerOf(modifier$iv);
               int $changed$iv$iv$iv = 6 | 7168 & $changed$iv$iv << 9;
               int $i$f$ReusableComposeNode = false;
               if (!($composer.getApplier() instanceof Applier)) {
                  ComposablesKt.invalidApplier();
               }

               $composer.startReusableNode();
               if ($composer.getInserting()) {
                  $composer.createNode(factory$iv$iv$iv);
               } else {
                  $composer.useNode();
               }

               Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
               int var21 = false;
               Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
               Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
               Function2 block$iv$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
               int var23 = false;
               int var25 = false;
               if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), compositeKeyHash$iv$iv)) {
                  $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(compositeKeyHash$iv$iv);
                  $this$Layout_u24lambda_u240$iv$iv.apply(compositeKeyHash$iv$iv, block$iv$iv$iv);
               }

               skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl($composer)), $composer, 112 & $changed$iv$iv$iv >> 3);
               $composer.startReplaceableGroup(2058660585);
               int $changed$iv = 14 & $changed$iv$iv$iv >> 9;
               int var28 = false;
               ComposerKt.sourceInformationMarkerStart($composer, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
               int var29 = 6 | 112 & $changed$ivx >> 6;
               BoxScope var50 = (BoxScope)BoxScopeInstance.INSTANCE;
               int var32 = false;
               ComposerKt.sourceInformationMarkerStart($composer, -339437644, "C126@5002L9:DebugComposeView.kt#qshby3");
               var48.invoke($composer, 0);
               final DebugUiCache var33 = (DebugUiCache)var8.debugUi.getValue();
               $composer.startReplaceableGroup(264346420);
               ComposerKt.sourceInformation($composer, "*128@5057L1174");
               if (var33 != null) {
                  int var35 = false;
                  Modifier var51 = DebugViewOptionsKt.debugView((Modifier)Modifier.Companion);
                  Object var10001 = var8.debugUiConstraints.getValue();
                  Intrinsics.checkNotNull(var10001);
                  long $this$invoke_u24lambda_u243_u24lambda_u242_u24lambda_u241 = ((Constraints)var10001).unbox-impl();
                  Modifier var38 = var51;
                  int var39 = false;
                  long resolved = androidx.compose.ui.geometry.SizeKt.Size(RangesKt.coerceAtMost(Size.getWidth-impl(var33.getSize-NH-jbRc()), (float)Constraints.getMaxWidth-impl($this$invoke_u24lambda_u243_u24lambda_u242_u24lambda_u241)), RangesKt.coerceAtMost(Size.getHeight-impl(var33.getSize-NH-jbRc()), (float)Constraints.getMaxHeight-impl($this$invoke_u24lambda_u243_u24lambda_u242_u24lambda_u241)));
                  Density $this$invoke_u24lambda_u243_u24lambda_u242_u24lambda_u241_u24lambda_u240 = owner.getDensity();
                  int var43 = false;
                  CanvasKt.Canvas(BackgroundKt.background-bw27NRU$default(OffsetKt.offset(SizeKt.size-6HolHcs(var38, DpSize.box-impl($this$invoke_u24lambda_u243_u24lambda_u242_u24lambda_u241_u24lambda_u240.toDpSize-k-rfVVM(resolved)).unbox-impl()), (Function1)(new Function1() {
                     public final long invoke_Bjo55l4/* $FF was: invoke-Bjo55l4*/(@NotNull Density $this$offset) {
                        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
                        return var33.positionInRoot-5SAbXVA(IntSizeKt.IntSize(owner.getRoot().getWidth(), owner.getRoot().getHeight()), owner.getDensity());
                     }
                  })), DebugComposeView.Companion.getDEFAULT_BACKGROUND_COLOR-0d7_KjU(), (Shape)null, 2, (Object)null), (Function1)(new Function1() {
                     public final void invoke(@NotNull DrawScope $this$Canvas) {
                        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
                        float left$iv = $this$Canvas.toPx-0680j_4(DebugComposeView.Companion.getDEBUG_VIEW_PADDING-D9Ej5fM());
                        float top$iv = $this$Canvas.toPx-0680j_4(DebugComposeView.Companion.getDEBUG_VIEW_PADDING-D9Ej5fM());
                        DebugUiCache var5 = var33;
                        int $i$f$translate = false;
                        $this$Canvas.getDrawContext().getTransform().translate(left$iv, top$iv);
                        DrawScope $this$invoke_u24lambda_u242 = $this$Canvas;
                        int var8 = false;
                        float y = 0.0F;
                        y = LiveLiterals$DebugComposeViewKt.INSTANCE.Float$val-y$fun-$anonymous$$arg-2$call-translate$fun-$anonymous$$arg-1$call-Canvas$fun-$anonymous$$arg-0$call-let$else$when$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-0$call-$set-value$$fun-setContent$class-DebugComposeView();
                        TextLayoutResult var10000 = var5.getTitle();
                        if (var10000 != null) {
                           TextLayoutResult it = var10000;
                           int var11 = false;
                           TextPainterKt.drawText-d8-rzKo$default($this$Canvas, it, 0L, 0L, 0.0F, (Shadow)null, (TextDecoration)null, (DrawStyle)null, 0, 254, (Object)null);
                           y += (float)IntSize.getHeight-impl(it.getSize-YbymL2g()) + $this$Canvas.toPx-0680j_4(DebugComposeView.Companion.getDEBUG_VIEW_SPACING-D9Ej5fM());
                        }

                        List $this$fastForEach$iv = var5.getContents();
                        int $i$f$fastForEach = false;
                        int index$iv = 0;

                        for(int var18 = $this$fastForEach$iv.size(); index$iv < var18; ++index$iv) {
                           Object item$iv = $this$fastForEach$iv.get(index$iv);
                           TextLayoutResult contentx = (TextLayoutResult)item$iv;
                           int var16 = false;
                           TextPainterKt.drawText-d8-rzKo$default($this$invoke_u24lambda_u242, contentx, 0L, androidx.compose.ui.geometry.OffsetKt.Offset(LiveLiterals$DebugComposeViewKt.INSTANCE.Float$arg-0$call-Offset$arg-2$call-drawText$fun-$anonymous$$arg-0$call-fastForEach$fun-$anonymous$$arg-2$call-translate$fun-$anonymous$$arg-1$call-Canvas$fun-$anonymous$$arg-0$call-let$else$when$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-0$call-$set-value$$fun-setContent$class-DebugComposeView(), y), 0.0F, (Shadow)null, (TextDecoration)null, (DrawStyle)null, 0, 250, (Object)null);
                           y += (float)IntSize.getHeight-impl(contentx.getSize-YbymL2g()) + $this$invoke_u24lambda_u242.toPx-0680j_4(DebugComposeView.Companion.getDEBUG_VIEW_SPACING-D9Ej5fM());
                        }

                        $this$Canvas.getDrawContext().getTransform().translate(-left$iv, -top$iv);
                     }
                  }), $composer, 0);
               }

               $composer.endReplaceableGroup();
               if (var8.isAttachedToWindow()) {
                  var8.createComposition();
               }

               ComposerKt.sourceInformationMarkerEnd($composer);
               ComposerKt.sourceInformationMarkerEnd($composer);
               $composer.endReplaceableGroup();
               $composer.endNode();
               $composer.endReplaceableGroup();
               $composer.endReplaceableGroup();
               if (ComposerKt.isTraceInProgress()) {
                  ComposerKt.traceEventEnd();
               }
            }

         }
      }));
   }

   private final Modifier layoutBoundsDrawingModifier() {
      return DrawModifierKt.drawWithContent((Modifier)Modifier.Companion, (Function1)(new Function1() {
         public final void invoke(@NotNull ContentDrawScope $this$drawWithContent) {
            Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
            $this$drawWithContent.drawContent();
            Iterable $this$forEach$iv = (Iterable)DebugComposeView.this.debugNodes.values();
            int $i$f$forEach = false;
            Iterator var4 = $this$forEach$iv.iterator();

            while(var4.hasNext()) {
               Object element$iv = var4.next();
               SemanticsNode node = (SemanticsNode)element$iv;
               int var7 = false;
               DrawScope var10000 = (DrawScope)$this$drawWithContent;
               long var10001 = Color.Companion.getRed-0d7_KjU();
               long var10002 = node.getPositionInRoot-F1C5BW0();
               long var10003 = IntSizeKt.toSize-ozmzZPI(node.getSize-YbymL2g());
               int $this$dp$iv = LiveLiterals$DebugComposeViewKt.INSTANCE.Int$$$this$call-$get-dp$$$$this$call-toPx$arg-0$call-$init$$arg-4$call-drawRect$fun-$anonymous$$arg-0$call-forEach$fun-$anonymous$$arg-0$call-drawWithContent$fun-layoutBoundsDrawingModifier$class-DebugComposeView();
               int $i$f$getDp = false;
               DrawScope.drawRect-n-J9OG0$default(var10000, var10001, var10002, var10003, 0.0F, (DrawStyle)(new Stroke($this$drawWithContent.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv)), 0.0F, 0, 0, (PathEffect)null, 30, (DefaultConstructorMarker)null)), (ColorFilter)null, 0, 104, (Object)null);
            }

         }
      }));
   }

   private final DebugUiCache calculateUi_3p2s80s/* $FF was: calculateUi-3p2s80s*/(Rect bounds, DebugData data, long textConstraints) {
      DebugComposeView $this$calculateUi_3p2s80s_u24lambda_u240 = (DebugComposeView)this;
      int $i$f$fastMap = false;
      TextLayoutResult title = !StringsKt.isBlank((CharSequence)data.getName()) ? TextMeasurer.measure-wNUYSr0$default($this$calculateUi_3p2s80s_u24lambda_u240.getTextMeasurer(), data.getName(), DEBUG_TITLE_STYLE, 0, false, 0, textConstraints, (LayoutDirection)null, (Density)null, (Resolver)null, false, 988, (Object)null) : null;
      List $this$fastMap$iv = data.getContents();
      $i$f$fastMap = false;
      ArrayList target$iv = new ArrayList($this$fastMap$iv.size());
      List $this$fastForEach$iv$iv = $this$fastMap$iv;
      int $i$f$fastForEach = false;
      int index$iv$iv = 0;

      int var13;
      for(var13 = $this$fastMap$iv.size(); index$iv$iv < var13; ++index$iv$iv) {
         Object item$iv$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
         int var16 = false;
         Collection var10000 = (Collection)target$iv;
         String it = (String)item$iv$iv;
         Collection var28 = var10000;
         int var18 = false;
         var28.add(TextMeasurer.measure-wNUYSr0$default(this.getTextMeasurer(), it, DEBUG_CONTENT_STYLE, 0, false, 0, textConstraints, (LayoutDirection)null, (Density)null, (Resolver)null, false, 988, (Object)null));
      }

      List contents = (List)target$iv;
      int $i$f$requireOwner = false;
      Owner var40 = access$getOwner$p(this);
      if (var40 == null) {
         $i$f$fastForEach = false;
         String var34 = LiveLiterals$DebugComposeViewKt.INSTANCE.String$fun-$anonymous$$arg-1$call-checkNotNull$fun-requireOwner$class-DebugComposeView();
         throw new IllegalStateException(var34.toString());
      } else {
         Density $this$calculateUi_3p2s80s_u24lambda_u245 = var40.getDensity();
         $i$f$fastForEach = false;
         float var42 = LiveLiterals$DebugComposeViewKt.INSTANCE.Float$$this$call-plus$$this$call-plus$arg-0$call-Size$fun-$anonymous$$arg-1$call-with$val-size$fun-calculateUi$class-DebugComposeView();
         index$iv$iv = title != null ? IntSize.getWidth-impl(title.getSize-YbymL2g()) : LiveLiterals$DebugComposeViewKt.INSTANCE.Int$branch$when$arg-0$call-max$arg-0$call-plus$$this$call-plus$arg-0$call-Size$fun-$anonymous$$arg-1$call-with$val-size$fun-calculateUi$class-DebugComposeView();
         List $this$fastMaxOfOrNull$iv = contents;
         float var37 = var42;
         int $i$f$fastMaxOfOrNull = false;
         Comparable var44;
         boolean $i$f$fastForEach;
         int index$iv$iv;
         if (contents.isEmpty()) {
            var44 = null;
         } else {
            TextLayoutResult it = (TextLayoutResult)contents.get(0);
            $i$f$fastForEach = false;
            Comparable maxValue$iv = (Comparable)IntSize.getWidth-impl(it.getSize-YbymL2g());
            int i$iv = 1;
            index$iv$iv = CollectionsKt.getLastIndex(contents);
            if (i$iv <= index$iv$iv) {
               while(true) {
                  TextLayoutResult it = (TextLayoutResult)$this$fastMaxOfOrNull$iv.get(i$iv);
                  int var20 = false;
                  Comparable v$iv = (Comparable)IntSize.getWidth-impl(it.getSize-YbymL2g());
                  if (v$iv.compareTo(maxValue$iv) > 0) {
                     maxValue$iv = v$iv;
                  }

                  if (i$iv == index$iv$iv) {
                     break;
                  }

                  ++i$iv;
               }
            }

            var44 = maxValue$iv;
         }

         Comparable var21 = var44;
         Intrinsics.checkNotNull(var21);
         var13 = ((Number)var21).intValue();
         var42 = var37 + (float)Math.max(index$iv$iv, var13) + $this$calculateUi_3p2s80s_u24lambda_u245.toPx-0680j_4(DEBUG_VIEW_PADDING) * (float)LiveLiterals$DebugComposeViewKt.INSTANCE.Int$arg-0$call-times$arg-0$call-plus$arg-0$call-Size$fun-$anonymous$$arg-1$call-with$val-size$fun-calculateUi$class-DebugComposeView();
         float it = LiveLiterals$DebugComposeViewKt.INSTANCE.Float$$this$call-plus$$$this$call-let$$this$call-plus$$this$call-plus$$this$call-plus$arg-1$call-Size$fun-$anonymous$$arg-1$call-with$val-size$fun-calculateUi$class-DebugComposeView() + (float)(title != null ? IntSize.getHeight-impl(title.getSize-YbymL2g()) : LiveLiterals$DebugComposeViewKt.INSTANCE.Int$branch$when$arg-0$call-plus$$$this$call-let$$this$call-plus$$this$call-plus$$this$call-plus$arg-1$call-Size$fun-$anonymous$$arg-1$call-with$val-size$fun-calculateUi$class-DebugComposeView());
         var37 = var42;
         $i$f$fastMaxOfOrNull = false;
         float var52 = title != null ? it + $this$calculateUi_3p2s80s_u24lambda_u245.toPx-0680j_4(DEBUG_VIEW_SPACING) : it;
         int $i$f$fastSumBy = false;
         int sum$iv = 0;
         List $this$fastForEach$iv$iv = contents;
         $i$f$fastForEach = false;
         index$iv$iv = 0;

         for(int var50 = contents.size(); index$iv$iv < var50; ++index$iv$iv) {
            Object item$iv$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            int var23 = false;
            TextLayoutResult it = (TextLayoutResult)item$iv$iv;
            int var26 = false;
            int var27 = IntSize.getHeight-impl(it.getSize-YbymL2g());
            sum$iv += var27;
         }

         long size = androidx.compose.ui.geometry.SizeKt.Size(var37, var52 + (float)sum$iv + $this$calculateUi_3p2s80s_u24lambda_u245.toPx-0680j_4(DEBUG_VIEW_SPACING) * (float)(contents.size() - LiveLiterals$DebugComposeViewKt.INSTANCE.Int$arg-0$call-minus$arg-0$call-times$arg-0$call-plus$$this$call-plus$arg-1$call-Size$fun-$anonymous$$arg-1$call-with$val-size$fun-calculateUi$class-DebugComposeView()) + $this$calculateUi_3p2s80s_u24lambda_u245.toPx-0680j_4(DEBUG_VIEW_PADDING) * (float)LiveLiterals$DebugComposeViewKt.INSTANCE.Int$arg-0$call-times$arg-0$call-plus$arg-1$call-Size$fun-$anonymous$$arg-1$call-with$val-size$fun-calculateUi$class-DebugComposeView());
         DebugUiCache var31 = new DebugUiCache(size, IntRectKt.roundToIntRect(bounds), title, contents, data, (DefaultConstructorMarker)null);
         $i$f$fastForEach = false;
         this.debugUi.setValue(var31);
         return var31;
      }
   }

   protected void onAttachedToWindow() {
      if (this.debugNodeCollectorThread != null) {
         Thread var10000 = this.debugNodeCollectorThread;
         Intrinsics.checkNotNull(var10000);
         var10000.interrupt();
      }

      final ObjectRef debugNodeCollectorDisposeHandle = new ObjectRef();
      this.debugNodeCollectorThread = ThreadsKt.thread$default(false, LiveLiterals$DebugComposeViewKt.INSTANCE.Boolean$arg-1$call-thread$arg-0$call-$set-debugNodeCollectorThread$$fun-onAttachedToWindow$class-DebugComposeView(), (ClassLoader)null, LiveLiterals$DebugComposeViewKt.INSTANCE.String$arg-3$call-thread$arg-0$call-$set-debugNodeCollectorThread$$fun-onAttachedToWindow$class-DebugComposeView(), 5, (Function0)(new Function0() {
         public final void invoke() {
            LifecycleOwner var10000 = ViewTreeLifecycleOwner.get((View)DebugComposeView.this);
            Intrinsics.checkNotNull(var10000);
            final LifecycleOwner var1 = var10000;
            final ObjectRef var2 = debugNodeCollectorDisposeHandle;
            final DebugComposeView var3 = DebugComposeView.this;
            int var5 = false;
            BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var1), (CoroutineContext)null, (CoroutineStart)null, (Function2)(new Function2((Continuation)null) {
               int label;

               @Nullable
               public final Object invokeSuspend(@NotNull Object $result) {
                  Throwable var10000;
                  ObserverHandle var19;
                  label184: {
                     Object var3x = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     boolean var10001;
                     switch(this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);

                        Object var17;
                        try {
                           LifecycleOwner var16 = var1;
                           State var18 = State.CREATED;
                           Function2 var10002 = (Function2)(new Function2((Continuation)null) {
                              int label;

                              @Nullable
                              public final Object invokeSuspend(@NotNull Object $result) {
                                 Object var2x = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                 Continuation var10000;
                                 switch(this.label) {
                                 case 0:
                                    ResultKt.throwOnFailure($result);
                                    var10000 = (Continuation)this;
                                    this.label = 1;
                                    if (HandlerDispatcherKt.awaitFrame(var10000) == var2x) {
                                       return var2x;
                                    }
                                    break;
                                 case 1:
                                    ResultKt.throwOnFailure($result);
                                    break;
                                 case 2:
                                    ResultKt.throwOnFailure($result);
                                    throw new KotlinNothingValueException();
                                 default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                 }

                                 do {
                                    if (var3.owner != null) {
                                       var3.collectDebugNodesOrClearIfDestroyed();
                                       var2.element = Snapshot.Companion.registerApplyObserver((Function2)(new Function2() {
                                          public final void invoke(@NotNull Set changes, @NotNull Snapshot var2x) {
                                             boolean var10000;
                                             label18: {
                                                Intrinsics.checkNotNullParameter(changes, "changes");
                                                Intrinsics.checkNotNullParameter(var2x, "<anonymous parameter 1>");
                                                DebugComposeView this_$iv = var3;
                                                int $i$f$isRealChanged = false;
                                                SnapshotStateMap var10001 = this_$iv.debugNodes;
                                                Intrinsics.checkNotNull(var10001, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateObject");
                                                if (!changes.contains((StateObject)var10001)) {
                                                   MutableState var6 = this_$iv.debugUi;
                                                   Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateObject");
                                                   if (!changes.contains((StateObject)var6)) {
                                                      var6 = DebugViewOptions.INSTANCE.get_enabled$app_debug();
                                                      Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateObject");
                                                      if (!changes.contains((StateObject)var6)) {
                                                         var10000 = true;
                                                         break label18;
                                                      }
                                                   }
                                                }

                                                var10000 = false;
                                             }

                                             if (var10000) {
                                                var3.collectDebugNodesOrClearIfDestroyed();
                                             }
                                          }
                                       }));
                                       var10000 = (Continuation)this;
                                       this.label = 2;
                                       if (DelayKt.awaitCancellation(var10000) == var2x) {
                                          return var2x;
                                       }

                                       throw new KotlinNothingValueException();
                                    }

                                    var10000 = (Continuation)this;
                                    this.label = 1;
                                 } while(HandlerDispatcherKt.awaitFrame(var10000) != var2x);

                                 return var2x;
                              }

                              @NotNull
                              public final Continuation create(@Nullable Object value, @NotNull Continuation $completion) {
                                 return (Continuation)(new <anonymous constructor>($completion));
                              }

                              @Nullable
                              public final Object invoke(@NotNull CoroutineScope p1, @Nullable Continuation p2) {
                                 return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                              }
                           });
                           Continuation var10003 = (Continuation)this;
                           this.label = 1;
                           var17 = RepeatOnLifecycleKt.repeatOnLifecycle(var16, var18, var10002, var10003);
                        } catch (Throwable var14) {
                           var10000 = var14;
                           var10001 = false;
                           break label184;
                        }

                        if (var17 == var3x) {
                           return var3x;
                        }
                        break;
                     case 1:
                        try {
                           ResultKt.throwOnFailure($result);
                           break;
                        } catch (Throwable var15) {
                           var10000 = var15;
                           var10001 = false;
                           break label184;
                        }
                     default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     try {
                        ;
                     } catch (Throwable var13) {
                        var10000 = var13;
                        var10001 = false;
                        break label184;
                     }

                     var19 = (ObserverHandle)var2.element;
                     if (var19 != null) {
                        var19.dispose();
                     }

                     var3.debugNodes.clear();
                     var3.debugUi.setValue((Object)null);
                     var3.owner = null;
                     return Unit.INSTANCE;
                  }

                  Throwable var2x = var10000;
                  var19 = (ObserverHandle)var2.element;
                  if (var19 != null) {
                     var19.dispose();
                  }

                  var3.debugNodes.clear();
                  var3.debugUi.setValue((Object)null);
                  var3.owner = null;
                  throw var2x;
               }

               @NotNull
               public final Continuation create(@Nullable Object value, @NotNull Continuation $completion) {
                  return (Continuation)(new <anonymous constructor>($completion));
               }

               @Nullable
               public final Object invoke(@NotNull CoroutineScope p1, @Nullable Continuation p2) {
                  return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
               }
            }), 3, (Object)null);
         }
      }), 5, (Object)null);
      super.onAttachedToWindow();
   }

   public boolean dispatchTouchEvent(@NotNull MotionEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      if (event.getAction() == 0) {
         long offset = androidx.compose.ui.geometry.OffsetKt.Offset(event.getX(), event.getY());
         Iterable $this$firstOrNull$iv = (Iterable)this.debugNodes.values();
         int $i$f$firstOrNull = false;
         Iterator var7 = $this$firstOrNull$iv.iterator();

         Object var10000;
         while(true) {
            if (!var7.hasNext()) {
               var10000 = null;
               break;
            }

            Object element$iv = var7.next();
            SemanticsNode node = (SemanticsNode)element$iv;
            int var10 = false;
            if (node.getBoundsInRoot().contains-k-4lQ0M(offset)) {
               var10000 = element$iv;
               break;
            }
         }

         SemanticsNode target = (SemanticsNode)var10000;
         DebugData data = null;
         if (target != null) {
            SemanticsNode var16;
            label35: {
               DebugUiCache var14 = (DebugUiCache)this.debugUi.getValue();
               if (var14 != null) {
                  DebugData var15 = var14.getSource();
                  if (var15 != null) {
                     var16 = var15.getRaw$app_debug();
                     break label35;
                  }
               }

               var16 = null;
            }

            if (!Intrinsics.areEqual(var16, target)) {
               DebugData.Resolver $this$invoke$iv = DebugViewOptions.INSTANCE.getResolver();
               int $i$f$invoke = false;
               data = $this$invoke$iv.resolve(target);
            }
         }

         if (data != null) {
            MutableState var17 = this.debugUi;
            Intrinsics.checkNotNull(target);
            Rect var10002 = target.getBoundsInRoot();
            Object var10004 = this.debugUiTextConstraints.getValue();
            Intrinsics.checkNotNull(var10004);
            var17.setValue(this.calculateUi-3p2s80s(var10002, data, ((Constraints)var10004).unbox-impl()));
         } else if (target == null) {
            this.debugUi.setValue((Object)null);
         }
      }

      return DebugViewOptions.INSTANCE.getEnabled() ? LiveLiterals$DebugComposeViewKt.INSTANCE.Boolean$branch$if-1$fun-dispatchTouchEvent$class-DebugComposeView() : super.dispatchTouchEvent(event);
   }

   private final Owner requireOwner() {
      int $i$f$requireOwner = false;
      Owner var10000 = access$getOwner$p(this);
      if (var10000 == null) {
         int var2 = false;
         String var3 = LiveLiterals$DebugComposeViewKt.INSTANCE.String$fun-$anonymous$$arg-1$call-checkNotNull$fun-requireOwner$class-DebugComposeView();
         throw new IllegalStateException(var3.toString());
      } else {
         return var10000;
      }
   }

   private final boolean isRealChanged(Set $this$isRealChanged) {
      int $i$f$isRealChanged = false;
      SnapshotStateMap var10001 = access$getDebugNodes$p(this);
      Intrinsics.checkNotNull(var10001, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateObject");
      boolean var10000;
      if (!$this$isRealChanged.contains((StateObject)var10001)) {
         MutableState var3 = access$getDebugUi$p(this);
         Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateObject");
         if (!$this$isRealChanged.contains((StateObject)var3)) {
            var3 = DebugViewOptions.INSTANCE.get_enabled$app_debug();
            Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateObject");
            if (!$this$isRealChanged.contains((StateObject)var3)) {
               var10000 = true;
               return var10000;
            }
         }
      }

      var10000 = false;
      return var10000;
   }

   private final void collectDebugNodesOrClearIfDestroyed() {
      Owner var10000 = this.owner;
      if (var10000 == null) {
         this.debugNodes.clear();
      } else {
         Owner owner = var10000;
         List $this$fastForEach$iv = SemanticsOwnerKt.getAllSemanticsNodes$default(owner.getRootForTest().getSemanticsOwner(), LiveLiterals$DebugComposeViewKt.INSTANCE.Boolean$arg-0$call-getAllSemanticsNodes$$$this$call-fastForEach$fun-collectDebugNodesOrClearIfDestroyed$class-DebugComposeView(), false, 2, (Object)null);
         int $i$f$fastForEach = false;
         int index$iv = 0;

         for(int var5 = $this$fastForEach$iv.size(); index$iv < var5; ++index$iv) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            SemanticsNode node = (SemanticsNode)item$iv;
            int var8 = false;
            if (!node.isRoot() && !this.isInDebugView(node)) {
               ((Map)this.debugNodes).put(node.getId(), node);
            }
         }

      }
   }

   private final boolean isInDebugView(SemanticsNode $this$isInDebugView) {
      SemanticsNode current = $this$isInDebugView;

      do {
         Intrinsics.checkNotNull(current);
         if (current.getConfig().contains(DebugViewOptions.INSTANCE.getSemantics())) {
            return LiveLiterals$DebugComposeViewKt.INSTANCE.Boolean$branch$if$body$loop$fun-isInDebugView$class-DebugComposeView();
         }

         current = current.getParent();
      } while(current != null);

      return LiveLiterals$DebugComposeViewKt.INSTANCE.Boolean$fun-isInDebugView$class-DebugComposeView();
   }

   static {
      $stable = LiveLiterals$DebugComposeViewKt.INSTANCE.Int$class-DebugComposeView();
      DEFAULT_BACKGROUND_COLOR = Color.copy-wmQWz5c$default(Color.Companion.getGray-0d7_KjU(), 0.7F, 0.0F, 0.0F, 0.0F, 14, (Object)null);
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
      d2 = {"Lland/sungbin/androidplayground/DebugComposeView$Companion;", "", "()V", "DEBUG_CONTENT_STYLE", "Landroidx/compose/ui/text/TextStyle;", "getDEBUG_CONTENT_STYLE", "()Landroidx/compose/ui/text/TextStyle;", "DEBUG_TITLE_STYLE", "getDEBUG_TITLE_STYLE", "DEBUG_VIEW_PADDING", "Landroidx/compose/ui/unit/Dp;", "getDEBUG_VIEW_PADDING-D9Ej5fM", "()F", "F", "DEBUG_VIEW_SPACING", "getDEBUG_VIEW_SPACING-D9Ej5fM", "DEFAULT_BACKGROUND_COLOR", "Landroidx/compose/ui/graphics/Color;", "getDEFAULT_BACKGROUND_COLOR-0d7_KjU", "()J", "J", "DEFAULT_CACHE_SIZE", "", "app_debug"}
   )
   private static final class Companion {
      private Companion() {
      }

      public final long getDEFAULT_BACKGROUND_COLOR_0d7_KjU/* $FF was: getDEFAULT_BACKGROUND_COLOR-0d7_KjU*/() {
         return DebugComposeView.DEFAULT_BACKGROUND_COLOR;
      }

      public final float getDEBUG_VIEW_PADDING_D9Ej5fM/* $FF was: getDEBUG_VIEW_PADDING-D9Ej5fM*/() {
         return DebugComposeView.DEBUG_VIEW_PADDING;
      }

      public final float getDEBUG_VIEW_SPACING_D9Ej5fM/* $FF was: getDEBUG_VIEW_SPACING-D9Ej5fM*/() {
         return DebugComposeView.DEBUG_VIEW_SPACING;
      }

      @NotNull
      public final TextStyle getDEBUG_TITLE_STYLE() {
         return DebugComposeView.DEBUG_TITLE_STYLE;
      }

      @NotNull
      public final TextStyle getDEBUG_CONTENT_STYLE() {
         return DebugComposeView.DEBUG_CONTENT_STYLE;
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
