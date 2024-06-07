package land.sungbin.androidplayground;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.activity.ComponentActivity;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.CompositionContext;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00050\n¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\f\u001a\f\u0010\r\u001a\u00020\u0005*\u00020\u0006H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"},
   d2 = {"DEBUG_POPUP_ID", "", "DefaultActivityContentLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "setDebugContent", "", "Landroidx/activity/ComponentActivity;", "parent", "Landroidx/compose/runtime/CompositionContext;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/activity/ComponentActivity;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setOwners", "app_debug"}
)
public final class DebugComposeViewKt {
   @NotNull
   private static final String DEBUG_POPUP_ID;
   @NotNull
   private static final LayoutParams DefaultActivityContentLayoutParams;

   @ComposableInferredTarget(
      scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]"
   )
   public static final void setDebugContent(@NotNull ComponentActivity $this$setDebugContent, @Nullable CompositionContext parent, @NotNull Function2 content) {
      Intrinsics.checkNotNullParameter($this$setDebugContent, "<this>");
      Intrinsics.checkNotNullParameter(content, "content");
      View var4 = ((ViewGroup)$this$setDebugContent.getWindow().getDecorView().findViewById(16908290)).getChildAt(LiveLiterals$DebugComposeViewKt.INSTANCE.Int$arg-0$call-getChildAt$val-existingDebugView$fun-setDebugContent());
      DebugComposeView existingDebugView = var4 instanceof DebugComposeView ? (DebugComposeView)var4 : null;
      if (existingDebugView != null) {
         int var5 = false;
         existingDebugView.setParentCompositionContext(parent);
         existingDebugView.setContent(content);
      } else {
         DebugComposeView var7 = new DebugComposeView((Context)$this$setDebugContent, (AttributeSet)null, 0, 6, (DefaultConstructorMarker)null);
         int var6 = false;
         var7.setParentCompositionContext(parent);
         var7.setContent(content);
         setOwners($this$setDebugContent);
         $this$setDebugContent.setContentView((View)var7, DefaultActivityContentLayoutParams);
      }

   }

   // $FF: synthetic method
   public static void setDebugContent$default(ComponentActivity var0, CompositionContext var1, Function2 var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = null;
      }

      setDebugContent(var0, var1, var2);
   }

   private static final void setOwners(ComponentActivity $this$setOwners) {
      View var10000 = $this$setOwners.getWindow().getDecorView();
      Intrinsics.checkNotNullExpressionValue(var10000, "getDecorView(...)");
      View decorView = var10000;
      if (ViewTreeLifecycleOwner.get(decorView) == null) {
         ViewTreeLifecycleOwner.set(decorView, (LifecycleOwner)$this$setOwners);
      }

      if (ViewTreeViewModelStoreOwner.get(decorView) == null) {
         ViewTreeViewModelStoreOwner.set(decorView, (ViewModelStoreOwner)$this$setOwners);
      }

      if (ViewTreeSavedStateRegistryOwner.get(decorView) == null) {
         ViewTreeSavedStateRegistryOwner.set(decorView, (SavedStateRegistryOwner)$this$setOwners);
      }

   }

   // $FF: synthetic method
   public static final String access$getDEBUG_POPUP_ID$p() {
      return DEBUG_POPUP_ID;
   }

   static {
      String var10000 = UUID.randomUUID().toString();
      Intrinsics.checkNotNullExpressionValue(var10000, "toString(...)");
      DEBUG_POPUP_ID = var10000;
      DefaultActivityContentLayoutParams = new LayoutParams(-2, -2);
   }
}
