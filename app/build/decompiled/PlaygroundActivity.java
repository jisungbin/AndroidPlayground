package land.sungbin.androidplayground;

import android.content.Context;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R \u0010\u0004\u001a\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0018\u0010\b\u001a\n \u0006*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0003¨\u0006\u0013"},
   d2 = {"Lland/sungbin/androidplayground/PlaygroundActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "clazz", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "Ljava/lang/Class;", "getLocalContext", "Ljava/lang/reflect/Method;", "Ljava/lang/reflect/Method;", "result", "Landroidx/compose/runtime/CompositionLocal;", "Landroid/content/Context;", "getResult$annotations", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)
@StabilityInferred(
   parameters = 0
)
public final class PlaygroundActivity extends ComponentActivity {
   private final Class clazz = Class.forName("androidx.compose.ui.platform.AndroidCompositionLocals_androidKt");
   private final Method getLocalContext;
   @NotNull
   private final CompositionLocal result;
   public static final int $stable = 8;

   public PlaygroundActivity() {
      this.getLocalContext = this.clazz.getMethod("getLocalContext");
      Object var10001 = this.getLocalContext.invoke((Object)null);
      Intrinsics.checkNotNull(var10001, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<android.content.Context>");
      this.result = (CompositionLocal)var10001;
   }

   /** @deprecated */
   // $FF: synthetic method
   private static void getResult$annotations() {
   }

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      ComponentActivityKt.setContent$default((ComponentActivity)this, (CompositionContext)null, (Function2)ComposableLambdaKt.composableLambdaInstance(2023832317, true, new Function2() {
         @Composable
         @ComposableTarget(
            applier = "androidx.compose.ui.UiComposable"
         )
         public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C27@1056L150:PlaygroundActivity.kt#qshby3");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
               $composer.skipToGroupEnd();
            } else {
               if (ComposerKt.isTraceInProgress()) {
                  ComposerKt.traceEventStart(2023832317, $changed, -1, "land.sungbin.androidplayground.PlaygroundActivity.onCreate.<anonymous> (PlaygroundActivity.kt:27)");
               }

               Modifier modifier$iv = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
               Alignment contentAlignment$iv = Alignment.Companion.getCenter();
               PlaygroundActivity var6 = PlaygroundActivity.this;
               int $changed$ivx = 54;
               int $i$f$Box = false;
               ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
               boolean propagateMinConstraints$iv = false;
               MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, propagateMinConstraints$iv);
               int $changed$iv$iv = 112 & $changed$ivx << 3;
               int $i$f$Layout = false;
               ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
               int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
               CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
               Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
               Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
               int $changed$iv$iv$iv = 6 | 896 & $changed$iv$iv << 6;
               int $i$f$ReusableComposeNode = false;
               ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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

               Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
               int $changed$iv = 14 & $changed$iv$iv$iv >> 6;
               int var26 = false;
               ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
               int var27 = 6 | 112 & $changed$ivx >> 6;
               BoxScope var10000 = (BoxScope)BoxScopeInstance.INSTANCE;
               int var30 = false;
               ComposerKt.sourceInformationMarkerStart($composer, -950482832, "C31@1179L7,31@1167L31:PlaygroundActivity.kt#qshby3");
               CompositionLocal this_$iv = var6.result;
               int $changed$ivxx = false;
               int $i$f$getCurrent = false;
               ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
               Object var34 = $composer.consume(this_$iv);
               ComposerKt.sourceInformationMarkerEnd($composer);
               TextKt.Text--4IGK_g(((Context)var34).toString(), (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131070);
               ComposerKt.sourceInformationMarkerEnd($composer);
               ComposerKt.sourceInformationMarkerEnd($composer);
               $composer.endNode();
               ComposerKt.sourceInformationMarkerEnd($composer);
               ComposerKt.sourceInformationMarkerEnd($composer);
               ComposerKt.sourceInformationMarkerEnd($composer);
               if (ComposerKt.isTraceInProgress()) {
                  ComposerKt.traceEventEnd();
               }
            }

         }
      }), 1, (Object)null);
   }
}
