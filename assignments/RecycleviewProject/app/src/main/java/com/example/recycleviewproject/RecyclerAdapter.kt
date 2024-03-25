package com.example.recycleviewproject


import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter(private val items: List<Data>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemImage: ImageView = itemView.findViewById(R.id.itemImage)
        private val itemTitle: TextView = itemView.findViewById(R.id.itemTitle)
        private val itemDetail: TextView = itemView.findViewById(R.id.itemDetail)

        fun bind(item: Data) {
            itemImage.setImageResource(item.imageResId)
            itemTitle.text = item.title
            itemDetail.text = item.detail

            itemView.setOnClickListener {
                val position = adapterPosition + 1
                Snackbar.make(
                    it,
                    "Click detected on item $position",
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null).show()
            }
        }
    }
}