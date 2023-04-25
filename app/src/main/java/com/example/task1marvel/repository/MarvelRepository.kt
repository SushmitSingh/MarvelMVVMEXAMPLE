package com.example.task1marvel.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.task1marvel.data.Marvel
import com.example.task1marvel.network.MarvelApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MarvelRepository {

    //Retrofit instance
    private val retrofit = Retrofit.Builder().baseUrl("https://simplifiedcoding.net/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    private val marvelApi = retrofit.create(MarvelApi::class.java)

    //Get the data from the API
    fun getMarvelData(): LiveData<List<Marvel>> {
        val data = MutableLiveData<List<Marvel>>()
        marvelApi.getMarvel().enqueue(object : Callback<List<Marvel>> {
            override fun onResponse(call: Call<List<Marvel>>, response: Response<List<Marvel>>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<List<Marvel>>, t: Throwable) {
                Log.e("MarvelRepository", "Error fetching Marvel data", t)
            }
        })

        return data
    }
}
