package com.example.imagesscrol.data.mapper

import com.example.imagesscrol.data.model.ImageDTO
import com.example.imagesscrol.domain.model.GetImage

fun ImageDTO.toDomain() =
    GetImage(
        id = id,
        cover = cover,
        price = price,
        title = title,
        location = location,
        reactionCount = reactionCount,
        rate = rate

    )