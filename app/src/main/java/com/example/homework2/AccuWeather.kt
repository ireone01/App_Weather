package com.example.homework2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AccuWeather {
    @GET("locations/v1/cities/search")
    fun getLocationKey(
        @Query("apikey") apiKey : String,
        @Query("q") query: String
    ): Call<List<LocationResponse>>
}