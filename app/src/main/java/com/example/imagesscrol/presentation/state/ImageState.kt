package com.example.imagesscrol.presentation.state

import com.example.imagesscrol.presentation.model.Image

data class ImageState(
    val isLoading: Boolean = false,
    val connections: List<Image>? = null,
    val errorMessage: String? = null
)
