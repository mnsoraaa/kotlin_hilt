package com.example.kotlin_hilt.repository

import com.example.kotlin_hilt.data.dao.RemoteAlbumDao
import com.example.kotlin_hilt.model.formatted.Album
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject

@Module
@InstallIn(ApplicationComponent::class)
class AlbumRepository @Inject constructor(
    private val albumDao: RemoteAlbumDao
){

    suspend fun getAlbums(): List<Album> = albumDao.getAlbums()
}