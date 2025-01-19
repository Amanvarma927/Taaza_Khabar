package com.a1developers.taazakhabar.domain.usecases.news

import com.a1developers.taazakhabar.data.local.NewsDao
import com.a1developers.taazakhabar.domain.model.Article
import com.a1developers.taazakhabar.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles (
    private val newsRepository: NewsRepository

) {
     operator fun invoke() : Flow<List<Article>> {
        return newsRepository.selectArticles()
    }
}