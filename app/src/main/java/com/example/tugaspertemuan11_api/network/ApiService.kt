package com.example.pertemuan11_retrofitapp.network

import com.example.pertemuan11_retrofitapp.model.Users
import com.example.tugaspertemuan11_api.model.Data
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("search?country=United+States")
    fun getAllUser(): Call<List<Data>>
}