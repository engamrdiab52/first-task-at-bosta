package com.amrabdelhamiddiab.firsttaskatbosta.framework.di

import com.amrabdelhamiddiab.core.domain.IDownloadAlbums
import com.amrabdelhamiddiab.core.domain.IDownloadImages
import com.amrabdelhamiddiab.core.domain.RepositoryDownloadAlbums
import com.amrabdelhamiddiab.core.domain.RepositoryDownloadImages
import com.amrabdelhamiddiab.core.usecases.DownloadAlbums
import com.amrabdelhamiddiab.core.usecases.DownloadImages
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DownloadCoreModule {

    @Provides
    fun provideRepositoryAlbums(iDownloadAlbums: IDownloadAlbums): RepositoryDownloadAlbums {
        return RepositoryDownloadAlbums(iDownloadAlbums)
    }

    @Provides
    fun provideDownloadAlbumUseCase(repositoryDownloadAlbums: RepositoryDownloadAlbums): DownloadAlbums {
        return DownloadAlbums(repositoryDownloadAlbums)
    }

    @Provides
    fun provideRepositoryImages(iDownloadImages: IDownloadImages): RepositoryDownloadImages {
        return RepositoryDownloadImages(iDownloadImages)
    }

    @Provides
    fun provideDownloadImagesUseCase(repositoryDownloadImages: RepositoryDownloadImages): DownloadImages {
        return DownloadImages(repositoryDownloadImages)
    }
}