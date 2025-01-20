package land.sungbin.androidplayground

object DebugLayoutUtil {
  private const val DEBUG_LAYOUT_PROPERTY = "debug.layout"

  fun setDebugLayout(value: Boolean): Boolean =
    try {
      val systemPropertiesClass = Class.forName("android.os.SystemProperties")
      val setMethod = systemPropertiesClass.getDeclaredMethod("set", String::class.java, String::class.java)

      setMethod.invoke(null, DEBUG_LAYOUT_PROPERTY, value.toString())
      true
    } catch (e: Exception) {
      println(e)
      false
    }

  fun getIsDebugLayout(): Boolean? =
    try {
      val systemPropertiesClass = Class.forName("android.os.SystemProperties")
      val getBooleanMethod = systemPropertiesClass.getDeclaredMethod("getBoolean", String::class.java, Boolean::class.java)

      getBooleanMethod.invoke(null, DEBUG_LAYOUT_PROPERTY, false) as Boolean
    } catch (e: Exception) {
      println(e)
      null
    }
}
