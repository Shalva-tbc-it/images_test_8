package com.example.imagesscrol.domain.repository

import com.example.imagesscrol.data.common.Resource
import com.example.imagesscrol.domain.model.GetImage
import kotlinx.coroutines.flow.Flow

interface ImageRepository {

    suspend fun getImage(): Flow<Resource<List<GetImage>>>

}