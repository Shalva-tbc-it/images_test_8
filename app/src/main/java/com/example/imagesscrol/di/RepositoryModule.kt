package com.example.imagesscrol.di

import com.example.imagesscrol.data.common.HandleResponse
import com.example.imagesscrol.data.repository.ImageRepositoryImpl
import com.example.imagesscrol.data.service.ImageService
import com.example.imagesscrol.domain.repository.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideImageRepository(
        imageService: ImageService,
        handleResponse: HandleResponse
    ): ImageRepository {
        return ImageRepositoryImpl(
            imageService = imageService,
            handleResponse = handleResponse
        )
    }

}