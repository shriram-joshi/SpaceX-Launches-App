package com.sj.spacexlaunches.activities

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.sj.spacexlaunches.R
import com.sj.spacexlaunches.adapters.LaunchesRvAdapter
import com.sj.spacexlaunches.model.Launch
import com.sj.spacexlaunches.viewmodel.LaunchViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URI
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var launchAdapter: LaunchesRvAdapter
    private lateinit var launchViewModel: LaunchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launchViewModel = ViewModelProvider(this).get(LaunchViewModel::class.java)

        launchViewModel.getLaunchData().observe(this, androidx.lifecycle.Observer {
            launchAdapter.notifyDataSetChanged()
        })

        initialize()

        swipe_refresh.setOnRefreshListener {
            launchViewModel.init()
            Handler().postDelayed(Runnable {
                swipe_refresh.isRefreshing = false
            }, 2000) }
    }

    private fun initialize() {
        launchViewModel.getLaunchData().value?.let {
            launchAdapter = LaunchesRvAdapter(it, this)
            val linearLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
            launches_rv.layoutManager = linearLayoutManager
            launches_rv.adapter = launchAdapter
        }
    }
}