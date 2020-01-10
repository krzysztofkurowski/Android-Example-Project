package com.example.template.useCases

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.template.cache.user.UserCacheRepository
import com.example.template.model.User
import com.example.template.remote.Output
import com.example.template.remote.user.UserRemoteRepository
import kotlinx.coroutines.Dispatchers

interface UserUseCase {
    fun getUsers(): LiveData<List<User>>
}

internal class UserUseCaseImpl(
    private val remote: UserRemoteRepository,
    private val cache: UserCacheRepository
) : UserUseCase, BaseUseCase() {

    override fun getUsers() = liveData(Dispatchers.IO) {
        emitSource(cache.getAllUsers())

        val userOutput = remote.getUsers()
        if(userOutput is Output.Success)
            cache.saveUsers(userOutput.data)
    }
}