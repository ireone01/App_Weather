package com.example.homework2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherService {
    private const val BASE_URL = "http://dataservice.accuweather.com/"
    val retrofitInstance : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}