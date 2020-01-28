package com.example.template.useCases

import com.example.template.cache.user.UserCacheRepository
import com.example.template.model.User
import com.example.template.remote.Output
import com.example.template.remote.user.UserRemoteRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface UserUseCase {
    fun getUsers(): Flowable<List<User>>
    suspend fun refreshUser()
}

internal class UserUseCaseImpl(
    private val remote: UserRemoteRepository,
    private val cache: UserCacheRepository
) : UserUseCase, BaseUseCase() {

    override fun getUsers() = cache.getAllUsers()

    override suspend fun refreshUser() {
        withContext(Dispatchers.IO) {
            val userOutput = remote.getUsers()
            if (userOutput is Output.Success)
                cache.saveUsers(userOutput.data)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe()
        }
    }
}