package com.example.template.remote.user

import com.example.template.remote.model.PostDto
import com.example.template.remote.model.UserDto
import io.reactivex.Observable
import retrofit2.Response

internal interface UserService {
    fun getPosts(userId: Int): Observable<Response<List<PostDto>>>
    fun getUsers(): Observable<Response<List<UserDto>>>
}

internal class UserServiceImpl(private val userInterface: UserInterface) :
    UserService {
    override fun getPosts(userId: Int) = userInterface.getPosts(userId)
    override fun getUsers() = userInterface.getUsers()
}

internal class UserMockServiceImpl() : UserService {

    override fun getPosts(userId: Int): Observable<Response<List<PostDto>>> =
        Observable.fromArray(Response.success(listOf(PostDto("body", 0, "title", 0))))

    override fun getUsers(): Observable<Response<List<UserDto>>> =
        Observable.fromArray(Response.success(emptyList()))
}