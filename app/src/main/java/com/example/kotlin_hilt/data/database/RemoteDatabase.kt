package com.example.kotlin_hilt.data.database

import com.example.kotlin_hilt.data.dao.RemoteAlbumDao
import com.example.kotlin_hilt.util.Retrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RemoteDatabase {

    @Provides
    @Singleton
    fun provideAlbumDAO(): RemoteAlbumDao = Retrofit.getClient().create(
        RemoteAlbumDao::class.java)
}