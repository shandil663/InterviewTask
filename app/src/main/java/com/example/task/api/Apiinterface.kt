package com.example.task.api

import com.example.task.model.ItemsList
import retrofit2.Response
import retrofit2.http.GET

interface Apiinterface {

    @GET("movie/popular?api_key=6621ef4429457083a4f3475925fbd9f4")
    suspend fun getdetails(): Response<ItemsList>
}