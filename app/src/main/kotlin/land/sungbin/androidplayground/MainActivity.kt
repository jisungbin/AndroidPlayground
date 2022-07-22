@file:Suppress("MemberVisibilityCanBePrivate")

package land.sungbin.androidplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        xml()
    }

    fun xml() {
        setContentView(R.layout.activity_main)
        // + animations, list apdater, click listener, ... etc
        // class TextAdapter(private val count: Int) : RecyclerView.Adapter<TextAdapter.ViewHolder>()
        findViewById<RecyclerView>(R.id.rv_texts).adapter = TextAdapter(count = 5)
    }

    fun compose() {
        setContent {
            LazyColumn { // RecyclerView 와 동일
                items(count = 5) {
                    Text(text = "성빈랜드")
                }
            }
        }
    }

}