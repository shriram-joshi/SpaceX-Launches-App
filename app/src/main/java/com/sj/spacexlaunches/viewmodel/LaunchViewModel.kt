package com.sj.spacexlaunches.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sj.spacexlaunches.OnGetDataListenerInterface
import com.sj.spacexlaunches.model.launch_model.Launch
import com.sj.spacexlaunches.repositories.LaunchRepository
import com.sj.spacexlaunches.view.activities.LaunchInfoActivity
import com.sj.spacexlaunches.view.activities.MainActivity

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

    val isFetching: MutableLiveData<Boolean> = MutableLiveData(false)

    fun initializeRvData(offset: Int, limit: Int) {
        launchRepo.getLaunches(offset, limit, object: OnGetDataListenerInterface{
            override fun onStart() {
                isFetching.value = true
            }

            override fun onSuccess(data: Any) {
                isFetching.value = false
                launchData.value = data as ArrayList<Launch>
            }

            override fun onFailed(t: Throwable) {
                isFetching.value = false
                Log.i("Latest Launch", "${t.message}")
            }

        })
    }

    fun initializeLaunchInfo(offset: Int){
        launchRepo.getLaunches(offset,1, object : OnGetDataListenerInterface{
            override fun onStart() {
                isFetching.value = true
            }

            override fun onSuccess(data: Any) {
                if((data as ArrayList<Launch>).size > 0){
                    launchInfoData.value = data[0]
                }else{
                    val launch = Launch()
                    launch.missionName  = "Not found"
                    launchInfoData.value = launch
                }
                isFetching.value = false
            }

            override fun onFailed(t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun getLatestLaunch(){
        launchRepo.getLatest(object: OnGetDataListenerInterface{
            override fun onStart() {
                isFetching.value = true
            }

            override fun onSuccess(data: Any) {
                latestLaunch.value = data as Launch
                isFetching.value = false
            }

            override fun onFailed(t: Throwable) {
                isFetching.value = false
                Log.i("Latest Launch", "${t.message}")
            }

        })
    }
}