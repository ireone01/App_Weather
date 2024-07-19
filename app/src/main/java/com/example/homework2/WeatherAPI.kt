package com.example.homework2

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call
interface WeatherAPI{
    @GET("currentconditions/v1/{locationKey}")
    fun getCurrentWeather(
        @Query("locationKey") locationKey : String,
        @Query("apikey") apiKey : String
    ) : Call<List<WeatherResponse>>
}