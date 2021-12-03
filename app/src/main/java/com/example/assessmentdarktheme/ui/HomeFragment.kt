package com.example.assessmentdarktheme.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assessmentdarktheme.R
import com.example.assessmentdarktheme.adapter.NewsAdapter
import com.example.assessmentdarktheme.data.model.Article
import com.example.assessmentdarktheme.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {
    private lateinit var binding: HomeFragmentBinding
    private lateinit var rootView: View
    private lateinit var newsAdapter: NewsAdapter
    companion object {
        fun newInstance() = HomeFragment()
    }
    var articleList = mutableListOf<Article>()

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater,container, false)
        rootView = binding.root
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        setNewsAdapter()
        setObservers()
        viewModel.getNews()
        return rootView
    }

    /*set news adapter*/
    private fun setNewsAdapter() {
        newsAdapter = NewsAdapter(articleList, requireActivity())
        binding.recyclerView.adapter = newsAdapter
        binding.recyclerView.layoutManager =LinearLayoutManager(activity)
    }

    /*set observers*/
    private fun setObservers() {
        viewModel.newsCallBack.observe(viewLifecycleOwner, Observer { newsCallBack ->
            if(newsCallBack.status.equals("ok")){
                articleList.clear()
                for (article in newsCallBack.articles){
                    articleList.add(Article(article?.author, article?.content, article?.description, article?.publishedAt, article?.source, article?.title, article?.url, article?.urlToImage))
                }
                newsAdapter.notifyDataSetChanged()
            }
            else{
                Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.newsthrowable.observe(viewLifecycleOwner, Observer { throwable ->
            Toast.makeText(requireContext(), throwable?.message, Toast.LENGTH_SHORT).show()
        })
    }


}