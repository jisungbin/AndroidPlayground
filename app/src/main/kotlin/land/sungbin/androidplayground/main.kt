package land.sungbin.androidplayground

import io.github.classgraph.BaseTypeSignature
import io.github.classgraph.ClassGraph

fun main() {
  test()
}

private fun test() {
  ClassGraph()
//    .verbose()
//    .enableClassInfo()
    .enableMethodInfo()
    .acceptPackages("com.naver.maps.map.overlay")
    .scan()
    .use { result ->
      val overlayClasses = result.getSubclasses("com.naver.maps.map.overlay.Overlay")
      overlayClasses.forEach { clazz ->
        println(buildString {
          appendLine("Found Overlay class: ${clazz.name}")
          clazz.methodInfo
            .filter {
              it.name.startsWith("set") &&
                (it.typeDescriptor.resultType as? BaseTypeSignature)?.type == Void.TYPE
            }
            .forEach {
              appendLine("  Found setter: ${it.toStringWithSimpleNames()}")
            }
          appendLine()
        })
      }
    }
}

