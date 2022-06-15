package com.amrabdelhamiddiab.firsttaskatbosta.framework.di

import com.amrabdelhamiddiab.core.domain.IDownloadAlbums
import com.amrabdelhamiddiab.core.domain.RepositoryDownloadAlbums
import com.amrabdelhamiddiab.core.usecases.DownloadAlbums
import com.amrabdelhamiddiab.firsttaskatbosta.framework.cloud.DownloadAlbumsImpl
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
}
