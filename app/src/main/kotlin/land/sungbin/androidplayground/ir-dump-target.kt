package land.sungbin.androidplayground

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember

/*
{ // BLOCK
  { // BLOCK
    val tmp0_safe_receiver: ScopeUpdateScope? = $composer.endRestartGroup()
    when {
      EQEQ(arg0 = tmp0_safe_receiver, arg1 = null) -> null
      else -> tmp0_safe_receiver.updateScope(block = local fun <anonymous>($composer: Composer?, $force: Int) {
        return Content(ms = ms, $composer = $composer, $changed = updateChangedFlags(flags = $changed.or(other = 1)))
      })
    }
  }
}

BLOCK type=kotlin.Unit origin=null
  BLOCK type=kotlin.Unit origin=SAFE_CALL
    VAR IR_TEMPORARY_VARIABLE name:tmp0_safe_receiver type:androidx.compose.runtime.ScopeUpdateScope? [val]
      CALL 'public abstract fun endRestartGroup (): androidx.compose.runtime.ScopeUpdateScope? declared in androidx.compose.runtime.Composer' type=androidx.compose.runtime.ScopeUpdateScope? origin=null
        $this: GET_VAR '$composer: androidx.compose.runtime.Composer? [assignable] declared in land.sungbin.androidplayground.Content' type=androidx.compose.runtime.Composer? origin=null
    WHEN type=kotlin.Unit origin=IF
      BRANCH
        if: CALL 'public final fun EQEQ (arg0: kotlin.Any?, arg1: kotlin.Any?): kotlin.Boolean declared in kotlin.internal.ir' type=kotlin.Boolean origin=null
          arg0: GET_VAR 'val tmp0_safe_receiver: androidx.compose.runtime.ScopeUpdateScope? [val] declared in land.sungbin.androidplayground.Content' type=androidx.compose.runtime.ScopeUpdateScope? origin=null
          arg1: CONST Null type=kotlin.Any? value=null
        then: CONST Null type=kotlin.Any? value=null
      BRANCH
        if: CONST Boolean type=kotlin.Boolean value=true
        then: CALL 'public abstract fun updateScope (block: kotlin.Function2<androidx.compose.runtime.Composer, kotlin.Int, kotlin.Unit>): kotlin.Unit declared in androidx.compose.runtime.ScopeUpdateScope' type=kotlin.Unit origin=null
          $this: GET_VAR 'val tmp0_safe_receiver: androidx.compose.runtime.ScopeUpdateScope? [val] declared in land.sungbin.androidplayground.Content' type=androidx.compose.runtime.ScopeUpdateScope? origin=null
          block: FUN_EXPR type=kotlin.Function2<androidx.compose.runtime.Composer?, kotlin.Int, kotlin.Unit> origin=LAMBDA
            FUN LOCAL_FUNCTION_FOR_LAMBDA name:<anonymous> visibility:local modality:FINAL <> ($composer:androidx.compose.runtime.Composer?, $force:kotlin.Int) returnType:kotlin.Unit
              VALUE_PARAMETER name:$composer index:0 type:androidx.compose.runtime.Composer?
              VALUE_PARAMETER name:$force index:1 type:kotlin.Int
              BLOCK_BODY
                RETURN type=kotlin.Nothing from='local final fun <anonymous> ($composer: androidx.compose.runtime.Composer?, $force: kotlin.Int): kotlin.Unit declared in land.sungbin.androidplayground.Content'
                  CALL 'public final fun Content (ms: androidx.compose.runtime.MutableLongState, $composer: androidx.compose.runtime.Composer?, $changed: kotlin.Int): kotlin.Unit declared in land.sungbin.androidplayground' type=kotlin.Unit origin=null
                    ms: GET_VAR 'ms: androidx.compose.runtime.MutableLongState declared in land.sungbin.androidplayground.Content' type=androidx.compose.runtime.MutableLongState origin=null
                    $composer: GET_VAR '$composer: androidx.compose.runtime.Composer? declared in land.sungbin.androidplayground.Content.<anonymous>' type=androidx.compose.runtime.Composer? origin=null
                    $changed: CALL 'internal final fun updateChangedFlags (flags: kotlin.Int): kotlin.Int declared in androidx.compose.runtime.RecomposeScopeImplKt' type=kotlin.Int origin=null
                      flags: CALL 'public final fun or (other: kotlin.Int): kotlin.Int [infix] declared in kotlin.Int' type=kotlin.Int origin=null
                        $this: GET_VAR '$changed: kotlin.Int declared in land.sungbin.androidplayground.Content' type=kotlin.Int origin=null
                        other: CONST Int type=kotlin.Int value=1
 */

@Composable
fun Content() {
  val ms = remember { mutableLongStateOf(System.currentTimeMillis()) }
  Button(onClick = { ms.longValue = System.currentTimeMillis() }) {}
  Display(text = ms.longValue.toString())
}

@Composable
private fun Display(text: String) {
  Text(text = text)
}
