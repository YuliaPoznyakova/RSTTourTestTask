package com.nrp.rsttourtesttask.model

data class BlogItem(
    val id: Int,
    val date: String,
    val url: String,
    val title: String,
    val subtitle: String,
    val image: SizedImage,
    val content: String,
)