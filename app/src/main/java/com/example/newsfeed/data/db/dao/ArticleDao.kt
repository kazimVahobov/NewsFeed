package com.example.newsfeed.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsfeed.data.db.entities.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArticles(articles: MutableList<Article>)

    @Query("SELECT * FROM Article")
    suspend fun getArticles(): MutableList<Article>
}