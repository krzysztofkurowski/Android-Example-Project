package com.example.template.remote.user

import com.example.template.model.Post
import com.example.template.model.User
import com.example.template.remote.BaseRemoteRepository
import com.example.template.remote.Output
import com.example.template.remote.model.toPosts
import com.example.template.remote.model.toUsers
import io.reactivex.Observable

interface UserRemoteRepository {
    fun getUsers(): Observable<Output<List<User>>>
    fun getPosts(userId: Int): Observable<Output<List<Post>>>
}

internal class UserRemoteRepositoryImpl(private val userService: UserService) :
    UserRemoteRepository, BaseRemoteRepository() {
    override fun getUsers() =
        userService.getUsers().convertToOutput {
            it.toUsers()
        }

    override fun getPosts(userId: Int) = userService.getPosts(userId).convertToOutput {
        it.toPosts()
    }
}