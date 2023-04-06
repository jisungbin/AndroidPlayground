import kotlin.concurrent.thread

class StringPrinter {
    private var value: String? = null

    fun delayedPrint(value: String, delay: Int = 1000) {
        this.value = value
        sleep(delay)
        println(this.value)
    }
}

class LocalStringPrinter {
    private var value = ThreadLocal<String>()

    fun delayedPrint(value: String, delay: Int = 1000) {
        this.value.set(value)
        sleep(delay)
        println(this.value.get())
    }
}

fun main() {
    val stringPrinter = StringPrinter()
    thread { stringPrinter.delayedPrint("threadA") }
    sleep(100)
    thread { stringPrinter.delayedPrint("threadB") }

    sleep(1500)
    println()

    val localStringPrinter = LocalStringPrinter()
    thread { localStringPrinter.delayedPrint("localThreadA") }
    sleep(100)
    thread { localStringPrinter.delayedPrint("localThreadB") }

    sleep(1500)
}

fun sleep(millis: Int) {
    try {
        Thread.sleep(millis.toLong())
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }
}
