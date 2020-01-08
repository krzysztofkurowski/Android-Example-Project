package com.example.template.cache.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.template.cache.model.toUsers
import com.example.template.cache.tools.diffUtil.BaseDiffCallback
import com.example.template.model.User
import com.example.template.model.toUserEntities

interface UserCacheRepository {
    fun getAllUsers(): LiveData<List<User>>
    suspend fun saveUsers(users: List<User>)
}

internal class UserCacheRepositoryImpl(private val userDao: UserDao) : UserCacheRepository {
    override fun getAllUsers(): LiveData<List<User>> =
        Transformations.map(userDao.getAllLiveItems()) { it.toUsers() }

    override suspend fun saveUsers(users: List<User>) {
        userDao.makeDiff(
            BaseDiffCallback(
                oldList = userDao.getALlItems(),
                newList = users.toUserEntities()
            )
        )
    }
}