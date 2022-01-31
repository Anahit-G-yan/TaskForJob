package com.example.taskforjob.view.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskforjob.R
import com.example.taskforjob.model.ResponseModel

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val newTitleIV = itemView.findViewById<TextView>(R.id.newsTitle)
    private val newCategoryIV = itemView.findViewById<TextView>(R.id.newsCategory)
    private val saveButton = itemView.findViewById<TextView>(R.id.saveButton)

    private lateinit var itemModel: ResponseModel.Response.Result


    fun onBind(itemModel: ResponseModel.Response.Result, favoriteItemClickListener: ((position: Int, item: ResponseModel.Response.Result) -> Unit)?, onItemClickListener:((position: Int, item: ResponseModel.Response.Result) -> Unit)? ) {
        this.itemModel = itemModel
        initItemView()
        initClicks(favoriteItemClickListener, onItemClickListener)
    }


    private fun initItemView() {
        newTitleIV.text = itemModel.webTitle
        newCategoryIV.text = itemModel.sectionName
    }

    private fun initClicks(itemClickListener: ((position: Int, item: ResponseModel.Response.Result) -> Unit)?, onItemClickListener: ((position: Int, item: ResponseModel.Response.Result) -> Unit)?) {
        //for saving news to favorites
        saveButton.setOnClickListener {
            itemClickListener?.invoke(position, itemModel)
        }
        //for going to DetailedNewsFragment
        itemView.setOnClickListener {
            onItemClickListener?.invoke(position, itemModel)
        }
    }
}
