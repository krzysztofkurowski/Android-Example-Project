package com.example.template.useCases

import androidx.lifecycle.LiveData
import com.example.template.BaseUseCase
import com.example.template.cache.post.PostCacheRepository
import com.example.template.model.Post
import com.example.template.remote.user.UserRemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface PostUseCase {
    fun getPosts(userId: Int): LiveData<List<Post>>
    suspend fun refreshPosts(userId: Int)
}

internal class PostUseCaseImpl(
    private val remote: UserRemoteRepository,
    private val cache: PostCacheRepository
) : PostUseCase, BaseUseCase() {

    override fun getPosts(userId: Int) = cache.getAllPosts(userId)

    override suspend fun refreshPosts(userId: Int) {
        withContext(Dispatchers.IO) {
            val posts = remote.getPosts(userId)
            cache.savePosts(posts)
        }
    }
}