package land.sungbin.androidplayground;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composable;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u0005H\u0017R\u00020\u0006j\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\b¨\u0006\t"},
   d2 = {"Lland/sungbin/androidplayground/TestImpl;", "Lland/sungbin/androidplayground/Test;", "<init>", "()V", "Content", "", "", "a", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "app_debug"}
)
@StabilityInferred(
   parameters = 1
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/TestImpl\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,69:1\n1282#2,6:70\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/TestImpl\n*L\n52#1:70,6\n*E\n"})
public final class TestImpl implements Test {
   @NotNull
   public static final TestImpl INSTANCE = new TestImpl();
   public static final int $stable;

   private TestImpl() {
   }

   @Composable
   public void Content(@NotNull Object a, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(a, "a");
      $composer = $composer.startRestartGroup(1021075470);
      ComposerKt.sourceInformation($composer, "C(Content)N(a)50@1397L21,51@1499L18,51@1423L95:PlaygroundActivity.kt#qshby3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changedInstance(a) ? 4 : 2);
      }

      if ($composer.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1021075470, $dirty, -1, "land.sungbin.androidplayground.TestImpl.Content (PlaygroundActivity.kt:48)");
         }

         PlaygroundActivityKt.used(a);
         RecomposeScope r = ComposablesKt.getCurrentRecomposeScope($composer, 0);
         String var10000 = r + " with " + System.currentTimeMillis();
         Modifier var10001 = (Modifier)Modifier.Companion;
         boolean var10002 = false;
         Object var10003 = null;
         Object var10004 = null;
         ComposerKt.sourceInformationMarkerStart($composer, 2000989344, "CC(remember):PlaygroundActivity.kt#9igjgp");
         boolean var8 = $composer.changedInstance(r);
         int var9 = false;
         Object var10 = $composer.rememberedValue();
         int var11 = false;
         Object var10005;
         if (!var8 && var10 != Composer.Companion.getEmpty()) {
            var10005 = var10;
         } else {
            Object var18 = null;
            Object var17 = null;
            boolean var16 = false;
            Modifier var15 = var10001;
            String var14 = var10000;
            int var12 = false;
            Function0 var19 = TestImpl::Content$lambda$1$lambda$0;
            var10000 = var14;
            var10001 = var15;
            var10002 = var16;
            var10003 = var17;
            var10004 = var18;
            $composer.updateRememberedValue(var19);
            var10005 = var19;
         }

         Function0 var6 = (Function0)var10005;
         ComposerKt.sourceInformationMarkerEnd($composer);
         TextKt.Text--4IGK_g(var10000, ClickableKt.clickable-XHw0xAI$default(var10001, var10002, (String)var10003, (Role)var10004, var6, 7, (Object)null), 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131068);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      } else {
         $composer.skipToGroupEnd();
      }

      ScopeUpdateScope var20 = $composer.endRestartGroup();
      if (var20 != null) {
         var20.updateScope(TestImpl::Content$lambda$2);
      }

   }

   private static final Unit Content$lambda$1$lambda$0(RecomposeScope $r) {
      $r.invalidate();
      return Unit.INSTANCE;
   }

   private static final Unit Content$lambda$2(TestImpl $tmp1_rcvr, Object $a, int $$changed, Composer $composer, int $force) {
      $tmp1_rcvr.Content($a, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }
}
