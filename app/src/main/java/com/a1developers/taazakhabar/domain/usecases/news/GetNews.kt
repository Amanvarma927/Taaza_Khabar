package com.a1developers.taazakhabar.domain.usecases.news

import androidx.paging.PagingData
import com.a1developers.taazakhabar.domain.model.Article
import com.a1developers.taazakhabar.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)

    }
}