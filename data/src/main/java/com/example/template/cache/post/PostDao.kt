package com.example.template.cache.post

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.template.cache.model.PostEntity
import com.example.template.cache.tools.BaseDao

@Dao
internal abstract class PostDao : BaseDao<PostEntity>() {

    companion object {
        const val GET_POSTS = "SELECT * FROM ${PostEntity.TABLE_NAME}"
        const val GET_USER_POSTS = GET_POSTS + " WHERE ${PostEntity.COLUMN_USER_ID} = :userId"
        const val CLEAR_TABLE = "DELETE FROM ${PostEntity.TABLE_NAME}"
    }

    @Query(GET_POSTS)
    abstract override fun getAllLiveItems(): LiveData<List<PostEntity>>

    @Query(GET_POSTS)
    abstract override fun getALlItems(): List<PostEntity>

    @Query(GET_USER_POSTS)
    abstract fun getPosts(userId: Int): LiveData<List<PostEntity>>

    @Query(CLEAR_TABLE)
    abstract override suspend fun clearTable()
}