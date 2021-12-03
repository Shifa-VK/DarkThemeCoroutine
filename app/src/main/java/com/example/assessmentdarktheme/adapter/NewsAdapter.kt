package com.example.assessmentdarktheme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assessmentdarktheme.data.model.Article
import com.example.assessmentdarktheme.databinding.NewsAdapterBinding

class NewsAdapter(var articleList:List<Article>, val context:Context): RecyclerView.Adapter<NewsAdapter.NewsAdapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapterViewHolder {
        val inflater    = LayoutInflater.from(parent.context)
        val binding     = NewsAdapterBinding.inflate(inflater, parent, false)
        return NewsAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsAdapterViewHolder, position: Int) {
        val article = articleList.get(position)
        holder.binding.titleTxtView.text = article?.title
        holder.binding.descriptionTxtView.text = article?.description
        holder.binding.authorNameTxtView.text = article?.author
        Glide.with(context).asDrawable()
            .load(article?.urlToImage)
            .centerCrop()
            .into(holder.binding.imageView);
    }

    override fun getItemCount(): Int {
        return articleList.size
    }
    class NewsAdapterViewHolder(val binding:NewsAdapterBinding):RecyclerView.ViewHolder(binding.root)
}