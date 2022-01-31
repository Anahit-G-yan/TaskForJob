package com.example.taskforjob.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskforjob.R
import com.example.taskforjob.room.entity.NewsEntity
import com.example.taskforjob.view.adapter.FavoriteNewsAdapter
import com.example.taskforjob.viewmodel.FavoriteViewModel


class FavoriteNewsFragment : Fragment() {

    private val favoriteViewModel: FavoriteViewModel by viewModels()
    private lateinit var favoriteRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        // Initializing live data observers
        initObservers()
        //getting all favorite news
        favoriteViewModel.getAll()
    }

    private fun initObservers() {
        favoriteViewModel.favoriteNewsLiveData.observe(viewLifecycleOwner){
            initAdapter(it)
        }
    }

    private fun initAdapter(favoriteItem: List<NewsEntity>) {
        val favoriteNewsAdapter = FavoriteNewsAdapter(favoriteItem)
        val linearLayoutManager = LinearLayoutManager(requireContext())
        favoriteRecyclerView.layoutManager = linearLayoutManager
        favoriteRecyclerView.adapter = favoriteNewsAdapter
    }

    private fun initView() {
        favoriteRecyclerView = requireView().findViewById(R.id.favoriteRecyclerView)
    }
}