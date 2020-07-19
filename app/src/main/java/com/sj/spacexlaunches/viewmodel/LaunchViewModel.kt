package com.sj.spacexlaunches.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sj.spacexlaunches.model.Launch
import com.sj.spacexlaunches.repositories.LaunchRepository

class LaunchViewModel: ViewModel() {
    private var launchData: MutableLiveData<ArrayList<Launch>> = MutableLiveData()
//    private var launchRepo: LaunchRepository = LaunchRepository()

    fun init(){
        launchData = LaunchRepository().getLaunches()
    }

    fun getLaunchData(): LiveData<ArrayList<Launch>> {
        return launchData
    }
}