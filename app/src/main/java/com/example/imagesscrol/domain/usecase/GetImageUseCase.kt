package com.example.imagesscrol.domain.usecase

import com.example.imagesscrol.domain.repository.ImageRepository
import javax.inject.Inject

class GetImageUseCase @Inject constructor(
    private val imageRepository: ImageRepository
) {

    suspend operator fun invoke() = imageRepository.getImage()

}