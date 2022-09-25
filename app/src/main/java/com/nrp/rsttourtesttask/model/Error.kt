package com.nrp.rsttourtesttask.model

data class Error(
    val name: String,
    val status: String,
    val code: String,
    val message: String
)