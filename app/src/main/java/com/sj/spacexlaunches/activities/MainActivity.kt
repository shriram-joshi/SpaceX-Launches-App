package com.sj.spacexlaunches.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sj.spacexlaunches.R
import com.sj.spacexlaunches.adapters.LaunchesRvAdapter
import com.sj.spacexlaunches.model.launch_model.Launch
import com.sj.spacexlaunches.viewmodel.LaunchViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private var launchAdapter: LaunchesRvAdapter = LaunchesRvAdapter(ArrayList(), this)
    private lateinit var launchViewModel: LaunchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launchViewModel = ViewModelProvider(this).get(LaunchViewModel::class.java)
        launchViewModel.initializeRvData(this)

        launchViewModel.launchData.observe(this,
            androidx.lifecycle.Observer<ArrayList<Launch>> {
                launchAdapter.notifyDataSetChanged()
                initialize()
            })

        swipe_refresh.setOnRefreshListener {
            launchViewModel.initializeRvData(this)
        }
    }

    private fun initialize() {
        launchViewModel.launchData.value?.let {
            launchAdapter = LaunchesRvAdapter(it, this)
            val linearLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
            launches_rv.layoutManager = linearLayoutManager
            launches_rv.adapter = launchAdapter
        }
    }

    fun startLoading(){
        swipe_refresh.isRefreshing = true
    }
    fun endLoading(){
        swipe_refresh.isRefreshing = false
    }
}