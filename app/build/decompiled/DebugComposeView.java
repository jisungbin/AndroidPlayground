package land.sungbin.androidplayground;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsOwnerKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.Lifecycle.State;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
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
   d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010(\u001a\u00020\fH\u0017¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\fH\u0002J\u0010\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020\fH\u0014J\u001e\u00103\u001a\u00020\f2\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\r¢\u0006\u0002\u00104J\f\u00105\u001a\u00020\"*\u00020\u0018H\u0002J\u0012\u00106\u001a\u00020\"*\b\u0012\u0004\u0012\u00020807H\u0002R!\u0010\t\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f0\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"@RX\u0094\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u00069"},
   d2 = {"Lland/sungbin/androidplayground/DebugComposeView;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "content", "Landroidx/compose/runtime/MutableState;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "debugData", "Lkotlin/Pair;", "Landroidx/compose/ui/geometry/Rect;", "Lland/sungbin/androidplayground/DebugData;", "getDebugData$app_debug", "()Landroidx/compose/runtime/MutableState;", "debugNodeCollectorThread", "Ljava/lang/Thread;", "debugNodes", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "Landroidx/compose/ui/semantics/SemanticsNode;", "debugPopup", "Lland/sungbin/androidplayground/DebugPopupWindow;", "owner", "Landroidx/compose/ui/node/Owner;", "getOwner$app_debug", "()Landroidx/compose/ui/node/Owner;", "setOwner$app_debug", "(Landroidx/compose/ui/node/Owner;)V", "<set-?>", "", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow$annotations", "()V", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "Content", "(Landroidx/compose/runtime/Composer;I)V", "collectDebugNodesOrClearIfDestroyed", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getAccessibilityClassName", "", "layoutBoundsDrawingModifier", "Landroidx/compose/ui/Modifier;", "onAttachedToWindow", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "isInDebugView", "isRealChanged", "", "", "app_debug"}
)
@StabilityInferred(
   parameters = 0
)
@SourceDebugExtension({"SMAP\nDebugComposeView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugComposeView.kt\nland/sungbin/androidplayground/DebugComposeView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 DebugData.kt\nland/sungbin/androidplayground/DebugDataKt\n+ 4 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,236:1\n288#2,2:237\n20#3:239\n33#4,6:240\n*S KotlinDebug\n*F\n+ 1 DebugComposeView.kt\nland/sungbin/androidplayground/DebugComposeView\n*L\n156#1:237,2\n158#1:239\n176#1:240,6\n*E\n"})
public final class DebugComposeView extends AbstractComposeView {
   @Nullable
   private Owner owner;
   @Nullable
   private DebugPopupWindow debugPopup;
   @NotNull
   private final SnapshotStateMap debugNodes;
   @NotNull
   private final MutableState debugData;
   @NotNull
   private final MutableState content;
   @Nullable
   private Thread debugNodeCollectorThread;
   private boolean shouldCreateCompositionOnAttachedToWindow;
   public static final int $stable;

