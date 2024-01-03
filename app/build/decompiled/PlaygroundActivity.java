package land.sungbin.androidplayground;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import land.sungbin.androidplayground.app02.PlaygroundActivity2;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"},
   d2 = {"Lland/sungbin/androidplayground/PlaygroundActivity;", "Landroidx/activity/ComponentActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)
@StabilityInferred(
   parameters = 1
)
public final class PlaygroundActivity extends ComponentActivity {
   public static final int $stable;

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      ComponentActivityKt.setContent$default((ComponentActivity)this, (CompositionContext)null, (Function2)ComposableLambdaKt.composableLambdaInstance(2023832317, true, new Function2() {
         @Composable
         @ComposableTarget(
            applier = "androidx.compose.ui.UiComposable"
         )
         public final void invoke(@Nullable Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C178@7087L39,180@7134L305:PlaygroundActivity.kt#qshby3");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
               $composer.skipToGroupEnd();
            } else {
               if (ComposerKt.isTraceInProgress()) {
                  ComposerKt.traceEventStart(2023832317, $changed, -1, "land.sungbin.androidplayground.PlaygroundActivity.onCreate.<anonymous> (PlaygroundActivity.kt:178)");
               }

               int $changed$iv = false;
               int $i$f$remember = false;
               $composer.startReplaceableGroup(-492369756);
               ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
               boolean invalid$iv$iv = false;
               int $i$f$cache = false;
               Object it$iv = $composer.rememberedValue();
               int var11 = false;
               boolean var12;
               Object var10000;
               if (it$iv == Composer.Companion.getEmpty()) {
                  var12 = false;
                  Object value$iv$iv = System.currentTimeMillis();
                  $composer.updateRememberedValue(value$iv$iv);
                  var10000 = value$iv$iv;
               } else {
                  var10000 = it$iv;
               }

               Object var13 = var10000;
               $composer.endReplaceableGroup();
               final long ms = ((Number)var13).longValue();
               Modifier var22 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), Color.Companion.getCyan-0d7_KjU(), (Shape)null, 2, (Object)null);
               boolean var10001 = false;
               Object var10002 = null;
               Object var10003 = null;
               $composer.startReplaceableGroup(-1968075155);
               boolean invalid$iv = $composer.changed(PlaygroundActivity.this) | $composer.changed(ms);
               final PlaygroundActivity var20 = PlaygroundActivity.this;
               $i$f$cache = false;
               it$iv = $composer.rememberedValue();
               var11 = false;
               Object var10004;
               if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                  var10004 = it$iv;
               } else {
                  Object var17 = null;
                  Object var16 = null;
                  boolean var15 = false;
                  Modifier var14 = var22;
                  var12 = false;
                  Function0 var18 = (Function0)(new Function0() {
                     public final void invoke() {
                        Intent var2 = new Intent((Context)var20, PlaygroundActivity2.class);
                        long var3 = ms;
                        int var6 = false;
                        var2.putExtra(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-putExtra$fun-$anonymous$$arg-0$call-apply$val-intent$fun-$anonymous$$arg-3$call-clickable$arg-0$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity(), String.valueOf(var3));
                        var20.startActivity(var2);
                     }
                  });
                  var22 = var14;
                  var10001 = var15;
                  var10002 = var16;
                  var10003 = var17;
                  $composer.updateRememberedValue(var18);
                  var10004 = var18;
               }

               Function0 var19 = (Function0)var10004;
               $composer.endReplaceableGroup();
               BoxKt.Box(ClickableKt.clickable-XHw0xAI$default(var22, var10001, (String)var10002, (Role)var10003, var19, 7, (Object)null), $composer, 0);
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
