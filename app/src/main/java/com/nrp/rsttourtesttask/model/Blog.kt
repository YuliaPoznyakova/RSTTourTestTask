package com.nrp.rsttourtesttask.model

data class Blog(
    val success: Boolean,
    val error: Error?,
    val data: List<BlogItem>
)
