package land.sungbin.androidplayground;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"},
   d2 = {"Lland/sungbin/androidplayground/PlaygroundActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getFontSizeResources", "", "app_debug"}
)
@StabilityInferred(
   parameters = 0
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivity\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,119:1\n113#2:120\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivity\n*L\n23#1:120\n*E\n"})
public final class PlaygroundActivity extends ComponentActivity {
   public static final int $stable = 8;

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      EdgeToEdge.enable$default((ComponentActivity)this, (SystemBarStyle)null, (SystemBarStyle)null, 3, (Object)null);
      super.onCreate(savedInstanceState);
      ComponentActivityKt.setContent$default((ComponentActivity)this, (CompositionContext)null, (Function2)ComposableLambdaKt.composableLambdaInstance(2023832317, true, PlaygroundActivity::onCreate$lambda$0), 1, (Object)null);
   }

   private final float[] getFontSizeResources() {
      Resources var10000 = this.getPackageManager().getResourcesForApplication("com.android.settings");
      Intrinsics.checkNotNullExpressionValue(var10000, "getResourcesForApplication(...)");
      Resources res = var10000;
      int resId = res.getIdentifier("entryvalues_font_size", "array", "com.android.settings");
      if (resId == 0) {
         return new float[0];
      } else {
         String[] var8 = res.getStringArray(resId);
         Intrinsics.checkNotNullExpressionValue(var8, "getStringArray(...)");
         String[] values = var8;
         int var4 = 0;
         int var5 = values.length;

         float[] var6;
         for(var6 = new float[var5]; var4 < var5; ++var4) {
            String var10002 = values[var4];
            Intrinsics.checkNotNullExpressionValue(values[var4], "get(...)");
            var6[var4] = Float.parseFloat(var10002);
         }

         return var6;
      }
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   private static final Unit onCreate$lambda$0(PlaygroundActivity this$0, Composer $composer, int $changed) {
      ComposerKt.sourceInformation($composer, "C21@687L114:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2023832317, $changed, -1, "land.sungbin.androidplayground.PlaygroundActivity.onCreate.<anonymous> (PlaygroundActivity.kt:21)");
         }

         Modifier var10000 = (Modifier)Modifier.Companion;
         int var4 = 50;
         int var5 = false;
         Modifier var3 = PaddingKt.padding-3ABfNKs(var10000, Dp.constructor-impl((float)var4));
         String var6 = Arrays.toString(this$0.getFontSizeResources());
         Intrinsics.checkNotNullExpressionValue(var6, "toString(...)");
         TextKt.Text--4IGK_g(var6, var3, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 48, 0, 131068);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      } else {
         $composer.skipToGroupEnd();
      }

      return Unit.INSTANCE;
   }
}
