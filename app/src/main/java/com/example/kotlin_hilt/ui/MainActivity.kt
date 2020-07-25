package com.example.kotlin_hilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.kotlin_hilt.R
import com.example.kotlin_hilt.util.RetrofitStatus
import com.example.kotlin_hilt.databinding.ActivityMainBinding
import com.example.kotlin_hilt.model.formatted.Album
import com.example.kotlin_hilt.ui.adapter.AlbumListAdapter
import com.example.kotlin_hilt.ui.adapter.AlbumListListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), AlbumListListener {

    private val mainListViewModel: MainViewModel by viewModels()
    private lateinit var activityMainBinding: ActivityMainBinding
    @Inject lateinit var albumListAdapter: AlbumListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainListViewModel.albums.observe(this, Observer { response ->
            when(response.status) {
                RetrofitStatus.SUCCESS -> response.albums?.let { albums ->
                    albumListAdapter.setAlbums(albums, this)
                    activityMainBinding.textError.visibility = View.GONE
                    activityMainBinding.recyclerview.visibility = View.VISIBLE
                }
                else -> {
                    activityMainBinding.textError.text = resources.getString(R.string.text_error)
                    activityMainBinding.textError.visibility = View.VISIBLE
                    activityMainBinding.recyclerview.visibility = View.GONE

                }
            }
            activityMainBinding.swipeRefreshLayout.isRefreshing = false
        })
        activityMainBinding.recyclerview.apply {
            adapter = albumListAdapter
            setHasFixedSize(true)
        }
        activityMainBinding.swipeRefreshLayout.setOnRefreshListener {
            mainListViewModel.getAlbums()
        }
        activityMainBinding.swipeRefreshLayout.isRefreshing = true
    }

    override fun onItemClick(album: Album) {
        Toast.makeText(this, "Yeah clicked!", Toast.LENGTH_LONG).show()
    }
}