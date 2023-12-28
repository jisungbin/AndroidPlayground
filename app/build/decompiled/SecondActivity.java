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
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextMeasurerHelperKt;
import androidx.compose.ui.text.TextPainterKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"},
   d2 = {"Lland/sungbin/androidplayground/SecondActivity;", "Landroidx/activity/ComponentActivity;", "()V", "ms", "", "getMs", "()Ljava/lang/String;", "ms$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)
@StabilityInferred(
   parameters = 0
)
public final class SecondActivity extends ComponentActivity {
   @NotNull
   private final Lazy ms$delegate = LazyKt.lazy((Function0)(new Function0() {
      @NotNull
      public final String invoke() {
         String var10000 = SecondActivity.this.getIntent().getStringExtra("test");
         Intrinsics.checkNotNull(var10000);
         return var10000;
      }
   }));
   public static final int $stable;

   private final String getMs() {
      Lazy var1 = this.ms$delegate;
      return (String)var1.getValue();
   }

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      ComponentActivityKt.setContent$default((ComponentActivity)this, (CompositionContext)null, (Function2)ComposableLambdaKt.composableLambdaInstance(2091821469, true, new Function2() {
         @Composable
         @ComposableTarget(
            applier = "androidx.compose.ui.UiComposable"
         )
         public final void invoke(@Nullable Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C23@879L22,25@909L252,33@1169L77:SecondActivity.kt#qshby3");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
               $composer.skipToGroupEnd();
            } else {
               if (ComposerKt.isTraceInProgress()) {
                  ComposerKt.traceEventStart(2091821469, $changed, -1, "land.sungbin.androidplayground.SecondActivity.onCreate.<anonymous> (SecondActivity.kt:23)");
               }

               final TextMeasurer textMeasurer = TextMeasurerHelperKt.rememberTextMeasurer(0, $composer, 0, 1);
               BoxKt.Box(ClickableKt.clickable-XHw0xAI$default(DrawModifierKt.drawBehind(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), Color.Companion.getBlue-0d7_KjU(), (Shape)null, 2, (Object)null), (Function1)(new Function1() {
                  public final void invoke(@NotNull DrawScope $this$drawBehind) {
                     Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
                     TextMeasurer var10001 = textMeasurer;
                     String var10002 = SecondActivity.this.getMs();
                     Intrinsics.checkNotNullExpressionValue(var10002, "access$getMs(...)");
                     TextPainterKt.drawText-TPWCCtM$default($this$drawBehind, var10001, var10002, 0L, (TextStyle)null, 0, false, 0, 0L, 0, 508, (Object)null);
                  }
               })), false, (String)null, (Role)null, (Function0)(new Function0() {
                  public final void invoke() {
                     SecondActivity.this.startActivity(new Intent((Context)SecondActivity.this, ThirdActivity.class));
                  }
               }), 7, (Object)null), $composer, 0);
               EffectsKt.LaunchedEffect(Unit.INSTANCE, (Function2)(new Function2((Continuation)null) {
                  int label;

                  @Nullable
                  public final Object invokeSuspend(@NotNull Object var1) {
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     switch(this.label) {
                     case 0:
                        ResultKt.throwOnFailure(var1);
                        System.out.println(LiveLiterals$SecondActivityKt.INSTANCE.String$0$str$arg-0$call-println$fun-$anonymous$$arg-1$call-LaunchedEffect$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-SecondActivity() + SecondActivity.this.getIntent().getExtras());
                        return Unit.INSTANCE;
                     default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }
                  }

                  @NotNull
                  public final Continuation create(@Nullable Object value, @NotNull Continuation $completion) {
                     return (Continuation)(new <anonymous constructor>($completion));
                  }

                  @Nullable
                  public final Object invoke(@NotNull CoroutineScope p1, @Nullable Continuation p2) {
                     return ((<undefinedtype>)this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                  }
               }), $composer, 70);
               if (ComposerKt.isTraceInProgress()) {
                  ComposerKt.traceEventEnd();
               }
            }

         }
      }), 1, (Object)null);
   }

   static {
      $stable = LiveLiterals$SecondActivityKt.INSTANCE.Int$class-SecondActivity();
   }
}
