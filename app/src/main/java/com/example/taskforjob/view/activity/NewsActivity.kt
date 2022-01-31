package com.example.taskforjob.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.taskforjob.R
import com.example.taskforjob.view.fragment.NewsFragment

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openFragment(R.id.fragmentContainer, NewsFragment())
    }

    fun openFragment(container: Int, fragment: Fragment) {

        supportFragmentManager
                .beginTransaction()
                .replace(container, fragment, fragment::class.java.name)
                .addToBackStack(fragment::class.java.name)
                .commit()
    }
}