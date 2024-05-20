package com.example.weather.ui

import android.icu.util.Calendar
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.weather.R
import com.example.weather.data.response.Forecast
import com.example.weather.databinding.WeatherItemBinding

class WeatherAdapter: RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    var forecast: Forecast = Forecast(0, emptyList())


    class WeatherViewHolder(binding: WeatherItemBinding): ViewHolder(binding.root) {
        val time = binding.time
        val icon = binding.icon
        val temp = binding.temperature
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(WeatherItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return forecast.list.size
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val data = forecast.list[position]
        val type = data.weather[0].main
        holder.icon.setImageResource(if (type=="Clear"){
            R.drawable.clear
        }else if(type=="Rain"){
            R.drawable.rain
        }else if(type=="Snow"){
            R.drawable.snow
        }else if (type=="Clouds"){
            R.drawable.cloud
        }else if (type=="Drizzle"){
            R.drawable.drizzle
        }else{
            R.drawable.thunder
        })
        Log.d("qwerty",type)
        val calendar = java.util.Calendar.getInstance()
        calendar.timeInMillis = data.dt*1000
        holder.time.text = "${calendar.get(Calendar.HOUR_OF_DAY)}:00"
        holder.temp.text = "${String.format("%.1f", data.main.temp)}°C"
    }

}