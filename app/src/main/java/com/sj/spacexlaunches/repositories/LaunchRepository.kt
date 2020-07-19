package com.sj.spacexlaunches.repositories

import android.net.Uri
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sj.spacexlaunches.model.Launch
import com.sj.spacexlaunches.retrofit.RetrofitAPIInterface
import com.sj.spacexlaunches.retrofit.RetrofitClient
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread

class LaunchRepository {

    private var dataSet: ArrayList<Launch> = ArrayList()
    private var apiInterface: RetrofitAPIInterface = RetrofitClient.getClient()

    fun getLaunches(): MutableLiveData<ArrayList<Launch>>{
        val offset = 95
        val limit = 1

        val map: Map<String, Int> = mapOf("offset" to offset, "limit" to limit)
        val call: Call<JSONArray> = apiInterface.getLaunches(map)

        call.enqueue(object : Callback<JSONArray>{
            override fun onFailure(call: Call<JSONArray>, t: Throwable) {
                Log.d("RESPONSE ERROR", "CALL FAILURE")
            }

            override fun onResponse(call: Call<JSONArray>, response: Response<JSONArray>) {
                val responseArray = response.body()
                responseArray?.length()?.let {
                    for (n in 0 until it){
                        val launch = responseArray.getJSONObject(n)
                        launch?.let { addLaunchToDataSet(launch)}
                    }
                }
            }
        })
        return MutableLiveData(dataSet)
    }

    private fun addLaunchToDataSet(launch: JSONObject) {
        val launchName: String = launch.getString("mission_name")
        val launchDate: String = launch.getString("launch_date_utc")
        val launchImage: Uri = Uri.parse(launch.getJSONObject("links").getJSONArray("flickr_images").getString(1))
        dataSet.add(Launch(launchName,launchDate, launchImage))
    }
}