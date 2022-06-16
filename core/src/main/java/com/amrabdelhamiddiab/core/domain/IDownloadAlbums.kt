package com.amrabdelhamiddiab.core.domain

import com.amrabdelhamiddiab.core.data.Album

interface IDownloadAlbums {
    suspend fun downloadAlbums(userId: Long): List<Album>?
}