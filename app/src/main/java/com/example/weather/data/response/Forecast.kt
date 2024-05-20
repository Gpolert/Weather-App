package com.example.weather.data.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.IDN

@Entity
data class Forecast(
    @PrimaryKey
    val id: Int = 0,
    val list: List<Weather>
)