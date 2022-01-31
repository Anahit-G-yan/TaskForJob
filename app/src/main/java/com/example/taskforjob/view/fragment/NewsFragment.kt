package com.example.taskforjob.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskforjob.R
import com.example.taskforjob.model.ResponseModel
import com.example.taskforjob.view.activity.NewsActivity
import com.example.taskforjob.view.adapter.NewsAdapter
import com.example.taskforjob.viewmodel.FavoriteViewModel
import com.example.taskforjob.viewmodel.ResponseViewModel


class NewsFragment : Fragment() {

    private val newsViewModel: ResponseViewModel by viewModels()
    private val favoriteViewModel: FavoriteViewModel by viewModels()
    private lateinit var newsRecyclerView: RecyclerView
    private lateinit var favoriteButton: TextView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        // Initializing live data observers
        initObservers()
        //getting all news from server
        newsViewModel.getAllNews()
        initClick()
    }

    private fun initClick() {
        //going to favorite news
        favoriteButton.setOnClickListener {
            val favoriteNewsFragment = activity as NewsActivity
            favoriteNewsFragment.openFragment(R.id.fragmentContainer, FavoriteNewsFragment())
        }
    }

    private fun initView() {
        newsRecyclerView = requireView().findViewById(R.id.newsRecyclerView)
        favoriteButton = requireView().findViewById(R.id.favoriteButton)
    }

    private fun initObservers() {
        // observing newsLiveData
        newsViewModel.newsLiveData.observe(viewLifecycleOwner, Observer {
            if (it == null) {
                Toast.makeText(requireContext(), resources.getString(R.string.can_not_load_data), Toast.LENGTH_SHORT).show()
                return@Observer
            }
            initNewsAdapter(it.response.results)
        })

        // observing toastLiveData. Callback is called, when we have duplicates in DB
        favoriteViewModel.toastLiveData.observe(viewLifecycleOwner, Observer {
            if(it){
                Toast.makeText(requireContext(), resources.getString(R.string.this_item_already_exist), Toast.LENGTH_SHORT).show()
            }
        })
}

    private fun initNewsAdapter(items: List<ResponseModel.Response.Result>) {
        val newsAdapter = NewsAdapter(items)
        val linearLayoutManager = LinearLayoutManager(requireContext())
        //saving news to favorites
        newsAdapter.addOnSaveClickListener { position, item ->
            favoriteViewModel.insert(item)
            Toast.makeText(requireContext(), resources.getString(R.string.news_added_to_favorites), Toast.LENGTH_SHORT).show()
        }
        //going to DetailedNewsFragment
        newsAdapter.onItemClickListener { position, item ->
            val bundle = Bundle()
            //send date to DetailedNewsFragment
            bundle.putParcelable("detailedItem", item)
            val detailedNewsFragment = DetailedNewsFragment()
            detailedNewsFragment.arguments = bundle
            val mainActivity = activity as NewsActivity
            mainActivity.openFragment(R.id.fragmentContainer, detailedNewsFragment)
        }

        newsRecyclerView.layoutManager = linearLayoutManager
        newsRecyclerView.adapter = newsAdapter
    }
}