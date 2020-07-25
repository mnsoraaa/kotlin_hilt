package com.example.kotlin_hilt.data.dao

import com.example.kotlin_hilt.model.formatted.Album
import retrofit2.http.GET

interface RemoteAlbumDao {

    @GET("albums/1/photos")
    suspend fun getAlbums() : List<Album>
}