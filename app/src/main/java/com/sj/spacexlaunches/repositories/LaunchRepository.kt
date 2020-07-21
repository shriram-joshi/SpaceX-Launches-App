package com.sj.spacexlaunches.repositories

import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.sj.spacexlaunches.activities.LaunchInfoActivity
import com.sj.spacexlaunches.activities.MainActivity
import com.sj.spacexlaunches.model.launch_model.Launch
import com.sj.spacexlaunches.retrofit.RetrofitAPIInterface
import com.sj.spacexlaunches.retrofit.RetrofitClient
import com.sj.spacexlaunches.viewmodel.LaunchViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LaunchRepository {

    //needed for get launches
    private var dataSet: ArrayList<Launch> = ArrayList()
    private var apiInterface: RetrofitAPIInterface = RetrofitClient.getClient()

    private var info: Launch = Launch()


    fun getLaunches(mainActivity: MainActivity, launchViewModel: LaunchViewModel) {
        mainActivity.startLoading()
        val offset = mainActivity.offset
        val limit = mainActivity.limit
        val map: Map<String, Int> = mapOf("offset" to offset, "limit" to limit)
        val call: Call<JsonArray> = apiInterface.getLaunches(map)

        call.enqueue(object : Callback<JsonArray> {
            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                Toast.makeText(mainActivity, "Could not load launches", Toast.LENGTH_SHORT).show()
                mainActivity.endLoading()
            }

            override fun onResponse(call: Call<JsonArray>, response: Response<JsonArray>) {
                val body = response.body()
                body?.size()?.let {
                    dataSet.clear()
                    for(n in 1..it){
                        val launch: Launch = Gson().fromJson((body[n-1] as JsonObject).toString(), Launch::class.java)
                        dataSet.add(launch)
                    }
                }
                launchViewModel.launchData.value = dataSet
                mainActivity.endLoading()
            }
        })
    }

    fun getLaunchInfo(launchInfoActivity: LaunchInfoActivity, launchViewModel: LaunchViewModel){
        launchInfoActivity.startProgressBar()
        val offset: Int = launchInfoActivity.id-1

        val map: Map<String, Int> = mapOf("offset" to offset, "limit" to 1)
        val call: Call<JsonArray> = apiInterface.getLaunches(map)

        call.enqueue(object : Callback<JsonArray> {
            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                Toast.makeText(launchInfoActivity, "Something went wrong", Toast.LENGTH_LONG).show()
                launchInfoActivity.stopProgressBar()
            }

            override fun onResponse(call: Call<JsonArray>, response: Response<JsonArray>) {
                val body = response.body()
                if (body?.size() != 0) {
                    body?.let { val launch: JsonObject = body[0].asJsonObject
                        info = Gson().fromJson(launch.toString(), Launch::class.java)
                        launchViewModel.launchInfoData.value = info
                        launchInfoActivity.stopProgressBar()
                    }
                }
            }
        })
    }

    fun getLatest(mainActivity: MainActivity, launchViewModel: LaunchViewModel){

        val call: Call<JsonObject> = apiInterface.getLatest()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Toast.makeText(mainActivity, "Something went wrong", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val body = response.body()
                body?.let {
                    info = Gson().fromJson(it.toString(), Launch::class.java)
                    launchViewModel.latestLaunch.value = info
                }
            }
        })
    }
}