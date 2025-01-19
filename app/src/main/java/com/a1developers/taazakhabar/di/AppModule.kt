package com.a1developers.taazakhabar.di

import android.app.Application
import androidx.room.Room
import com.a1developers.taazakhabar.Utils.Constants.BASE_URL
import com.a1developers.taazakhabar.Utils.Constants.NEWS_DATABASE_NAME
import com.a1developers.taazakhabar.data.local.NewsDao
import com.a1developers.taazakhabar.data.local.NewsDatabase
import com.a1developers.taazakhabar.data.local.NewsTypeConvertor
import com.a1developers.taazakhabar.domain.usecases.app_entry.ReadAppEntry
import com.a1developers.taazakhabar.domain.usecases.app_entry.SaveAppEntry
import com.a1developers.taazakhabar.data.manager.LocalUserManagerImpl
import com.a1developers.taazakhabar.data.remote.dto.NewsApi
import com.a1developers.taazakhabar.data.repository.NewsRepositoryImpl
import com.a1developers.taazakhabar.domain.manager.LocalUserManager
import com.a1developers.taazakhabar.domain.repository.NewsRepository
import com.a1developers.taazakhabar.domain.usecases.app_entry.AppEntryUseCases
import com.a1developers.taazakhabar.domain.usecases.news.DeleteArticle
import com.a1developers.taazakhabar.domain.usecases.news.GetNews
import com.a1developers.taazakhabar.domain.usecases.news.NewsUseCases
import com.a1developers.taazakhabar.domain.usecases.news.SearchNews
import com.a1developers.taazakhabar.domain.usecases.news.SelectArticle
import com.a1developers.taazakhabar.domain.usecases.news.SelectArticles
import com.a1developers.taazakhabar.domain.usecases.news.UpsertArticle
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )


    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }


    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ): NewsRepository = NewsRepositoryImpl(newsApi, newsDao)


    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsRepository),
            deleteArticle = DeleteArticle(newsRepository),
            selectArticles = SelectArticles(newsRepository),
            selectArticle = SelectArticle(newsRepository)


        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application

    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase

    ) : NewsDao = newsDatabase.newsDao
}



