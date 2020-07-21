package com.sj.spacexlaunches.activities

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sj.spacexlaunches.R
import com.sj.spacexlaunches.model.launch_model.Launch
import com.sj.spacexlaunches.viewmodel.LaunchViewModel
import kotlinx.android.synthetic.main.activity_launch_info.*

class LaunchInfoActivity : AppCompatActivity() {

    var id: Int = 0
    private var launchViewModel: LaunchViewModel = LaunchViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_info)

        id = intent.getIntExtra("id", 0)

        launchViewModel.initializeLaunchInfo(this)

        launchViewModel.launchInfoData.observe(this,
            Observer<Launch> {
                initialize(it)
            })
    }

    private fun initialize(launch: Launch){
        if (launch.links.flickrImages.size != 0) {
            val options: RequestOptions =
                RequestOptions().placeholder(R.drawable.loading_image)
                    .error(R.drawable.rocket_icon)
            Glide.with(this).load(Uri.parse(launch.links.flickrImages[0])).apply(options).into(image)
        }
        if (launch.details == null){
            details.text = "No info available"
        }else
            details.text = launch.details
        name.text = launch.missionName
    }

    fun startProgressBar(){
        progressbar.visibility = View.VISIBLE
    }

    fun stopProgressBar(){
        progressbar.visibility = View.GONE
    }
}