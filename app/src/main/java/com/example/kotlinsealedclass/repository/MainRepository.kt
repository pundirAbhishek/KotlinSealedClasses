package com.example.kotlinsealedclass.repository

import com.example.kotlinsealedclass.SearchResponse
import com.example.kotlinsealedclass.services.network.NetworkResponse
import com.example.kotlinsealedclass.services.network.RetrofitInstance
import retrofit2.HttpException
import java.io.IOException

object MainRepository {
    suspend fun search(): NetworkResponse<SearchResponse> {
        return try {
            val response = RetrofitInstance
                .getApiServices()
                .search()
            NetworkResponse.Success(data = response)
        } catch (e: HttpException) {
            //handles exception with the request
            NetworkResponse.Failure(exception = e)
        } catch (e: IOException) {
            //handles no internet exception
            NetworkResponse.Failure(exception = e)
        }
    }
}