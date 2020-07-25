package com.example.kotlin_hilt.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_hilt.util.RetrofitStatus
import com.example.kotlin_hilt.model.response.AlbumResponse
import com.example.kotlin_hilt.repository.AlbumRepository
import com.example.kotlin_hilt.util.Retrofit.printRetrofitError
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel @ViewModelInject constructor(
    private val albumRepository: AlbumRepository
) : ViewModel() {

    private val _albums = MutableLiveData<AlbumResponse>()
    val albums: LiveData<AlbumResponse> = _albums

    init {
        getAlbums()
    }

    fun getAlbums() = viewModelScope.launch {
        try {
            _albums.postValue(
                AlbumResponse(
                    RetrofitStatus.SUCCESS,
                    albumRepository.getAlbums()
                )
            )
        } catch (e: Exception){
            _albums.postValue(
                AlbumResponse(
                    RetrofitStatus.FAILURE
                )
            )
            e.printRetrofitError()
        }
    }
}