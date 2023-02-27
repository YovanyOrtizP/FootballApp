package com.example.footballapp.data.model


import com.google.gson.annotations.SerializedName

data class Video(
    @SerializedName("embed")
    val embed: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("title")
    val title: String? = ""
)