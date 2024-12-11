package land.sungbin.androidplayground;

import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontVariation.Setting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(
   mv = {2, 0, 0},
   k = 2,
   xi = 48,
   d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0002¨\u0006\u0003"},
   d2 = {"pretendardVariables", "", "Landroidx/compose/ui/text/font/Font;", "app_debug"}
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivityKt\n+ 2 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,195:1\n508#2,3:196\n33#2,4:199\n511#2:203\n151#2,3:204\n33#2,4:207\n154#2,2:211\n38#2:213\n156#2:214\n512#2,2:215\n38#2:217\n514#2:218\n151#2,3:219\n33#2,4:222\n154#2,2:226\n38#2:228\n156#2:229\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivityKt\n*L\n186#1:196,3\n186#1:199,4\n186#1:203\n186#1:204,3\n186#1:207,4\n186#1:211,2\n186#1:213\n186#1:214\n186#1:215,2\n186#1:217\n186#1:218\n187#1:219,3\n187#1:222,4\n187#1:226,2\n187#1:228\n187#1:229\n*E\n"})
public final class PlaygroundActivityKt {
   private static final List pretendardVariables() {
      List $this$fastMap$iv = FontWeight.Companion.getValues$ui_text_release();
      int $i$f$fastMap = false;
      ArrayList target$iv = new ArrayList($this$fastMap$iv.size());
      List $this$fastForEach$iv$iv = $this$fastMap$iv;
      int $i$f$fastForEach = false;
      int index$iv$iv = 0;

      int var6;
      Object item$iv$iv;
      boolean var9;
      boolean var11;
      Collection var10000;
      for(var6 = $this$fastMap$iv.size(); index$iv$iv < var6; ++index$iv$iv) {
         item$iv$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
         var9 = false;
         FontWeight weight = (FontWeight)item$iv$iv;
         var11 = false;
         List $this$fastMap$iv = FontStyle.Companion.values();
         int $i$f$fastMap = false;
         ArrayList target$iv = new ArrayList($this$fastMap$iv.size());
         List $this$fastForEach$iv$iv = $this$fastMap$iv;
         int $i$f$fastForEach = false;
         int index$iv$iv = 0;

         for(int var18 = $this$fastMap$iv.size(); index$iv$iv < var18; ++index$iv$iv) {
            Object item$iv$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            int var21 = false;
            var10000 = (Collection)target$iv;
            int style = ((FontStyle)item$iv$iv).unbox-impl();
            Collection var23 = var10000;
            int var24 = false;
            var23.add(TuplesKt.to(weight, FontStyle.box-impl(style)));
         }

         Iterable list$iv = (Iterable)((List)target$iv);
         CollectionsKt.addAll((Collection)target$iv, list$iv);
      }

      $this$fastMap$iv = (List)target$iv;
      $i$f$fastMap = false;
      target$iv = new ArrayList($this$fastMap$iv.size());
      $this$fastForEach$iv$iv = $this$fastMap$iv;
      $i$f$fastForEach = false;
      index$iv$iv = 0;

      for(var6 = $this$fastMap$iv.size(); index$iv$iv < var6; ++index$iv$iv) {
         item$iv$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
         var9 = false;
         var10000 = (Collection)target$iv;
         Pair var27 = (Pair)item$iv$iv;
         Collection var25 = var10000;
         var11 = false;
         FontWeight weight = (FontWeight)var27.component1();
         int style = ((FontStyle)var27.component2()).unbox-impl();
         var25.add(FontKt.Font-F3nL8kk$default(2131034112, weight, style, 0, FontVariation.INSTANCE.Settings-6EWAqTQ(weight, style, new Setting[0]), 8, (Object)null));
      }

      return (List)target$iv;
   }

   // $FF: synthetic method
   public static final List access$pretendardVariables() {
      return pretendardVariables();
   }
}
