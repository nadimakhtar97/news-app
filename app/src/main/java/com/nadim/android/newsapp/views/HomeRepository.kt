package com.nadim.android.newsapp.views

import com.nadim.android.newsapp.api.NewsApi
import com.nadim.android.newsapp.models.News
import com.nadim.android.newsapp.util.NetworkRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class HomeRepository @Inject constructor() {

    @Inject
    lateinit var newsApi: NewsApi

    private val key = "d624d0b0d44c4f2db7feb943e44cf04b"

    fun getAllNews(): Flow<NetworkRequest<News>> = flow {
        emit(NetworkRequest.Loading)
        val res = newsApi.getAllNews("tesla", "2025-07-20","publishedAt", key)

        if(res.isSuccessful) {
            emit(NetworkRequest.Success<News>(res.body()!!))
        } else {
            emit(NetworkRequest.Error("Something went wrong!! Please check!!"))
        }
    }

}
