package com.nadim.android.newsapp.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nadim.android.newsapp.models.News
import com.nadim.android.newsapp.util.NetworkRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

data class NewsUiState(
    val isLoading: Boolean = false,
    val news: News? = null,
    val userMessage: String = ""
)

@HiltViewModel
class HomeViewModel @Inject constructor(repository: HomeRepository): ViewModel() {


    val uiState: StateFlow<NewsUiState> = repository.getAllNews().map { item ->
        when(item) {
            NetworkRequest.Loading -> {
                NewsUiState(isLoading = true)
            }
            is NetworkRequest.Error -> {
                NewsUiState(userMessage = item.userMessage)
            }
            is NetworkRequest.Success -> {
                NewsUiState(news = item.data)
            }
        }
    } .stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = NewsUiState(isLoading = true)
    )

}