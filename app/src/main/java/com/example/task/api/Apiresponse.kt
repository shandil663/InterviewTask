package com.example.task.api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitAPI {


    val retro: Retrofit = Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val service: Apiinterface = retro.create(Apiinterface::class.java)


}