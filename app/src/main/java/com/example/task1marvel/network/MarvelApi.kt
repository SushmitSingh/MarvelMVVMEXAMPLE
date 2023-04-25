package com.example.task1marvel.network

import com.example.task1marvel.data.Marvel
import retrofit2.Call
import retrofit2.http.GET

interface MarvelApi {
    @GET("demos/marvel/")
    fun getMarvel(): Call<List<Marvel>>
}