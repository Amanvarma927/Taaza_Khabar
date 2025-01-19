package com.a1developers.taazakhabar.presentation.bookmark

import com.a1developers.taazakhabar.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)
