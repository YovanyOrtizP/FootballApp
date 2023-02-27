package com.example.footballapp.data.model


import com.google.gson.annotations.SerializedName

data class FootballModel(
    @SerializedName("response")
    val response: List<Response>? = listOf()
)