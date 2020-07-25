package com.example.kotlin_hilt.model.response

import android.os.Parcelable
import com.example.kotlin_hilt.model.formatted.Album
import com.example.kotlin_hilt.util.RetrofitStatus
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AlbumResponse(
    val status: RetrofitStatus = RetrofitStatus.UNKNOWN,
    val albums: List<Album>? = null
) : Parcelable