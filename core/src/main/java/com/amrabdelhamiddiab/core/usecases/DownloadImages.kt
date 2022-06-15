package com.amrabdelhamiddiab.core.usecases

import com.amrabdelhamiddiab.core.domain.RepositoryDownloadImages

class DownloadImages(private val repositoryDownloadImages: RepositoryDownloadImages) {
    suspend operator fun invoke(albumId: Long) = repositoryDownloadImages.downloadImages(albumId)
}