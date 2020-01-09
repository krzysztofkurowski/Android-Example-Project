package com.example.template.remote.user

import com.example.template.model.Post
import com.example.template.model.User
import com.example.template.remote.BaseRemoteRepository
import com.example.template.remote.Output
import com.example.template.remote.model.toPosts
import com.example.template.remote.model.toUsers

interface UserRemoteRepository {
    suspend fun getUsers(): Output<List<User>>
    suspend fun getPosts(userId: Int): Output<List<Post>>
}

internal class UserRemoteRepositoryImpl(private val userService: UserService) :
    UserRemoteRepository, BaseRemoteRepository() {
    override suspend fun getUsers() =
        userService.getUsers().convertToOutput {
            it.toUsers()
        }

    override suspend fun getPosts(userId: Int) = userService.getPosts(userId).convertToOutput {
        it.toPosts()
    }
}