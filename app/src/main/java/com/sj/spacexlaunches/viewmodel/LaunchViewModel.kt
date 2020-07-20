package com.sj.spacexlaunches.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sj.spacexlaunches.activities.LaunchInfoActivity
import com.sj.spacexlaunches.activities.MainActivity
import com.sj.spacexlaunches.model.launch_model.Launch
import com.sj.spacexlaunches.repositories.LaunchInfoRepository
import com.sj.spacexlaunches.repositories.LaunchRepository

class LaunchViewModel: ViewModel() {

    private var launchRepo: LaunchRepository = LaunchRepository()
    val launchData: MutableLiveData<ArrayList<Launch>> by lazy {
        MutableLiveData<ArrayList<Launch>>()
    }


    private var launchInfoRepository: LaunchInfoRepository = LaunchInfoRepository()
    val launchInfoData: MutableLiveData<com.sj.spacexlaunches.model.launch_model.Launch> by lazy {
        MutableLiveData<com.sj.spacexlaunches.model.launch_model.Launch>()
    }

    fun initializeRvData(mainActivity: MainActivity) {
        launchRepo.getLaunches(mainActivity, this)
    }

    fun initializeLaunchInfo(launchInfoActivity: LaunchInfoActivity){
        launchInfoRepository.getInfo(launchInfoActivity, this)
    }
}