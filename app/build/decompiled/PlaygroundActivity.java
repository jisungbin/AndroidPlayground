package land.sungbin.androidplayground;

import android.app.Notification;
import android.app.Notification.Action;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.widget.RemoteViews;
import androidx.activity.ComponentActivity;
import androidx.compose.runtime.internal.StabilityInferred;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivity\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,41:1\n13309#2,2:42\n13309#2,2:44\n13309#2,2:46\n13309#2,2:48\n13309#2,2:50\n13309#2,2:52\n13309#2,2:54\n13309#2,2:56\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivity\n*L\n14#1:42,2\n15#1:44,2\n22#1:46,2\n23#1:48,2\n30#1:50,2\n31#1:52,2\n36#1:54,2\n37#1:56,2\n*E\n"})
public final class PlaygroundActivity extends ComponentActivity {
   public static final int $stable;

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      System.out.println(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-println$fun-onCreate$class-PlaygroundActivity());
      Class $this$onCreate_u24lambda_u2411 = StatusBarNotification.class;
      int var3 = false;
      Method[] var10000 = $this$onCreate_u24lambda_u2411.getDeclaredMethods();
      Intrinsics.checkNotNullExpressionValue(var10000, "getDeclaredMethods(...)");
      Object[] $this$forEach$iv = (Object[])var10000;
      int $i$f$forEach = false;
      int var6 = 0;

      int var7;
      Object element$iv;
      Method method;
      boolean var10;
      String var12;
      for(var7 = $this$forEach$iv.length; var6 < var7; ++var6) {
         element$iv = $this$forEach$iv[var6];
         method = (Method)element$iv;
         var10 = false;
         var12 = LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach$fun-$anonymous$$arg-0$call-run$fun-onCreate$class-PlaygroundActivity();
         System.out.println(var12 + method.getName() + LiveLiterals$PlaygroundActivityKt.INSTANCE.String$2$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach$fun-$anonymous$$arg-0$call-run$fun-onCreate$class-PlaygroundActivity() + method.getReturnType().getName());
      }

      Field[] var13 = $this$onCreate_u24lambda_u2411.getDeclaredFields();
      Intrinsics.checkNotNullExpressionValue(var13, "getDeclaredFields(...)");
      $this$forEach$iv = (Object[])var13;
      $i$f$forEach = false;
      var6 = 0;

      Field field;
      for(var7 = $this$forEach$iv.length; var6 < var7; ++var6) {
         element$iv = $this$forEach$iv[var6];
         field = (Field)element$iv;
         var10 = false;
         var12 = LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach-1$fun-$anonymous$$arg-0$call-run$fun-onCreate$class-PlaygroundActivity();
         System.out.println(var12 + field.getName() + LiveLiterals$PlaygroundActivityKt.INSTANCE.String$2$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach-1$fun-$anonymous$$arg-0$call-run$fun-onCreate$class-PlaygroundActivity() + field.getType().getName());
      }

      System.out.println();
      System.out.println(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-println-2$fun-onCreate$class-PlaygroundActivity());
      $this$onCreate_u24lambda_u2411 = Notification.class;
      var3 = false;
      var10000 = $this$onCreate_u24lambda_u2411.getDeclaredMethods();
      Intrinsics.checkNotNullExpressionValue(var10000, "getDeclaredMethods(...)");
      $this$forEach$iv = (Object[])var10000;
      $i$f$forEach = false;
      var6 = 0;

      for(var7 = $this$forEach$iv.length; var6 < var7; ++var6) {
         element$iv = $this$forEach$iv[var6];
         method = (Method)element$iv;
         var10 = false;
         var12 = LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach$fun-$anonymous$$arg-0$call-run-1$fun-onCreate$class-PlaygroundActivity();
         System.out.println(var12 + method.getName() + LiveLiterals$PlaygroundActivityKt.INSTANCE.String$2$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach$fun-$anonymous$$arg-0$call-run-1$fun-onCreate$class-PlaygroundActivity() + method.getReturnType().getName());
      }

      var13 = $this$onCreate_u24lambda_u2411.getDeclaredFields();
      Intrinsics.checkNotNullExpressionValue(var13, "getDeclaredFields(...)");
      $this$forEach$iv = (Object[])var13;
      $i$f$forEach = false;
      var6 = 0;

