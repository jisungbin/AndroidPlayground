package land.sungbin.androidplayground;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JvmInline
@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004B \u0012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0002H\u0097\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t\u0088\u0001\u0005¨\u0006\u001d"},
   d2 = {"Lland/sungbin/androidplayground/ComposableClass;", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier;", "", "Landroidx/compose/runtime/Composable;", "composable", "constructor-impl", "(Lkotlin/jvm/functions/Function3;)Lkotlin/jvm/functions/Function3;", "getComposable", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "equals", "", "other", "", "equals-impl", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Lkotlin/jvm/functions/Function3;)I", "invoke", "p1", "invoke-impl", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "toString", "", "toString-impl", "(Lkotlin/jvm/functions/Function3;)Ljava/lang/String;", "app_debug"}
)
public final class ComposableClass implements Function3 {
   @NotNull
   private final Function3 composable;

   @NotNull
   public final Function3 getComposable() {
      return this.composable;
   }

   public static String toString_impl/* $FF was: toString-impl*/(Function3 arg0) {
      return "ComposableClass(composable=" + arg0 + ")";
   }

   public String toString() {
      return toString-impl(this.composable);
   }

   public static int hashCode_impl/* $FF was: hashCode-impl*/(Function3 arg0) {
      return arg0.hashCode();
   }

   public int hashCode() {
      return hashCode-impl(this.composable);
   }

   public static boolean equals_impl/* $FF was: equals-impl*/(Function3 arg0, Object other) {
      if (!(other instanceof ComposableClass)) {
         return false;
      } else {
         return Intrinsics.areEqual(arg0, ((ComposableClass)other).unbox-impl());
      }
   }

   public boolean equals(Object other) {
      return equals-impl(this.composable, other);
   }

   @Composable
   public static void invoke_impl/* $FF was: invoke-impl*/(Function3 arg0, @NotNull Modifier p1, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(p1, "p1");
      $composer = $composer.startRestartGroup(636074801);
      ComposerKt.sourceInformation($composer, "C(invoke)0@-2:PlaygroundActivity.kt#qshby3");
      int $dirty = $changed;
      if (($changed & 6) == 0) {
         $dirty = $changed | ($composer.changed(p1) ? 4 : 2);
      }

      if (($changed & 48) == 0) {
         $dirty |= $composer.changedInstance(arg0) ? 32 : 16;
      }

      if (($dirty & 19) == 18 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(636074801, $dirty, -1, "land.sungbin.androidplayground.ComposableClass.invoke (PlaygroundActivity.kt:0)");
         }

         arg0.invoke(p1, $composer, 14 & $dirty);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var10000 = $composer.endRestartGroup();
      if (var10000 != null) {
         var10000.updateScope(ComposableClass::invoke_impl$lambda$0);
      }

   }

   @Composable
   public void invoke(@NotNull Modifier p1, @Nullable Composer $composer, int $changed) {
      Intrinsics.checkNotNullParameter(p1, "p1");
      invoke-impl(this.composable, p1, $composer, $changed);
   }

   // $FF: synthetic method
   private ComposableClass(Function3 composable) {
      this.composable = composable;
   }

   @NotNull
   public static Function3 constructor_impl/* $FF was: constructor-impl*/(@NotNull Function3 composable) {
      Intrinsics.checkNotNullParameter(composable, "composable");
      return composable;
   }

   // $FF: synthetic method
   public static final ComposableClass box_impl/* $FF was: box-impl*/(Function3 v) {
      return new ComposableClass(v);
   }

   // $FF: synthetic method
   public final Function3 unbox_impl/* $FF was: unbox-impl*/() {
      return this.composable;
   }

   public static final boolean equals_impl0/* $FF was: equals-impl0*/(Function3 p1, Function3 p2) {
      return Intrinsics.areEqual(p1, p2);
   }

   private static final Unit invoke_impl$lambda$0(Function3 $tmp0_rcvr, Modifier $p1, int $$changed, Composer $composer, int $force) {
      invoke-impl($tmp0_rcvr, $p1, $composer, RecomposeScopeImplKt.updateChangedFlags($$changed | 1));
      return Unit.INSTANCE;
   }
}
