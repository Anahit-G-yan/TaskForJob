package com.example.taskforjob.view.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskforjob.R
import com.example.taskforjob.room.entity.NewsEntity

class FavoriteNewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {

    private lateinit var itemModel: NewsEntity

    private val favoriteNewTitleIV = itemView.findViewById<TextView>(R.id.favoriteTitle)
    private val favoriteNewCategoryIV = itemView.findViewById<TextView>(R.id.favoriteCategory)

    fun onBind(itemModel: NewsEntity) {
        this.itemModel = itemModel
        initView()
    }

    private fun initView() {
        favoriteNewCategoryIV.text = itemModel.sectionName
        favoriteNewTitleIV.text = itemModel.webTitle
    }
}