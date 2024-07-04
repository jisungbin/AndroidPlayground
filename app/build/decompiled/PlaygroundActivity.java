package land.sungbin.androidplayground;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.NavigationBarItemColors;
import androidx.compose.material3.NavigationBarKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarColors;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 9, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0002\u0010\fJ\r\u0010\r\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0013J \u0010\u0014\u001a\u00020\u00042\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00040\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u0018J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014¨\u0006\u001c²\u0006\n\u0010\u0005\u001a\u00020\u0006X\u008a\u008e\u0002"},
   d2 = {"Lland/sungbin/androidplayground/PlaygroundActivity;", "Landroidx/activity/ComponentActivity;", "()V", "BottomNavigationBar", "", "selectedItem", "", "onItemSelected", "Lkotlin/Function1;", "items", "", "", "(ILkotlin/jvm/functions/Function1;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "HomeScreen", "(Landroidx/compose/runtime/Composer;I)V", "MainContent", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "(Landroidx/compose/foundation/layout/PaddingValues;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "TopAppBar", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"}
)
@StabilityInferred(
   parameters = 1
)
@SourceDebugExtension({"SMAP\nPlaygroundActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivity\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 SnapshotIntState.kt\nandroidx/compose/runtime/SnapshotIntStateKt__SnapshotIntStateKt\n*L\n1#1,77:1\n1116#2,6:78\n75#3:84\n108#3,2:85\n*S KotlinDebug\n*F\n+ 1 PlaygroundActivity.kt\nland/sungbin/androidplayground/PlaygroundActivity\n*L\n36#1:78,6\n36#1:84\n36#1:85,2\n*E\n"})
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
            ComposerKt.sourceInformation($composer, "C29@1160L12:PlaygroundActivity.kt#qshby3");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
               $composer.skipToGroupEnd();
            } else {
               if (ComposerKt.isTraceInProgress()) {
                  ComposerKt.traceEventStart(2023832317, $changed, -1, "land.sungbin.androidplayground.PlaygroundActivity.onCreate.<anonymous> (PlaygroundActivity.kt:29)");
               }

               PlaygroundActivity.this.HomeScreen($composer, 0);
               if (ComposerKt.isTraceInProgress()) {
                  ComposerKt.traceEventEnd();
               }
            }

         }
      }), 1, (Object)null);
   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public final void HomeScreen(@Nullable Composer $composer, final int $changed) {
      $composer = $composer.startRestartGroup(-880495258);
      ComposerKt.sourceInformation($composer, "C(HomeScreen)35@1243L33,38@1337L327:PlaygroundActivity.kt#qshby3");
      int $dirty = $changed;
      if (($changed & 14) == 0) {
         $dirty = $changed | ($composer.changed(this) ? 4 : 2);
      }

      if (($dirty & 11) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-880495258, $dirty, -1, "land.sungbin.androidplayground.PlaygroundActivity.HomeScreen (PlaygroundActivity.kt:34)");
         }

         $composer.startReplaceableGroup(967552981);
         ComposerKt.sourceInformation($composer, "CC(remember):PlaygroundActivity.kt#9igjgp");
         boolean invalid$iv = false;
         int $i$f$cache = false;
         Object it$iv = $composer.rememberedValue();
         int var10 = false;
         Object var10000;
         if (it$iv == Composer.Companion.getEmpty()) {
            int var11 = false;
            Object value$iv = SnapshotIntStateKt.mutableIntStateOf(LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$arg-0$call-mutableIntStateOf$fun-$anonymous$$arg-0$call-remember$val-selectedItem$delegate$fun-HomeScreen$class-PlaygroundActivity());
            $composer.updateRememberedValue(value$iv);
            var10000 = value$iv;
         } else {
            var10000 = it$iv;
         }

         MutableIntState var5 = (MutableIntState)var10000;
         $composer.endReplaceableGroup();
         final MutableIntState selectedItem$delegate = var5;
         String[] var6 = new String[]{LiveLiterals$PlaygroundActivityKt.INSTANCE.String$0$vararg$arg-0$call-listOf$val-items$fun-HomeScreen$class-PlaygroundActivity(), LiveLiterals$PlaygroundActivityKt.INSTANCE.String$1$vararg$arg-0$call-listOf$val-items$fun-HomeScreen$class-PlaygroundActivity(), LiveLiterals$PlaygroundActivityKt.INSTANCE.String$2$vararg$arg-0$call-listOf$val-items$fun-HomeScreen$class-PlaygroundActivity()};
         final List items = CollectionsKt.listOf(var6);
         ScaffoldKt.Scaffold-TvnljyQ((Modifier)null, (Function2)ComposableLambdaKt.composableLambda($composer, 1602155818, true, new Function2() {
            @Composable
            @ComposableTarget(
               applier = "androidx.compose.ui.UiComposable"
            )
            public final void invoke(@Nullable Composer $composer, int $changed) {
               ComposerKt.sourceInformation($composer, "C40@1372L60:PlaygroundActivity.kt#qshby3");
               if (($changed & 11) == 2 && $composer.getSkipping()) {
                  $composer.skipToGroupEnd();
               } else {
                  if (ComposerKt.isTraceInProgress()) {
                     ComposerKt.traceEventStart(1602155818, $changed, -1, "land.sungbin.androidplayground.PlaygroundActivity.HomeScreen.<anonymous> (PlaygroundActivity.kt:40)");
                  }

                  PlaygroundActivity.this.TopAppBar(ComposableSingletons$PlaygroundActivityKt.INSTANCE.getLambda-1$app_debug(), $composer, 6);
                  if (ComposerKt.isTraceInProgress()) {
                     ComposerKt.traceEventEnd();
                  }
               }

            }
         }), (Function2)ComposableLambdaKt.composableLambda($composer, 2033072619, true, new Function2() {
            @Composable
            @ComposableTarget(
               applier = "androidx.compose.ui.UiComposable"
            )
            public final void invoke(@Nullable Composer $composer, int $changed) {
               ComposerKt.sourceInformation($composer, "C45@1536L21,45@1470L103:PlaygroundActivity.kt#qshby3");
               if (($changed & 11) == 2 && $composer.getSkipping()) {
                  $composer.skipToGroupEnd();
               } else {
                  if (ComposerKt.isTraceInProgress()) {
                     ComposerKt.traceEventStart(2033072619, $changed, -1, "land.sungbin.androidplayground.PlaygroundActivity.HomeScreen.<anonymous> (PlaygroundActivity.kt:45)");
                  }

                  PlaygroundActivity var10000 = PlaygroundActivity.this;
                  int var10001 = PlaygroundActivity.HomeScreen$lambda$1(selectedItem$delegate);
                  $composer.startReplaceableGroup(-1201140709);
                  ComposerKt.sourceInformation($composer, "CC(remember):PlaygroundActivity.kt#9igjgp");
                  boolean var5 = false;
                  final MutableIntState var6 = selectedItem$delegate;
                  int $i$f$cache = false;
                  Object it$iv = $composer.rememberedValue();
                  int var9 = false;
                  Object var10002;
                  if (it$iv == Composer.Companion.getEmpty()) {
                     int var13 = var10001;
                     PlaygroundActivity var12 = var10000;
                     int var10 = false;
                     Function1 var14 = (Function1)(new Function1() {
                        public final void invoke(int it) {
                           PlaygroundActivity.HomeScreen$lambda$2(var6, it);
                        }
                     });
                     var10000 = var12;
                     var10001 = var13;
                     $composer.updateRememberedValue(var14);
                     var10002 = var14;
                  } else {
                     var10002 = it$iv;
                  }

                  Function1 var3 = (Function1)var10002;
                  $composer.endReplaceableGroup();
                  var10000.BottomNavigationBar(var10001, var3, items, $composer, 48);
                  if (ComposerKt.isTraceInProgress()) {
                     ComposerKt.traceEventEnd();
                  }
               }

            }
         }), (Function2)null, (Function2)null, 0, 0L, 0L, (WindowInsets)null, (Function3)ComposableLambdaKt.composableLambda($composer, -1106969035, true, new Function3() {
            @Composable
            @ComposableTarget(
               applier = "androidx.compose.ui.UiComposable"
            )
            public final void invoke(@NotNull PaddingValues innerPadding, @Nullable Composer $composer, int $changed) {
               Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
               ComposerKt.sourceInformation($composer, "C48@1612L46:PlaygroundActivity.kt#qshby3");
               int $dirty = $changed;
               if (($changed & 14) == 0) {
                  $dirty = $changed | ($composer.changed(innerPadding) ? 4 : 2);
               }

               if (($dirty & 91) == 18 && $composer.getSkipping()) {
                  $composer.skipToGroupEnd();
               } else {
                  if (ComposerKt.isTraceInProgress()) {
                     ComposerKt.traceEventStart(-1106969035, $dirty, -1, "land.sungbin.androidplayground.PlaygroundActivity.HomeScreen.<anonymous> (PlaygroundActivity.kt:48)");
                  }

                  PlaygroundActivity.this.MainContent(innerPadding, LiveLiterals$PlaygroundActivityKt.INSTANCE.String$arg-1$call-MainContent$fun-$anonymous$$arg-9$call-Scaffold$fun-HomeScreen$class-PlaygroundActivity(), $composer, 14 & $dirty);
                  if (ComposerKt.isTraceInProgress()) {
                     ComposerKt.traceEventEnd();
                  }
               }

            }
         }), $composer, 805306800, 505);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var14 = $composer.endRestartGroup();
      if (var14 != null) {
         var14.updateScope((Function2)(new Function2() {
            public final void invoke(@Nullable Composer $composer, int $force) {
               PlaygroundActivity.this.HomeScreen($composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
         }));
      }

   }

   @Composable
   @ComposableInferredTarget(
      scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]"
   )
   public final void TopAppBar(@NotNull final Function2 title, @Nullable Composer $composer, final int $changed) {
      Intrinsics.checkNotNullParameter(title, "title");
      $composer = $composer.startRestartGroup(-297532352);
      ComposerKt.sourceInformation($composer, "C(TopAppBar)54@1737L37:PlaygroundActivity.kt#qshby3");
      int $dirty = $changed;
      if (($changed & 14) == 0) {
         $dirty = $changed | ($composer.changedInstance(title) ? 4 : 2);
      }

      if (($dirty & 11) == 2 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-297532352, $dirty, -1, "land.sungbin.androidplayground.PlaygroundActivity.TopAppBar (PlaygroundActivity.kt:53)");
         }

         AppBarKt.CenterAlignedTopAppBar(title, (Modifier)null, (Function2)null, (Function3)null, (WindowInsets)null, (TopAppBarColors)null, (TopAppBarScrollBehavior)null, $composer, 14 & $dirty, 126);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var10000 = $composer.endRestartGroup();
      if (var10000 != null) {
         var10000.updateScope((Function2)(new Function2() {
            public final void invoke(@Nullable Composer $composer, int $force) {
               PlaygroundActivity.this.TopAppBar(title, $composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
         }));
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public final void BottomNavigationBar(final int selectedItem, @NotNull final Function1 onItemSelected, @NotNull final List items, @Nullable Composer $composer, final int $changed) {
      Intrinsics.checkNotNullParameter(onItemSelected, "onItemSelected");
      Intrinsics.checkNotNullParameter(items, "items");
      $composer = $composer.startRestartGroup(121864615);
      ComposerKt.sourceInformation($composer, "C(BottomNavigationBar)P(2,1)59@1897L311:PlaygroundActivity.kt#qshby3");
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventStart(121864615, $changed, -1, "land.sungbin.androidplayground.PlaygroundActivity.BottomNavigationBar (PlaygroundActivity.kt:58)");
      }

      NavigationBarKt.NavigationBar-HsRjFd4((Modifier)null, 0L, 0L, 0.0F, (WindowInsets)null, (Function3)ComposableLambdaKt.composableLambda($composer, -1526068896, true, new Function3() {
         @Composable
         @ComposableTarget(
            applier = "androidx.compose.ui.UiComposable"
         )
         public final void invoke(@NotNull RowScope $this$NavigationBar, @Nullable Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter($this$NavigationBar, "$this$NavigationBar");
            ComposerKt.sourceInformation($composer, "C*65@2159L25,61@1965L229:PlaygroundActivity.kt#qshby3");
            int $dirty = $changed;
            if (($changed & 14) == 0) {
               $dirty = $changed | ($composer.changed($this$NavigationBar) ? 4 : 2);
            }

            if (($dirty & 91) == 18 && $composer.getSkipping()) {
               $composer.skipToGroupEnd();
            } else {
               if (ComposerKt.isTraceInProgress()) {
                  ComposerKt.traceEventStart(-1526068896, $dirty, -1, "land.sungbin.androidplayground.PlaygroundActivity.BottomNavigationBar.<anonymous> (PlaygroundActivity.kt:60)");
               }

               Iterable $this$forEachIndexed$iv = (Iterable)items;
               int var6 = selectedItem;
               final Function1 var7 = onItemSelected;
               int $i$f$forEachIndexed = false;
               int index$iv = 0;
               Iterator var10 = $this$forEachIndexed$iv.iterator();

               while(var10.hasNext()) {
                  Object item$iv = var10.next();
                  final int var12 = index$iv++;
                  if (var12 < 0) {
                     CollectionsKt.throwIndexOverflow();
                  }

                  final String item = (String)item$iv;
                  int var15 = false;
                  boolean var16 = var6 == var12;
                  RowScope var28 = $this$NavigationBar;
                  boolean var10001 = var16;
                  $composer.startReplaceableGroup(1634615704);
                  ComposerKt.sourceInformation($composer, "CC(remember):PlaygroundActivity.kt#9igjgp");
                  boolean invalid$iv = $composer.changed(var7) | $composer.changed(var12);
                  int $i$f$cache = false;
                  Object it$iv = $composer.rememberedValue();
                  int var21 = false;
                  Object var10002;
                  if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                     var10002 = it$iv;
                  } else {
                     int var24 = false;
                     Function0 var25 = (Function0)(new Function0() {
                        public final void invoke() {
                           var7.invoke(var12);
                        }
                     });
                     var28 = $this$NavigationBar;
                     var10001 = var16;
                     $composer.updateRememberedValue(var25);
                     var10002 = var25;
                  }

                  Function0 var27 = (Function0)var10002;
                  $composer.endReplaceableGroup();
                  NavigationBarKt.NavigationBarItem(var28, var10001, var27, ComposableSingletons$PlaygroundActivityKt.INSTANCE.getLambda-2$app_debug(), (Modifier)null, false, (Function2)ComposableLambdaKt.composableLambda($composer, 500566712, true, new Function2() {
                     @Composable
                     @ComposableTarget(
                        applier = "androidx.compose.ui.UiComposable"
                     )
                     public final void invoke(@Nullable Composer $composer, int $changed) {
                        ComposerKt.sourceInformation($composer, "C63@2081L10:PlaygroundActivity.kt#qshby3");
                        if (($changed & 11) == 2 && $composer.getSkipping()) {
                           $composer.skipToGroupEnd();
                        } else {
                           if (ComposerKt.isTraceInProgress()) {
                              ComposerKt.traceEventStart(500566712, $changed, -1, "land.sungbin.androidplayground.PlaygroundActivity.BottomNavigationBar.<anonymous>.<anonymous>.<anonymous> (PlaygroundActivity.kt:63)");
                           }

                           TextKt.Text--4IGK_g(item, (Modifier)null, 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 0, 0, 131070);
                           if (ComposerKt.isTraceInProgress()) {
                              ComposerKt.traceEventEnd();
                           }
                        }

                     }
                  }), false, (NavigationBarItemColors)null, (MutableInteractionSource)null, $composer, 1575936 | 14 & $dirty, 472);
               }

               if (ComposerKt.isTraceInProgress()) {
                  ComposerKt.traceEventEnd();
               }
            }

         }
      }), $composer, 196608, 31);
      if (ComposerKt.isTraceInProgress()) {
         ComposerKt.traceEventEnd();
      }

      ScopeUpdateScope var10000 = $composer.endRestartGroup();
      if (var10000 != null) {
         var10000.updateScope((Function2)(new Function2() {
            public final void invoke(@Nullable Composer $composer, int $force) {
               PlaygroundActivity.this.BottomNavigationBar(selectedItem, onItemSelected, items, $composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
         }));
      }

   }

   @Composable
   @ComposableTarget(
      applier = "androidx.compose.ui.UiComposable"
   )
   public final void MainContent(@NotNull final PaddingValues paddingValues, @NotNull final String content, @Nullable Composer $composer, final int $changed) {
      Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
      Intrinsics.checkNotNullParameter(content, "content");
      $composer = $composer.startRestartGroup(-1258158121);
      ComposerKt.sourceInformation($composer, "C(MainContent)P(1)73@2299L64:PlaygroundActivity.kt#qshby3");
      int $dirty = $changed;
      if (($changed & 14) == 0) {
         $dirty = $changed | ($composer.changed(paddingValues) ? 4 : 2);
      }

      if (($changed & 112) == 0) {
         $dirty |= $composer.changed(content) ? 32 : 16;
      }

      if (($dirty & 91) == 18 && $composer.getSkipping()) {
         $composer.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1258158121, $dirty, -1, "land.sungbin.androidplayground.PlaygroundActivity.MainContent (PlaygroundActivity.kt:72)");
         }

         TextKt.Text--4IGK_g(content, PaddingKt.padding((Modifier)Modifier.Companion, paddingValues), 0L, 0L, (FontStyle)null, (FontWeight)null, (FontFamily)null, 0L, (TextDecoration)null, (TextAlign)null, 0L, 0, false, 0, 0, (Function1)null, (TextStyle)null, $composer, 14 & $dirty >> 3, 0, 131068);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var10000 = $composer.endRestartGroup();
      if (var10000 != null) {
         var10000.updateScope((Function2)(new Function2() {
            public final void invoke(@Nullable Composer $composer, int $force) {
               PlaygroundActivity.this.MainContent(paddingValues, content, $composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
         }));
      }

   }

   private static final int HomeScreen$lambda$1(MutableIntState $selectedItem$delegate) {
      IntState $this$getValue$iv = (IntState)$selectedItem$delegate;
      Object var2 = null;
      KProperty property$iv = null;
      int $i$f$getValue = false;
      return $this$getValue$iv.getIntValue();
   }

   private static final void HomeScreen$lambda$2(MutableIntState $selectedItem$delegate, int value) {
      Object var3 = null;
      KProperty property$iv = null;
      int $i$f$setValue = false;
      $selectedItem$delegate.setIntValue(value);
   }

   static {
      $stable = LiveLiterals$PlaygroundActivityKt.INSTANCE.Int$class-PlaygroundActivity();
   }
}
