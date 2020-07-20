package com.sj.spacexlaunches.repositories

import android.net.Uri
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonNull
import com.google.gson.JsonObject
import com.sj.spacexlaunches.activities.MainActivity
import com.sj.spacexlaunches.model.launch_model.Launch
import com.sj.spacexlaunches.retrofit.RetrofitAPIInterface
import com.sj.spacexlaunches.retrofit.RetrofitClient
import com.sj.spacexlaunches.viewmodel.LaunchViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class LaunchRepository {

    private var dataSet: ArrayList<Launch> = ArrayList()
    private var apiInterface: RetrofitAPIInterface = RetrofitClient.getClient()

    fun getLaunches(mainActivity: MainActivity, launchViewModel: LaunchViewModel) {
        mainActivity.startLoading()
        val offset = 89
        val limit = 15
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
}