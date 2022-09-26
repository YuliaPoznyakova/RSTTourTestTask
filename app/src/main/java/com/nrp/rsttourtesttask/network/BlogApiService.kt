package com.nrp.rsttourtesttask

import com.nrp.rsttourtesttask.model.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

private const val BASE_URL = "https://rsttur.ru/api/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("base-app/main?id=117")
    suspend fun getMain(): Response<Main>


    @GET("base-app/blog-info")
    suspend fun getBlog(
        @Query("id") id: Int,
        @Query("blog_id") blogId: Int
    ): Blog

    @GET
    suspend fun getBlogCards(
        @Url url: String
    ): Response<BlogCards>
}

object Api {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}