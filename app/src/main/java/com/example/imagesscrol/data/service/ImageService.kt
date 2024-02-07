package com.example.imagesscrol.data.service

import com.example.imagesscrol.data.model.ImageDTO
import retrofit2.Response
import retrofit2.http.GET

interface ImageService {
    @GET("0545ddc1-c487-46ce-b70c-5b95270d6b76")
    suspend fun getImageData() : Response<List<ImageDTO>>
}