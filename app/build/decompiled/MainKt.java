package land.sungbin.androidplayground;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import land.sungbin.composeinvestigator.runtime.ComposableInvalidationTrackTable;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 9, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"},
   d2 = {"main", "", "app_debug"}
)
@SourceDebugExtension({"SMAP\nmain.kt\nKotlin\n*S Kotlin\n*F\n+ 1 main.kt\nland/sungbin/androidplayground/MainKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,18:1\n1#2:19\n*E\n"})
public final class MainKt {
   @NotNull
   private static final ComposableInvalidationTrackTable ComposableInvalidationTrackTableImpl$MainKt = new ComposableInvalidationTrackTable();
   @NotNull
   public static final Stack ComposableCallstackTrackerImpl$MainKt = new Stack();

   @NotNull
   public static final Stack getComposableCallstackTrackerImpl$MainKt() {
      return ComposableCallstackTrackerImpl$MainKt;
   }

   public static final void main() {
      Class dss = Class.forName(LiveLiterals$MainKt.INSTANCE.String$arg-0$call-forName$val-dss$fun-main());
      Method[] var10000 = dss.getDeclaredMethods();
      Intrinsics.checkNotNullExpressionValue(var10000, "getDeclaredMethods(...)");
      Object[] var4 = (Object[])var10000;
      int var5 = 0;
      int var6 = var4.length;

      Object var12;
      while(true) {
         if (var5 >= var6) {
            var12 = null;
            break;
         }

         Object var7 = var4[var5];
         Method it = (Method)var7;
         int var9 = false;
         if (Intrinsics.areEqual(it.getName(), LiveLiterals$MainKt.INSTANCE.String$arg-1$call-EQEQ$fun-$anonymous$$arg-0$call-find$val-tmp0_safe_receiver$val-displayValueMethod$fun-main())) {
            var12 = var7;
            break;
         }

         ++var5;
      }

      Method var13 = (Method)var12;
      if ((Method)var12 != null) {
         Method var3 = var13;
         int var11 = false;
         var3.setAccessible(LiveLiterals$MainKt.INSTANCE.Boolean$arg-0$call-setAccessible$fun-$anonymous$$arg-0$call-apply$else$when$val-displayValueMethod$fun-main());
         var13 = var3;
      } else {
         var13 = null;
      }

      Method displayValueMethod = var13;
      final MutableIntState number = SnapshotIntStateKt.mutableIntStateOf(Integer.MAX_VALUE);
      State numberFormatter = SnapshotStateKt.derivedStateOf((Function0)(new Function0() {
         public final String invoke() {
            return NumberFormat.getNumberInstance().format(number.getIntValue());
         }
      }));
      System.out.println(numberFormatter.getValue());
      System.out.println(displayValueMethod != null ? displayValueMethod.invoke(numberFormatter) : null);
      number.setIntValue(Integer.MIN_VALUE);
      System.out.println(numberFormatter.getValue());
      System.out.println(displayValueMethod != null ? displayValueMethod.invoke(numberFormatter) : null);
   }

   // $FF: synthetic method
   public static void main(String[] args) {
      main();
   }
}
