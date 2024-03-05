package land.sungbin.androidplayground;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.material.ButtonColors;
import androidx.compose.material.ButtonElevation;
import androidx.compose.material.ButtonKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import land.sungbin.composeinvestigator.runtime.ComposableInvalidationTrackTable;
import land.sungbin.composeinvestigator.runtime.ComposableInvalidationType;
import land.sungbin.composeinvestigator.runtime.ComposeInvestigatorConfig;
import land.sungbin.composeinvestigator.runtime.InvalidationReason;
import land.sungbin.composeinvestigator.runtime.StateObjectGetter;
import land.sungbin.composeinvestigator.runtime.StateObjectTrackerKt;
import land.sungbin.composeinvestigator.runtime.StateValueGetter;
import land.sungbin.composeinvestigator.runtime.ComposableInvalidationType.Processed;
import land.sungbin.composeinvestigator.runtime.ComposableInvalidationType.Skipped;
import land.sungbin.composeinvestigator.runtime.InvalidationReason.Invalidate;
import land.sungbin.composeinvestigator.runtime.affect.AffectedComposable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002¨\u0006\u0003²\u0006\n\u0010\u0004\u001a\u00020\u0005X\u008a\u008e\u0002"},
   d2 = {"Home", "", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "number2", ""}
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivityKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 SnapshotIntState.kt\nandroidx/compose/runtime/SnapshotIntStateKt__SnapshotIntStateKt\n*L\n1#1,198:1\n1116#2,6:199\n1116#2,6:205\n1116#2,6:211\n1116#2,6:217\n75#3:223\n108#3,2:224\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivityKt\n*L\n187#1:199,6\n188#1:205,6\n189#1:211,6\n191#1:217,6\n188#1:223\n188#1:224,2\n*E\n"})
public final class PlaygroundActivityKt {
   @NotNull
   private static final ComposableInvalidationTrackTable ComposableInvalidationTrackTableImpl$PlaygroundActivityKt = new ComposableInvalidationTrackTable();
   @NotNull
   public static final Stack ComposableCallstackTrackerImpl$PlaygroundActivityKt = new Stack();

