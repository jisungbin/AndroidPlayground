package land.sungbin.androidplayground;

import androidx.compose.ui.semantics.SemanticsNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\n¨\u0006\u0005"},
   d2 = {"invoke", "Lland/sungbin/androidplayground/DebugData;", "Lland/sungbin/androidplayground/DebugData$Resolver;", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "app_debug"}
)
public final class DebugDataKt {
   @NotNull
   public static final DebugData invoke(@NotNull DebugData.Resolver $this$invoke, @NotNull SemanticsNode node) {
      Intrinsics.checkNotNullParameter($this$invoke, "<this>");
      Intrinsics.checkNotNullParameter(node, "node");
      int $i$f$invoke = false;
      return $this$invoke.resolve(node);
   }
}
