package land.sungbin.androidplayground;

import androidx.compose.runtime.internal.StabilityInferred;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 1, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\r\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"},
   d2 = {"Lland/sungbin/androidplayground/DebugLayoutUtil;", "", "<init>", "()V", "DEBUG_LAYOUT_PROPERTY", "", "setDebugLayout", "", "value", "getIsDebugLayout", "()Ljava/lang/Boolean;", "app_debug"}
)
@StabilityInferred(
   parameters = 1
)
public final class DebugLayoutUtil {
   @NotNull
   public static final DebugLayoutUtil INSTANCE = new DebugLayoutUtil();
   @NotNull
   private static final String DEBUG_LAYOUT_PROPERTY = "debug.layout";
   public static final int $stable;

   private DebugLayoutUtil() {
   }

   public final boolean setDebugLayout(boolean value) {
      boolean var2;
      try {
         Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
         Class[] var4 = new Class[]{String.class, String.class};
         Method setMethod = systemPropertiesClass.getDeclaredMethod("set", var4);
         Object[] var7 = new Object[]{"debug.layout", String.valueOf(value)};
         setMethod.invoke((Object)null, var7);
         var2 = true;
      } catch (Exception var5) {
         System.out.println(var5);
         var2 = false;
      }

      return var2;
   }

   @Nullable
   public final Boolean getIsDebugLayout() {
      Boolean var1;
      try {
         Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
         Class[] var3 = new Class[]{String.class, Boolean.TYPE};
         Method getBooleanMethod = systemPropertiesClass.getDeclaredMethod("getBoolean", var3);
         Object[] var4 = new Object[]{"debug.layout", false};
         Object var10000 = getBooleanMethod.invoke((Object)null, var4);
         Intrinsics.checkNotNull(var10000, "null cannot be cast to non-null type kotlin.Boolean");
         var1 = (Boolean)var10000;
      } catch (Exception var5) {
         System.out.println(var5);
         var1 = null;
      }

      return var1;
   }
}
