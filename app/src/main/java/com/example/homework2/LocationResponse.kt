package com.example.homework2

import retrofit2.http.GET

data class LocationResponse(
    val Key:String ,
    val LocalizedName:String,
    val country: Country
) {
    data class Country(val ID : String,
        val LocalizedName: String) {
    }

}
