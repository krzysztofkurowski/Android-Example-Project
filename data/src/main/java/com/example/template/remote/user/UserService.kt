package com.example.template.remote.user

import com.example.template.remote.model.PostDto
import com.example.template.remote.model.UserDto
import retrofit2.Response

internal interface UserService {
    suspend fun getPosts(userId: Int): Response<List<PostDto>>
    suspend fun getUsers(): Response<List<UserDto>>
}

internal class UserServiceImpl(private val userInterface: UserInterface) :
    UserService {
    override suspend fun getPosts(userId: Int) = userInterface.getPosts(userId)
    override suspend fun getUsers() = userInterface.getUsers()
}

internal class UserMockServiceImpl() : UserService {

    override suspend fun getPosts(userId: Int): Response<List<PostDto>> =
        Response.success(listOf(PostDto("body", 0, "title", 0)))

    override suspend fun getUsers(): Response<List<UserDto>> =
        Response.success(emptyList())
}