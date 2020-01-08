package com.example.template.remote.user

import com.example.template.remote.model.PostDto
import com.example.template.remote.model.UserDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface UserInterface {

    @GET("/users")
    suspend fun getUsers(): Response<List<UserDto>>

    @GET("/posts")
    suspend fun getPosts(@Query("userId") userId: Int): Response<List<PostDto>>
}