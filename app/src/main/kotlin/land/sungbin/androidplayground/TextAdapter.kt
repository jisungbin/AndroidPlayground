package land.sungbin.androidplayground

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TextAdapter(private val count: Int) : RecyclerView.Adapter<TextAdapter.ViewHolder>() {
    inner class ViewHolder(text: TextView) : RecyclerView.ViewHolder(text)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.item_textview, viewGroup, false) as TextView
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewholder: ViewHolder, position: Int) {}

    override fun getItemCount() = count
}