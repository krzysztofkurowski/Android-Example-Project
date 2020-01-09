package com.example.template.useCases

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.template.BaseUseCase
import com.example.template.cache.post.PostCacheRepository
import com.example.template.model.Post
import com.example.template.remote.user.UserRemoteRepository
import kotlinx.coroutines.Dispatchers

interface PostUseCase {
    fun getPosts(userId: Int): LiveData<List<Post>>
}

internal class PostUseCaseImpl(
    private val remote: UserRemoteRepository,
    private val cache: PostCacheRepository
) : PostUseCase, BaseUseCase() {

    override fun getPosts(userId: Int) = liveData(Dispatchers.IO) {
        emitSource(cache.getAllPosts(userId))
        val posts = remote.getPosts(userId)
        cache.savePosts(posts)
    }
}