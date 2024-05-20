package com.example.weather.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.weather.data.response.Forecast
import com.example.weather.data.response.Weather

@Database(
    entities = [Weather::class,Forecast::class],
    version = 1,
)
@TypeConverters(
    value = [MyTypeConverters::class]
)
abstract class Database: RoomDatabase() {
    abstract fun dao(): Dao
}