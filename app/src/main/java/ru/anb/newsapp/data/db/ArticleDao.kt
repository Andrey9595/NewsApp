package ru.anb.newsapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import retrofit2.http.DELETE

import ru.anb.newsapp.models.Article

interface ArticleDao {
    @Query("SELECT * FROM articles")
    suspend fun getAllArticles(): LiveData<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @DELETE
    suspend fun delete(article: Article)
}