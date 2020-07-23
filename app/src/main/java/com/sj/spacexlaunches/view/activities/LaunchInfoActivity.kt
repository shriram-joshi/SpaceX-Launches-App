package com.sj.spacexlaunches.view.activities

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
        Log.i("id", "$id")

        launchViewModel.initializeLaunchInfo(id - 1)

        launchViewModel.isFetching.observe(this, Observer {
            when(it){
                true -> progressbar.visibility = View.VISIBLE
                false -> progressbar.visibility = View.GONE
            }
        })

        launchViewModel.launchInfoData.observe(this, Observer { initialize(it) })
    }

    private fun initialize(launch: Launch) {
        if (launch.links != null && launch.links.flickrImages.size != 0) {
            val options: RequestOptions =
                RequestOptions().placeholder(R.drawable.loading_image)
                    .error(R.drawable.rocket_icon)
            Glide.with(this).load(Uri.parse(launch.links.flickrImages[0])).apply(options)
                .into(image)
        }
        if (launch.details == null) {
            details.text = "No info available"
        } else
            details.text = launch.details
        name.text = launch.missionName
        if (launch.links != null && launch.links.videoLink != null && launch.links.videoLink.isNotEmpty() && !launch.links.videoLink.isBlank()) {
            link.text = "Youtube: ${launch.links.videoLink}"
        } else {
            link.text = "No youtube link available"
        }
    }
}