package com.a1developers.taazakhabar.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.a1developers.taazakhabar.data.local.NewsDao
import com.a1developers.taazakhabar.data.remote.dto.NewsApi
import com.a1developers.taazakhabar.data.remote.dto.NewsPagingSource
import com.a1developers.taazakhabar.data.remote.dto.SearchNewsPagingSource
import com.a1developers.taazakhabar.domain.model.Article
import com.a1developers.taazakhabar.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class NewsRepositoryImpl(

    private val newsApi: NewsApi,
    private val newsDao: NewsDao
) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        val pager = Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )

            }
        ).flow
        return pager
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        val pager = Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ","),
                    searchQuery = searchQuery
                )

            }
        ).flow

        return pager
    }

    override suspend fun upsertArticle(article: Article) {
        newsDao.upsert(article)
    }

    override suspend fun deleteArticle(article: Article) {
        newsDao.delete(article)
    }

    override fun selectArticles(): Flow<List<Article>> {
        return newsDao.getArticles().onEach { it.reversed() }
    }

    override suspend fun selectArticle(url: String): Article? {
        return newsDao.getArticle(url)
    }
}
