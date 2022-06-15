package com.amrabdelhamiddiab.firsttaskatbosta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.amrabdelhamiddiab.firsttaskatbosta.presentation.albumsScreen.AlbumsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
   // private val viewModel: AlbumsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        viewModel.downloadAlbumsViewModel()
//        viewModel.listOfAlbums.observe(this){
//            Log.d(TAG, it.toString())
//        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}