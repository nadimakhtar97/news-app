package com.nadim.android.newsapp.views

import android.R
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.nadim.android.newsapp.models.Article
import timber.log.Timber

@Composable
fun Home(viewModel: HomeViewModel = hiltViewModel()) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { paddingValues ->

        if(uiState.isLoading) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(Modifier.padding(paddingValues)) {
                items(items = uiState.news?.articles ?: emptyList(), key = { article: Article ->
                    article.url
                }) { article: Article ->
                    Article(article)
                }
            }
        }

    }
}


@Composable
fun Article(article: Article) {
    Column(Modifier.fillMaxWidth().padding(20.dp)) {
        Text(article.title, modifier = Modifier.border(1.dp, color = colorResource(R.color.holo_purple)))
    }
}