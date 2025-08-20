package com.nadim.android.newsapp.api

import androidx.compose.ui.input.key.Key

import com.nadim.android.newsapp.models.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getAllNews(@Query("q") q: String, @Query("from") from: String, @Query("sortBy") sortBy: String, @Query("apiKey") key: String): Response<News>

}