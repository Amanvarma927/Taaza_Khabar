package com.a1developers.taazakhabar.data.remote.dto

import com.a1developers.taazakhabar.Utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface  NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page : Int,
        @Query("sources") sources : String,
        @Query("apikey") apiKey : String = API_KEY
        ) : NewsResponse


    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery : String,
        @Query("page") page : Int,
        @Query("sources") sources : String,
        @Query("apikey") apiKey : String = API_KEY
    ) : NewsResponse

}