package land.sungbin.androidplayground;

import androidx.collection.MutableIntObjectMap;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B^\u0012,\u0010\u0005\u001a(\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006¢\u0006\u0002\b\r\u0012!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\n\u0010+\u001a\u0004\u0018\u00010\fH\u0007J\b\u0010,\u001a\u00020\u0014H\u0016J\b\u0010-\u001a\u00020\u0012H\u0016J\b\u0010.\u001a\u00020\u0012H\u0016J\b\u0010/\u001a\u00020\u0012H\u0016J*\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u0010\u0016\u001a\u000205H\u0016ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u001a\u00108\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u000205H\u0016ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\b\u0010;\u001a\u00020\u0012H\u0016J\b\u0010<\u001a\u00020\u0014H\u0016J\u0006\u0010=\u001a\u00020\u0012J\f\u0010>\u001a\u00020\u0012*\u00020?H\u0016R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R5\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\u0005\u001a(\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006¢\u0006\u0002\b\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006@"},
   d2 = {"Lland/sungbin/androidplayground/SuspendBoundingPointerInputNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "rect", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Size;", "Lkotlin/ParameterName;", "name", "size", "Landroidx/compose/ui/geometry/Rect;", "Lkotlin/ExtensionFunctionType;", "onClick", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "offset", "", "semanticsEnabled", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Z)V", "bounds", "Landroidx/compose/ui/node/Ref;", "elementId", "", "lastSize", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "setOnClick", "(Lkotlin/jvm/functions/Function1;)V", "pointerInputDelegate", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "previousSemantics", "Landroidx/collection/MutableIntObjectMap;", "getRect", "()Lkotlin/jvm/functions/Function2;", "setRect", "(Lkotlin/jvm/functions/Function2;)V", "getSemanticsEnabled", "()Z", "setSemanticsEnabled", "(Z)V", "currentRect", "interceptOutOfBoundsChildEvents", "onCancelPointerInput", "onDensityChange", "onDetach", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onRemeasured", "onRemeasured-ozmzZPI", "(J)V", "onViewConfigurationChange", "sharePointerInputWithSiblings", "updateBounds", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "app_debug"}
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/SuspendBoundingPointerInputNode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,341:1\n1#2:342\n*E\n"})
final class SuspendBoundingPointerInputNode extends DelegatingNode implements PointerInputModifierNode, SemanticsModifierNode, LayoutAwareModifierNode {
   @NotNull
   private Function2 rect;
   @NotNull
   private Function1 onClick;
   private boolean semanticsEnabled;
   @NotNull
   private final Ref lastSize;
   @NotNull
   private final Ref bounds;
   @Nullable
   private MutableIntObjectMap previousSemantics;
   private final int elementId;
   @NotNull
   private final SuspendingPointerInputModifierNode pointerInputDelegate;

   public SuspendBoundingPointerInputNode(@NotNull Function2 rect, @NotNull Function1 onClick, boolean semanticsEnabled) {
      Intrinsics.checkNotNullParameter(rect, "rect");
      Intrinsics.checkNotNullParameter(onClick, "onClick");
      super();
      this.rect = rect;
      this.onClick = onClick;
      this.semanticsEnabled = semanticsEnabled;
      this.lastSize = new Ref();
      this.bounds = new Ref();
      this.elementId = PlaygroundActivityKt.access$getElementIdCounter$p().getAndIncrement();
      this.pointerInputDelegate = (SuspendingPointerInputModifierNode)this.delegate((DelegatableNode)SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode((Function2)(new Function2((Continuation)null) {
         int label;
         // $FF: synthetic field
         private Object L$0;

         @Nullable
         public final Object invokeSuspend(@NotNull Object $result) {
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
            case 0:
               ResultKt.throwOnFailure($result);
               PointerInputScope $this$SuspendingPointerInputModifierNode = (PointerInputScope)this.L$0;
               Function1 var10004 = (Function1)(new Function1() {
                  public final void invoke_k_4lQ0M/* $FF was: invoke-k-4lQ0M*/(long offset) {
                     Object var10000 = SuspendBoundingPointerInputNode.this.bounds.getValue();
                     if (var10000 == null) {
                        int var4 = false;
                        String var5 = "A click event was requested before the click area was calculated.";
                        throw new IllegalStateException(var5.toString());
                     } else {
                        Rect bounds = (Rect)var10000;
                        if (bounds.contains-k-4lQ0M(offset)) {
                           SuspendBoundingPointerInputNode.this.getOnClick().invoke(Offset.box-impl(offset));
                        }

                     }
                  }
               });
               Continuation var10005 = (Continuation)this;
               this.label = 1;
               if (TapGestureDetectorKt.detectTapGestures$default($this$SuspendingPointerInputModifierNode, (Function1)null, (Function1)null, (Function3)null, var10004, var10005, 7, (Object)null) == var3) {
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
      })));
   }

   @NotNull
   public final Function2 getRect() {
      return this.rect;
   }

   public final void setRect(@NotNull Function2 var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.rect = var1;
   }

   @NotNull
   public final Function1 getOnClick() {
      return this.onClick;
   }

   public final void setOnClick(@NotNull Function1 var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.onClick = var1;
   }

   public final boolean getSemanticsEnabled() {
      return this.semanticsEnabled;
   }

   public final void setSemanticsEnabled(boolean var1) {
      this.semanticsEnabled = var1;
   }

   public final void updateBounds() {
      Object var10000 = this.lastSize.getValue();
      if (var10000 == null) {
         int var3 = false;
         String var4 = LiveLiterals$PlaygroundActivityKt.INSTANCE.String$fun-$anonymous$$arg-1$call-checkNotNull$val-size$fun-updateBounds$class-SuspendBoundingPointerInputNode();
         throw new IllegalStateException(var4.toString());
      } else {
         long size = ((Size)var10000).unbox-impl();
         this.bounds.setValue(this.rect.invoke(DelegatableNodeKt.requireDensity((DelegatableNode)this), Size.box-impl(size)));
         if (this.semanticsEnabled) {
            SemanticsConfiguration var10001 = DelegatableNodeKt.requireLayoutNode((DelegatableNode)this).getCollapsedSemantics$ui_release();
            this.previousSemantics = var10001 != null ? (MutableIntObjectMap)SemanticsConfigurationKt.getOrNull(var10001, PlaygroundActivityKt.access$getPointerInputBounds$p()) : null;
            SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode)this);
         }

      }
   }

   @TestOnly
   @Nullable
   public final Rect currentRect() {
      return (Rect)this.bounds.getValue();
   }

   public void onRemeasured_ozmzZPI/* $FF was: onRemeasured-ozmzZPI*/(long size) {
      this.lastSize.setValue(Size.box-impl(IntSizeKt.toSize-ozmzZPI(size)));
      System.out.println(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-println$fun-onRemeasured$class-SuspendBoundingPointerInputNode() + IntSize.toString-impl(size));
      this.updateBounds();
   }

   public void onPointerEvent_H0pRuoY/* $FF was: onPointerEvent-H0pRuoY*/(@NotNull PointerEvent pointerEvent, @NotNull PointerEventPass pass, long bounds) {
      Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
      Intrinsics.checkNotNullParameter(pass, "pass");
      this.pointerInputDelegate.onPointerEvent-H0pRuoY(pointerEvent, pass, bounds);
   }

   public void applySemantics(@NotNull SemanticsPropertyReceiver $this$applySemantics) {
      Intrinsics.checkNotNullParameter($this$applySemantics, "<this>");
      SemanticsPropertiesKt.onClick($this$applySemantics, LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-onClick$fun-applySemantics$class-SuspendBoundingPointerInputNode(), (Function0)(new Function0() {
         @NotNull
         public final Boolean invoke() {
            SuspendBoundingPointerInputNode.this.getOnClick().invoke(Offset.box-impl(Offset.Companion.getZero-F1C5BW0()));
            return LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$fun-$anonymous$$arg-1$call-onClick$fun-applySemantics$class-SuspendBoundingPointerInputNode();
         }
      }));
      if (this.semanticsEnabled) {
         Rect var10000 = (Rect)this.bounds.getValue();
         if (var10000 != null) {
            Rect value = var10000;
            int var6 = false;
            final MutableIntObjectMap previous = this.previousSemantics;
            MutableIntObjectMap var11;
            if (previous != null) {
               PlaygroundActivityKt.access$getDirtyElementIds$p().removeIf(SuspendBoundingPointerInputNode::applySemantics$lambda$2$lambda$1);
               var11 = previous;
            } else {
               var11 = new MutableIntObjectMap(0, 1, (DefaultConstructorMarker)null);
            }

            MutableIntObjectMap var3 = var11;
            SemanticsPropertyKey var9 = PlaygroundActivityKt.access$getPointerInputBounds$p();
            var6 = false;
            var3.put(this.elementId, value);
            Unit var10 = Unit.INSTANCE;
            $this$applySemantics.set(var9, var3);
         }
      }
   }

   public void onViewConfigurationChange() {
      this.pointerInputDelegate.onViewConfigurationChange();
      this.updateBounds();
   }

   public void onDensityChange() {
      this.pointerInputDelegate.onDensityChange();
      this.updateBounds();
   }

   public void onCancelPointerInput() {
      this.pointerInputDelegate.onCancelPointerInput();
   }

   public boolean interceptOutOfBoundsChildEvents() {
      return this.pointerInputDelegate.interceptOutOfBoundsChildEvents();
   }

   public boolean sharePointerInputWithSiblings() {
      return this.pointerInputDelegate.sharePointerInputWithSiblings();
   }

   public void onDetach() {
      if (this.semanticsEnabled) {
         ((Collection)PlaygroundActivityKt.access$getDirtyElementIds$p()).add(this.elementId);
         SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode)this);
      }
   }

   private static final boolean applySemantics$lambda$2$lambda$1(Function1 $tmp0, Object p0) {
      Intrinsics.checkNotNullParameter($tmp0, "$tmp0");
      return (Boolean)$tmp0.invoke(p0);
   }
}
