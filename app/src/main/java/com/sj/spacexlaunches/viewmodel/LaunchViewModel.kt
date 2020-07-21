package com.sj.spacexlaunches.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sj.spacexlaunches.activities.LaunchInfoActivity
import com.sj.spacexlaunches.activities.MainActivity
import com.sj.spacexlaunches.model.launch_model.Launch
import com.sj.spacexlaunches.repositories.LaunchRepository

class LaunchViewModel: ViewModel() {

    private var launchRepo: LaunchRepository = LaunchRepository()
    val launchData: MutableLiveData<ArrayList<Launch>> by lazy {
        MutableLiveData<ArrayList<Launch>>()
    }

    val launchInfoData: MutableLiveData<Launch> by lazy {
        MutableLiveData<Launch>()
    }

    val latestLaunch: MutableLiveData<Launch> by lazy {
        MutableLiveData<Launch>()
    }

    fun initializeRvData(mainActivity: MainActivity) {
        launchRepo.getLaunches(mainActivity, this)
    }

    fun initializeLaunchInfo(launchInfoActivity: LaunchInfoActivity){
        launchRepo.getLaunchInfo(launchInfoActivity, this)
    }

    fun getLatestLaunch(mainActivity: MainActivity){
        launchRepo.getLatest(mainActivity, this)
    }
}