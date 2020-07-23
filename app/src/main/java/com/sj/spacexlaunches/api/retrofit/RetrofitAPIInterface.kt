package com.sj.spacexlaunches.api.retrofit

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RetrofitAPIInterface {

    @GET("launches/")
    fun getLaunches(@QueryMap map: Map<String, Int>): Call<JsonArray>

    @GET("launches/latest/")
    fun getLatest(): Call<JsonObject>
}