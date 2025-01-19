package com.a1developers.taazakhabar.domain.usecases.news

import com.a1developers.taazakhabar.data.local.NewsDao
import com.a1developers.taazakhabar.domain.model.Article
import com.a1developers.taazakhabar.domain.repository.NewsRepository
import java.net.URL

class SelectArticle (
    private val newsRepository: NewsRepository

) {
    suspend operator fun invoke(url: String): Article? {
        run {
            return newsRepository.selectArticle(url)
        }

    }
}