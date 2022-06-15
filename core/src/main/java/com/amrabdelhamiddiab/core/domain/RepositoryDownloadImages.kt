package com.amrabdelhamiddiab.core.domain

class RepositoryDownloadImages(private val iDownloadImages: IDownloadImages) {
    suspend fun downloadImages(albumId:Long) = iDownloadImages.downloadImages(albumId)
}