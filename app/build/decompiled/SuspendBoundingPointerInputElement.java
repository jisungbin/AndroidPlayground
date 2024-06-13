package land.sungbin.androidplayground;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u008c\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007\u0012,\u0010\b\u001a(\u0012\u0004\u0012\u00020\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\u0002\b\u0010\u0012!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\b\u0010&\u001a\u00020\u0002H\u0016J\u0013\u0010'\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u0002H\u0016J\f\u0010-\u001a\u00020\u0015*\u00020.H\u0016R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001f\u0010\u0006\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR,\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0012¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R7\u0010\b\u001a(\u0012\u0004\u0012\u00020\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\u0002\b\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006/"},
   d2 = {"Lland/sungbin/androidplayground/SuspendBoundingPointerInputElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Lland/sungbin/androidplayground/SuspendBoundingPointerInputNode;", "key1", "", "key2", "keys", "", "rect", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Size;", "Lkotlin/ParameterName;", "name", "size", "Landroidx/compose/ui/geometry/Rect;", "Lkotlin/ExtensionFunctionType;", "onClick", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "offset", "", "semanticsEnabled", "", "(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Z)V", "instance", "getKey1", "()Ljava/lang/Object;", "getKey2", "getKeys", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "getRect", "()Lkotlin/jvm/functions/Function2;", "getSemanticsEnabled", "()Z", "create", "equals", "other", "hashCode", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "app_debug"}
)
final class SuspendBoundingPointerInputElement extends ModifierNodeElement {
   @Nullable
   private final Object key1;
   @Nullable
   private final Object key2;
   @Nullable
   private final Object[] keys;
   @NotNull
   private final Function2 rect;
   @NotNull
   private final Function1 onClick;
   private final boolean semanticsEnabled;
   @Nullable
   private SuspendBoundingPointerInputNode instance;

   public SuspendBoundingPointerInputElement(@Nullable Object key1, @Nullable Object key2, @Nullable Object[] keys, @NotNull Function2 rect, @NotNull Function1 onClick, boolean semanticsEnabled) {
      Intrinsics.checkNotNullParameter(rect, "rect");
      Intrinsics.checkNotNullParameter(onClick, "onClick");
      super();
      this.key1 = key1;
      this.key2 = key2;
      this.keys = keys;
      this.rect = rect;
      this.onClick = onClick;
      this.semanticsEnabled = semanticsEnabled;
   }

   // $FF: synthetic method
   public SuspendBoundingPointerInputElement(Object var1, Object var2, Object[] var3, Function2 var4, Function1 var5, boolean var6, int var7, DefaultConstructorMarker var8) {
      if ((var7 & 1) != 0) {
         var1 = null;
      }

      if ((var7 & 2) != 0) {
         var2 = null;
      }

      if ((var7 & 4) != 0) {
         var3 = null;
      }

      this(var1, var2, var3, var4, var5, var6);
   }

   @Nullable
   public final Object getKey1() {
      return this.key1;
   }

   @Nullable
   public final Object getKey2() {
      return this.key2;
   }

   @Nullable
   public final Object[] getKeys() {
      return this.keys;
   }

   @NotNull
   public final Function2 getRect() {
      return this.rect;
   }

   @NotNull
   public final Function1 getOnClick() {
      return this.onClick;
   }

   public final boolean getSemanticsEnabled() {
      return this.semanticsEnabled;
   }

   @NotNull
   public SuspendBoundingPointerInputNode create() {
      SuspendBoundingPointerInputNode var1 = new SuspendBoundingPointerInputNode(this.rect, this.onClick, this.semanticsEnabled);
      int var3 = false;
      this.instance = var1;
      return var1;
   }

   public void update(@NotNull SuspendBoundingPointerInputNode node) {
      Intrinsics.checkNotNullParameter(node, "node");
      node.setRect(this.rect);
      node.setOnClick(this.onClick);
      node.setSemanticsEnabled(this.semanticsEnabled);
      node.updateBounds();
      this.instance = node;
   }

   public void inspectableProperties(@NotNull InspectorInfo $this$inspectableProperties) {
      Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
      SuspendBoundingPointerInputNode instance = this.instance;
      $this$inspectableProperties.setName(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-$set-name$$fun-inspectableProperties$class-SuspendBoundingPointerInputElement());
      if (instance == null) {
         $this$inspectableProperties.setValue(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-$set-value$$branch$if$fun-inspectableProperties$class-SuspendBoundingPointerInputElement());
      } else {
         $this$inspectableProperties.getProperties().set(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-set$else$if$fun-inspectableProperties$class-SuspendBoundingPointerInputElement(), instance.currentRect());
         $this$inspectableProperties.getProperties().set(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-set-1$else$if$fun-inspectableProperties$class-SuspendBoundingPointerInputElement(), this.onClick);
         $this$inspectableProperties.getProperties().set(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-set-2$else$if$fun-inspectableProperties$class-SuspendBoundingPointerInputElement(), this.semanticsEnabled);
      }

   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$branch$if$fun-equals$class-SuspendBoundingPointerInputElement();
      } else if (!(other instanceof SuspendBoundingPointerInputElement)) {
         return LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$branch$if-1$fun-equals$class-SuspendBoundingPointerInputElement();
      } else if (!Intrinsics.areEqual(this.key1, ((SuspendBoundingPointerInputElement)other).key1)) {
         return LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$branch$if-2$fun-equals$class-SuspendBoundingPointerInputElement();
      } else if (!Intrinsics.areEqual(this.key2, ((SuspendBoundingPointerInputElement)other).key2)) {
         return LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$branch$if-3$fun-equals$class-SuspendBoundingPointerInputElement();
      } else {
         if (this.keys != null) {
            if (((SuspendBoundingPointerInputElement)other).keys == null) {
               return LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$branch$if$branch$if-4$fun-equals$class-SuspendBoundingPointerInputElement();
            }

            if (!Arrays.equals(this.keys, ((SuspendBoundingPointerInputElement)other).keys)) {
               return LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$branch$if-1$branch$if-4$fun-equals$class-SuspendBoundingPointerInputElement();
            }
         } else if (((SuspendBoundingPointerInputElement)other).keys != null) {
            return LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$branch-1$if-4$fun-equals$class-SuspendBoundingPointerInputElement();
         }

         return LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$fun-equals$class-SuspendBoundingPointerInputElement();
      }
   }

   public int hashCode() {
      Object var10000 = this.key1;
      int result = var10000 != null ? var10000.hashCode() : 0;
      int var2 = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$$this$call-times$$this$call-plus$set-result$fun-hashCode$class-SuspendBoundingPointerInputElement() * result;
      Object var10001 = this.key2;
      result = var2 + (var10001 != null ? var10001.hashCode() : 0);
      result = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$$this$call-times$$this$call-plus$set-result-1$fun-hashCode$class-SuspendBoundingPointerInputElement() * result + Arrays.hashCode(this.keys);
      return result;
   }
}
