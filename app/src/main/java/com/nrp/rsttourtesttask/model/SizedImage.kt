package com.nrp.rsttourtesttask.model

import com.squareup.moshi.Json

data class SizedImage(
    @Json(name = "sm") val small: String,
    @Json(name = "md") val medium: String,
    @Json(name = "lg") val large: String
)