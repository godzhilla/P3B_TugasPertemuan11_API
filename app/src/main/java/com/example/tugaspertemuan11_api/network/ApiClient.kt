package com.example.pertemuan11_retrofitapp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    //digunakan untuk pembuatan api service berkomunikasi dengan server

    fun getInstance(): ApiService {

        // Membuat objek interceptor untuk logging HTTP
        val mOkHttpInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        // Membuat objek OkHttpClient dengan menambahkan interceptor
        val mOkHttpClient = OkHttpClient.Builder().addInterceptor(mOkHttpInterceptor).build()

        // Membuat objek Retrofit dengan konfigurasi dasar
        val builder = Retrofit.Builder().baseUrl("http://universities.hipolabs.com/") // URL dasar dari API
            .client(mOkHttpClient) // Menggunakan OkHttpClient yang sudah dikonfigurasi
            .addConverterFactory(GsonConverterFactory.create()) // Menggunakan Gson untuk konversi JSON
            .build()

        // Menghasilkan instance dari interface ApiService yang telah didefinisikan
        return builder.create(ApiService::class.java)
    }
}