   public DebugComposeView(@NotNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
      Intrinsics.checkNotNullParameter(context, "context");
      super(context, attrs, defStyleAttr);
      this.debugPopup = new DebugPopupWindow();
      this.debugNodes = SnapshotStateKt.mutableStateMapOf();
      this.debugData = SnapshotStateKt.mutableStateOf$default((Object)null, (SnapshotMutationPolicy)null, 2, (Object)null);
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

   @Nullable
   public final Owner getOwner$app_debug() {
      return this.owner;
   }

   public final void setOwner$app_debug(@Nullable Owner var1) {
      this.owner = var1;
   }

   @NotNull
   public final MutableState getDebugData$app_debug() {
      return this.debugData;
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
      ComposerKt.sourceInformation($composer, "C(Content)66@2677L8:DebugComposeView.kt#qshby3");
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventStart(-503666316, $changed, -1, "land.sungbin.androidplayground.DebugComposeView.Content (DebugComposeView.kt:65)");
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
            ComposerKt.sourceInformation($composer, "C77@3056L117:DebugComposeView.kt#qshby3");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
               $composer.skipToGroupEnd();
            } else {
               if (ComposerKt.isTraceInProgress()) {
                  ComposerKt.traceEventStart(1384190133, $changed, -1, "land.sungbin.androidplayground.DebugComposeView.setContent.<anonymous> (DebugComposeView.kt:75)");
               }

               $composer.startReplaceableGroup(264344379);
               ComposerKt.sourceInformation($composer, "75@3032L7");
               boolean propagateMinConstraints$iv;
               if (DebugComposeView.this.getOwner$app_debug() == null) {
                  DebugComposeView var10000 = DebugComposeView.this;
                  CompositionLocal this_$iv = (CompositionLocal)AndroidCompositionLocals_androidKt.getLocalView();
                  propagateMinConstraints$iv = false;
                  int $i$f$getCurrent = false;
                  ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                  Object var7 = $composer.consume(this_$iv);
                  ComposerKt.sourceInformationMarkerEnd($composer);
                  Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type androidx.compose.ui.node.Owner");
                  var10000.setOwner$app_debug((Owner)var7);
               }

               $composer.endReplaceableGroup();
               Modifier modifier$iv = DebugViewOptions.INSTANCE.getEnabled() ? DebugComposeView.this.layoutBoundsDrawingModifier() : (Modifier)Modifier.Companion;
               Function2 var32 = content;
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
               int var19 = false;
               Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
               Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
               Function2 block$iv$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
               int var21 = false;
               int var23 = false;
               if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), compositeKeyHash$iv$iv)) {
                  $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(compositeKeyHash$iv$iv);
                  $this$Layout_u24lambda_u240$iv$iv.apply(compositeKeyHash$iv$iv, block$iv$iv$iv);
               }

               skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl($composer)), $composer, 112 & $changed$iv$iv$iv >> 3);
               $composer.startReplaceableGroup(2058660585);
               int $changed$iv = 14 & $changed$iv$iv$iv >> 9;
               int var26 = false;
               ComposerKt.sourceInformationMarkerStart($composer, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
               int var27 = 6 | 112 & $changed$ivx >> 6;
               BoxScope var34 = (BoxScope)BoxScopeInstance.INSTANCE;
               int var30 = false;
               ComposerKt.sourceInformationMarkerStart($composer, -339439490, "C78@3156L9:DebugComposeView.kt#qshby3");
               var32.invoke($composer, 0);
               ComposerKt.sourceInformationMarkerEnd($composer);
               ComposerKt.sourceInformationMarkerEnd($composer);
               $composer.endReplaceableGroup();
               $composer.endNode();
               $composer.endReplaceableGroup();
               $composer.endReplaceableGroup();
               if (DebugComposeView.this.isAttachedToWindow()) {
                  DebugComposeView.this.createComposition();
               }

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
                        System.out.println(LiveLiterals$DebugComposeViewKt.INSTANCE.String$arg-0$call-println$fun-$anonymous$$arg-2$call-launch$fun-$anonymous$$arg-0$call-run$fun-$anonymous$$arg-5$call-thread$arg-0$call-$set-debugNodeCollectorThread$$fun-onAttachedToWindow$class-DebugComposeView());

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
                                    System.out.println(LiveLiterals$DebugComposeViewKt.INSTANCE.String$arg-0$call-println$fun-$anonymous$$arg-1$call-repeatOnLifecycle$try$fun-$anonymous$$arg-2$call-launch$fun-$anonymous$$arg-0$call-run$fun-$anonymous$$arg-5$call-thread$arg-0$call-$set-debugNodeCollectorThread$$fun-onAttachedToWindow$class-DebugComposeView());
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
                                    if (var3.getOwner$app_debug() != null) {
                                       var3.collectDebugNodesOrClearIfDestroyed();
                                       String var3x = LiveLiterals$DebugComposeViewKt.INSTANCE.String$0$str$arg-0$call-println$body$loop$fun-$anonymous$$arg-1$call-repeatOnLifecycle$try$fun-$anonymous$$arg-2$call-launch$fun-$anonymous$$arg-0$call-run$fun-$anonymous$$arg-5$call-thread$arg-0$call-$set-debugNodeCollectorThread$$fun-onAttachedToWindow$class-DebugComposeView();
                                       System.out.println(var3x + var3.debugNodes.size() + LiveLiterals$DebugComposeViewKt.INSTANCE.String$2$str$arg-0$call-println$body$loop$fun-$anonymous$$arg-1$call-repeatOnLifecycle$try$fun-$anonymous$$arg-2$call-launch$fun-$anonymous$$arg-0$call-run$fun-$anonymous$$arg-5$call-thread$arg-0$call-$set-debugNodeCollectorThread$$fun-onAttachedToWindow$class-DebugComposeView());
                                       var2.element = Snapshot.Companion.registerApplyObserver((Function2)(new Function2() {
                                          public final void invoke(@NotNull Set changes, @NotNull Snapshot var2x) {
                                             Intrinsics.checkNotNullParameter(changes, "changes");
                                             Intrinsics.checkNotNullParameter(var2x, "<anonymous parameter 1>");
                                             System.out.println(LiveLiterals$DebugComposeViewKt.INSTANCE.String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-registerApplyObserver$set-debugNodeCollectorDisposeHandle$fun-$anonymous$$arg-1$call-repeatOnLifecycle$try$fun-$anonymous$$arg-2$call-launch$fun-$anonymous$$arg-0$call-run$fun-$anonymous$$arg-5$call-thread$arg-0$call-$set-debugNodeCollectorThread$$fun-onAttachedToWindow$class-DebugComposeView() + changes);
                                             if (var3.isRealChanged(changes)) {
                                                var3.collectDebugNodesOrClearIfDestroyed();
                                                String var10000 = LiveLiterals$DebugComposeViewKt.INSTANCE.String$0$str$arg-0$call-println-1$fun-$anonymous$$arg-0$call-registerApplyObserver$set-debugNodeCollectorDisposeHandle$fun-$anonymous$$arg-1$call-repeatOnLifecycle$try$fun-$anonymous$$arg-2$call-launch$fun-$anonymous$$arg-0$call-run$fun-$anonymous$$arg-5$call-thread$arg-0$call-$set-debugNodeCollectorThread$$fun-onAttachedToWindow$class-DebugComposeView();
                                                System.out.println(var10000 + var3.debugNodes.size() + LiveLiterals$DebugComposeViewKt.INSTANCE.String$2$str$arg-0$call-println-1$fun-$anonymous$$arg-0$call-registerApplyObserver$set-debugNodeCollectorDisposeHandle$fun-$anonymous$$arg-1$call-repeatOnLifecycle$try$fun-$anonymous$$arg-2$call-launch$fun-$anonymous$$arg-0$call-run$fun-$anonymous$$arg-5$call-thread$arg-0$call-$set-debugNodeCollectorThread$$fun-onAttachedToWindow$class-DebugComposeView());
                                             }
                                          }
                                       }));
                                       System.out.println(LiveLiterals$DebugComposeViewKt.INSTANCE.String$arg-0$call-println-1$fun-$anonymous$$arg-1$call-repeatOnLifecycle$try$fun-$anonymous$$arg-2$call-launch$fun-$anonymous$$arg-0$call-run$fun-$anonymous$$arg-5$call-thread$arg-0$call-$set-debugNodeCollectorThread$$fun-onAttachedToWindow$class-DebugComposeView());
                                       DebugPopupWindow var4 = var3.debugPopup;
                                       if (var4 != null) {
                                          var4.start(var3);
                                       }

                                       var10000 = (Continuation)this;
                                       this.label = 2;
                                       if (DelayKt.awaitCancellation(var10000) == var2x) {
                                          return var2x;
                                       }

                                       throw new KotlinNothingValueException();
                                    }

                                    System.out.println(LiveLiterals$DebugComposeViewKt.INSTANCE.String$arg-0$call-println$branch$if$body$loop$fun-$anonymous$$arg-1$call-repeatOnLifecycle$try$fun-$anonymous$$arg-2$call-launch$fun-$anonymous$$arg-0$call-run$fun-$anonymous$$arg-5$call-thread$arg-0$call-$set-debugNodeCollectorThread$$fun-onAttachedToWindow$class-DebugComposeView());
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

                     var3.getDebugData$app_debug().setValue((Object)null);
                     var3.debugNodes.clear();
                     var3.debugPopup = null;
                     var3.setOwner$app_debug((Owner)null);
                     System.out.println(LiveLiterals$DebugComposeViewKt.INSTANCE.String$arg-0$call-println$finally$fun-$anonymous$$arg-2$call-launch$fun-$anonymous$$arg-0$call-run$fun-$anonymous$$arg-5$call-thread$arg-0$call-$set-debugNodeCollectorThread$$fun-onAttachedToWindow$class-DebugComposeView());
                     return Unit.INSTANCE;
                  }

                  Throwable var2x = var10000;
                  var19 = (ObserverHandle)var2.element;
                  if (var19 != null) {
                     var19.dispose();
                  }

                  var3.getDebugData$app_debug().setValue((Object)null);
                  var3.debugNodes.clear();
                  var3.debugPopup = null;
                  var3.setOwner$app_debug((Owner)null);
                  System.out.println(LiveLiterals$DebugComposeViewKt.INSTANCE.String$arg-0$call-println$finally$fun-$anonymous$$arg-2$call-launch$fun-$anonymous$$arg-0$call-run$fun-$anonymous$$arg-5$call-thread$arg-0$call-$set-debugNodeCollectorThread$$fun-onAttachedToWindow$class-DebugComposeView());
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

   public boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
      Intrinsics.checkNotNullParameter(ev, "ev");
      long offset = OffsetKt.Offset(ev.getX(), ev.getY());
      Iterable $this$firstOrNull$iv = (Iterable)this.debugNodes.values();
      int $i$f$invoke = false;
      Iterator var7 = $this$firstOrNull$iv.iterator();

      Object var10000;
      while(true) {
         if (var7.hasNext()) {
            Object element$iv = var7.next();
            SemanticsNode node = (SemanticsNode)element$iv;
            int var10 = false;
            if (!node.getBoundsInRoot().contains-k-4lQ0M(offset)) {
               continue;
            }

            var10000 = element$iv;
            break;
         }

         var10000 = null;
         break;
      }

      label33: {
         SemanticsNode target = (SemanticsNode)var10000;
         if (target != null) {
            SemanticsNode var14;
            label30: {
               Pair var12 = (Pair)this.debugData.getValue();
               if (var12 != null) {
                  DebugData var13 = (DebugData)var12.getSecond();
                  if (var13 != null) {
                     var14 = var13.getRaw$app_debug();
                     break label30;
                  }
               }

               var14 = null;
            }

            if (!Intrinsics.areEqual(var14, target)) {
               MutableState var15 = this.debugData;
               Rect var10001 = target.getBoundsInRoot();
               DebugData.Resolver $this$invoke$iv = DebugViewOptions.INSTANCE.getResolver();
               $i$f$invoke = false;
               var15.setValue(TuplesKt.to(var10001, $this$invoke$iv.resolve(target)));
               break label33;
            }
         }

         if (target == null) {
            this.debugData.setValue((Object)null);
         }
      }

      String var16 = LiveLiterals$DebugComposeViewKt.INSTANCE.String$0$str$arg-0$call-println$fun-dispatchTouchEvent$class-DebugComposeView();
      System.out.println(var16 + Offset.toString-impl(offset) + LiveLiterals$DebugComposeViewKt.INSTANCE.String$2$str$arg-0$call-println$fun-dispatchTouchEvent$class-DebugComposeView() + this.debugData.getValue());
      return DebugViewOptions.INSTANCE.getEnabled() ? LiveLiterals$DebugComposeViewKt.INSTANCE.Boolean$branch$if-1$fun-dispatchTouchEvent$class-DebugComposeView() : super.dispatchTouchEvent(ev);
   }

   private final boolean isRealChanged(Set $this$isRealChanged) {
      SnapshotStateMap var10001 = this.debugNodes;
      Intrinsics.checkNotNull(var10001, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateObject");
      boolean var10000;
      if (!$this$isRealChanged.contains((StateObject)var10001)) {
         MutableState var2 = this.debugData;
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
   }
}
