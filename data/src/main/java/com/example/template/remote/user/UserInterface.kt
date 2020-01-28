package com.example.template.remote.user

import com.example.template.remote.model.PostDto
import com.example.template.remote.model.UserDto
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface UserInterface {

    @GET("/users")
    fun getUsers(): Observable<Response<List<UserDto>>>

    @GET("/posts")
    fun getPosts(@Query("userId") userId: Int): Observable<Response<List<PostDto>>>
}