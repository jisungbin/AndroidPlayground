@file:NoLiveLiterals

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.NoLiveLiterals
import java.io.File

class PlaygroundActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val filename = "test.txt"
        val file = File.createTempFile(filename, null, cacheDir)
        file.writeText("Hello!!!!!")
        println("read: ${file.readText()}")
        println("path: ${file.path}")
    }
}
