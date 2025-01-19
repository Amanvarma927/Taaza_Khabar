package com.a1developers.taazakhabar.domain.usecases.news

import com.a1developers.taazakhabar.data.local.NewsDao
import com.a1developers.taazakhabar.domain.model.Article
import com.a1developers.taazakhabar.domain.repository.NewsRepository

class DeleteArticle (
    private val newsRepository: NewsRepository

) {
    suspend operator fun invoke(article: Article) {
        newsRepository.deleteArticle(article)
    }
}