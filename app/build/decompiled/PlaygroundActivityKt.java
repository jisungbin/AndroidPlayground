package land.sungbin.androidplayground;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a(\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0087\u0002¢\u0006\u0002\u0010\b¨\u0006\t"},
   d2 = {"use", "", "a", "", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Lkotlin/Unit;Ljava/lang/Object;Lkotlin/reflect/KProperty;Landroidx/compose/runtime/Composer;I)V", "app_debug"}
)
public final class PlaygroundActivityKt {
   private static final void use(Object a) {
   }

   @Composable
   public static final void getValue(@NotNull Unit $this$getValue, @Nullable Object thisRef, @NotNull KProperty property, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter($this$getValue, "<this>");
      Intrinsics.checkNotNullParameter(property, "property");
      $composer = $composer.startRestartGroup(-1275297804);
      ComposerKt.sourceInformation($composer, "C(getValue)N(thisRef,property)23@593L24:PlaygroundActivity.kt#qshby3");
      int $dirty = $changed;
      if (($changed & 384) == 0) {
         $dirty = $changed | ($composer.changedInstance(property) ? 256 : 128);
      }

      if ($composer.shouldExecute(($dirty & 129) != 128, $dirty & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1275297804, $dirty, -1, "land.sungbin.androidplayground.getValue (PlaygroundActivity.kt:22)");
         }

         BasicTextKt.BasicText-RWo7tUw(property.getName(), (Modifier)null, (TextStyle)null, (Function1)null, 0, false, 0, 0, (ColorProducer)null, (TextAutoSize)null, $composer, 0, 1022);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      } else {
         $composer.skipToGroupEnd();
      }

      ScopeUpdateScope var10000 = $composer.endRestartGroup();
      if (var10000 != null) {
         var10000.updateScope(PlaygroundActivityKt::getValue$lambda$0);
      }

   }

   private static final Unit getValue$lambda$0(Unit $this_getValue, Object $thisRef, KProperty $property, int $$changed, Composer $composer, int $force) {
      getValue($this_getValue, $thisRef, $property, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }
}
