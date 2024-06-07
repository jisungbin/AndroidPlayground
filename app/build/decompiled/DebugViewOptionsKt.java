package land.sungbin.androidplayground;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"},
   d2 = {"debugView", "Landroidx/compose/ui/Modifier;", "app_debug"}
)
public final class DebugViewOptionsKt {
   @NotNull
   public static final Modifier debugView(@NotNull Modifier $this$debugView) {
      Intrinsics.checkNotNullParameter($this$debugView, "<this>");
      return SemanticsModifierKt.semantics$default($this$debugView, false, (Function1)null.INSTANCE, 1, (Object)null);
   }
}
