package land.sungbin.androidplayground;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
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
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"},
   d2 = {"Lland/sungbin/androidplayground/PlaygroundActivity;", "Landroidx/activity/ComponentActivity;", "()V", "ms", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)
@StabilityInferred(
   parameters = 1
)
public final class PlaygroundActivity extends ComponentActivity {
   private final long ms = System.currentTimeMillis();
   public static final int $stable;

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      ComponentActivityKt.setContent$default((ComponentActivity)this, (CompositionContext)null, (Function2)ComposableLambdaKt.composableLambdaInstance(2023832317, true, new Function2() {
         @Composable
         @ComposableTarget(
            applier = "androidx.compose.ui.UiComposable"
         )
         public final void invoke(@Nullable Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C178@7004L401:PlaygroundActivity.kt#qshby3");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
               $composer.skipToGroupEnd();
            } else {
               if (ComposerKt.isTraceInProgress()) {
                  ComposerKt.traceEventStart(2023832317, $changed, -1, "land.sungbin.androidplayground.PlaygroundActivity.onCreate.<anonymous> (PlaygroundActivity.kt:178)");
               }

               Modifier modifier$iv = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
               Alignment contentAlignment$iv = Alignment.Companion.getCenter();
               final PlaygroundActivity var6 = PlaygroundActivity.this;
               int $changed$ivx = 54;
               int $i$f$Box = false;
               $composer.startReplaceableGroup(733328855);
               ComposerKt.sourceInformation($composer, "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo");
               boolean propagateMinConstraints$iv = false;
               MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, propagateMinConstraints$iv, $composer, 14 & $changed$ivx >> 3 | 112 & $changed$ivx >> 3);
               int $changed$iv$iv = 112 & $changed$ivx << 3;
               int $i$f$Layout = false;
               $composer.startReplaceableGroup(-1323940314);
               ComposerKt.sourceInformation($composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
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
               ComposerKt.sourceInformationMarkerStart($composer, -1253629358, "C71@3331L9:Box.kt#2w3rfo");
               int var27 = 6 | 112 & $changed$ivx >> 6;
               BoxScope var10000 = (BoxScope)BoxScopeInstance.INSTANCE;
               int var30 = false;
               ComposerKt.sourceInformationMarkerStart($composer, -14390953, "C182@7115L282:PlaygroundActivity.kt#qshby3");
               $composer.startReplaceableGroup(-1968075256);
               boolean invalid$iv = $composer.changed(var6);
               int $i$f$cache = false;
               Object it$iv = $composer.rememberedValue();
               int var35 = false;
               Object var39;
               if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                  var39 = it$iv;
               } else {
                  int var36 = false;
                  Object value$iv = (Function0)(new Function0() {
                     public final void invoke() {
                        PlaygroundActivity var10000 = var6;
                        Intent var1 = new Intent((Context)var6, SecondActivity.class);
                        PlaygroundActivity var2 = var6;
                        PlaygroundActivity var5 = var10000;
                        int var4 = false;
                        var1.putExtra(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-putExtra$fun-$anonymous$$arg-0$call-apply$arg-0$call-startActivity$fun-$anonymous$$arg-0$call-Button$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity(), var2.ms);
                        var5.startActivity(var1);
                     }
                  });
                  $composer.updateRememberedValue(value$iv);
                  var39 = value$iv;
               }

               Function0 var38 = (Function0)var39;
               $composer.endReplaceableGroup();
               ButtonKt.Button(var38, (Modifier)null, false, (Shape)null, (ButtonColors)null, (ButtonElevation)null, (BorderStroke)null, (PaddingValues)null, (MutableInteractionSource)null, (Function3)ComposableLambdaKt.composableLambda($composer, 1589692019, true, new Function3() {
                  @Composable
                  @ComposableTarget(
                     applier = "androidx.compose.ui.UiComposable"
                  )
                  public final void invoke(@NotNull RowScope $this$Button, @Nullable Composer $composer, int $changed) {
                     Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
                     ComposerKt.sourceInformation($composer, "C191@7354L33:PlaygroundActivity.kt#qshby3");
                     if (($changed & 81) == 16 && $composer.getSkipping()) {
                        $composer.skipToGroupEnd();
                     } else {
                        if (ComposerKt.isTraceInProgress()) {
                           ComposerKt.traceEventStart(1589692019, $changed, -1, "land.sungbin.androidplayground.PlaygroundActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (PlaygroundActivity.kt:191)");
                        }

                        TextKt.Text--4IGK_g(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-Text$fun-$anonymous$$arg-9$call-Button$fun-$anonymous$$arg-3$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity() + var6.ms, (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131070);
                        if (ComposerKt.isTraceInProgress()) {
                           ComposerKt.traceEventEnd();
                        }
                     }

                  }
               }), $composer, 805306368, 510);
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
