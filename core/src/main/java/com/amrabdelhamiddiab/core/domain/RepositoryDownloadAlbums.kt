package com.amrabdelhamiddiab.core.domain

class RepositoryDownloadAlbums(private val iDownloadAlbums: IDownloadAlbums) {
    suspend fun downloadAlbums(userId: Long) =iDownloadAlbums.downloadAlbums(userId)
}