package land.sungbin.androidplayground;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0017¢\u0006\u0002\u0010\u0006¨\u0006\b"},
   d2 = {"Lland/sungbin/androidplayground/Test2;", "Lland/sungbin/androidplayground/Test;", "<init>", "()V", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "Companion", "app_debug"}
)
@StabilityInferred(
   parameters = 1
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/Test2\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,65:1\n1282#2,6:66\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/Test2\n*L\n57#1:66,6\n*E\n"})
public class Test2 implements Test {
   @NotNull
   public static final Test2.Companion Companion = new Test2.Companion((DefaultConstructorMarker)null);
   public static final int $stable;

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public void Content(@Nullable Composer $composer, int $changed) {
      $composer.startReplaceGroup(251203394);
      ComposerKt.sourceInformation($composer, "C(Content)55@1565L21,56@1667L18,56@1591L95:PlaygroundActivity.kt#qshby3");
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventStart(251203394, $changed, -1, "land.sungbin.androidplayground.Test2.Content (PlaygroundActivity.kt:54)");
      }

      RecomposeScope r = ComposablesKt.getCurrentRecomposeScope($composer, 0);
      String var10000 = r + " with " + System.currentTimeMillis();
      Modifier var10001 = (Modifier)Modifier.Companion;
      boolean var10002 = false;
      Object var10003 = null;
      Object var10004 = null;
      ComposerKt.sourceInformationMarkerStart($composer, 888298228, "CC(remember):PlaygroundActivity.kt#9igjgp");
      boolean var6 = $composer.changedInstance(r);
      int var7 = false;
      Object var8 = $composer.rememberedValue();
      int var9 = false;
      Object var10005;
      if (!var6 && var8 != Composer.Companion.getEmpty()) {
         var10005 = var8;
      } else {
         Object var16 = null;
         Object var15 = null;
         boolean var14 = false;
         Modifier var13 = var10001;
         String var12 = var10000;
         int var10 = false;
         Function0 var17 = Test2::Content$lambda$1$lambda$0;
         var10000 = var12;
         var10001 = var13;
         var10002 = var14;
         var10003 = var15;
         var10004 = var16;
         $composer.updateRememberedValue(var17);
         var10005 = var17;
      }

      Function0 var4 = (Function0)var10005;
      ComposerKt.sourceInformationMarkerEnd($composer);
      TextKt.Text--4IGK_g(var10000, ClickableKt.clickable-XHw0xAI$default(var10001, var10002, (String)var10003, (Role)var10004, var4, 7, (Object)null), 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131068);
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventEnd();
      }

      $composer.endReplaceGroup();
   }

   private static final Unit Content$lambda$1$lambda$0(RecomposeScope $r) {
      $r.invalidate();
      return Unit.INSTANCE;
   }

   @Metadata(
      mv = {2, 2, 0},
      k = 1,
      xi = 48,
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lland/sungbin/androidplayground/Test2$Companion;", "Lland/sungbin/androidplayground/Test2;", "<init>", "()V", "app_debug"}
   )
   public static final class Companion extends Test2 {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
