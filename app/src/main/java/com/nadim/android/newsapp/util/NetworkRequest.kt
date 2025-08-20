package com.nadim.android.newsapp.util

sealed class NetworkRequest<out T> {

    object Loading: NetworkRequest<Nothing>()

    data class Success<out T>(val data: T): NetworkRequest<T>()

    data class Error<out Nothing>(val userMessage: String): NetworkRequest<Nothing>()

}