package land.sungbin.androidplayground;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"},
   d2 = {"Lland/sungbin/androidplayground/FontScaleInspector;", "", "<init>", "()V", "TAG", "", "MAX_SCALE_ANDROID_14", "", "MAX_SCALE_LEGACY", "getMaxUserSelectableFontScale", "context", "Landroid/content/Context;", "extractFromSettingsResources", "(Landroid/content/Context;)Ljava/lang/Float;", "app_debug"}
)
@StabilityInferred(
   parameters = 1
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/FontScaleInspector\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,114:1\n11879#2,9:115\n13805#2:124\n13806#2:126\n11888#2:127\n1#3:125\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/FontScaleInspector\n*L\n97#1:115,9\n97#1:124\n97#1:126\n97#1:127\n97#1:125\n*E\n"})
public final class FontScaleInspector {
   @NotNull
   public static final FontScaleInspector INSTANCE = new FontScaleInspector();
   @NotNull
   private static final String TAG = "FontScaleInspector";
   private static final float MAX_SCALE_ANDROID_14 = 2.0F;
   private static final float MAX_SCALE_LEGACY = 1.3F;
   public static final int $stable;

   private FontScaleInspector() {
   }

   public final float getMaxUserSelectableFontScale(@NotNull Context context) {
      Intrinsics.checkNotNullParameter(context, "context");
      Float settingsMax = this.extractFromSettingsResources(context);
      if (settingsMax != null) {
         Log.i("FontScaleInspector", "Detected precise max font scale from Settings app: " + settingsMax);
         return settingsMax;
      } else {
         float var10000;
         if (VERSION.SDK_INT >= 34) {
            Log.i("FontScaleInspector", "Using Android 14+ standard max scale: 2.0");
            var10000 = 2.0F;
         } else {
            Log.i("FontScaleInspector", "Using legacy standard max scale: 1.3");
            var10000 = 1.3F;
         }

         return var10000;
      }
   }

   private final Float extractFromSettingsResources(Context context) {
      String targetPackage = "com.android.settings";

      Float var3;
      try {
         Context settingsContext = context.createPackageContext(targetPackage, 2);
         Resources res = settingsContext.getResources();
         int resId = res.getIdentifier("entryvalues_font_size", "array", targetPackage);
         if (resId == 0) {
            Log.w("FontScaleInspector", "Resource 'entryvalues_font_size' not found in " + targetPackage);
            return null;
         }

         String[] var10000 = res.getStringArray(resId);
         Intrinsics.checkNotNullExpressionValue(var10000, "getStringArray(...)");
         String[] values = var10000;
         int var8 = false;
         Collection var10 = (Collection)(new ArrayList());
         int var11 = false;
         Object[] var12 = values;
         int var13 = false;
         int var14 = 0;

         for(int var15 = values.length; var14 < var15; ++var14) {
            Object var16 = var12[var14];
            int var18 = false;
            String var19 = var16;
            boolean var20 = false;

            Float var21;
            try {
               Intrinsics.checkNotNull(var19);
               var21 = Float.parseFloat(var19);
            } catch (NumberFormatException var25) {
               var21 = null;
            }

            if (var21 != null) {
               int var24 = false;
               var10.add(var21);
            }
         }

         var3 = CollectionsKt.maxOrNull((Iterable)((List)var10));
      } catch (NameNotFoundException var26) {
         Log.w("FontScaleInspector", "Settings package not found: " + targetPackage);
         var3 = null;
      } catch (Exception var27) {
         Log.e("FontScaleInspector", "Failed to inspect settings resources", (Throwable)var27);
         var3 = null;
      }

      return var3;
   }
}
