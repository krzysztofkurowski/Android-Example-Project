package com.example.template.useCases

import androidx.lifecycle.LiveData
import com.example.template.BaseUseCase
import com.example.template.cache.user.UserCacheRepository
import com.example.template.model.User
import com.example.template.remote.user.UserRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface UserUseCase {
    fun getUsers(): LiveData<List<User>>
    suspend fun refreshUsers()
}

internal class UserUseCaseImpl(
    private val remote: UserRemoteRepository,
    private val cache: UserCacheRepository
) : UserUseCase, BaseUseCase() {

    override fun getUsers() = cache.getAllUsers()

    override suspend fun refreshUsers(){
        withContext(Dispatchers.IO){
            val users = remote.getUsers()
            cache.saveUsers(users)
        }
    }
}