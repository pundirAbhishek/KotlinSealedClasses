package com.example.kotlinsealedclass.services.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://catfact.ninja/"
object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(
            OkHttpClient()
                .newBuilder()
                .addInterceptor { chain ->
                    chain.proceed(chain
                        .request()
                        .newBuilder()
                        .build()
                    )
                }
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getApiServices(): ApiServices {
        return retrofit.create(ApiServices::class.java)
    }
}