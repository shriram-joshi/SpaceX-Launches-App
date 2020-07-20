package com.sj.spacexlaunches.repositories

import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.sj.spacexlaunches.activities.LaunchInfoActivity
import com.sj.spacexlaunches.model.launch_model.Launch
import com.sj.spacexlaunches.retrofit.RetrofitAPIInterface
import com.sj.spacexlaunches.retrofit.RetrofitClient
import com.sj.spacexlaunches.viewmodel.LaunchViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LaunchInfoRepository {

    private var info: Launch = Launch()
    private var apiInterface: RetrofitAPIInterface = RetrofitClient.getClient()

    fun getInfo(launchInfoActivity: LaunchInfoActivity, launchViewModel: LaunchViewModel){
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
                body?.let {
                    val launch: JsonObject = body[0].asJsonObject
                    info = Gson().fromJson(launch.toString(), Launch::class.java)
                    launchViewModel.launchInfoData.value = info
                    launchInfoActivity.stopProgressBar()
                }
            }
        })
    }

}