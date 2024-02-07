package com.example.imagesscrol.data.repository

import com.example.imagesscrol.data.common.HandleResponse
import com.example.imagesscrol.data.common.Resource
import com.example.imagesscrol.data.mapper.base.asResource
import com.example.imagesscrol.data.mapper.toDomain
import com.example.imagesscrol.data.service.ImageService
import com.example.imagesscrol.domain.model.GetImage
import com.example.imagesscrol.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val imageService: ImageService,
    private val handleResponse: HandleResponse
): ImageRepository {

    override suspend fun getImage(): Flow<Resource<List<GetImage>>> {
        return handleResponse.safeApiCall {
            imageService.getImageData()
        }.asResource { imageList ->
            imageList.map {
                it.toDomain()
            }
        }
    }

}