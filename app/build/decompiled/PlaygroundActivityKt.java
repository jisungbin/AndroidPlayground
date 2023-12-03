package land.sungbin.androidplayground;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import land.sungbin.composeinvestigator.runtime.ComposableInvalidationLogger;
import land.sungbin.composeinvestigator.runtime.ComposableInvalidationTrackTable;
import land.sungbin.composeinvestigator.runtime.ComposableInvalidationType;
import land.sungbin.composeinvestigator.runtime.ComposeInvestigatorConfig;
import land.sungbin.composeinvestigator.runtime.InvalidationReason;
import land.sungbin.composeinvestigator.runtime.ComposableInvalidationType.Processed;
import land.sungbin.composeinvestigator.runtime.ComposableInvalidationType.Skipped;
import land.sungbin.composeinvestigator.runtime.affect.AffectedComposable;
import land.sungbin.composeinvestigator.runtime.affect.AffectedField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"},
   d2 = {"A", "", "(Landroidx/compose/runtime/Composer;I)V", "app_debug"}
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivityKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,205:1\n154#2:206\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivityKt\n*L\n197#1:206\n*E\n"})
public final class PlaygroundActivityKt {
   @NotNull
   private static final ComposableInvalidationTrackTable ComposableInvalidationTrackTableImpl$PlaygroundActivityKt = new ComposableInvalidationTrackTable();

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void A(@Nullable Composer $composer, final int $changed) {
      $composer = $composer.startRestartGroup(-1556754418);
      ComposerKt.sourceInformation($composer, "C(A)194@7511L188:PlaygroundActivity.kt#qshby3");
      if ($changed == 0 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
         ComposableInvalidationTrackTableImpl$PlaygroundActivityKt.callListeners("fun-A(Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", new AffectedComposable("A", "land.sungbin.androidplayground.A", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 194, 0), (ComposableInvalidationType)Skipped.INSTANCE);
         ComposableInvalidationLogger.box-impl(ComposeInvestigatorConfig.INSTANCE.getInvalidationLogger-GB7v7qM()).invoke(new AffectedComposable("A", "land.sungbin.androidplayground.A", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 194, 0), Skipped.INSTANCE);
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1556754418, $changed, -1, "land.sungbin.androidplayground.A (PlaygroundActivity.kt:193)");
         }

         Modifier var10000 = (Modifier)Modifier.Companion;
         int $this$dp$iv = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$$$this$call-$get-dp$$arg-0$call-size$$$this$call-drawBehind$arg-0$call-Box$fun-A();
         int $i$f$getDp = false;
         BoxKt.Box(DrawModifierKt.drawBehind(SizeKt.size-3ABfNKs(var10000, Dp.constructor-impl((float)$this$dp$iv)), (Function1)null.INSTANCE), $composer, 0);
         InvalidationReason var4 = ComposableInvalidationTrackTableImpl$PlaygroundActivityKt.computeInvalidationReason("fun-A(Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", new AffectedField[0]);
         ComposableInvalidationTrackTableImpl$PlaygroundActivityKt.callListeners("fun-A(Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", new AffectedComposable("A", "land.sungbin.androidplayground.A", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 194, 0), (ComposableInvalidationType)(new Processed(var4)));
         ComposableInvalidationLogger.box-impl(ComposeInvestigatorConfig.INSTANCE.getInvalidationLogger-GB7v7qM()).invoke(new AffectedComposable("A", "land.sungbin.androidplayground.A", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 194, 0), new Processed(var4));
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var5 = $composer.endRestartGroup();
      if (var5 != null) {
         var5.updateScope((Function2)(new Function2() {
            public final void invoke(@Nullable Composer $composer, int $force) {
               PlaygroundActivityKt.A($composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
         }));
      }

   }

   // $FF: synthetic method
   public static final ComposableInvalidationTrackTable access$getComposableInvalidationTrackTableImpl$PlaygroundActivityKt$p() {
      return ComposableInvalidationTrackTableImpl$PlaygroundActivityKt;
   }
}
