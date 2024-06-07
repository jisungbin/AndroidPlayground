package land.sungbin.androidplayground;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.Arrangement.Vertical;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
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
import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable.PlacementScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.platform.ViewRootForTest;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsOwnerKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.math.MathKt;
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
   d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010!\u001a\u00020\fH\u0017¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\fH\u0002J\u0012\u0010$\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020\fH\u0014J\u001e\u0010+\u001a\u00020\f2\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\r¢\u0006\u0002\u0010,J\f\u0010-\u001a\u00020\u001b*\u00020\u0015H\u0002J\u0012\u0010.\u001a\u00020\u001b*\b\u0012\u0004\u0012\u0002000/H\u0002R!\u0010\t\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000e\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u000f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@RX\u0094\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u00061"},
   d2 = {"Lland/sungbin/androidplayground/DebugComposeView;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "content", "Landroidx/compose/runtime/MutableState;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "debugData", "Lkotlin/Pair;", "Landroidx/compose/ui/geometry/Rect;", "", "", "debugNodes", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "Landroidx/compose/ui/semantics/SemanticsNode;", "debugPopupDraggedOffset", "Landroidx/compose/ui/geometry/Offset;", "root", "Landroidx/compose/ui/platform/ViewRootForTest;", "<set-?>", "", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow$annotations", "()V", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "Content", "(Landroidx/compose/runtime/Composer;I)V", "collectDebugNodes", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getAccessibilityClassName", "layoutBoundsDrawingModifier", "Landroidx/compose/ui/Modifier;", "onAttachedToWindow", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "isInDebugPopup", "isRealChanged", "", "", "app_debug"}
)
@StabilityInferred(
   parameters = 0
)
@SourceDebugExtension({"SMAP\nDebugComposeView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugComposeView.kt\nland/sungbin/androidplayground/DebugComposeView\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,293:1\n33#2,6:294\n*S KotlinDebug\n*F\n+ 1 DebugComposeView.kt\nland/sungbin/androidplayground/DebugComposeView\n*L\n234#1:294,6\n*E\n"})
public final class DebugComposeView extends AbstractComposeView {
   private ViewRootForTest root;
   @NotNull
   private final SnapshotStateMap debugNodes;
   @NotNull
   private final MutableState debugData;
   @NotNull
   private final MutableState debugPopupDraggedOffset;
   @NotNull
   private final MutableState content;
   private boolean shouldCreateCompositionOnAttachedToWindow;
   public static final int $stable;

