package com.example.kotlinsealedclass.services.network

import com.example.kotlinsealedclass.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("fact")
    suspend fun search(): SearchResponse
}