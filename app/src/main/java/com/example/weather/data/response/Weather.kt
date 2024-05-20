package com.example.weather.data.response

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Weather(
    @PrimaryKey
    val id: Int = 0,
    val weather: List<WeatherDto>,
    @Embedded
    val main: MainDto,
    @Embedded
    val wind: WindDto,
    val dt: Long,
)