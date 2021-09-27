package com.sammydj.fetchrewards.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sammydj.fetchrewards.R
import com.sammydj.fetchrewards.model.Item

class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val listingIdTextview: TextView = itemView.findViewById(R.id.list_id_input_textview)
    private val nameTextView: TextView = itemView.findViewById(R.id.name_input_textview)
    private val idTextView: TextView = itemView.findViewById(R.id.id_input_textview)

    fun bind(item: Item) {
        listingIdTextview.text = item.listId.toString()
        nameTextView.text = item.name
        idTextView.text = item.id.toString()
    }
}