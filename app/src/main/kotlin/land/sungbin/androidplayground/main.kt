package land.sungbin.androidplayground

import androidx.compose.animation.core.Animatable
import java.util.Stack

/*

w: dump: FILE fqName:land.sungbin.androidplayground fileName:/Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/ir-dump-target.kt
  annotations:
    NoLiveLiterals
  PROPERTY name:ComposableInvalidationTrackTableImpl$Ir_dump_targetKt visibility:private modality:FINAL [val]
    FIELD name:ComposableInvalidationTrackTableImpl$Ir_dump_targetKt type:land.sungbin.composeinvestigator.runtime.ComposableInvalidationTrackTable visibility:private [final,static]
      EXPRESSION_BODY
        CONSTRUCTOR_CALL 'public constructor <init> () [primary] declared in land.sungbin.composeinvestigator.runtime.ComposableInvalidationTrackTable' type=land.sungbin.composeinvestigator.runtime.ComposableInvalidationTrackTable origin=null
    FUN DEFAULT_PROPERTY_ACCESSOR name:<get-ComposableInvalidationTrackTableImpl$Ir_dump_targetKt> visibility:private modality:FINAL <> () returnType:land.sungbin.composeinvestigator.runtime.ComposableInvalidationTrackTable
      correspondingProperty: PROPERTY name:ComposableInvalidationTrackTableImpl$Ir_dump_targetKt visibility:private modality:FINAL [val]
      BLOCK_BODY
        RETURN type=kotlin.Nothing from='private final fun <get-ComposableInvalidationTrackTableImpl$Ir_dump_targetKt> (): land.sungbin.composeinvestigator.runtime.ComposableInvalidationTrackTable declared in land.sungbin.androidplayground'
          GET_FIELD 'FIELD name:ComposableInvalidationTrackTableImpl$Ir_dump_targetKt type:land.sungbin.composeinvestigator.runtime.ComposableInvalidationTrackTable visibility:private [final,static]' type=land.sungbin.composeinvestigator.runtime.ComposableInvalidationTrackTable origin=null
  FUN name:main visibility:public modality:FINAL <> () returnType:kotlin.Unit
    BLOCK_BODY
      VAR name:value type:kotlin.Function0<kotlin.Unit> [val]
        TRY type=kotlin.Function0<kotlin.Unit>
          try: BLOCK type=kotlin.Function0<kotlin.Unit> origin=null
            CALL 'public final fun println (message: kotlin.Any?): kotlin.Unit [inline] declared in kotlin.io.ConsoleKt' type=kotlin.Unit origin=null
              message: FUN_EXPR type=kotlin.Function1<kotlin.Int, kotlin.Int> origin=ANONYMOUS_FUNCTION
                FUN LOCAL_FUNCTION name:<no name provided> visibility:local modality:FINAL <> (a:kotlin.Int) returnType:kotlin.Int
                  VALUE_PARAMETER name:a index:0 type:kotlin.Int
                  BLOCK_BODY
                    RETURN type=kotlin.Nothing from='local final fun <no name provided> (a: kotlin.Int): kotlin.Int declared in land.sungbin.androidplayground.main'
                      GET_VAR 'a: kotlin.Int declared in land.sungbin.androidplayground.main.<no name provided>' type=kotlin.Int origin=null
            FUN_EXPR type=kotlin.Function0<kotlin.Unit> origin=ANONYMOUS_FUNCTION
              FUN LOCAL_FUNCTION name:<no name provided> visibility:local modality:FINAL <> () returnType:kotlin.Unit
                BLOCK_BODY
                  RETURN type=kotlin.Nothing from='local final fun <no name provided> (): kotlin.Unit declared in land.sungbin.androidplayground.main'
                    GET_OBJECT 'CLASS IR_EXTERNAL_DECLARATION_STUB OBJECT name:Unit modality:FINAL visibility:public superTypes:[kotlin.Any]' type=kotlin.Unit
          finally: BLOCK type=kotlin.Unit origin=null
            CALL 'public final fun println (message: kotlin.Any?): kotlin.Unit [inline] declared in kotlin.io.ConsoleKt' type=kotlin.Unit origin=null
              message: CONST String type=kotlin.String value="finally"
      CALL 'public final fun println (message: kotlin.Any?): kotlin.Unit [inline] declared in kotlin.io.ConsoleKt' type=kotlin.Unit origin=null
        message: CALL 'public abstract fun invoke (): R of kotlin.Function0 [operator] declared in kotlin.Function0' type=kotlin.Unit origin=null
          $this: GET_VAR 'val value: kotlin.Function0<kotlin.Unit> [val] declared in land.sungbin.androidplayground.main' type=kotlin.Function0<kotlin.Unit> origin=null

w:


w: dumpSrc: val ComposableInvalidationTrackTableImpl$Ir_dump_targetKt: ComposableInvalidationTrackTable = ComposableInvalidationTrackTable()
fun main() {
  val value = try {
    println { a: Int ->
      return@println a
    }
    {
      return
    }
  } finally {
    println("finally")
  }
  println(value())
}
w: dumpKotlinLike: // FILE: ir-dump-target.kt
// path: /Users/jisungbin/AndroidStudioProjects/AndroidPlayground/app/src/main/kotlin/land/sungbin/androidplayground/ir-dump-target.kt
@file:NoLiveLiterals
package land.sungbin.androidplayground

private val ComposableInvalidationTrackTableImpl$Ir_dump_targetKt: ComposableInvalidationTrackTable
  field = ComposableInvalidationTrackTable()
  private get

fun main() {
  val value: Function0<Unit> = try { // BLOCK
    println(message = local fun <no name provided>(a: Int): Int {
      return a
    }
)
    local fun <no name provided>() {
      return Unit
    }

  }
  finally { // BLOCK
    println(message = "finally")
  }
  println(message = value.invoke())
}


 */

