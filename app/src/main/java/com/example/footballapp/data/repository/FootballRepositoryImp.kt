package com.example.footballapp.data.repository

import com.example.footballapp.data.model.Response
import com.example.footballapp.data.remote.FootballApi
import com.example.footballapp.data.remote.FootballApi.Companion.TOKEN
import com.example.footballapp.util.ResponseType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FootballRepositoryImp @Inject constructor(
    private val footballApi: FootballApi
) : FootballRepository{

    override fun getInformationFlow(): Flow<ResponseType<List<Response>>> = flow {
        emit(ResponseType.LOADING)

        try{
            val response = footballApi.getInformation(TOKEN)
            if (response.isSuccessful){
                response.body()?.let {
                    it.response?.let { data->
                        emit(ResponseType.SUCCESS(data))
                    }
                }
            }else{
                emit(ResponseType.ERROR(response.message()))
            }
        }catch (e:java.lang.Exception){
            emit(ResponseType.ERROR(e.localizedMessage))
        }
    }

}