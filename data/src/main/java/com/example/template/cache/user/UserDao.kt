package com.example.template.cache.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.template.cache.tools.BaseDao
import com.example.template.cache.model.UserEntity

@Dao
internal abstract class UserDao : BaseDao<UserEntity>() {

    companion object {
        const val GET_USERS = "SELECT * FROM ${UserEntity.TABLE_NAME}"
        const val CLEAR_TABLE = "DELETE FROM ${UserEntity.TABLE_NAME}"
    }

    @Query(GET_USERS)
    abstract override fun getAllLiveItems(): LiveData<List<UserEntity>>

    @Query(GET_USERS)
    abstract override fun getALlItems(): List<UserEntity>

    @Query(CLEAR_TABLE)
    abstract override suspend fun clearTable()
}