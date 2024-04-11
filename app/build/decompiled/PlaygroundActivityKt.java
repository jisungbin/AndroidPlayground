package land.sungbin.androidplayground;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.Arrangement.Vertical;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"},
   d2 = {"Content", "", "(Landroidx/compose/runtime/Composer;I)V", "app_debug"}
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivityKt\n+ 2 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 3 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 4 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 5 Composer.kt\nandroidx/compose/runtime/Updater\n*L\n1#1,192:1\n73#2,7:193\n80#2:228\n84#2:233\n79#3,11:200\n92#3:232\n456#4,8:211\n464#4,3:225\n467#4,3:229\n3737#5,6:219\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivityKt\n*L\n185#1:193,7\n185#1:228\n185#1:233\n185#1:200,11\n185#1:232\n185#1:211,8\n185#1:225,3\n185#1:229,3\n185#1:219,6\n*E\n"})
public final class PlaygroundActivityKt {
   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public static final void Content(@Nullable Composer $composer, final int $changed) {
      $composer = $composer.startRestartGroup(490480294);
      ComposerKt.sourceInformation($composer, "C(Content)184@6980L120:PlaygroundActivity.kt#qshby3");
      if ($changed == 0 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(490480294, $changed, -1, "land.sungbin.androidplayground.Content (PlaygroundActivity.kt:183)");
         }

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
         int var17 = false;
         Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
         Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
         Function2 block$iv$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
         int var19 = false;
         int var21 = false;
         if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), compositeKeyHash$iv$iv)) {
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(compositeKeyHash$iv$iv);
            $this$Layout_u24lambda_u240$iv$iv.apply(compositeKeyHash$iv$iv, block$iv$iv$iv);
         }

         skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl($composer)), $composer, 112 & $changed$iv$iv$iv >> 3);
         $composer.startReplaceableGroup(2058660585);
         int $changed$iv = 14 & $changed$iv$iv$iv >> 9;
         int var24 = false;
         ComposerKt.sourceInformationMarkerStart($composer, 276693656, "C79@3979L9:Column.kt#2w3rfo");
         int var25 = 6 | 112 & $changed$iv >> 6;
         ColumnScope var10000 = (ColumnScope)ColumnScopeInstance.INSTANCE;
         int var28 = false;
         ComposerKt.sourceInformationMarkerStart($composer, -444264766, "C185@6993L22,186@7020L22,187@7047L22,188@7074L22:PlaygroundActivity.kt#qshby3");
         BasicTextKt.BasicText-VhcvRP8(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-BasicText$fun-$anonymous$$arg-3$call-Column$fun-Content(), (Modifier)null, (TextStyle)null, (Function1)null, 0, false, 0, 0, (ColorProducer)null, $composer, 0, 510);
         BasicTextKt.BasicText-VhcvRP8(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-BasicText-1$fun-$anonymous$$arg-3$call-Column$fun-Content(), (Modifier)null, (TextStyle)null, (Function1)null, 0, false, 0, 0, (ColorProducer)null, $composer, 0, 510);
         BasicTextKt.BasicText-VhcvRP8(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-BasicText-2$fun-$anonymous$$arg-3$call-Column$fun-Content(), (Modifier)null, (TextStyle)null, (Function1)null, 0, false, 0, 0, (ColorProducer)null, $composer, 0, 510);
         BasicTextKt.BasicText-VhcvRP8(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-BasicText-3$fun-$anonymous$$arg-3$call-Column$fun-Content(), (Modifier)null, (TextStyle)null, (Function1)null, 0, false, 0, 0, (ColorProducer)null, $composer, 0, 510);
         ComposerKt.sourceInformationMarkerEnd($composer);
         ComposerKt.sourceInformationMarkerEnd($composer);
         $composer.endReplaceableGroup();
         $composer.endNode();
         $composer.endReplaceableGroup();
         $composer.endReplaceableGroup();
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var29 = $composer.endRestartGroup();
      if (var29 != null) {
         var29.updateScope((Function2)(new Function2() {
            public final void invoke(@Nullable Composer $composer, int $force) {
               PlaygroundActivityKt.Content($composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
         }));
      }

   }
}