   @JvmOverloads
   public DebugComposeView(@NotNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
      Intrinsics.checkNotNullParameter(context, "context");
      super(context, attrs, defStyleAttr);
      this.debugNodes = SnapshotStateKt.mutableStateMapOf();
      this.debugData = SnapshotStateKt.mutableStateOf$default((Object)null, (SnapshotMutationPolicy)null, 2, (Object)null);
      this.debugPopupDraggedOffset = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.getZero-F1C5BW0()), (SnapshotMutationPolicy)null, 2, (Object)null);
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
      ComposerKt.sourceInformation($composer, "C(Content)81@3421L8:DebugComposeView.kt#qshby3");
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventStart(-503666316, $changed, -1, "land.sungbin.androidplayground.DebugComposeView.Content (DebugComposeView.kt:80)");
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
            ComposerKt.sourceInformation($composer, "C91@3732L1829:DebugComposeView.kt#qshby3");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
               $composer.skipToGroupEnd();
            } else {
               if (ComposerKt.isTraceInProgress()) {
                  ComposerKt.traceEventStart(1384190133, $changed, -1, "land.sungbin.androidplayground.DebugComposeView.setContent.<anonymous> (DebugComposeView.kt:89)");
               }

               $composer.startReplaceableGroup(264345039);
               ComposerKt.sourceInformation($composer, "89@3698L7");
               boolean propagateMinConstraints$iv;
               DebugComposeView var10000;
               if (DebugComposeView.this.root == null) {
                  var10000 = DebugComposeView.this;
                  CompositionLocal this_$iv = (CompositionLocal)AndroidCompositionLocals_androidKt.getLocalView();
                  propagateMinConstraints$iv = false;
                  int $i$f$getCurrent = false;
                  ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                  Object var7 = $composer.consume(this_$iv);
                  ComposerKt.sourceInformationMarkerEnd($composer);
                  Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type androidx.compose.ui.platform.ViewRootForTest");
                  var10000.root = (ViewRootForTest)var7;
               }

               $composer.endReplaceableGroup();
               Modifier modifier$iv = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null).then(DebugViewOptions.INSTANCE.getEnabled() ? DebugComposeView.this.layoutBoundsDrawingModifier() : (Modifier)Modifier.Companion);
               Function2 var70 = content;
               final DebugComposeView var71 = DebugComposeView.this;
               int $changed$iv = 0;
               int $i$f$Box = false;
               $composer.startReplaceableGroup(733328855);
               ComposerKt.sourceInformation($composer, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
               Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
               propagateMinConstraints$iv = false;
               MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, propagateMinConstraints$iv, $composer, 14 & $changed$iv >> 3 | 112 & $changed$iv >> 3);
               int $changed$iv$iv = 112 & $changed$iv << 3;
               int $i$f$Layout = false;
               $composer.startReplaceableGroup(-1323940314);
               ComposerKt.sourceInformation($composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
               int compositeKeyHash$iv$ivx = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
               CompositionLocalMap localMap$iv$ivx = $composer.getCurrentCompositionLocalMap();
               Function0 factory$iv$iv$ivx = ComposeUiNode.Companion.getConstructor();
               Function3 skippableUpdate$iv$iv$ivx = LayoutKt.modifierMaterializerOf(modifier$iv);
               int $changed$iv$iv$ivx = 6 | 7168 & $changed$iv$iv << 9;
               int $i$f$ReusableComposeNodex = false;
               if (!($composer.getApplier() instanceof Applier)) {
                  ComposablesKt.invalidApplier();
               }

               $composer.startReusableNode();
               if ($composer.getInserting()) {
                  $composer.createNode(factory$iv$iv$ivx);
               } else {
                  $composer.useNode();
               }

               Composer $this$Layout_u24lambda_u240$iv$ivx = Updater.constructor-impl($composer);
               int var20 = false;
               Updater.set-impl($this$Layout_u24lambda_u240$iv$ivx, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
               Updater.set-impl($this$Layout_u24lambda_u240$iv$ivx, localMap$iv$ivx, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
               Function2 block$iv$iv$ivx = ComposeUiNode.Companion.getSetCompositeKeyHash();
               int var22 = false;
               int var24 = false;
               if ($this$Layout_u24lambda_u240$iv$ivx.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$ivx.rememberedValue(), compositeKeyHash$iv$ivx)) {
                  $this$Layout_u24lambda_u240$iv$ivx.updateRememberedValue(compositeKeyHash$iv$ivx);
                  $this$Layout_u24lambda_u240$iv$ivx.apply(compositeKeyHash$iv$ivx, block$iv$iv$ivx);
               }

               skippableUpdate$iv$iv$ivx.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl($composer)), $composer, 112 & $changed$iv$iv$ivx >> 3);
               $composer.startReplaceableGroup(2058660585);
               int $changed$ivxx = 14 & $changed$iv$iv$ivx >> 9;
               int var27 = false;
               ComposerKt.sourceInformationMarkerStart($composer, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
               int var28 = 6 | 112 & $changed$iv >> 6;
               BoxScope var79 = (BoxScope)BoxScopeInstance.INSTANCE;
               int var31 = false;
               ComposerKt.sourceInformationMarkerStart($composer, -339438746, "C96@3900L9:DebugComposeView.kt#qshby3");
               var70.invoke($composer, 0);
               final Pair var32 = (Pair)var71.debugData.getValue();
               $composer.startReplaceableGroup(264345360);
               ComposerKt.sourceInformation($composer, "*100@4005L1538");
               if (var32 == null) {
                  var10000 = null;
               } else {
                  int var34 = false;
                  Modifier var80 = LayoutModifierKt.layout(SizeKt.fillMaxSize$default(TestTagKt.testTag((Modifier)Modifier.Companion, DebugComposeViewKt.access$getDEBUG_POPUP_ID$p()), 0.0F, 1, (Object)null), (Function3)(new Function3() {
                     @NotNull
                     public final MeasureResult invoke_3p2s80s/* $FF was: invoke-3p2s80s*/(@NotNull MeasureScope $this$layout, @NotNull Measurable measurable, long constraints) {
                        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
                        Intrinsics.checkNotNullParameter(measurable, "measurable");
                        long looseConstraints = Constraints.copy-Zbe2FdA$default(constraints, LiveLiterals$DebugComposeViewKt.INSTANCE.Int$arg-0$call-copy$val-looseConstraints$fun-$anonymous$$arg-0$call-layout$$$this$call-heightIn$$$this$call-background$$$this$call-padding$arg-0$call-Column$fun-$anonymous$$arg-0$call-let$else$when$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-0$call-$set-value$$fun-setContent$class-DebugComposeView(), 0, LiveLiterals$DebugComposeViewKt.INSTANCE.Int$arg-2$call-copy$val-looseConstraints$fun-$anonymous$$arg-0$call-layout$$$this$call-heightIn$$$this$call-background$$$this$call-padding$arg-0$call-Column$fun-$anonymous$$arg-0$call-let$else$when$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-0$call-$set-value$$fun-setContent$class-DebugComposeView(), 0, 10, (Object)null);
                        final Placeable placeable = measurable.measure-BRTryo0(looseConstraints);
                        final long position = DebugPopupPositionProvider.INSTANCE.calculatePosition-llwVHH4(IntRectKt.roundToIntRect((Rect)var32.getFirst()), IntSizeKt.IntSize(Constraints.getMaxWidth-impl(constraints), Constraints.getMaxHeight-impl(constraints)), $this$layout.getLayoutDirection(), IntSizeKt.IntSize(placeable.getWidth(), placeable.getHeight()));
                        return MeasureScope.layout$default($this$layout, Constraints.getMaxWidth-impl(constraints), Constraints.getMaxHeight-impl(constraints), (Map)null, (Function1)(new Function1() {
                           public final void invoke(@NotNull PlacementScope $this$layout) {
                              Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
                              Placeable var10001 = placeable;
                              long arg0$iv = position;
                              long other$iv = ((Offset)var71.debugPopupDraggedOffset.getValue()).unbox-impl();
                              int var6 = false;
                              other$iv = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.getX-impl(other$iv)), MathKt.roundToInt(Offset.getY-impl(other$iv)));
                              var6 = false;
                              PlacementScope.place-70tqf50$default($this$layout, var10001, IntOffsetKt.IntOffset(IntOffset.getX-impl(arg0$iv) + IntOffset.getX-impl(other$iv), IntOffset.getY-impl(arg0$iv) + IntOffset.getY-impl(other$iv)), 0.0F, 2, (Object)null);
                           }
                        }), 4, (Object)null);
                     }
                  }));
                  int $this$dp$ivx = LiveLiterals$DebugComposeViewKt.INSTANCE.Int$$$this$call-$get-dp$$arg-1$call-heightIn$$$this$call-background$$$this$call-padding$arg-0$call-Column$fun-$anonymous$$arg-0$call-let$else$when$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-0$call-$set-value$$fun-setContent$class-DebugComposeView();
                  int $i$f$getDp = false;
                  var80 = BackgroundKt.background-bw27NRU$default(SizeKt.heightIn-VpY3zN4$default(var80, 0.0F, Dp.constructor-impl((float)$this$dp$ivx), 1, (Object)null), Color.copy-wmQWz5c$default(Color.Companion.getGray-0d7_KjU(), LiveLiterals$DebugComposeViewKt.INSTANCE.Float$arg-0$call-copy$arg-0$call-background$$$this$call-padding$arg-0$call-Column$fun-$anonymous$$arg-0$call-let$else$when$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-0$call-$set-value$$fun-setContent$class-DebugComposeView(), 0.0F, 0.0F, 0.0F, 14, (Object)null), (Shape)null, 2, (Object)null);
                  $this$dp$ivx = LiveLiterals$DebugComposeViewKt.INSTANCE.Int$$$this$call-$get-dp$$arg-0$call-padding$arg-0$call-Column$fun-$anonymous$$arg-0$call-let$else$when$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-0$call-$set-value$$fun-setContent$class-DebugComposeView();
                  $i$f$getDp = false;
                  Modifier modifier$ivx = PaddingKt.padding-3ABfNKs(var80, Dp.constructor-impl((float)$this$dp$ivx));
                  Arrangement var81 = Arrangement.INSTANCE;
                  int $this$dp$iv = LiveLiterals$DebugComposeViewKt.INSTANCE.Int$$$this$call-$get-dp$$arg-0$call-spacedBy$arg-1$call-Column$fun-$anonymous$$arg-0$call-let$else$when$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-0$call-$set-value$$fun-setContent$class-DebugComposeView();
                  int $i$f$getDpx = false;
                  Vertical verticalArrangement$iv = (Vertical)var81.spacedBy-0680j_4(Dp.constructor-impl((float)$this$dp$iv));
                  int $changed$ivxxx = 0;
                  int $i$f$Column = false;
                  $composer.startReplaceableGroup(-483455358);
                  ComposerKt.sourceInformation($composer, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                  Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                  MeasurePolicy measurePolicy$ivx = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, 14 & $changed$ivxxx >> 3 | 112 & $changed$ivxxx >> 3);
                  int $changed$iv$ivx = 112 & $changed$ivxxx << 3;
                  int $i$f$Layoutx = false;
                  $composer.startReplaceableGroup(-1323940314);
                  ComposerKt.sourceInformation($composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                  int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                  CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                  Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
                  Function3 skippableUpdate$iv$iv$iv = LayoutKt.modifierMaterializerOf(modifier$ivx);
                  int $changed$iv$iv$iv = 6 | 7168 & $changed$iv$ivx << 9;
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
                  int var50 = false;
                  Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$ivx, ComposeUiNode.Companion.getSetMeasurePolicy());
                  Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                  Function2 block$iv$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
                  int var52 = false;
                  int var54 = false;
                  if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), compositeKeyHash$iv$iv)) {
                     $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(compositeKeyHash$iv$iv);
                     $this$Layout_u24lambda_u240$iv$iv.apply(compositeKeyHash$iv$iv, block$iv$iv$iv);
                  }

                  skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl($composer)), $composer, 112 & $changed$iv$iv$iv >> 3);
                  $composer.startReplaceableGroup(2058660585);
                  int $changed$ivx = 14 & $changed$iv$iv$iv >> 9;
                  int var57 = false;
                  ComposerKt.sourceInformationMarkerStart($composer, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                  int var58 = 6 | 112 & $changed$ivxxx >> 6;
                  Composer $composerx = $composer;
                  ColumnScope var82 = (ColumnScope)ColumnScopeInstance.INSTANCE;
                  int var61 = false;
                  ComposerKt.sourceInformationMarkerStart($composer, -205253329, "C124@5243L7,124@5187L99,127@5372L159:DebugComposeView.kt#qshby3");
                  String var83 = LiveLiterals$DebugComposeViewKt.INSTANCE.String$arg-0$call-Text$fun-$anonymous$$arg-3$call-Column$fun-$anonymous$$arg-0$call-let$else$when$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-0$call-$set-value$$fun-setContent$class-DebugComposeView();
                  CompositionLocal this_$ivx = (CompositionLocal)TextKt.getLocalTextStyle();
                  int $i$f$fastForEach = false;
                  int $i$f$getCurrentx = false;
                  ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                  Object var65 = $composer.consume(this_$ivx);
                  ComposerKt.sourceInformationMarkerEnd($composer);
                  TextKt.Text--4IGK_g(var83, (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, TextStyle.copy-p1EtxEg$default((TextStyle)var65, 0L, 0L, FontWeight.Companion.getBold(), (FontStyle)null, (FontSynthesis)null, (FontFamily)null, (String)null, 0L, (BaselineShift)null, (TextGeometricTransform)null, (LocaleList)null, 0L, (TextDecoration)null, (Shadow)null, (DrawStyle)null, 0, 0, 0L, (TextIndent)null, (PlatformTextStyle)null, (LineHeightStyle)null, 0, 0, (TextMotion)null, 16777211, (Object)null), $composer, 0, 0, 65534);
                  $composer.startReplaceableGroup(-205253199);
                  ComposerKt.sourceInformation($composer, "*125@5340L16");
                  List $this$fastForEach$iv = (List)var32.getSecond();
                  $i$f$fastForEach = false;
                  int index$iv = 0;

                  for(int var78 = $this$fastForEach$iv.size(); index$iv < var78; ++index$iv) {
                     Object item$iv = $this$fastForEach$iv.get(index$iv);
                     String debug = (String)item$iv;
                     int var68 = false;
                     TextKt.Text--4IGK_g(LiveLiterals$DebugComposeViewKt.INSTANCE.String$0$str$arg-0$call-Text$fun-$anonymous$$arg-0$call-fastForEach$fun-$anonymous$$arg-3$call-Column$fun-$anonymous$$arg-0$call-let$else$when$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-0$call-$set-value$$fun-setContent$class-DebugComposeView() + debug, (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composerx, 0, 0, 131070);
                  }

                  $composerx.endReplaceableGroup();
                  EffectsKt.DisposableEffect(var71.debugPopupDraggedOffset, (Function1)(new Function1() {
                     @NotNull
                     public final DisposableEffectResult invoke(@NotNull DisposableEffectScope $this$DisposableEffect) {
                        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
                        DebugComposeView var3 = var71;
                        int $i$f$onDispose = false;
                        return (DisposableEffectResult)(new DebugComposeView$setContent$1$1$1$2$2$invoke$$inlined$onDispose$1(var3));
                     }
                  }), $composerx, 0);
                  ComposerKt.sourceInformationMarkerEnd($composerx);
                  ComposerKt.sourceInformationMarkerEnd($composer);
                  $composer.endReplaceableGroup();
                  $composer.endNode();
                  $composer.endReplaceableGroup();
                  $composer.endReplaceableGroup();
                  Unit var84 = Unit.INSTANCE;
                  var84 = Unit.INSTANCE;
               }

               $composer.endReplaceableGroup();
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
      if (this.isAttachedToWindow()) {
         this.createComposition();
      }

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

   protected void onAttachedToWindow() {
      final ObjectRef debugNodeCollectorDisposeHandle = new ObjectRef();
      ThreadsKt.thread$default(false, LiveLiterals$DebugComposeViewKt.INSTANCE.Boolean$arg-1$call-thread$fun-onAttachedToWindow$class-DebugComposeView(), (ClassLoader)null, LiveLiterals$DebugComposeViewKt.INSTANCE.String$arg-3$call-thread$fun-onAttachedToWindow$class-DebugComposeView(), 5, (Function0)(new Function0() {
         public final void invoke() {
            try {
               LifecycleOwner var10000 = ViewTreeLifecycleOwner.get((View)DebugComposeView.this);
               Intrinsics.checkNotNull(var10000);
               BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var10000), (CoroutineContext)null, (CoroutineStart)null, (Function2)(new Function2((Continuation)null) {
                  int label;

                  @Nullable
                  public final Object invokeSuspend(@NotNull Object $result) {
                     Object var8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     Continuation var10000;
                     switch(this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);
                        var10000 = (Continuation)this;
                        this.label = 1;
                        if (HandlerDispatcherKt.awaitFrame(var10000) == var8) {
                           return var8;
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
                        if (DebugComposeView.this.root != null) {
                           DebugComposeView.this.collectDebugNodes();
                           String var9 = LiveLiterals$DebugComposeViewKt.INSTANCE.String$0$str$arg-0$call-println$body$loop$fun-$anonymous$$arg-2$call-launch$try$fun-$anonymous$$arg-5$call-thread$fun-onAttachedToWindow$class-DebugComposeView();
                           System.out.println(var9 + DebugComposeView.this.debugNodes.size() + LiveLiterals$DebugComposeViewKt.INSTANCE.String$2$str$arg-0$call-println$body$loop$fun-$anonymous$$arg-2$call-launch$try$fun-$anonymous$$arg-5$call-thread$fun-onAttachedToWindow$class-DebugComposeView());
                           Iterable $this$forEach$iv = (Iterable)DebugComposeView.this.debugNodes.values();
                           int $i$f$forEach = false;
                           Iterator var4 = $this$forEach$iv.iterator();

                           while(var4.hasNext()) {
                              Object element$iv = var4.next();
                              SemanticsNode node = (SemanticsNode)element$iv;
                              int var7 = false;
                              var9 = LiveLiterals$DebugComposeViewKt.INSTANCE.String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach$body$loop$fun-$anonymous$$arg-2$call-launch$try$fun-$anonymous$$arg-5$call-thread$fun-onAttachedToWindow$class-DebugComposeView();
                              System.out.println(var9 + node.getId() + LiveLiterals$DebugComposeViewKt.INSTANCE.String$2$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach$body$loop$fun-$anonymous$$arg-2$call-launch$try$fun-$anonymous$$arg-5$call-thread$fun-onAttachedToWindow$class-DebugComposeView() + Offset.toString-impl(node.getPositionInRoot-F1C5BW0()) + LiveLiterals$DebugComposeViewKt.INSTANCE.String$4$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach$body$loop$fun-$anonymous$$arg-2$call-launch$try$fun-$anonymous$$arg-5$call-thread$fun-onAttachedToWindow$class-DebugComposeView() + Offset.toString-impl(node.getPositionInWindow-F1C5BW0()) + LiveLiterals$DebugComposeViewKt.INSTANCE.String$6$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach$body$loop$fun-$anonymous$$arg-2$call-launch$try$fun-$anonymous$$arg-5$call-thread$fun-onAttachedToWindow$class-DebugComposeView());
                           }

                           debugNodeCollectorDisposeHandle.element = Snapshot.Companion.registerApplyObserver((Function2)(new Function2() {
                              public final void invoke(@NotNull Set changes, @NotNull Snapshot var2) {
                                 Intrinsics.checkNotNullParameter(changes, "changes");
                                 Intrinsics.checkNotNullParameter(var2, "<anonymous parameter 1>");
                                 if (DebugComposeView.this.isRealChanged(changes)) {
                                    DebugComposeView.this.collectDebugNodes();
                                    String var10000 = LiveLiterals$DebugComposeViewKt.INSTANCE.String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-registerApplyObserver$set-debugNodeCollectorDisposeHandle$fun-$anonymous$$arg-2$call-launch$try$fun-$anonymous$$arg-5$call-thread$fun-onAttachedToWindow$class-DebugComposeView();
                                    System.out.println(var10000 + DebugComposeView.this.debugNodes.size() + LiveLiterals$DebugComposeViewKt.INSTANCE.String$2$str$arg-0$call-println$fun-$anonymous$$arg-0$call-registerApplyObserver$set-debugNodeCollectorDisposeHandle$fun-$anonymous$$arg-2$call-launch$try$fun-$anonymous$$arg-5$call-thread$fun-onAttachedToWindow$class-DebugComposeView());
                                    Iterable $this$forEach$iv = (Iterable)DebugComposeView.this.debugNodes.values();
                                    int $i$f$forEach = false;
                                    Iterator var5 = $this$forEach$iv.iterator();

                                    while(var5.hasNext()) {
                                       Object element$iv = var5.next();
                                       SemanticsNode node = (SemanticsNode)element$iv;
                                       int var8 = false;
                                       var10000 = LiveLiterals$DebugComposeViewKt.INSTANCE.String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach$fun-$anonymous$$arg-0$call-registerApplyObserver$set-debugNodeCollectorDisposeHandle$fun-$anonymous$$arg-2$call-launch$try$fun-$anonymous$$arg-5$call-thread$fun-onAttachedToWindow$class-DebugComposeView();
                                       System.out.println(var10000 + node.getId() + LiveLiterals$DebugComposeViewKt.INSTANCE.String$2$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach$fun-$anonymous$$arg-0$call-registerApplyObserver$set-debugNodeCollectorDisposeHandle$fun-$anonymous$$arg-2$call-launch$try$fun-$anonymous$$arg-5$call-thread$fun-onAttachedToWindow$class-DebugComposeView() + Offset.toString-impl(node.getPositionInRoot-F1C5BW0()) + LiveLiterals$DebugComposeViewKt.INSTANCE.String$4$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach$fun-$anonymous$$arg-0$call-registerApplyObserver$set-debugNodeCollectorDisposeHandle$fun-$anonymous$$arg-2$call-launch$try$fun-$anonymous$$arg-5$call-thread$fun-onAttachedToWindow$class-DebugComposeView() + Offset.toString-impl(node.getPositionInWindow-F1C5BW0()) + LiveLiterals$DebugComposeViewKt.INSTANCE.String$6$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach$fun-$anonymous$$arg-0$call-registerApplyObserver$set-debugNodeCollectorDisposeHandle$fun-$anonymous$$arg-2$call-launch$try$fun-$anonymous$$arg-5$call-thread$fun-onAttachedToWindow$class-DebugComposeView());
                                    }

                                 }
                              }
                           }));
                           var10000 = (Continuation)this;
                           this.label = 2;
                           if (DelayKt.awaitCancellation(var10000) == var8) {
                              return var8;
                           }

                           throw new KotlinNothingValueException();
                        }

                        System.out.println(LiveLiterals$DebugComposeViewKt.INSTANCE.String$arg-0$call-println$branch$if$body$loop$fun-$anonymous$$arg-2$call-launch$try$fun-$anonymous$$arg-5$call-thread$fun-onAttachedToWindow$class-DebugComposeView());
                        var10000 = (Continuation)this;
                        this.label = 1;
                     } while(HandlerDispatcherKt.awaitFrame(var10000) != var8);

                     return var8;
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
            } finally {
               ObserverHandle var4 = (ObserverHandle)debugNodeCollectorDisposeHandle.element;
               if (var4 != null) {
                  var4.dispose();
               }

            }

         }
      }), 5, (Object)null);
      super.onAttachedToWindow();
   }

   public boolean dispatchTouchEvent(@Nullable MotionEvent ev) {
      String var10000 = LiveLiterals$DebugComposeViewKt.INSTANCE.String$0$str$arg-0$call-println$fun-dispatchTouchEvent$class-DebugComposeView();
      System.out.println(var10000 + Offset.toString-impl(OffsetKt.Offset(ev != null ? ev.getX() : LiveLiterals$DebugComposeViewKt.INSTANCE.Float$branch$when$arg-0$call-Offset$1$str$arg-0$call-println$fun-dispatchTouchEvent$class-DebugComposeView(), ev != null ? ev.getY() : LiveLiterals$DebugComposeViewKt.INSTANCE.Float$branch$when$arg-1$call-Offset$1$str$arg-0$call-println$fun-dispatchTouchEvent$class-DebugComposeView())));
      return DebugViewOptions.INSTANCE.getEnabled() ? LiveLiterals$DebugComposeViewKt.INSTANCE.Boolean$branch$if$fun-dispatchTouchEvent$class-DebugComposeView() : super.dispatchTouchEvent(ev);
   }

   private final boolean isRealChanged(Set $this$isRealChanged) {
      SnapshotStateMap var10001 = this.debugNodes;
      Intrinsics.checkNotNull(var10001, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateObject");
      boolean var10000;
      if (!$this$isRealChanged.contains((StateObject)var10001)) {
         MutableState var2 = this.debugData;
         Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateObject");
         if (!$this$isRealChanged.contains((StateObject)var2)) {
            var2 = this.debugPopupDraggedOffset;
            Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateObject");
            if (!$this$isRealChanged.contains((StateObject)var2)) {
               var2 = DebugViewOptions.INSTANCE.get_enabled$app_debug();
               Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateObject");
               if (!$this$isRealChanged.contains((StateObject)var2)) {
                  var10000 = true;
                  return var10000;
               }
            }
         }
      }

      var10000 = false;
      return var10000;
   }

   private final void collectDebugNodes() {
      ViewRootForTest var10000 = this.root;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("root");
         var10000 = null;
      }

      List $this$fastForEach$iv = SemanticsOwnerKt.getAllSemanticsNodes$default(var10000.getSemanticsOwner(), LiveLiterals$DebugComposeViewKt.INSTANCE.Boolean$arg-0$call-getAllSemanticsNodes$$$this$call-fastForEach$fun-collectDebugNodes$class-DebugComposeView(), false, 2, (Object)null);
      int $i$f$fastForEach = false;
      int index$iv = 0;

      for(int var4 = $this$fastForEach$iv.size(); index$iv < var4; ++index$iv) {
         Object item$iv = $this$fastForEach$iv.get(index$iv);
         SemanticsNode node = (SemanticsNode)item$iv;
         int var7 = false;
         if (!node.isRoot() && !this.isInDebugPopup(node)) {
            ((Map)this.debugNodes).put(node.getId(), node);
         }
      }

   }

   private final boolean isInDebugPopup(SemanticsNode $this$isInDebugPopup) {
      SemanticsNode current = $this$isInDebugPopup;

      do {
         Intrinsics.checkNotNull(current);
         if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(current.getConfig(), SemanticsProperties.INSTANCE.getTestTag()), DebugComposeViewKt.access$getDEBUG_POPUP_ID$p())) {
            return LiveLiterals$DebugComposeViewKt.INSTANCE.Boolean$branch$if$body$loop$fun-isInDebugPopup$class-DebugComposeView();
         }

         current = current.getParent();
      } while(current != null);

      return LiveLiterals$DebugComposeViewKt.INSTANCE.Boolean$fun-isInDebugPopup$class-DebugComposeView();
   }

   @JvmOverloads
   public DebugComposeView(@NotNull Context context, @Nullable AttributeSet attrs) {
      Intrinsics.checkNotNullParameter(context, "context");
      this(context, attrs, 0, 4, (DefaultConstructorMarker)null);
   }

   @JvmOverloads
   public DebugComposeView(@NotNull Context context) {
      Intrinsics.checkNotNullParameter(context, "context");
      this(context, (AttributeSet)null, 0, 6, (DefaultConstructorMarker)null);
   }

   static {
      $stable = LiveLiterals$DebugComposeViewKt.INSTANCE.Int$class-DebugComposeView();
   }
}
