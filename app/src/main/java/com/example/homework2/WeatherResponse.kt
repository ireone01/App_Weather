package com.example.homework2

import android.health.connect.datatypes.units.Temperature

data class WeatherResponse (val WeatherText : String , val temperature: Temperature ){
    data class Temperature(val metric: Metric){
        data class Metric(val Value: Float, val Unit: String)
    }
}
