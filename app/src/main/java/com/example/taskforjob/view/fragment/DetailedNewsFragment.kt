package com.example.taskforjob.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.taskforjob.R
import com.example.taskforjob.model.ResponseModel

class DetailedNewsFragment : Fragment() {

    private lateinit var newsModel: ResponseModel.Response.Result
    private lateinit var detailedNewsCategory: TextView
    private lateinit var detailedNewsTitle: TextView
    private lateinit var detailedNewsData: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detailed_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        //getting arguments from NewsFragment
        getArgumentData()
    }

    private fun initView() {
        detailedNewsCategory = requireView().findViewById(R.id.detailedNewsCategory)
        detailedNewsTitle = requireView().findViewById(R.id.detailedNewsTitle)
        detailedNewsData = requireView().findViewById(R.id.detailedNewsData)
    }

    private fun getArgumentData() {
        if (arguments == null)return
        newsModel = requireArguments().getParcelable<ResponseModel.Response.Result>("detailedItem") as ResponseModel.Response.Result
        initUI()
    }

    private fun initUI() {
        detailedNewsTitle.text = newsModel.webTitle
        detailedNewsCategory.text = newsModel.sectionName
        detailedNewsData.text = newsModel.webPublicationDate
    }
}