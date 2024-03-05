package land.sungbin.androidplayground;

import android.os.Bundle;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import land.sungbin.composeinvestigator.runtime.ComposableInvalidationType;
import land.sungbin.composeinvestigator.runtime.ComposeInvestigatorConfig;
import land.sungbin.composeinvestigator.runtime.affect.AffectedComposable;
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

   public PlaygroundActivity() {
      ComposeInvestigatorConfig.INSTANCE.setInvalidationLogger(PlaygroundActivity::_init_$lambda$0);
   }

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      ComponentActivityKt.setContent$default((ComponentActivity)this, (CompositionContext)null, ComposableSingletons$PlaygroundActivityKt.INSTANCE.getLambda-1$app_debug(), 1, (Object)null);
   }

   private static final void _init_$lambda$0(List callstack, AffectedComposable composable, ComposableInvalidationType type) {
      Intrinsics.checkNotNullParameter(callstack, "callstack");
      Intrinsics.checkNotNullParameter(composable, "composable");
      Intrinsics.checkNotNullParameter(type, "type");
      String var10000 = LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-d$fun-$anonymous$$arg-0$call-$set-invalidationLogger$$init$class-PlaygroundActivity();
      String var10001 = LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-1$call-d$fun-$anonymous$$arg-0$call-$set-invalidationLogger$$init$class-PlaygroundActivity();
      Log.d(var10000, var10001 + composable.getName() + LiveLiterals$PlaygroundActivityKt.INSTANCE.String$2$str$arg-1$call-d$fun-$anonymous$$arg-0$call-$set-invalidationLogger$$init$class-PlaygroundActivity() + CollectionsKt.joinToString$default((Iterable)callstack, (CharSequence)LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-joinToString$3$str$arg-1$call-d$fun-$anonymous$$arg-0$call-$set-invalidationLogger$$init$class-PlaygroundActivity(), (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null) + LiveLiterals$PlaygroundActivityKt.INSTANCE.String$4$str$arg-1$call-d$fun-$anonymous$$arg-0$call-$set-invalidationLogger$$init$class-PlaygroundActivity() + type);
   }

   static {
      $stable = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$class-PlaygroundActivity();
   }
}
