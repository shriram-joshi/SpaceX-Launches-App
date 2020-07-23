package com.sj.spacexlaunches.view.activities

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sj.spacexlaunches.R
import com.sj.spacexlaunches.model.launch_model.Launch
import com.sj.spacexlaunches.view.adapters.LaunchesRvAdapter
import com.sj.spacexlaunches.viewmodel.LaunchViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private var launchAdapter: LaunchesRvAdapter = LaunchesRvAdapter(ArrayList(), this)
    private lateinit var launchViewModel: LaunchViewModel
    var offset: Int = 0
    var limit: Int = 0
    var latest: Int = 0

    private var duration = arrayOf("Selectↆ", "Latest", "Upcoming", "All"/*, "Previous Month", "Previous 3 Months", "Previous 6 Months", "Past Year"*/)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launchViewModel = ViewModelProvider(this).get(LaunchViewModel::class.java)
        launchViewModel.getLatestLaunch()

        launchViewModel.launchData.observe(this,
            androidx.lifecycle.Observer {
                launchAdapter.notifyDataSetChanged()
                initialize()
            })

        launchViewModel.latestLaunch.observe(this, Observer {
            latest = it.flightNumber
        })

        launchViewModel.isFetching.observe(this, Observer {
            when(it){
                true -> swipe_refresh.isRefreshing = true
                false -> swipe_refresh.isRefreshing = false
            }
        })

        val spinnerArrayAdapter: ArrayAdapter<String> = ArrayAdapter(this, R.layout.spinner_item, duration)
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item)
        option_spinner.adapter = spinnerArrayAdapter
        option_spinner.prompt = "Duration"
        option_spinner.onItemSelectedListener = this

        swipe_refresh.setOnRefreshListener {
            launchViewModel.initializeRvData(offset, limit)
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        launches_rv.visibility = View.GONE
        msg_tv.visibility = View.VISIBLE
        launchViewModel.launchData.value?.clear()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        launches_rv.visibility = View.VISIBLE
        msg_tv.visibility = View.GONE
        when(position){
            0 -> {
                launches_rv.visibility = View.GONE
                msg_tv.visibility = View.VISIBLE
                launchViewModel.launchData.value?.clear()
            }
            1 -> {
                offset = latest - 4
                limit = 5
                if (latest == 0){ offset = 97 - 4; }
                launchViewModel.initializeRvData(offset, limit)
            }
            2 -> {
                offset = latest
                limit = 0
                if (latest == 0){ offset = 97 }
                launchViewModel.initializeRvData(offset, limit)
            }
            3 -> {
                offset = 0
                limit = 0
                launchViewModel.initializeRvData(offset, limit)
            }
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
}