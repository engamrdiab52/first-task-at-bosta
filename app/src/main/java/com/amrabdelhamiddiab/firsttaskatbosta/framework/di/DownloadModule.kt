package com.amrabdelhamiddiab.firsttaskatbosta.framework.di

import com.amrabdelhamiddiab.core.domain.IDownloadAlbums
import com.amrabdelhamiddiab.core.domain.IDownloadImages
import com.amrabdelhamiddiab.core.domain.IDownloadUser
import com.amrabdelhamiddiab.core.domain.RepositoryDownloadAlbums
import com.amrabdelhamiddiab.core.usecases.DownloadAlbums
import com.amrabdelhamiddiab.firsttaskatbosta.framework.cloud.DownloadAlbumsImpl
import com.amrabdelhamiddiab.firsttaskatbosta.framework.cloud.DownloadPhotosImpl
import com.amrabdelhamiddiab.firsttaskatbosta.framework.cloud.DownloadUserImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DownloadModule {
    @Binds
    abstract fun bindDownloadAlbums(downloadAlbumsImpl: DownloadAlbumsImpl): IDownloadAlbums

    @Binds
    abstract fun bindDownloadImages(downloadPhotosImpl: DownloadPhotosImpl): IDownloadImages

    @Binds
    abstract fun bindDownloadUser(downloadUserImpl: DownloadUserImpl): IDownloadUser
}