   @NotNull
   public static final Stack getComposableCallstackTrackerImpl$PlaygroundActivityKt() {
      return ComposableCallstackTrackerImpl$PlaygroundActivityKt;
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final void Home(Composer $composer, final int $changed) {
      $composer = $composer.startRestartGroup(-980793304);
      ComposerKt.sourceInformation($composer, "C(Home)186@7233L33,187@7284L33,188@7330L57,190@7408L41,190@7391L101:PlaygroundActivity.kt#qshby3");
      if ($changed == 0 && $composer.getSkipping()) {
         ComposableInvalidationTrackTableImpl$PlaygroundActivityKt.callListeners("fun-Home(Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", new AffectedComposable("Home", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 186, 8), (ComposableInvalidationType)Skipped.INSTANCE);
         ComposeInvestigatorConfig.INSTANCE.getInvalidationLogger().invoke(CollectionsKt.toList((Iterable)ComposableCallstackTrackerImpl$PlaygroundActivityKt), new AffectedComposable("Home", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 186, 8), (ComposableInvalidationType)Skipped.INSTANCE);
         $composer.skipToGroupEnd();
      } else {
         List var2 = (List)(new ArrayList());
         InvalidationReason var3 = ComposableInvalidationTrackTableImpl$PlaygroundActivityKt.computeInvalidationReason("fun-Home(Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", var2);
         ComposableInvalidationTrackTableImpl$PlaygroundActivityKt.callListeners("fun-Home(Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", new AffectedComposable("Home", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 186, 8), (ComposableInvalidationType)(new Processed(var3)));
         ComposeInvestigatorConfig.INSTANCE.getInvalidationLogger().invoke(CollectionsKt.toList((Iterable)ComposableCallstackTrackerImpl$PlaygroundActivityKt), new AffectedComposable("Home", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 186, 8), (ComposableInvalidationType)(new Processed(var3)));
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-980793304, $changed, -1, "land.sungbin.androidplayground.Home (PlaygroundActivity.kt:185)");
         }

         $composer.startReplaceableGroup(-255238855);
         ComposerKt.sourceInformation($composer, "CC(remember):PlaygroundActivity.kt#9igjgp");
         boolean invalid$iv = false;
         int invalid$iv = false;
         Object it$iv = $composer.rememberedValue();
         int $i$f$cache = false;
         boolean var11;
         Object var10000;
         if (it$iv == Composer.Companion.getEmpty()) {
            var11 = false;
            Object value$iv = SnapshotIntStateKt.mutableIntStateOf(LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$arg-0$call-mutableIntStateOf$fun-$anonymous$$arg-0$call-remember$val-number$fun-Home());
            $composer.updateRememberedValue(value$iv);
            var10000 = value$iv;
         } else {
            var10000 = it$iv;
         }

         final MutableIntState number2$delegate = (MutableIntState)var10000;
         $composer.endReplaceableGroup();
         final MutableIntState number = (MutableIntState)StateObjectTrackerKt.registerStateObjectTracking$default(number2$delegate, $composer, new AffectedComposable("Home", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 186, 8), "fun-Home(Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", "number", (StateObjectGetter)null, (StateValueGetter)null, 48, (Object)null);
         $composer.startReplaceableGroup(-255238804);
         ComposerKt.sourceInformation($composer, "CC(remember):PlaygroundActivity.kt#9igjgp");
         invalid$iv = false;
         int invalid$iv = false;
         Object it$iv = $composer.rememberedValue();
         var11 = false;
         boolean var12;
         if (it$iv == Composer.Companion.getEmpty()) {
            var12 = false;
            Object value$iv = SnapshotIntStateKt.mutableIntStateOf(LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$arg-0$call-mutableIntStateOf$fun-$anonymous$$arg-0$call-remember$val-number2$delegate$fun-Home());
            $composer.updateRememberedValue(value$iv);
            var10000 = value$iv;
         } else {
            var10000 = it$iv;
         }

         MutableIntState var6 = (MutableIntState)var10000;
         $composer.endReplaceableGroup();
         number2$delegate = (MutableIntState)StateObjectTrackerKt.registerStateObjectTracking$default(var6, $composer, new AffectedComposable("Home", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 186, 8), "fun-Home(Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", "number2", (StateObjectGetter)null, (StateValueGetter)null, 48, (Object)null);
         $composer.startReplaceableGroup(-255238758);
         ComposerKt.sourceInformation($composer, "CC(remember):PlaygroundActivity.kt#9igjgp");
         invalid$iv = false;
         $i$f$cache = false;
         Object it$iv = $composer.rememberedValue();
         var12 = false;
         boolean var13;
         if (it$iv == Composer.Companion.getEmpty()) {
            var13 = false;
            Object value$iv = SnapshotStateKt.derivedStateOf((Function0)(new Function0() {
               @NotNull
               public final Integer invoke() {
                  return number.getIntValue() + PlaygroundActivityKt.Home$lambda$2(number2$delegate);
               }
            }));
            $composer.updateRememberedValue(value$iv);
            var10000 = value$iv;
         } else {
            var10000 = it$iv;
         }

         State var18 = (State)var10000;
         $composer.endReplaceableGroup();
         final State sum = (State)StateObjectTrackerKt.registerStateObjectTracking$default(var18, $composer, new AffectedComposable("Home", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 186, 8), "fun-Home(Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", "sum", (StateObjectGetter)null, (StateValueGetter)null, 48, (Object)null);

         try {
            ComposableCallstackTrackerImpl$PlaygroundActivityKt.push(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-push$try$fun-Home());
            $composer.startReplaceableGroup(-255238680);
            ComposerKt.sourceInformation($composer, "CC(remember):PlaygroundActivity.kt#9igjgp");
            invalid$iv = false;
            $i$f$cache = false;
            it$iv = $composer.rememberedValue();
            var12 = false;
            if (it$iv == Composer.Companion.getEmpty()) {
               var13 = false;
               Object value$iv = (Function0)(new Function0() {
                  public final void invoke() {
                     MutableIntState var1 = number;
                     int var2 = var1.getIntValue();
                     var1.setIntValue(var2 + 1);
                     int var3 = PlaygroundActivityKt.Home$lambda$2(number2$delegate);
                     PlaygroundActivityKt.Home$lambda$3(number2$delegate, var3 + 1);
                  }
               });
               $composer.updateRememberedValue(value$iv);
               var10000 = value$iv;
            } else {
               var10000 = it$iv;
            }

            Function0 var19 = (Function0)var10000;
            $composer.endReplaceableGroup();
            ButtonKt.Button(var19, (Modifier)null, false, (MutableInteractionSource)null, (ButtonElevation)null, (Shape)null, (BorderStroke)null, (ButtonColors)null, (PaddingValues)null, (Function3)ComposableLambdaKt.composableLambda($composer, -1463825908, true, new Function3() {
               @Composable
               @ComposableTarget(
                  applier = "androidx.compose.ui.UiComposable"
               )
               public final void invoke(@NotNull RowScope $this$Button, @Nullable Composer $composer, int $changed) {
                  Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
                  ComposerKt.sourceInformation($composer, "C194@7457L31:PlaygroundActivity.kt#qshby3");
                  if (($changed & 81) == 16 && $composer.getSkipping()) {
                     PlaygroundActivityKt.ComposableInvalidationTrackTableImpl$PlaygroundActivityKt.callListeners("fun-RowScope.$anonymous$(Composer,Int)Unit/arg-3/call-composableLambda/arg-9/call-Button/try/branch/if/fun-Home(Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", new AffectedComposable("<anonymous>", "land.sungbin.androidplayground.Home", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 194, 5), (ComposableInvalidationType)Skipped.INSTANCE);
                     ComposeInvestigatorConfig.INSTANCE.getInvalidationLogger().invoke(CollectionsKt.toList((Iterable)PlaygroundActivityKt.ComposableCallstackTrackerImpl$PlaygroundActivityKt), new AffectedComposable("<anonymous>", "land.sungbin.androidplayground.Home", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 194, 5), (ComposableInvalidationType)Skipped.INSTANCE);
                     $composer.skipToGroupEnd();
                  } else {
                     List var4 = (List)(new ArrayList());
                     InvalidationReason var5 = PlaygroundActivityKt.ComposableInvalidationTrackTableImpl$PlaygroundActivityKt.computeInvalidationReason("fun-RowScope.$anonymous$(Composer,Int)Unit/arg-3/call-composableLambda/arg-9/call-Button/try/branch/if/fun-Home(Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", var4);
                     PlaygroundActivityKt.ComposableInvalidationTrackTableImpl$PlaygroundActivityKt.callListeners("fun-RowScope.$anonymous$(Composer,Int)Unit/arg-3/call-composableLambda/arg-9/call-Button/try/branch/if/fun-Home(Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", new AffectedComposable("<anonymous>", "land.sungbin.androidplayground.Home", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 194, 5), (ComposableInvalidationType)(new Processed(var5)));
                     ComposeInvestigatorConfig.INSTANCE.getInvalidationLogger().invoke(CollectionsKt.toList((Iterable)PlaygroundActivityKt.ComposableCallstackTrackerImpl$PlaygroundActivityKt), new AffectedComposable("<anonymous>", "land.sungbin.androidplayground.Home", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 194, 5), (ComposableInvalidationType)(new Processed(var5)));
                     if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1463825908, $changed, -1, "land.sungbin.androidplayground.Home.<anonymous> (PlaygroundActivity.kt:194)");
                     }

                     try {
                        PlaygroundActivityKt.getComposableCallstackTrackerImpl$PlaygroundActivityKt().push(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-push$try$fun-$anonymous$$arg-9$call-Button$try$fun-Home());
                        BasicTextKt.BasicText-VhcvRP8(String.valueOf(((Number)sum.getValue()).intValue()), (Modifier)null, (TextStyle)null, (Function1)null, 0, false, 0, 0, (ColorProducer)null, $composer, 0, 510);
                     } finally {
                        PlaygroundActivityKt.getComposableCallstackTrackerImpl$PlaygroundActivityKt().pop();
                     }

                     if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                     }
                  }

               }
            }), $composer, 805306374, 510);
         } finally {
            ComposableCallstackTrackerImpl$PlaygroundActivityKt.pop();
         }

         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var26 = $composer.endRestartGroup();
      if (var26 != null) {
         var26.updateScope((Function2)(new Function2() {
            public final void invoke(@Nullable Composer $composer, int $force) {
               PlaygroundActivityKt.ComposableInvalidationTrackTableImpl$PlaygroundActivityKt.callListeners("fun-Home(Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", new AffectedComposable("Home", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 186, 8), (ComposableInvalidationType)(new Processed((InvalidationReason)Invalidate.INSTANCE)));
               ComposeInvestigatorConfig.INSTANCE.getInvalidationLogger().invoke(CollectionsKt.toList((Iterable)PlaygroundActivityKt.ComposableCallstackTrackerImpl$PlaygroundActivityKt), new AffectedComposable("Home", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 186, 8), (ComposableInvalidationType)(new Processed((InvalidationReason)Invalidate.INSTANCE)));
               PlaygroundActivityKt.Home($composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
         }));
      }

   }

   private static final int Home$lambda$2(MutableIntState $number2$delegate) {
      IntState $this$getValue$iv = (IntState)$number2$delegate;
      Object var2 = null;
      KProperty property$iv = null;
      int $i$f$getValue = false;
      return $this$getValue$iv.getIntValue();
   }

   private static final void Home$lambda$3(MutableIntState $number2$delegate, int value) {
      Object var3 = null;
      KProperty property$iv = null;
      int $i$f$setValue = false;
      $number2$delegate.setIntValue(value);
   }
}
