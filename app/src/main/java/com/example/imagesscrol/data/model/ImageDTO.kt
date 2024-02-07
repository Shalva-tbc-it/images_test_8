package com.example.imagesscrol.data.model

import com.squareup.moshi.Json

data class ImageDTO(
    @Json(name = "id")
    val id: Int,
    @Json(name = "cover")
    val cover: String,
    @Json(name = "price")
    val price: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "location")
    val location: String,
    @Json(name = "reaction_count")
    val reactionCount: Int,
    @Json(name = "rate")
    val rate: Int? = null
)