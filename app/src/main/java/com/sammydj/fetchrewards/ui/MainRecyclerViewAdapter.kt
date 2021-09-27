package com.sammydj.fetchrewards.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sammydj.fetchrewards.R
import com.sammydj.fetchrewards.model.Item

class MainRecyclerViewAdapter: RecyclerView.Adapter<MainViewHolder>() {

    private var itemList = emptyList<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_tableview, parent, false)
        return MainViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun updateList(newItemList: List<Item>) {
        itemList = newItemList
        notifyDataSetChanged()
    }
}