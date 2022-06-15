package com.amrabdelhamiddiab.firsttaskatbosta.framework.cloud

import android.util.Log
import com.amrabdelhamiddiab.core.data.Album
import com.amrabdelhamiddiab.core.domain.IDownloadAlbums
import com.amrabdelhamiddiab.firsttaskatbosta.MainActivity.Companion.TAG
import com.amrabdelhamiddiab.firsttaskatbosta.framework.api.BostaService
import java.lang.Exception
import javax.inject.Inject

class DownloadAlbumsImpl @Inject constructor(private val bostaService: BostaService) :
    IDownloadAlbums {

    private val _listOfAlbums: MutableList<Album> = mutableListOf()
    private val listOfAlbums: List<Album> = _listOfAlbums

    override suspend fun downloadAlbums(): List<Album>? {
        return try {
            bostaService.fetchAlbumsOfSingleUser((1..10).random().toLong())
        } catch (e: Exception) {
            Log.d(TAG, e.message.toString())
            emptyList()
        }
    }
}