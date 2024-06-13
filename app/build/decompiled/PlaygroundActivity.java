package land.sungbin.androidplayground;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.collection.IntObjectMap;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifierKt;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsOwnerKt;
import androidx.compose.ui.unit.Dp;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
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
public final class PlaygroundActivity extends ComponentActivity {
   public static final int $stable;

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      ComponentActivityKt.setContent$default((ComponentActivity)this, (CompositionContext)null, (Function2)ComposableLambdaKt.composableLambdaInstance(2023832317, true, new Function2() {
         @Composable
         @ComposableTarget(
            applier = "androidx.compose.ui.UiComposable"
         )
         public final void invoke(@Nullable Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C56@2517L7,57@2586L21,59@2628L39,64@2744L996,61@2675L2395:PlaygroundActivity.kt#qshby3");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
               $composer.skipToGroupEnd();
            } else {
               if (ComposerKt.isTraceInProgress()) {
                  ComposerKt.traceEventStart(2023832317, $changed, -1, "land.sungbin.androidplayground.PlaygroundActivity.onCreate.<anonymous> (PlaygroundActivity.kt:56)");
               }

               CompositionLocal this_$iv = (CompositionLocal)AndroidCompositionLocals_androidKt.getLocalView();
               int $changed$iv = false;
               int $i$f$getCurrent = false;
               ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
               Object var8 = $composer.consume(this_$iv);
               ComposerKt.sourceInformationMarkerEnd($composer);
               Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type androidx.compose.ui.node.Owner");
               final Owner owner = (Owner)var8;
               final RecomposeScope recomposeScope = ComposablesKt.getCurrentRecomposeScope($composer, 0);
               $composer.startReplaceableGroup(-729096657);
               ComposerKt.sourceInformation($composer, "CC(remember):PlaygroundActivity.kt#9igjgp");
               boolean invalid$iv = false;
               int $i$f$cache = false;
               Object it$iv = $composer.rememberedValue();
               int var11 = false;
               boolean var12;
               Object var10000;
               if (it$iv == Composer.Companion.getEmpty()) {
                  var12 = false;
                  Object value$ivx = SnapshotStateKt.mutableStateListOf();
                  $composer.updateRememberedValue(value$ivx);
                  var10000 = value$ivx;
               } else {
                  var10000 = it$iv;
               }

               final SnapshotStateList var16 = (SnapshotStateList)var10000;
               $composer.endReplaceableGroup();
               final SnapshotStateList bounds = var16;
               Modifier var20 = SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null);
               $composer.startReplaceableGroup(-729096541);
               ComposerKt.sourceInformation($composer, "CC(remember):PlaygroundActivity.kt#9igjgp");
               invalid$iv = false;
               $i$f$cache = false;
               it$iv = $composer.rememberedValue();
               var11 = false;
               Object var21;
               if (it$iv == Composer.Companion.getEmpty()) {
                  Modifier var14 = var20;
                  var12 = false;
                  Function1 var10001 = (Function1)(new Function1() {
                     public final void invoke(@NotNull DrawScope $this$drawBehind) {
                        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
                        long var10000 = androidx.compose.ui.geometry.SizeKt.getCenter-uvyYCjk($this$drawBehind.getSize-NH-jbRc());
                        int $this$dp$ivx = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$$$this$call-$get-dp$$$$this$call-toPx$arg-0$call-Size$arg-1$call-Rect$val-clickableArea$fun-$anonymous$$arg-0$call-drawBehind$$$this$call-clickableBoundingRect$$$this$call-clickableBoundingRect$$$this$call-onPlaced$arg-0$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity();
                        int $i$f$getDpx = false;
                        float var10001 = $this$drawBehind.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$ivx));
                        $this$dp$ivx = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$$$this$call-$get-dp$$$$this$call-toPx$arg-1$call-Size$arg-1$call-Rect$val-clickableArea$fun-$anonymous$$arg-0$call-drawBehind$$$this$call-clickableBoundingRect$$$this$call-clickableBoundingRect$$$this$call-onPlaced$arg-0$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity();
                        $i$f$getDpx = false;
                        Rect clickableArea = RectKt.Rect-tz77jQw(var10000, androidx.compose.ui.geometry.SizeKt.Size(var10001, $this$drawBehind.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$ivx))));
                        var10000 = androidx.compose.ui.geometry.SizeKt.getCenter-uvyYCjk($this$drawBehind.getSize-NH-jbRc());
                        int $this$dp$iv = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$$$this$call-$get-dp$$$$this$call-toPx$arg-0$call-Size$arg-1$call-Rect$val-clickableArea2$fun-$anonymous$$arg-0$call-drawBehind$$$this$call-clickableBoundingRect$$$this$call-clickableBoundingRect$$$this$call-onPlaced$arg-0$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity();
                        int $i$f$forEach = false;
                        var10001 = $this$drawBehind.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv));
                        $this$dp$iv = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$$$this$call-$get-dp$$$$this$call-toPx$arg-1$call-Size$arg-1$call-Rect$val-clickableArea2$fun-$anonymous$$arg-0$call-drawBehind$$$this$call-clickableBoundingRect$$$this$call-clickableBoundingRect$$$this$call-onPlaced$arg-0$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity();
                        $i$f$forEach = false;
                        Rect clickableArea2 = RectKt.Rect-tz77jQw(var10000, androidx.compose.ui.geometry.SizeKt.Size(var10001, $this$drawBehind.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv))));
                        DrawScope.drawRect-n-J9OG0$default($this$drawBehind, Color.Companion.getGreen-0d7_KjU(), clickableArea.getTopLeft-F1C5BW0(), clickableArea.getSize-NH-jbRc(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-3$call-drawRect$fun-$anonymous$$arg-0$call-drawBehind$$$this$call-clickableBoundingRect$$$this$call-clickableBoundingRect$$$this$call-onPlaced$arg-0$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity(), (DrawStyle)null, (ColorFilter)null, 0, 112, (Object)null);
                        DrawScope.drawRect-n-J9OG0$default($this$drawBehind, Color.Companion.getBlue-0d7_KjU(), clickableArea2.getTopLeft-F1C5BW0(), clickableArea2.getSize-NH-jbRc(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Float$arg-3$call-drawRect-1$fun-$anonymous$$arg-0$call-drawBehind$$$this$call-clickableBoundingRect$$$this$call-clickableBoundingRect$$$this$call-onPlaced$arg-0$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity(), (DrawStyle)null, (ColorFilter)null, 0, 112, (Object)null);
                        Iterable $this$forEach$iv = (Iterable)var16;
                        $i$f$forEach = false;
                        Iterator var6 = $this$forEach$iv.iterator();

                        while(var6.hasNext()) {
                           Object element$iv = var6.next();
                           Rect clickableBound = (Rect)element$iv;
                           int var9 = false;
                           long var15 = Color.Companion.getRed-0d7_KjU();
                           long var10002 = clickableBound.getTopLeft-F1C5BW0();
                           long var10003 = clickableBound.getSize-NH-jbRc();
                           int $this$dp$ivxx = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$$$this$call-$get-dp$$$$this$call-toPx$arg-0$call-$init$$arg-4$call-drawRect$fun-$anonymous$$arg-0$call-forEach$fun-$anonymous$$arg-0$call-drawBehind$$$this$call-clickableBoundingRect$$$this$call-clickableBoundingRect$$$this$call-onPlaced$arg-0$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity();
                           int $i$f$getDp = false;
                           DrawScope.drawRect-n-J9OG0$default($this$drawBehind, var15, var10002, var10003, 0.0F, (DrawStyle)(new Stroke($this$drawBehind.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$ivxx)), 0.0F, 0, 0, (PathEffect)null, 30, (DefaultConstructorMarker)null)), (ColorFilter)null, 0, 104, (Object)null);
                        }

                     }
                  });
                  var20 = var14;
                  Object value$iv = var10001;
                  $composer.updateRememberedValue(value$iv);
                  var21 = value$iv;
               } else {
                  var21 = it$iv;
               }

               Function1 var17 = (Function1)var21;
               $composer.endReplaceableGroup();
               BoxKt.Box(OnPlacedModifierKt.onPlaced(PlaygroundActivityKt.clickableBoundingRect(PlaygroundActivityKt.clickableBoundingRect(DrawModifierKt.drawBehind(var20, var17), new Object[0], LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$arg-1$call-clickableBoundingRect$$$this$call-clickableBoundingRect$$$this$call-onPlaced$arg-0$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity(), (Function2)null.INSTANCE, (Function1)(new Function1() {
                  public final void invoke_k_4lQ0M/* $FF was: invoke-k-4lQ0M*/(long offset) {
                     Context var10000 = PlaygroundActivity.this.getApplicationContext();
                     String var10001 = Offset.toString-impl(offset);
                     Toast.makeText(var10000, (CharSequence)(var10001 + LiveLiterals$PlaygroundActivityKt.INSTANCE.String$1$str$arg-1$call-makeText$$this$call-show$fun-$anonymous$$arg-3$call-clickableBoundingRect$$$this$call-clickableBoundingRect$$$this$call-onPlaced$arg-0$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity()), 0).show();
                     recomposeScope.invalidate();
                  }
               })), new Object[0], LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$arg-1$call-clickableBoundingRect$$$this$call-onPlaced$arg-0$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity(), (Function2)null.INSTANCE, (Function1)(new Function1() {
                  public final void invoke_k_4lQ0M/* $FF was: invoke-k-4lQ0M*/(long offset) {
                     Context var10000 = PlaygroundActivity.this.getApplicationContext();
                     String var10001 = Offset.toString-impl(offset);
                     Toast.makeText(var10000, (CharSequence)(var10001 + LiveLiterals$PlaygroundActivityKt.INSTANCE.String$1$str$arg-1$call-makeText$$this$call-show$fun-$anonymous$$arg-3$call-clickableBoundingRect$$$this$call-onPlaced$arg-0$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity()), 0).show();
                     recomposeScope.invalidate();
                  }
               })), (Function1)(new Function1() {
                  public final void invoke(@NotNull LayoutCoordinates it) {
                     Intrinsics.checkNotNullParameter(it, "it");
                     List semantics = SemanticsOwnerKt.getAllSemanticsNodes$default(owner.getRootForTest().getSemanticsOwner(), LiveLiterals$PlaygroundActivityKt.INSTANCE.Boolean$arg-0$call-getAllSemanticsNodes$val-semantics$fun-$anonymous$$arg-0$call-onPlaced$arg-0$call-Box$fun-$anonymous$$arg-1$call-setContent$fun-onCreate$class-PlaygroundActivity(), false, 2, (Object)null);
                     Iterable $this$first$iv = (Iterable)semantics;
                     int $i$f$first = false;
                     Iterator var6 = $this$first$iv.iterator();

                     Object element$iv;
                     SemanticsNode node;
                     boolean var9;
                     do {
                        if (!var6.hasNext()) {
                           throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }

                        element$iv = var6.next();
                        node = (SemanticsNode)element$iv;
                        var9 = false;
                     } while(!node.getConfig().contains(PlaygroundActivityKt.access$getPointerInputBounds$p()));

                     SemanticsNode var3 = (SemanticsNode)element$iv;
                     IntObjectMap this_$iv = (IntObjectMap)var3.getConfig().get(PlaygroundActivityKt.access$getPointerInputBounds$p());
                     SnapshotStateList var28 = bounds;
                     boolean var29 = false;
                     Object[] v$iv = this_$iv.values;
                     var9 = false;
                     long[] m$iv$iv = this_$iv.metadata;
                     int lastIndex$iv$iv = m$iv$iv.length - 2;
                     int i$iv$iv = 0;
                     if (i$iv$iv <= lastIndex$iv$iv) {
                        while(true) {
                           long slot$iv$iv = m$iv$iv[i$iv$iv];
                           int $i$f$maskEmptyOrDeleted = false;
                           if ((slot$iv$iv & ~slot$iv$iv << 7 & -9187201950435737472L) != -9187201950435737472L) {
                              int bitCount$iv$iv = 8 - (~(i$iv$iv - lastIndex$iv$iv) >>> 31);
                              int j$iv$iv = 0;

                              while(true) {
                                 if (j$iv$iv >= bitCount$iv$iv) {
                                    if (bitCount$iv$iv != 8) {
                                       return;
                                    }
                                    break;
                                 }

                                 long value$iv$iv$iv = slot$iv$iv & 255L;
                                 int $i$f$isFull = false;
                                 if (value$iv$iv$iv < 128L) {
                                    int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                                    int var24 = false;
                                    Rect p0 = (Rect)v$iv[index$iv$iv];
                                    int var26 = false;
                                    var28.add(p0);
                                 }

                                 slot$iv$iv >>= 8;
                                 ++j$iv$iv;
                              }
                           }

                           if (i$iv$iv == lastIndex$iv$iv) {
                              break;
                           }

                           ++i$iv$iv;
                        }
                     }

                  }
               })), $composer, 0);
               if (ComposerKt.isTraceInProgress()) {
                  ComposerKt.traceEventEnd();
               }
            }

         }
      }), 1, (Object)null);
   }

   static {
      $stable = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$class-PlaygroundActivity();
   }
}
