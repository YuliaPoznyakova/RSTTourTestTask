package com.nrp.rsttourtesttask.model

import com.squareup.moshi.Json

data class BlogCards(
    val success: Boolean,
    val error: Error?,
    val data: List<BlogCard>
)

data class BlogCard(
    val id: Int,
    val image: SizedImage,
    val title: String,
    val subtitle: String,
    val view: Int,
    val like: Int,
    val date: RSTDate
)

data class RSTDate(
    @Json(name = "typeDate") val type: String,
    val date: String
)