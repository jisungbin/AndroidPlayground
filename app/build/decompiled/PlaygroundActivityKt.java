package land.sungbin.androidplayground;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.Arrangement.Vertical;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.material.ButtonColors;
import androidx.compose.material.ButtonElevation;
import androidx.compose.material.ButtonKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
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
import land.sungbin.composeinvestigator.runtime.DeclarationStability;
import land.sungbin.composeinvestigator.runtime.InvalidationReason;
import land.sungbin.composeinvestigator.runtime.StateObjectGetter;
import land.sungbin.composeinvestigator.runtime.StateObjectTrackerKt;
import land.sungbin.composeinvestigator.runtime.StateValueGetter;
import land.sungbin.composeinvestigator.runtime.ComposableInvalidationType.Processed;
import land.sungbin.composeinvestigator.runtime.ComposableInvalidationType.Skipped;
import land.sungbin.composeinvestigator.runtime.DeclarationStability.Certain;
import land.sungbin.composeinvestigator.runtime.InvalidationReason.Invalidate;
import land.sungbin.composeinvestigator.runtime.affect.AffectedComposable;
import land.sungbin.composeinvestigator.runtime.affect.AffectedField.ValueParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\u0015\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\u0005X\u008a\u008e\u0002"},
   d2 = {"Home", "", "(Landroidx/compose/runtime/Composer;I)V", "View", "src", "", "(ILandroidx/compose/runtime/Composer;I)V", "app_debug", "num"}
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivityKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n+ 7 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 8 SnapshotIntState.kt\nandroidx/compose/runtime/SnapshotIntStateKt__SnapshotIntStateKt\n*L\n1#1,213:1\n1116#2,6:214\n1116#2,6:256\n73#3,7:220\n80#3:255\n84#3:307\n79#4,11:227\n79#4,11:269\n92#4:301\n92#4:306\n456#5,8:238\n464#5,3:252\n456#5,8:280\n464#5,3:294\n467#5,3:298\n467#5,3:303\n3737#6,6:246\n3737#6,6:288\n86#7,7:262\n93#7:297\n97#7:302\n75#8:308\n108#8,2:309\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivityKt\n*L\n200#1:214,6\n202#1:256,6\n201#1:220,7\n201#1:255\n201#1:307\n201#1:227,11\n203#1:269,11\n203#1:301\n201#1:306\n201#1:238,8\n201#1:252,3\n203#1:280,8\n203#1:294,3\n203#1:298,3\n201#1:303,3\n201#1:246,6\n203#1:288,6\n203#1:262,7\n203#1:297\n203#1:302\n200#1:308\n200#1:309,2\n*E\n"})
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
   public static final void Home(@Nullable Composer $composer, final int $changed) {
      $composer = $composer.startRestartGroup(-980793304);
      ComposerKt.sourceInformation($composer, "C(Home)199@7755L33,200@7791L79:PlaygroundActivity.kt#qshby3");
      if ($changed == 0 && $composer.getSkipping()) {
         ComposableInvalidationTrackTableImpl$PlaygroundActivityKt.callListeners("fun-Home(Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", new AffectedComposable("Home", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 199, 0), (ComposableInvalidationType)Skipped.INSTANCE);
         ComposeInvestigatorConfig.INSTANCE.getInvalidationLogger().invoke(CollectionsKt.toList((Iterable)ComposableCallstackTrackerImpl$PlaygroundActivityKt), new AffectedComposable("Home", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 199, 0), (ComposableInvalidationType)Skipped.INSTANCE);
         $composer.skipToGroupEnd();
      } else {
         List var2 = (List)(new ArrayList());
         InvalidationReason var3 = ComposableInvalidationTrackTableImpl$PlaygroundActivityKt.computeInvalidationReason("fun-Home(Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", var2);
         ComposableInvalidationTrackTableImpl$PlaygroundActivityKt.callListeners("fun-Home(Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", new AffectedComposable("Home", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 199, 0), (ComposableInvalidationType)(new Processed(var3)));
         ComposeInvestigatorConfig.INSTANCE.getInvalidationLogger().invoke(CollectionsKt.toList((Iterable)ComposableCallstackTrackerImpl$PlaygroundActivityKt), new AffectedComposable("Home", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 199, 0), (ComposableInvalidationType)(new Processed(var3)));
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-980793304, $changed, -1, "land.sungbin.androidplayground.Home (PlaygroundActivity.kt:198)");
         }

         $composer.startReplaceableGroup(-255238333);
         ComposerKt.sourceInformation($composer, "CC(remember):PlaygroundActivity.kt#9igjgp");
         boolean invalid$iv = false;
         int $i$f$cache = false;
         Object it$iv = $composer.rememberedValue();
         int var10 = false;
         Object var10000;
         if (it$iv == Composer.Companion.getEmpty()) {
            int var11 = false;
            Object value$iv = SnapshotIntStateKt.mutableIntStateOf(LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$arg-0$call-mutableIntStateOf$fun-$anonymous$$arg-0$call-remember$val-num$delegate$fun-Home());
            $composer.updateRememberedValue(value$iv);
            var10000 = value$iv;
         } else {
            var10000 = it$iv;
         }

         MutableIntState var5 = (MutableIntState)var10000;
         $composer.endReplaceableGroup();
         final MutableIntState num$delegate = (MutableIntState)StateObjectTrackerKt.registerStateObjectTracking$default(var5, $composer, new AffectedComposable("Home", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 199, 0), "fun-Home(Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", "num", (StateObjectGetter)null, (StateValueGetter)null, 48, (Object)null);

         try {
            ComposableCallstackTrackerImpl$PlaygroundActivityKt.push(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-push$try$fun-Home());
            int $changed$iv = 0;
            int $i$f$Column = false;
            $composer.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation($composer, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            Modifier modifier$iv = (Modifier)Modifier.Companion;
            Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, 14 & $changed$iv >> 3 | 112 & $changed$iv >> 3);
            int $changed$iv$iv = 112 & $changed$iv << 3;
            int $i$f$Layout = false;
            $composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
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
            int var20 = false;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
            int var22 = false;
            int var24 = false;
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), compositeKeyHash$iv$iv)) {
               $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(compositeKeyHash$iv$iv);
               $this$Layout_u24lambda_u240$iv$iv.apply(compositeKeyHash$iv$iv, block$iv$iv$iv);
            }

            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl($composer)), $composer, 112 & $changed$iv$iv$iv >> 3);
            $composer.startReplaceableGroup(2058660585);
            int $changed$iv = 14 & $changed$iv$iv$iv >> 9;
            int var27 = false;
            ComposerKt.sourceInformationMarkerStart($composer, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            int var28 = 6 | 112 & $changed$iv >> 6;
            Composer $composer = $composer;
            ColumnScope var87 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            int var31 = false;
            ComposerKt.sourceInformationMarkerStart($composer, -1798394475, "C201@7821L9,201@7804L30,202@7839L27:PlaygroundActivity.kt#qshby3");

            try {
               ComposableCallstackTrackerImpl$PlaygroundActivityKt.push(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-push$try$fun-$anonymous$$arg-3$call-Column$try$fun-Home());
               $composer.startReplaceableGroup(-1798394458);
               ComposerKt.sourceInformation($composer, "CC(remember):PlaygroundActivity.kt#9igjgp");
               boolean invalid$iv = false;
               int $i$f$cache = false;
               Object it$iv = $composer.rememberedValue();
               int var36 = false;
               if (it$iv == Composer.Companion.getEmpty()) {
                  int var37 = false;
                  Object value$iv = (Function0)(new Function0() {
                     public final void invoke() {
                        int var1 = PlaygroundActivityKt.Home$lambda$1(num$delegate);
                        PlaygroundActivityKt.Home$lambda$2(num$delegate, var1 + 1);
                     }
                  });
                  $composer.updateRememberedValue(value$iv);
                  var10000 = value$iv;
               } else {
                  var10000 = it$iv;
               }

               Function0 var39 = (Function0)var10000;
               $composer.endReplaceableGroup();
               ButtonKt.Button(var39, (Modifier)null, false, (MutableInteractionSource)null, (ButtonElevation)null, (Shape)null, (BorderStroke)null, (ButtonColors)null, (PaddingValues)null, ComposableSingletons$PlaygroundActivityKt.INSTANCE.getLambda-2$app_debug(), $composer, 805306374, 510);
            } finally {
               ComposableCallstackTrackerImpl$PlaygroundActivityKt.pop();
            }

            try {
               ComposableCallstackTrackerImpl$PlaygroundActivityKt.push(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-push$try-1$fun-$anonymous$$arg-3$call-Column$try$fun-Home());
               int $changed$iv = 0;
               int $i$f$Row = false;
               $composer.startReplaceableGroup(693286680);
               ComposerKt.sourceInformation($composer, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
               Modifier modifier$iv = (Modifier)Modifier.Companion;
               androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
               androidx.compose.ui.Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
               MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, 14 & $changed$iv >> 3 | 112 & $changed$iv >> 3);
               int $changed$iv$iv = 112 & $changed$iv << 3;
               int $i$f$Layout = false;
               $composer.startReplaceableGroup(-1323940314);
               ComposerKt.sourceInformation($composer, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
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
               int var47 = false;
               Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
               Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
               Function2 block$iv$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
               int var49 = false;
               int var51 = false;
               if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), compositeKeyHash$iv$iv)) {
                  $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(compositeKeyHash$iv$iv);
                  $this$Layout_u24lambda_u240$iv$iv.apply(compositeKeyHash$iv$iv, block$iv$iv$iv);
               }

               skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl($composer)), $composer, 112 & $changed$iv$iv$iv >> 3);
               $composer.startReplaceableGroup(2058660585);
               int $changed$iv = 14 & $changed$iv$iv$iv >> 9;
               int var54 = false;
               ComposerKt.sourceInformationMarkerStart($composer, -326681643, "C92@4661L9:Row.kt#2w3rfo");
               int var55 = 6 | 112 & $changed$iv >> 6;
               Composer $composer = $composer;
               RowScope var88 = (RowScope)RowScopeInstance.INSTANCE;
               int var58 = false;
               ComposerKt.sourceInformationMarkerStart($composer, 70439525, "C203@7851L9:PlaygroundActivity.kt#qshby3");

               try {
                  ComposableCallstackTrackerImpl$PlaygroundActivityKt.push(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-push$try$fun-$anonymous$$arg-3$call-Row$try-1$fun-$anonymous$$arg-3$call-Column$try$fun-Home());
                  View(Home$lambda$1(num$delegate), $composer, 0);
               } finally {
                  ComposableCallstackTrackerImpl$PlaygroundActivityKt.pop();
               }

               ComposerKt.sourceInformationMarkerEnd($composer);
               ComposerKt.sourceInformationMarkerEnd($composer);
               $composer.endReplaceableGroup();
               $composer.endNode();
               $composer.endReplaceableGroup();
               $composer.endReplaceableGroup();
            } finally {
               ComposableCallstackTrackerImpl$PlaygroundActivityKt.pop();
            }

            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceableGroup();
            $composer.endNode();
            $composer.endReplaceableGroup();
            $composer.endReplaceableGroup();
         } finally {
            ComposableCallstackTrackerImpl$PlaygroundActivityKt.pop();
         }

         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var89 = $composer.endRestartGroup();
      if (var89 != null) {
         var89.updateScope((Function2)(new Function2() {
            public final void invoke(@Nullable Composer $composer, int $force) {
               PlaygroundActivityKt.ComposableInvalidationTrackTableImpl$PlaygroundActivityKt.callListeners("fun-Home(Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", new AffectedComposable("Home", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 199, 0), (ComposableInvalidationType)(new Processed((InvalidationReason)Invalidate.INSTANCE)));
               ComposeInvestigatorConfig.INSTANCE.getInvalidationLogger().invoke(CollectionsKt.toList((Iterable)PlaygroundActivityKt.ComposableCallstackTrackerImpl$PlaygroundActivityKt), new AffectedComposable("Home", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 199, 0), (ComposableInvalidationType)(new Processed((InvalidationReason)Invalidate.INSTANCE)));
               PlaygroundActivityKt.Home($composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
         }));
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void View(final int src, @Nullable Composer $composer, final int $changed) {
      $composer = $composer.startRestartGroup(1256085897);
      ComposerKt.sourceInformation($composer, "C(View)210@7909L25:PlaygroundActivity.kt#qshby3");
      int $dirty = $changed;
      if (($changed & 14) == 0) {
         $dirty = $changed | ($composer.changed(src) ? 4 : 2);
      }

      if (($dirty & 11) == 2 && $composer.getSkipping()) {
         ComposableInvalidationTrackTableImpl$PlaygroundActivityKt.callListeners("fun-View(Int,Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", new AffectedComposable("View", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 210, 0), (ComposableInvalidationType)Skipped.INSTANCE);
         ComposeInvestigatorConfig.INSTANCE.getInvalidationLogger().invoke(CollectionsKt.toList((Iterable)ComposableCallstackTrackerImpl$PlaygroundActivityKt), new AffectedComposable("View", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 210, 0), (ComposableInvalidationType)Skipped.INSTANCE);
         $composer.skipToGroupEnd();
      } else {
         List var4 = (List)(new ArrayList());
         var4.add(new ValueParameter("src", "kotlin.Int", String.valueOf(src), Integer.valueOf(src).hashCode(), (DeclarationStability)(new Certain(true))));
         InvalidationReason var5 = ComposableInvalidationTrackTableImpl$PlaygroundActivityKt.computeInvalidationReason("fun-View(Int,Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", var4);
         ComposableInvalidationTrackTableImpl$PlaygroundActivityKt.callListeners("fun-View(Int,Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", new AffectedComposable("View", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 210, 0), (ComposableInvalidationType)(new Processed(var5)));
         ComposeInvestigatorConfig.INSTANCE.getInvalidationLogger().invoke(CollectionsKt.toList((Iterable)ComposableCallstackTrackerImpl$PlaygroundActivityKt), new AffectedComposable("View", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 210, 0), (ComposableInvalidationType)(new Processed(var5)));
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1256085897, $dirty, -1, "land.sungbin.androidplayground.View (PlaygroundActivity.kt:209)");
         }

         try {
            ComposableCallstackTrackerImpl$PlaygroundActivityKt.push(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-push$try$fun-View());
            BasicTextKt.BasicText-VhcvRP8(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-BasicText$try$fun-View() + src, (Modifier)null, (TextStyle)null, (Function1)null, 0, false, 0, 0, (ColorProducer)null, $composer, 0, 510);
         } finally {
            ComposableCallstackTrackerImpl$PlaygroundActivityKt.pop();
         }

         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var10000 = $composer.endRestartGroup();
      if (var10000 != null) {
         var10000.updateScope((Function2)(new Function2() {
            public final void invoke(@Nullable Composer $composer, int $force) {
               PlaygroundActivityKt.ComposableInvalidationTrackTableImpl$PlaygroundActivityKt.callListeners("fun-View(Int,Composer,Int)Unit/pkg-land.sungbin.androidplayground/file-PlaygroundActivity.kt", new AffectedComposable("View", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 210, 0), (ComposableInvalidationType)(new Processed((InvalidationReason)Invalidate.INSTANCE)));
               ComposeInvestigatorConfig.INSTANCE.getInvalidationLogger().invoke(CollectionsKt.toList((Iterable)PlaygroundActivityKt.ComposableCallstackTrackerImpl$PlaygroundActivityKt), new AffectedComposable("View", "land.sungbin.androidplayground", "/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/PlaygroundActivity.kt", 210, 0), (ComposableInvalidationType)(new Processed((InvalidationReason)Invalidate.INSTANCE)));
               PlaygroundActivityKt.View(src, $composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
         }));
      }

   }

   private static final int Home$lambda$1(MutableIntState $num$delegate) {
      IntState $this$getValue$iv = (IntState)$num$delegate;
      Object var2 = null;
      KProperty property$iv = null;
      int $i$f$getValue = false;
      return $this$getValue$iv.getIntValue();
   }

   private static final void Home$lambda$2(MutableIntState $num$delegate, int value) {
      Object var3 = null;
      KProperty property$iv = null;
      int $i$f$setValue = false;
      $num$delegate.setIntValue(value);
   }
}
