package com.example.taskforjob.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskforjob.R
import com.example.taskforjob.model.ResponseModel
import com.example.taskforjob.view.adapter.viewholder.NewsViewHolder

class NewsAdapter(private val item:  List<ResponseModel.Response.Result>): RecyclerView.Adapter<NewsViewHolder>() {

    //for saving news to favorites
    private var onSaveClickListener: ((position: Int, item: ResponseModel.Response.Result) -> Unit)? = null
    //for going to DetailedNewsFragment
    private var onItemClickListener: ((position: Int, item: ResponseModel.Response.Result) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.vh_news, parent, false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val singleItem = item[position]
        holder.onBind(singleItem, onSaveClickListener, onItemClickListener)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    fun addOnSaveClickListener(clickListener: (position: Int, item: ResponseModel.Response.Result) -> Unit){
        this.onSaveClickListener = clickListener
    }

    fun onItemClickListener(onItemClickListener: (position: Int, item: ResponseModel.Response.Result) -> Unit){
        this.onItemClickListener = onItemClickListener
    }
}