package com.example.weather.data.dao

import androidx.room.TypeConverter
import com.example.weather.data.response.Weather
import com.example.weather.data.response.WeatherDto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MyTypeConverters {

    @TypeConverter
    fun fromListToJSON(list: List<Weather>): String {
        return Gson().toJson(list)
    }
    @TypeConverter
    fun fromListToJSON(json: String): List<Weather> {
        val type = object : TypeToken<List<Weather>>() {}.type
        return Gson().fromJson(json,type)
    }
    @TypeConverter
    fun fromToJSON(list: List<WeatherDto>): String {
        return Gson().toJson(list)
    }
    @TypeConverter
    fun fromToJSON(json: String): List<WeatherDto> {
        val type = object : TypeToken<List<WeatherDto>>() {}.type
        return Gson().fromJson(json,type)
    }
}