package com.amrabdelhamiddiab.core.domain

class RepositoryDownloadAlbums(private val iDownloadAlbums: IDownloadAlbums) {
    suspend fun downloadAlbums() =iDownloadAlbums.downloadAlbums()
}