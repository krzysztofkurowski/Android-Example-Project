package com.example.template.cache.user

import androidx.room.Dao
import androidx.room.Query
import com.example.template.cache.model.UserEntity
import com.example.template.cache.tools.BaseDao
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
internal abstract class UserDao : BaseDao<UserEntity>() {

    companion object {
        const val GET_USERS = "SELECT * FROM ${UserEntity.TABLE_NAME}"
        const val CLEAR_TABLE = "DELETE FROM ${UserEntity.TABLE_NAME}"
    }

    @Query(GET_USERS)
    abstract override fun getAllLiveItems(): Flowable<List<UserEntity>>

    @Query(GET_USERS)
    abstract override fun getALlItems(): List<UserEntity>

    @Query(CLEAR_TABLE)
    abstract override fun clearTable(): Completable
}