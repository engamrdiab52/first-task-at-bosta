package com.amrabdelhamiddiab.firsttaskatbosta.framework.di

import com.amrabdelhamiddiab.firsttaskatbosta.framework.api.BostaService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideBostaService(): BostaService {
        return BostaService.create()
    }
}