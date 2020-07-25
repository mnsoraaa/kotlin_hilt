package com.example.kotlin_hilt.ui.adapter

import com.example.kotlin_hilt.model.formatted.Album

interface AlbumListListener {

    fun onItemClick(album: Album)
}