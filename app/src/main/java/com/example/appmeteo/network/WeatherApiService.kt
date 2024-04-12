package com.example.appmeteo.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.appmeteo.modele.Meteo
import com.example.appmeteo.modele.Ville

interface WeatherApiService {
    @GET("weather")
     fun getData(
        @Query("q") city: String,
        @Query("appid") apiKey: String
    ): Call<Ville>
}

