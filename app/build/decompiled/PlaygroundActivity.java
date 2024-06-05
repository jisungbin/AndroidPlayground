package land.sungbin.androidplayground;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnPlacedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ViewRootForTest;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsOwnerKt;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
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
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000e"},
   d2 = {"Lland/sungbin/androidplayground/PlaygroundActivity;", "Landroidx/activity/ComponentActivity;", "()V", "debugBounds", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "", "Landroidx/compose/ui/geometry/Rect;", "root", "Landroidx/compose/ui/platform/ViewRootForTest;", "onAttachedToWindow", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)
@StabilityInferred(
   parameters = 0
)
public final class PlaygroundActivity extends ComponentActivity {
   private ViewRootForTest root;
   @NotNull
   private final SnapshotStateMap debugBounds = SnapshotStateKt.mutableStateMapOf();
   public static final int $stable;

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
            ComposerKt.sourceInformation($composer, "C36@1474L1567:PlaygroundActivity.kt#qshby3");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
               $composer.skipToGroupEnd();
            } else {
               if (ComposerKt.isTraceInProgress()) {
                  ComposerKt.traceEventStart(2023832317, $changed, -1, "land.sungbin.androidplayground.PlaygroundActivity.onCreate.<anonymous> (PlaygroundActivity.kt:36)");
               }

               Modifier modifier$iv = DrawModifierKt.drawWithContent(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), (Function1)(new Function1() {
                  public final void invoke(@NotNull ContentDrawScope $this$drawWithContent) {
                     Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
                     $this$drawWithContent.drawContent();
                     Iterable $this$forEach$iv = (Iterable)PlaygroundActivity.this.debugBounds.values();
                     int $i$f$forEach = false;
                     Iterator var4 = $this$forEach$iv.iterator();

                     while(var4.hasNext()) {
                        Object element$iv = var4.next();
                        Rect bounds = (Rect)element$iv;
                        int var7 = false;
                        DrawScope var10000 = (DrawScope)$this$drawWithContent;
                        long var10001 = Color.Companion.getRed-0d7_KjU();
                        long var10002 = bounds.getTopLeft-F1C5BW0();
                        long var10003 = bounds.getSize-NH-jbRc();
                        int $this$dp$iv = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$$$this$call-$get-dp$$$$this$call-toPx$arg-0$call-$init$$arg-4$call-drawRect$fun-$anonymous$$arg-0$call-forEach$fun-$anonymous$$arg-0$call-drawWithContent$arg-0$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity();
                        int $i$f$getDp = false;
                        DrawScope.drawRect-n-J9OG0$default(var10000, var10001, var10002, var10003, 0.0F, (DrawStyle)(new Stroke($this$drawWithContent.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv)), 0.0F, 0, 0, (PathEffect)null, 30, (DefaultConstructorMarker)null)), (ColorFilter)null, 0, 104, (Object)null);
                     }

                  }
               }));
               Alignment contentAlignment$iv = Alignment.Companion.getCenter();
               final PlaygroundActivity var6 = PlaygroundActivity.this;
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
               ComposerKt.sourceInformationMarkerStart($composer, -14396134, "C52@1934L1099:PlaygroundActivity.kt#qshby3");
               Modifier var31 = OnPlacedModifierKt.onPlaced((Modifier)Modifier.Companion, (Function1)(new Function1() {
                  public final void invoke(@NotNull LayoutCoordinates it) {
                     Intrinsics.checkNotNullParameter(it, "it");
                     ViewRootForTest var10000 = var6.root;
                     if (var10000 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("root");
                        var10000 = null;
                     }

                     List allNodes = SemanticsOwnerKt.getAllSemanticsNodes(var10000.getSemanticsOwner(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$arg-0$call-getAllSemanticsNodes$val-allNodes$fun-$anonymous$$arg-0$call-onPlaced$val-tmp0_modifier$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$arg-1$call-getAllSemanticsNodes$val-allNodes$fun-$anonymous$$arg-0$call-onPlaced$val-tmp0_modifier$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity());
                     System.out.print(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-print$fun-$anonymous$$arg-0$call-onPlaced$val-tmp0_modifier$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity());
                     System.out.println(CollectionsKt.joinToString$default((Iterable)allNodes, (CharSequence)null, (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null.INSTANCE, 31, (Object)null));
                     int $i$f$fastFirstOrNull = false;
                     List $this$fastForEach$iv$iv = allNodes;
                     int result = false;
                     int index$iv$iv = 0;
                     int var10 = allNodes.size();

                     Object var18;
                     while(true) {
                        if (index$iv$iv >= var10) {
                           var18 = null;
                           break;
                        }

                        Object item$iv$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
                        int var13 = false;
                        SemanticsNode node = (SemanticsNode)item$iv$iv;
                        int var15 = false;
                        if (node.getConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                           var18 = item$iv$iv;
                           break;
                        }

                        ++index$iv$iv;
                     }

                     SemanticsNode var19 = (SemanticsNode)var18;
                     if ((SemanticsNode)var18 != null) {
                        SemanticsNode textNode = var19;
                        ArrayList var5 = new ArrayList();
                        int var17 = false;
                        Function var20 = ((AccessibilityAction)textNode.getConfig().get(SemanticsActions.INSTANCE.getGetTextLayoutResult())).getAction();
                        Intrinsics.checkNotNull(var20);
                        result = (Boolean)((Function1)var20).invoke(var5);
                        if (!result) {
                           System.out.println(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-println$branch$if$fun-$anonymous$$arg-0$call-apply$val-textLayouts$fun-$anonymous$$arg-0$call-onPlaced$val-tmp0_modifier$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity());
                        } else {
                           TextLayoutInput layout = ((TextLayoutResult)CollectionsKt.first((List)var5)).getLayoutInput();
                           var17 = false;
                           String var21 = LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-let$fun-$anonymous$$arg-0$call-onPlaced$val-tmp0_modifier$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity();
                           System.out.println(var21 + layout.getText() + LiveLiterals$PlaygroundActivityKt.INSTANCE.String$2$str$arg-0$call-println$fun-$anonymous$$arg-0$call-let$fun-$anonymous$$arg-0$call-onPlaced$val-tmp0_modifier$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity());
                           System.out.println(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-println-1$fun-$anonymous$$arg-0$call-let$fun-$anonymous$$arg-0$call-onPlaced$val-tmp0_modifier$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity() + layout.getStyle());
                           System.out.println(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-println-2$fun-$anonymous$$arg-0$call-let$fun-$anonymous$$arg-0$call-onPlaced$val-tmp0_modifier$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity() + Constraints.toString-impl(layout.getConstraints-msEJaDk()));
                           System.out.println(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-println-3$fun-$anonymous$$arg-0$call-let$fun-$anonymous$$arg-0$call-onPlaced$val-tmp0_modifier$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity() + layout.getDensity().getDensity());
                        }
                     }
                  }
               }));
               TextKt.Text--4IGK_g(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-Text$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity(), var31, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131068);
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
                     ((Map)var3.debugBounds).put(Boxing.boxInt(node.getId()), node.getBoundsInRoot());
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
