package com.example.kotlinsealedclass.services.network

sealed class NetworkResponse<T>(
    val data: T? = null,
    val exception: Exception? = null
) {
    class Success<T>(data: T) : NetworkResponse<T>(data = data)
    class Failure<T>(exception: Exception) : NetworkResponse<T>(exception = exception)
    class Loading<T>() : NetworkResponse<T>()
}
