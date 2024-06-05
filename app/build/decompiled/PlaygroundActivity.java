package land.sungbin.androidplayground;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
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
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ViewRootForTest;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsOwnerKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.android.HandlerDispatcherKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014RS\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00048B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"},
   d2 = {"Lland/sungbin/androidplayground/PlaygroundActivity;", "Landroidx/activity/ComponentActivity;", "()V", "<set-?>", "Lkotlin/Pair;", "Landroidx/compose/ui/geometry/Rect;", "", "", "debugData", "getDebugData", "()Lkotlin/Pair;", "setDebugData", "(Lkotlin/Pair;)V", "debugData$delegate", "Landroidx/compose/runtime/MutableState;", "debugNodes", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "root", "Landroidx/compose/ui/platform/ViewRootForTest;", "onAttachedToWindow", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)
@StabilityInferred(
   parameters = 0
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivity\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,154:1\n81#2:155\n107#2,2:156\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivity\n*L\n51#1:155\n51#1:156,2\n*E\n"})
public final class PlaygroundActivity extends ComponentActivity {
   private ViewRootForTest root;
   @NotNull
   private final SnapshotStateMap debugNodes = SnapshotStateKt.mutableStateMapOf();
   @NotNull
   private final MutableState debugData$delegate = SnapshotStateKt.mutableStateOf$default((Object)null, (SnapshotMutationPolicy)null, 2, (Object)null);
   public static final int $stable;

   private final Pair getDebugData() {
      State $this$getValue$iv = (State)this.debugData$delegate;
      KProperty property$iv = null;
      int $i$f$getValue = false;
      return (Pair)$this$getValue$iv.getValue();
   }

   private final void setDebugData(Pair var1) {
      MutableState $this$setValue$iv = this.debugData$delegate;
      KProperty property$iv = null;
      int $i$f$setValue = false;
      $this$setValue$iv.setValue(var1);
   }

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      ViewRootForTest.Companion.setOnViewCreatedCallback((Function1)(new Function1() {
         public final void invoke(@NotNull ViewRootForTest root) {
            Intrinsics.checkNotNullParameter(root, "root");
            PlaygroundActivity.this.root = root;
         }
      }));
      ComponentActivityKt.setContent$default((ComponentActivity)this, (CompositionContext)null, (Function2)ComposableLambdaKt.composableLambdaInstance(2023832317, true, new Function2() {
         @Composable
         @ComposableTarget(
            applier = "androidx.compose.ui.UiComposable"
         )
         public final void invoke(@Nullable Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C100@4136L1288:PlaygroundActivity.kt#qshby3");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
               $composer.skipToGroupEnd();
            } else {
               if (ComposerKt.isTraceInProgress()) {
                  ComposerKt.traceEventStart(2023832317, $changed, -1, "land.sungbin.androidplayground.PlaygroundActivity.onCreate.<anonymous> (PlaygroundActivity.kt:56)");
               }

               final Pair debugData = PlaygroundActivity.this.getDebugData();
               $composer.startReplaceableGroup(-729096822);
               ComposerKt.sourceInformation($composer, "58@2496L1624");
               if (debugData != null) {
                  AndroidPopup_androidKt.Popup((PopupPositionProvider)(new PopupPositionProvider() {
                     public long calculatePosition_llwVHH4/* $FF was: calculatePosition-llwVHH4*/(@NotNull IntRect anchorBounds, long windowSize, @NotNull LayoutDirection layoutDirection, long popupContentSize) {
                        Intrinsics.checkNotNullParameter(anchorBounds, "anchorBounds");
                        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                        int candidateX = false;
                        int candidateYx = false;
                        IntRect anchorBoundsx = IntRectKt.roundToIntRect((Rect)debugData.getFirst());
                        int candidateXx = RangesKt.coerceAtLeast(anchorBoundsx.getLeft() - IntSize.getWidth-impl(popupContentSize) / LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$arg-0$call-div$arg-0$call-minus$$$this$call-coerceAtLeast$set-candidateX$fun-calculatePosition$class-$no-name-provided$$arg-0$call-Popup$branch$if$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$arg-0$call-coerceAtLeast$set-candidateX$fun-calculatePosition$class-$no-name-provided$$arg-0$call-Popup$branch$if$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity());
                        if (candidateXx + IntSize.getWidth-impl(popupContentSize) > IntSize.getWidth-impl(windowSize)) {
                           candidateXx = RangesKt.coerceAtLeast(IntSize.getWidth-impl(windowSize) - IntSize.getWidth-impl(popupContentSize), LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$arg-0$call-coerceAtLeast$set-candidateX$branch$if$fun-calculatePosition$class-$no-name-provided$$arg-0$call-Popup$branch$if$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity());
                        }

                        int candidateY = RangesKt.coerceAtLeast(anchorBoundsx.getTop() - IntSize.getHeight-impl(popupContentSize), LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$arg-0$call-coerceAtLeast$set-candidateY$fun-calculatePosition$class-$no-name-provided$$arg-0$call-Popup$branch$if$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity());
                        if (candidateY + IntSize.getHeight-impl(popupContentSize) > IntSize.getHeight-impl(windowSize)) {
                           candidateY = RangesKt.coerceAtLeast(IntSize.getHeight-impl(windowSize) - IntSize.getHeight-impl(popupContentSize), LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$arg-0$call-coerceAtLeast$set-candidateY$branch$if-1$fun-calculatePosition$class-$no-name-provided$$arg-0$call-Popup$branch$if$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity());
                        }

                        return IntOffsetKt.IntOffset(candidateXx, candidateY);
                     }
                  }), (Function0)(new Function0() {
                     public final void invoke() {
                        PlaygroundActivity.this.setDebugData((Pair)null);
                     }
                  }), (PopupProperties)null, (Function2)ComposableLambdaKt.composableLambda($composer, -1876877514, true, new Function2() {
                     @Composable
                     @ComposableTarget(
                        applier = "androidx.compose.ui.UiComposable"
                     )
                     public final void invoke(@Nullable Composer $composer, int $changed) {
                        ComposerKt.sourceInformation($composer, "C88@3766L344:PlaygroundActivity.kt#qshby3");
                        if (($changed & 11) == 2 && $composer.getSkipping()) {
                           $composer.skipToGroupEnd();
                        } else {
                           if (ComposerKt.isTraceInProgress()) {
                              ComposerKt.traceEventStart(-1876877514, $changed, -1, "land.sungbin.androidplayground.PlaygroundActivity.onCreate.<anonymous>.<anonymous> (PlaygroundActivity.kt:88)");
                           }

                           Modifier var10000 = BackgroundKt.background-bw27NRU$default(SizeKt.wrapContentSize$default((Modifier)Modifier.Companion, (Alignment)null, false, 3, (Object)null), Color.copy-wmQWz5c$default(Color.Companion.getGray-0d7_KjU(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-0$call-copy$arg-0$call-background$$$this$call-padding$arg-0$call-Column$fun-$anonymous$$arg-3$call-Popup$branch$if$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity(), 0.0F, 0.0F, 0.0F, 14, (Object)null), (Shape)null, 2, (Object)null);
                           int $this$dp$iv = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$$$this$call-$get-dp$$arg-0$call-padding$arg-0$call-Column$fun-$anonymous$$arg-3$call-Popup$branch$if$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity();
                           int $i$f$getDp = false;
                           Modifier modifier$iv = PaddingKt.padding-3ABfNKs(var10000, Dp.constructor-impl((float)$this$dp$iv));
                           Arrangement var41 = Arrangement.INSTANCE;
                           int $this$dp$ivx = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$$$this$call-$get-dp$$arg-0$call-spacedBy$arg-1$call-Column$fun-$anonymous$$arg-3$call-Popup$branch$if$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity();
                           int $i$f$getDpx = false;
                           Vertical verticalArrangement$iv = (Vertical)var41.spacedBy-0680j_4(Dp.constructor-impl((float)$this$dp$ivx));
                           Pair var6 = debugData;
                           int $changed$ivx = 0;
                           int $i$f$Column = false;
                           $composer.startReplaceableGroup(-483455358);
                           ComposerKt.sourceInformation($composer, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                           Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                           MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, 14 & $changed$ivx >> 3 | 112 & $changed$ivx >> 3);
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
                           ComposerKt.sourceInformationMarkerStart($composer, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                           int var27 = 6 | 112 & $changed$ivx >> 6;
                           Composer $composerx = $composer;
                           ColumnScope var42 = (ColumnScope)ColumnScopeInstance.INSTANCE;
                           int var30 = false;
                           ComposerKt.sourceInformationMarkerStart($composer, -88642190, "C:PlaygroundActivity.kt#qshby3");
                           $composer.startReplaceableGroup(-14394014);
                           ComposerKt.sourceInformation($composer, "*95@4073L23");
                           Iterable $this$forEach$iv = (Iterable)var6.getSecond();
                           int $i$f$forEach = false;
                           Iterator var33 = $this$forEach$iv.iterator();

                           while(var33.hasNext()) {
                              Object element$iv = var33.next();
                              String debug = (String)element$iv;
                              int var36 = false;
                              TextKt.Text--4IGK_g(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-Text$fun-$anonymous$$arg-0$call-forEach$fun-$anonymous$$arg-3$call-Column$fun-$anonymous$$arg-3$call-Popup$branch$if$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity() + debug, (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composerx, 0, 0, 131070);
                           }

                           $composerx.endReplaceableGroup();
                           ComposerKt.sourceInformationMarkerEnd($composerx);
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
                  }), $composer, 3072, 4);
               }

               $composer.endReplaceableGroup();
               Modifier modifier$iv = DrawModifierKt.drawWithContent(SuspendingPointerInputFilterKt.pointerInput(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), PlaygroundActivity.this.debugNodes.hashCode(), (Function2)(new Function2((Continuation)null) {
                  int label;
                  // $FF: synthetic field
                  private Object L$0;

                  @Nullable
                  public final Object invokeSuspend(@NotNull Object $result) {
                     Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     switch(this.label) {
                     case 0:
                        ResultKt.throwOnFailure($result);
                        PointerInputScope $this$pointerInput = (PointerInputScope)this.L$0;
                        Function1 var10004 = (Function1)(new Function1() {
                           public final void invoke_k_4lQ0M/* $FF was: invoke-k-4lQ0M*/(long offset) {
                              Iterable $this$firstOrNull$iv = (Iterable)PlaygroundActivity.this.debugNodes.values();
                              int $i$f$firstOrNull = false;
                              Iterator var6 = $this$firstOrNull$iv.iterator();

                              Object var10000;
                              while(true) {
                                 if (var6.hasNext()) {
                                    Object element$iv = var6.next();
                                    SemanticsNode node = (SemanticsNode)element$iv;
                                    int var9 = false;
                                    if (!node.getBoundsInRoot().contains-k-4lQ0M(offset)) {
                                       continue;
                                    }

                                    var10000 = element$iv;
                                    break;
                                 }

                                 var10000 = null;
                                 break;
                              }

                              SemanticsNode target = (SemanticsNode)var10000;
                              if (target != null) {
                                 String[] var11 = new String[5];
                                 String var10002 = LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$0$vararg$arg-0$call-listOf$val-debug$branch$if$fun-$anonymous$$arg-3$call-detectTapGestures$fun-$anonymous$$arg-1$call-pointerInput$$$this$call-drawWithContent$arg-0$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity();
                                 var11[0] = var10002 + target.getId();
                                 var10002 = LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$1$vararg$arg-0$call-listOf$val-debug$branch$if$fun-$anonymous$$arg-3$call-detectTapGestures$fun-$anonymous$$arg-1$call-pointerInput$$$this$call-drawWithContent$arg-0$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity();
                                 var11[1] = var10002 + target.getBoundsInRoot();
                                 var10002 = LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$2$vararg$arg-0$call-listOf$val-debug$branch$if$fun-$anonymous$$arg-3$call-detectTapGestures$fun-$anonymous$$arg-1$call-pointerInput$$$this$call-drawWithContent$arg-0$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity();
                                 var11[2] = var10002 + target.getBoundsInWindow();
                                 var10002 = LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$3$vararg$arg-0$call-listOf$val-debug$branch$if$fun-$anonymous$$arg-3$call-detectTapGestures$fun-$anonymous$$arg-1$call-pointerInput$$$this$call-drawWithContent$arg-0$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity();
                                 var11[3] = var10002 + IntSize.toString-impl(target.getSize-YbymL2g());
                                 var10002 = LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$4$vararg$arg-0$call-listOf$val-debug$branch$if$fun-$anonymous$$arg-3$call-detectTapGestures$fun-$anonymous$$arg-1$call-pointerInput$$$this$call-drawWithContent$arg-0$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity();
                                 List var10003 = (List)SemanticsConfigurationKt.getOrNull(target.getConfig(), SemanticsProperties.INSTANCE.getText());
                                 var11[4] = var10002 + (var10003 != null ? (AnnotatedString)CollectionsKt.firstOrNull(var10003) : null);
                                 List debug = CollectionsKt.listOf(var11);
                                 PlaygroundActivity.this.setDebugData(TuplesKt.to(target.getBoundsInRoot(), debug));
                              } else {
                                 PlaygroundActivity.this.setDebugData((Pair)null);
                              }

                           }
                        });
                        Continuation var10005 = (Continuation)this;
                        this.label = 1;
                        if (TapGestureDetectorKt.detectTapGestures$default($this$pointerInput, (Function1)null, (Function1)null, (Function3)null, var10004, var10005, 7, (Object)null) == var3) {
                           return var3;
                        }
                        break;
                     case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                     default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     return Unit.INSTANCE;
                  }

                  @NotNull
                  public final Continuation create(@Nullable Object value, @NotNull Continuation $completion) {
                     Function2 var3 = new <anonymous constructor>($completion);
                     var3.L$0 = value;
                     return (Continuation)var3;
                  }

                  @Nullable
                  public final Object invoke(@NotNull PointerInputScope p1, @Nullable Continuation p2) {
                     return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                  }
               })), (Function1)(new Function1() {
                  public final void invoke(@NotNull ContentDrawScope $this$drawWithContent) {
                     Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
                     $this$drawWithContent.drawContent();
                     Iterable $this$forEach$iv = (Iterable)PlaygroundActivity.this.debugNodes.values();
                     int $i$f$forEach = false;
                     Iterator var4 = $this$forEach$iv.iterator();

                     while(var4.hasNext()) {
                        Object element$iv = var4.next();
                        SemanticsNode node = (SemanticsNode)element$iv;
                        int var7 = false;
                        DrawScope var10000 = (DrawScope)$this$drawWithContent;
                        long var10001 = Color.Companion.getRed-0d7_KjU();
                        long var10002 = node.getBoundsInRoot().getTopLeft-F1C5BW0();
                        long var10003 = IntSizeKt.toSize-ozmzZPI(node.getSize-YbymL2g());
                        int $this$dp$iv = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$$$this$call-$get-dp$$$$this$call-toPx$arg-0$call-$init$$arg-4$call-drawRect$fun-$anonymous$$arg-0$call-forEach$fun-$anonymous$$arg-0$call-drawWithContent$arg-0$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity();
                        int $i$f$getDp = false;
                        DrawScope.drawRect-n-J9OG0$default(var10000, var10001, var10002, var10003, 0.0F, (DrawStyle)(new Stroke($this$drawWithContent.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv)), 0.0F, 0, 0, (PathEffect)null, 30, (DefaultConstructorMarker)null)), (ColorFilter)null, 0, 104, (Object)null);
                     }

                  }
               }));
               Alignment contentAlignment$iv = Alignment.Companion.getCenter();
               int $changed$ivx = 48;
               int $i$f$Box = false;
               $composer.startReplaceableGroup(733328855);
               ComposerKt.sourceInformation($composer, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
               boolean propagateMinConstraints$iv = false;
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
               BoxScope var10000 = (BoxScope)BoxScopeInstance.INSTANCE;
               int var30 = false;
               ComposerKt.sourceInformationMarkerStart($composer, -14392681, "C133@5387L29:PlaygroundActivity.kt#qshby3");
               TextKt.Text--4IGK_g(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-Text$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity(), (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131070);
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
      }), 1, (Object)null);
   }

   public void onAttachedToWindow() {
      BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this), (CoroutineContext)null, (CoroutineStart)null, (Function2)(new Function2((Continuation)null) {
         int label;

         @Nullable
         public final Object invokeSuspend(@NotNull Object $result) {
            Object var10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            Continuation var10000;
            switch(this.label) {
            case 0:
               ResultKt.throwOnFailure($result);
               var10000 = (Continuation)this;
               this.label = 1;
               if (HandlerDispatcherKt.awaitFrame(var10000) == var10) {
                  return var10;
               }
               break;
            case 1:
               ResultKt.throwOnFailure($result);
               break;
            default:
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            do {
               if (PlaygroundActivity.this.root == null) {
                  System.out.println(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-println$branch$if$body$loop$fun-$anonymous$$arg-2$call-launch$fun-onAttachedToWindow$class-PlaygroundActivity());
               } else {
                  ViewRootForTest var11 = PlaygroundActivity.this.root;
                  if (var11 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("root");
                     var11 = null;
                  }

                  List $this$fastForEach$iv = SemanticsOwnerKt.getAllSemanticsNodes(var11.getSemanticsOwner(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$arg-0$call-getAllSemanticsNodes$$$this$call-fastForEach$body$loop$fun-$anonymous$$arg-2$call-launch$fun-onAttachedToWindow$class-PlaygroundActivity(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$arg-1$call-getAllSemanticsNodes$$$this$call-fastForEach$body$loop$fun-$anonymous$$arg-2$call-launch$fun-onAttachedToWindow$class-PlaygroundActivity());
                  PlaygroundActivity var3 = PlaygroundActivity.this;
                  int $i$f$fastForEach = false;
                  int index$iv = 0;

                  for(int var6 = $this$fastForEach$iv.size(); index$iv < var6; ++index$iv) {
                     Object item$iv = $this$fastForEach$iv.get(index$iv);
                     SemanticsNode node = (SemanticsNode)item$iv;
                     int var9 = false;
                     ((Map)var3.debugNodes).put(Boxing.boxInt(node.getId()), node);
                  }
               }

               var10000 = (Continuation)this;
               this.label = 1;
            } while(HandlerDispatcherKt.awaitFrame(var10000) != var10);

            return var10;
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

   static {
      $stable = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$class-PlaygroundActivity();
   }
}
