package com.example.kotlinsealedclass

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("fact")
    val fact: String,

    @SerializedName("length")
    val length: Int,
)
