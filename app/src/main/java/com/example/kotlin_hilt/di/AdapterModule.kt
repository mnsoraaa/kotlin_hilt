package com.example.kotlin_hilt.di

import com.example.kotlin_hilt.ui.adapter.AlbumListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class AdapterModule {

    @Provides
    @ActivityScoped
    fun provideAlbumListAdapter(): AlbumListAdapter = AlbumListAdapter()
}