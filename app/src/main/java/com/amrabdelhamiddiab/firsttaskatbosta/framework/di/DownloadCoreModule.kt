package com.amrabdelhamiddiab.firsttaskatbosta.framework.di

import com.amrabdelhamiddiab.core.domain.*
import com.amrabdelhamiddiab.core.usecases.DownloadAlbums
import com.amrabdelhamiddiab.core.usecases.DownloadImages
import com.amrabdelhamiddiab.core.usecases.DownloadUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
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

    @Provides
    fun provideRepositoryUser(iDownloadUser: IDownloadUser): RepositoryUser {
        return RepositoryUser(iDownloadUser)
    }

    @Provides
    fun provideDownloadUserUseCase(repositoryUser: RepositoryUser): DownloadUser {
        return DownloadUser(repositoryUser)
    }

}