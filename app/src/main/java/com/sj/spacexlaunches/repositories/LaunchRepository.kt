package com.sj.spacexlaunches.repositories

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.sj.spacexlaunches.OnGetDataListenerInterface
import com.sj.spacexlaunches.api.retrofit.RetrofitAPIInterface
import com.sj.spacexlaunches.api.retrofit.RetrofitClient
import com.sj.spacexlaunches.model.launch_model.Launch
import com.sj.spacexlaunches.view.activities.LaunchInfoActivity
import com.sj.spacexlaunches.view.activities.MainActivity
import com.sj.spacexlaunches.viewmodel.LaunchViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LaunchRepository {

    //needed for get launches
    private var apiInterface: RetrofitAPIInterface = RetrofitClient.getClient()

    fun getLaunches(offset: Int, limit: Int, listenerInterface: OnGetDataListenerInterface) {
        val dataSet: ArrayList<Launch> = ArrayList()
        listenerInterface.onStart()
        val map: Map<String, Int> = mapOf("offset" to offset, "limit" to limit)
        val call: Call<JsonArray> = apiInterface.getLaunches(map)

        call.enqueue(object : Callback<JsonArray> {
            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                listenerInterface.onFailed(t)
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
                listenerInterface.onSuccess(dataSet)
            }
        })
    }

    fun getLatest(listenerInterface: OnGetDataListenerInterface){
        var info: Launch
        listenerInterface.onStart()
        val call: Call<JsonObject> = apiInterface.getLatest()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                listenerInterface.onFailed(t)
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val body = response.body()
                body?.let {
                    info = Gson().fromJson(it.toString(), Launch::class.java)
                    listenerInterface.onSuccess(info)
                }
            }
        })
    }
}