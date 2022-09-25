package com.nrp.rsttourtesttask.model

import com.squareup.moshi.Json

data class Main(
    @Json(name = "success") val isSuccess: Boolean,
    val error: Error?,
    val data: MainData
)

data class MainData(
    val content: List<ContentItem>
)

data class ContentItem(
    val title: String,
    val template: Template,
    val url: String
)

data class Template(
    @Json(name = "object") val type: String
)