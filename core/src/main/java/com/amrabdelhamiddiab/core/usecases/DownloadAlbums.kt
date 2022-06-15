package com.amrabdelhamiddiab.core.usecases

import com.amrabdelhamiddiab.core.domain.RepositoryDownloadAlbums

class DownloadAlbums(private val repositoryDownloadAlbums: RepositoryDownloadAlbums) {
    suspend operator fun invoke() =repositoryDownloadAlbums.downloadAlbums()
}