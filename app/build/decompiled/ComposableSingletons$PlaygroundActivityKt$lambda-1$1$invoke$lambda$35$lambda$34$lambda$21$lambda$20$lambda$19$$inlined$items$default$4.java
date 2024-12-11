package land.sungbin.androidplayground;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.Arrangement.Vertical;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 0, 0},
   k = 3,
   xi = 48,
   d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"},
   d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V", "androidx/compose/foundation/lazy/LazyDslKt$items$4"}
)
@SourceDebugExtension({"SMAP\nLazyDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt$items$4\n+ 2 PlaygroundActivity.kt\nland/sungbin/androidplayground/ComposableSingletons$PlaygroundActivityKt$lambda-1$1\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 4 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 5 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 6 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 7 Composer.kt\nandroidx/compose/runtime/Updater\n+ 8 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,433:1\n110#2,3:434\n114#2,3:475\n118#2,2:484\n120#2:490\n149#3:437\n86#4:438\n82#4,7:439\n89#4:474\n93#4:489\n79#5,6:446\n86#5,4:461\n90#5,2:471\n94#5:488\n368#6,9:452\n377#6:473\n378#6,2:486\n4034#7,6:465\n1225#8,6:478\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/ComposableSingletons$PlaygroundActivityKt$lambda-1$1\n*L\n112#1:437\n110#1:438\n110#1:439,7\n110#1:474\n110#1:489\n110#1:446,6\n110#1:461,4\n110#1:471,2\n110#1:488\n110#1:452,9\n110#1:473\n110#1:486,2\n110#1:465,6\n116#1:478,6\n*E\n"})
public final class ComposableSingletons$PlaygroundActivityKt$lambda-1$1$invoke$lambda$35$lambda$34$lambda$21$lambda$20$lambda$19$$inlined$items$default$4 extends Lambda implements Function4 {
   // $FF: synthetic field
   final List $items;
   // $FF: synthetic field
   final MutableState $selectedFontWeight$delegate$inlined;

   public ComposableSingletons$PlaygroundActivityKt$lambda_1$1$invoke$lambda$35$lambda$34$lambda$21$lambda$20$lambda$19$$inlined$items$default$4/* $FF was: ComposableSingletons$PlaygroundActivityKt$lambda-1$1$invoke$lambda$35$lambda$34$lambda$21$lambda$20$lambda$19$$inlined$items$default$4*/(List $items, MutableState var2) {
      super(4);
      this.$items = $items;
      this.$selectedFontWeight$delegate$inlined = var2;
   }

   @Composable
   public final void invoke(@NotNull LazyItemScope $this$items, int it, @Nullable Composer $composer, int $changed) {
      // $FF: Couldn't be decompiled
   }
}
