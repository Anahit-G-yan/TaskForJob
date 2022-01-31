package com.example.taskforjob.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskforjob.R
import com.example.taskforjob.room.entity.NewsEntity
import com.example.taskforjob.view.adapter.viewholder.FavoriteNewsViewHolder

class FavoriteNewsAdapter(private val item:  List<NewsEntity>): RecyclerView.Adapter<FavoriteNewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteNewsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.vh_favorite_news, parent, false)
        return FavoriteNewsViewHolder(itemView)    }

    override fun onBindViewHolder(holder: FavoriteNewsViewHolder, position: Int) {
        val singleItem = item[position]
        holder.onBind(singleItem)
    }

    override fun getItemCount(): Int {
        return item.size
    }
}