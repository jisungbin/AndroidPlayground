package land.sungbin.androidplayground;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
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
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0017¢\u0006\u0002\u0010\u0006¨\u0006\u0007"},
   d2 = {"Lland/sungbin/androidplayground/TestImpl;", "Lland/sungbin/androidplayground/Test;", "<init>", "()V", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "app_debug"}
)
@StabilityInferred(
   parameters = 1
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/TestImpl\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,65:1\n1282#2,6:66\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/TestImpl\n*L\n49#1:66,6\n*E\n"})
public final class TestImpl implements Test {
   @NotNull
   public static final TestImpl INSTANCE = new TestImpl();
   public static final int $stable;

   private TestImpl() {
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public void Content(@Nullable Composer $composer, int $changed) {
      $composer = $composer.startRestartGroup(548023004);
      ComposerKt.sourceInformation($composer, "C(Content)47@1349L21,48@1451L18,48@1375L95:PlaygroundActivity.kt#qshby3");
      if ($composer.shouldExecute(($changed & 1) != 0, $changed & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(548023004, $changed, -1, "land.sungbin.androidplayground.TestImpl.Content (PlaygroundActivity.kt:46)");
         }

         RecomposeScope r = ComposablesKt.getCurrentRecomposeScope($composer, 0);
         String var10000 = r + " with " + System.currentTimeMillis();
         Modifier var10001 = (Modifier)Modifier.Companion;
         boolean var10002 = false;
         Object var10003 = null;
         Object var10004 = null;
         ComposerKt.sourceInformationMarkerStart($composer, -1630865362, "CC(remember):PlaygroundActivity.kt#9igjgp");
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
            Function0 var17 = TestImpl::Content$lambda$1$lambda$0;
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
      } else {
         $composer.skipToGroupEnd();
      }

      ScopeUpdateScope var18 = $composer.endRestartGroup();
      if (var18 != null) {
         var18.updateScope(TestImpl::Content$lambda$2);
      }

   }

   private static final Unit Content$lambda$1$lambda$0(RecomposeScope $r) {
      $r.invalidate();
      return Unit.INSTANCE;
   }

   private static final Unit Content$lambda$2(TestImpl $tmp1_rcvr, int $$changed, Composer $composer, int $force) {
      $tmp1_rcvr.Content($composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }
}
