package com.example.imagesscrol.presentation.mapper

import com.example.imagesscrol.domain.model.GetImage
import com.example.imagesscrol.presentation.model.Image

fun GetImage.toPresenter() =
    Image(
        id = id,
        cover = cover,
        price = price,
        title = title,
        location = location,
        reactionCount = reactionCount,
        rate = rate

    )