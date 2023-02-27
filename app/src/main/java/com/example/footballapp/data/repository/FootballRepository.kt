package com.example.footballapp.data.repository

import com.example.footballapp.data.model.Response
import com.example.footballapp.util.ResponseType
import kotlinx.coroutines.flow.Flow

interface FootballRepository {
    fun getInformationFlow(): Flow<ResponseType<List<Response>>>
}