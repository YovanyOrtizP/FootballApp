package com.example.footballapp.ui.football

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.data.model.Response
import com.example.footballapp.data.repository.FootballRepository
import com.example.footballapp.util.ResponseType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FootballViewModel @Inject constructor(
    private val footballRepository: FootballRepository
): ViewModel(){

    var footballObject: Response? = null

    private val _result = MutableLiveData<ResponseType<List<Response>>>()
    val result: LiveData<ResponseType<List<Response>>> = _result

    fun flowInformation(){
        viewModelScope.launch {
            footballRepository.getInformationFlow().collect{
                _result.postValue(it)
            }
        }
    }
}