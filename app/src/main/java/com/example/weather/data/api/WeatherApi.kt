package com.example.weather.data.api

import com.example.weather.data.response.Forecast
import com.example.weather.data.response.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/forecast")
    suspend fun getForecast(@Query("q")city: String, @Query("appid")apikey: String = APIKEY, @Query("units")a:String = "metric",@Query("lang")l:String = "ru"): Forecast
    @GET("data/2.5/forecast")
    suspend fun getForecast(@Query("lat")lat: Double, @Query("lon")lon: Double, @Query("appid")apikey: String = APIKEY, @Query("units")a:String = "metric",@Query("lang")l:String = "ru"): Forecast
    @GET("data/2.5/weather")
    suspend fun getWeather(@Query("q")city: String, @Query("appid")apikey: String = APIKEY, @Query("units")a:String = "metric",@Query("lang")l:String = "ru"): Weather
    @GET("data/2.5/weather")
    suspend fun getWeather(@Query("lat")lat: Double, @Query("lon")lon: Double, @Query("appid")apikey: String = APIKEY, @Query("units")a:String = "metric", @Query("lang")l:String = "ru"): Weather

    companion object{
        private const val APIKEY = "dc8ecec968c5f0fa2162b50eb1cce678"
    }
}