package land.sungbin.androidplayground;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnPlacedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ViewRootForTest;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsOwnerKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\t"},
   d2 = {"Lland/sungbin/androidplayground/PlaygroundActivity;", "Landroidx/activity/ComponentActivity;", "()V", "root", "Landroidx/compose/ui/platform/ViewRootForTest;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)
@StabilityInferred(
   parameters = 0
)
public final class PlaygroundActivity extends ComponentActivity {
   private ViewRootForTest root;
   public static final int $stable;

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      ViewRootForTest.Companion.setOnViewCreatedCallback((Function1)(new Function1() {
         public final void invoke(@NotNull ViewRootForTest root) {
            Intrinsics.checkNotNullParameter(root, "root");
            PlaygroundActivity.this.root = root;
         }
      }));
      ComponentActivityKt.setContent$default((ComponentActivity)this, (CompositionContext)null, (Function2)ComposableLambdaKt.composableLambdaInstance(2023832317, true, new Function2() {
         @Composable
         @ComposableTarget(
            applier = "androidx.compose.ui.UiComposable"
         )
         public final void invoke(@Nullable Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C26@1027L1265:PlaygroundActivity.kt#qshby3");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
               $composer.skipToGroupEnd();
            } else {
               if (ComposerKt.isTraceInProgress()) {
                  ComposerKt.traceEventStart(2023832317, $changed, -1, "land.sungbin.androidplayground.PlaygroundActivity.onCreate.<anonymous> (PlaygroundActivity.kt:26)");
               }

               Modifier modifier$iv = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
               Alignment contentAlignment$iv = Alignment.Companion.getCenter();
               final PlaygroundActivity var6 = PlaygroundActivity.this;
               int $changed$ivx = 54;
               int $i$f$Box = false;
               $composer.startReplaceableGroup(733328855);
               ComposerKt.sourceInformation($composer, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
               boolean propagateMinConstraints$iv = false;
               MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, propagateMinConstraints$iv, $composer, 14 & $changed$ivx >> 3 | 112 & $changed$ivx >> 3);
               int $changed$iv$iv = 112 & $changed$ivx << 3;
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
               int var19 = false;
               Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
               Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
               Function2 block$iv$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
               int var21 = false;
               int var23 = false;
               if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), compositeKeyHash$iv$iv)) {
                  $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(compositeKeyHash$iv$iv);
                  $this$Layout_u24lambda_u240$iv$iv.apply(compositeKeyHash$iv$iv, block$iv$iv$iv);
               }

               skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl($composer)), $composer, 112 & $changed$iv$iv$iv >> 3);
               $composer.startReplaceableGroup(2058660585);
               int $changed$iv = 14 & $changed$iv$iv$iv >> 9;
               int var26 = false;
               ComposerKt.sourceInformationMarkerStart($composer, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
               int var27 = 6 | 112 & $changed$ivx >> 6;
               BoxScope var10000 = (BoxScope)BoxScopeInstance.INSTANCE;
               int var30 = false;
               ComposerKt.sourceInformationMarkerStart($composer, -14396930, "C30@1138L1146:PlaygroundActivity.kt#qshby3");
               Modifier var31 = OnPlacedModifierKt.onPlaced((Modifier)Modifier.Companion, (Function1)(new Function1() {
                  public final void invoke(@NotNull LayoutCoordinates it) {
                     Intrinsics.checkNotNullParameter(it, "it");
                     ViewRootForTest var10000 = var6.root;
                     if (var10000 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("root");
                        var10000 = null;
                     }

                     List allNodes = SemanticsOwnerKt.getAllSemanticsNodes(var10000.getSemanticsOwner(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$arg-0$call-getAllSemanticsNodes$val-allNodes$fun-$anonymous$$arg-0$call-onPlaced$val-tmp0_modifier$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$arg-1$call-getAllSemanticsNodes$val-allNodes$fun-$anonymous$$arg-0$call-onPlaced$val-tmp0_modifier$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity());
                     System.out.print(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-print$fun-$anonymous$$arg-0$call-onPlaced$val-tmp0_modifier$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity());
                     System.out.println(CollectionsKt.joinToString$default((Iterable)allNodes, (CharSequence)null, (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null.INSTANCE, 31, (Object)null));
                     int $i$f$fastForEach = false;
                     List $this$fastForEach$iv$iv = allNodes;
                     int result = false;
                     int index$iv$iv = 0;
                     int var10 = allNodes.size();

                     Object var23;
                     while(true) {
                        if (index$iv$iv >= var10) {
                           var23 = null;
                           break;
                        }

                        Object item$iv$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
                        int var13 = false;
                        SemanticsNode node = (SemanticsNode)item$iv$iv;
                        int var15 = false;
                        if (node.getConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                           var23 = item$iv$iv;
                           break;
                        }

                        ++index$iv$iv;
                     }

                     SemanticsNode var24 = (SemanticsNode)var23;
                     if ((SemanticsNode)var23 != null) {
                        SemanticsNode textNode = var24;
                        ArrayList var5 = new ArrayList();
                        int var17 = false;
                        Function var25 = ((AccessibilityAction)textNode.getConfig().get(SemanticsActions.INSTANCE.getGetTextLayoutResult())).getAction();
                        Intrinsics.checkNotNull(var25);
                        result = (Boolean)((Function1)var25).invoke(var5);
                        if (!result) {
                           System.out.println(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-println$branch$if$fun-$anonymous$$arg-0$call-apply$val-textLayouts$fun-$anonymous$$arg-0$call-onPlaced$val-tmp0_modifier$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity());
                        } else {
                           String var26 = LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-println-1$fun-$anonymous$$arg-0$call-onPlaced$val-tmp0_modifier$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity();
                           System.out.println(var26 + ((TextLayoutResult)CollectionsKt.first((List)var5)).getLayoutInput().getText() + LiveLiterals$PlaygroundActivityKt.INSTANCE.String$2$str$arg-0$call-println-1$fun-$anonymous$$arg-0$call-onPlaced$val-tmp0_modifier$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity());
                           List $this$fastForEach$iv = (List)var5;
                           $i$f$fastForEach = false;
                           int index$iv = 0;

                           for(int var19 = $this$fastForEach$iv.size(); index$iv < var19; ++index$iv) {
                              Object item$iv = $this$fastForEach$iv.get(index$iv);
                              TextLayoutResult layout = (TextLayoutResult)item$iv;
                              int var22 = false;
                              System.out.println(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-fastForEach$fun-$anonymous$$arg-0$call-onPlaced$val-tmp0_modifier$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity() + layout.getLayoutInput().getStyle());
                              System.out.println(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-println-1$fun-$anonymous$$arg-0$call-fastForEach$fun-$anonymous$$arg-0$call-onPlaced$val-tmp0_modifier$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity() + Constraints.toString-impl(layout.getLayoutInput().getConstraints-msEJaDk()));
                              System.out.println(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-println-2$fun-$anonymous$$arg-0$call-fastForEach$fun-$anonymous$$arg-0$call-onPlaced$val-tmp0_modifier$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity() + layout.getLayoutInput().getDensity().getDensity());
                           }

                        }
                     }
                  }
               }));
               TextKt.Text--4IGK_g(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-Text$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity(), var31, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131068);
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

         }
      }), 1, (Object)null);
   }

   static {
      $stable = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$class-PlaygroundActivity();
   }
}
