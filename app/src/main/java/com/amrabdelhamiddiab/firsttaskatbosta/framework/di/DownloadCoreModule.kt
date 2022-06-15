package com.amrabdelhamiddiab.firsttaskatbosta.framework.di

import com.amrabdelhamiddiab.core.domain.IDownloadAlbums
import com.amrabdelhamiddiab.core.domain.RepositoryDownloadAlbums
import com.amrabdelhamiddiab.core.usecases.DownloadAlbums
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
}