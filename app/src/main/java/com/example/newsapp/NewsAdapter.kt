package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class NewsAdapter(mainActivity: MainActivity, val newsList: ArrayList<News>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.newsitem,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        val currentNews = newsList[position]
        holder.newsImg.setImageResource(currentNews.img)
        holder.tvNewsHeadline.text = currentNews.newsHeadLine

    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val newsImg = itemView.findViewById<ShapeableImageView>(R.id.ivNewsImg)
        val tvNewsHeadline = itemView.findViewById<TextView>(R.id.tvNewsHeadline)
    }
}
