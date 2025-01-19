package com.a1developers.taazakhabar.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.a1developers.taazakhabar.domain.model.Article

@Database(entities = [Article::class], version = 2)
@TypeConverters(NewsTypeConvertor::class)
abstract class NewsDatabase : RoomDatabase()  {

    abstract val newsDao : NewsDao
}