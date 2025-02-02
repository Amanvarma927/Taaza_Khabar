package com.a1developers.taazakhabar.presentation.Details.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a1developers.taazakhabar.domain.model.Article
import com.a1developers.taazakhabar.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewmodel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {

    var sideEffect by mutableStateOf<String?>(null)
        private set

    private suspend fun upsertArticle(article: Article) {
        newsUseCases.upsertArticle(article)
        sideEffect = "Article Saved"


    }

    private suspend fun deleteArticle(article: Article) {
        newsUseCases.deleteArticle(article)
        sideEffect = "Article Deleted"
    }



fun onEvent(event: DetailsEvent) {
    when (event) {
        is DetailsEvent.UpsertDeleteArticle -> {
            viewModelScope.launch(Dispatchers.IO) {
                val article = newsUseCases.selectArticle(event.article.url)
                if (article == null) {
                    upsertArticle(event.article)
                } else {
                    deleteArticle(event.article)
                }
            }

        }
        is DetailsEvent.RemoveSideEffect -> {
            sideEffect = null
        }


    }
}}