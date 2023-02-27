package com.example.footballapp.data.remote

import com.example.footballapp.data.model.FootballModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballApi {
    //https://www.scorebat.com/video-api/v3/feed/?token=NjA0MjZfMTY3Njc0NjM1NV9iNzIxZTZhOTkyMWRmMjkzMWMyMTIxZjc4ZGZlMGRlNWIzOGYxYjQz
    @GET(ENDPOINT)
    suspend fun getInformation(
        @Query(PARAM_TOKEN) tokenApi:String
    ): Response<FootballModel>

    companion object{
        const val BASE_URL = "https://www.scorebat.com"
        const val ENDPOINT = "/video-api/v3/feed/"
        const val PARAM_TOKEN = "token"
        const val TOKEN = "NjA0MjZfMTY3NzI2NjY3NV9iMzQxYzY4MjlhZWMzNjg2ZWU3ZGJlMGFhYjgyNmZkNGFjZjQ5YjMz"
    }
}