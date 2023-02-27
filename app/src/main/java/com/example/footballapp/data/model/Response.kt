package com.example.footballapp.data.model


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("competition")
    val competition: String? = "",
    @SerializedName("competitionUrl")
    val competitionUrl: String? = "",
    @SerializedName("date")
    val date: String? = "",
    @SerializedName("matchviewUrl")
    val matchviewUrl: String? = "",
    @SerializedName("thumbnail")
    val thumbnail: String? = "",
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("videos")
    val videos: List<Video>? = listOf()
)