      for(var7 = $this$forEach$iv.length; var6 < var7; ++var6) {
         element$iv = $this$forEach$iv[var6];
         field = (Field)element$iv;
         var10 = false;
         var12 = LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach-1$fun-$anonymous$$arg-0$call-run-1$fun-onCreate$class-PlaygroundActivity();
         System.out.println(var12 + field.getName() + LiveLiterals$PlaygroundActivityKt.INSTANCE.String$2$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach-1$fun-$anonymous$$arg-0$call-run-1$fun-onCreate$class-PlaygroundActivity() + field.getType().getName());
      }

      System.out.println();
      System.out.println(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-println-4$fun-onCreate$class-PlaygroundActivity());
      $this$onCreate_u24lambda_u2411 = Action.class;
      var3 = false;
      var10000 = $this$onCreate_u24lambda_u2411.getDeclaredMethods();
      Intrinsics.checkNotNullExpressionValue(var10000, "getDeclaredMethods(...)");
      $this$forEach$iv = (Object[])var10000;
      $i$f$forEach = false;
      var6 = 0;

      for(var7 = $this$forEach$iv.length; var6 < var7; ++var6) {
         element$iv = $this$forEach$iv[var6];
         method = (Method)element$iv;
         var10 = false;
         var12 = LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach$fun-$anonymous$$arg-0$call-run-2$fun-onCreate$class-PlaygroundActivity();
         System.out.println(var12 + method.getName() + LiveLiterals$PlaygroundActivityKt.INSTANCE.String$2$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach$fun-$anonymous$$arg-0$call-run-2$fun-onCreate$class-PlaygroundActivity() + method.getReturnType().getName());
      }

      var13 = $this$onCreate_u24lambda_u2411.getDeclaredFields();
      Intrinsics.checkNotNullExpressionValue(var13, "getDeclaredFields(...)");
      $this$forEach$iv = (Object[])var13;
      $i$f$forEach = false;
      var6 = 0;

      for(var7 = $this$forEach$iv.length; var6 < var7; ++var6) {
         element$iv = $this$forEach$iv[var6];
         field = (Field)element$iv;
         var10 = false;
         var12 = LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach-1$fun-$anonymous$$arg-0$call-run-2$fun-onCreate$class-PlaygroundActivity();
         System.out.println(var12 + field.getName() + LiveLiterals$PlaygroundActivityKt.INSTANCE.String$2$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach-1$fun-$anonymous$$arg-0$call-run-2$fun-onCreate$class-PlaygroundActivity() + field.getType().getName());
      }

      System.out.println(LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-0$call-println-5$fun-onCreate$class-PlaygroundActivity());
      $this$onCreate_u24lambda_u2411 = RemoteViews.class;
      var3 = false;
      var10000 = $this$onCreate_u24lambda_u2411.getDeclaredMethods();
      Intrinsics.checkNotNullExpressionValue(var10000, "getDeclaredMethods(...)");
      $this$forEach$iv = (Object[])var10000;
      $i$f$forEach = false;
      var6 = 0;

      for(var7 = $this$forEach$iv.length; var6 < var7; ++var6) {
         element$iv = $this$forEach$iv[var6];
         method = (Method)element$iv;
         var10 = false;
         var12 = LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach$fun-$anonymous$$arg-0$call-run-3$fun-onCreate$class-PlaygroundActivity();
         System.out.println(var12 + method.getName() + LiveLiterals$PlaygroundActivityKt.INSTANCE.String$2$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach$fun-$anonymous$$arg-0$call-run-3$fun-onCreate$class-PlaygroundActivity() + method.getReturnType().getName());
      }

      var13 = $this$onCreate_u24lambda_u2411.getDeclaredFields();
      Intrinsics.checkNotNullExpressionValue(var13, "getDeclaredFields(...)");
      $this$forEach$iv = (Object[])var13;
      $i$f$forEach = false;
      var6 = 0;

      for(var7 = $this$forEach$iv.length; var6 < var7; ++var6) {
         element$iv = $this$forEach$iv[var6];
         field = (Field)element$iv;
         var10 = false;
         var12 = LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach-1$fun-$anonymous$$arg-0$call-run-3$fun-onCreate$class-PlaygroundActivity();
         System.out.println(var12 + field.getName() + LiveLiterals$PlaygroundActivityKt.INSTANCE.String$2$str$arg-0$call-println$fun-$anonymous$$arg-0$call-forEach-1$fun-$anonymous$$arg-0$call-run-3$fun-onCreate$class-PlaygroundActivity() + field.getType().getName());
      }

   }

   static {
      $stable = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$class-PlaygroundActivity();
   }
}
