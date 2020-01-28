package com.example.template.cache.user

import com.example.template.cache.model.toUsers
import com.example.template.cache.tools.diffUtil.BaseDiffCallback
import com.example.template.model.User
import com.example.template.model.toUserEntities
import io.reactivex.Completable
import io.reactivex.Flowable

interface UserCacheRepository {
    fun getAllUsers(): Flowable<List<User>>
    fun saveUsers(users: List<User>): Completable
}

internal class UserCacheRepositoryImpl(private val userDao: UserDao) : UserCacheRepository {
    override fun getAllUsers(): Flowable<List<User>> =
        userDao.getAllLiveItems().map { it.toUsers() }

    override fun saveUsers(users: List<User>): Completable =
        Completable.fromAction {
            userDao.makeDiff(
                BaseDiffCallback(
                    oldList = userDao.getALlItems(),
                    newList = users.toUserEntities()
                )
            )
        }
}