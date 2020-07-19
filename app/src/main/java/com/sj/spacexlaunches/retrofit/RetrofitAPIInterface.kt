package com.sj.spacexlaunches.retrofit

import org.json.JSONArray
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RetrofitAPIInterface {

    @GET
    fun getLaunches(@QueryMap map: Map<String, Int>): Call<JSONArray>

}