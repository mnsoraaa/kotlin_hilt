package com.example.kotlin_hilt.util

import android.webkit.WebSettings
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.kotlin_hilt.R

@BindingAdapter("image")
fun loadImage(imageView: ImageView, imageUrl: String){
    Glide.with(imageView.context)
        .load(
            GlideUrl(imageUrl, LazyHeaders
                .Builder()
                .addHeader("User-Agent", WebSettings.getDefaultUserAgent(imageView.context))
                .build()
            )
        )
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .transition(DrawableTransitionOptions.withCrossFade())
        .fitCenter()
        .placeholder(R.color.colorShimmer)
        .error(R.color.colorShimmer)
        .into(imageView)
}