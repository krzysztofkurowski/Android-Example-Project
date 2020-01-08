package com.example.template.cache.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.template.cache.model.toPosts
import com.example.template.cache.tools.diffUtil.BaseDiffCallback
import com.example.template.model.Post
import com.example.template.model.toEntities

interface PostCacheRepository {
    fun getAllPosts(userId: Int): LiveData<List<Post>>
    suspend fun savePosts(posts: List<Post>)
}

internal class PostCacheRepositoryImpl(private val postDao: PostDao) : PostCacheRepository {
    override fun getAllPosts(userId: Int): LiveData<List<Post>> =
        Transformations.map(postDao.getPosts(userId)) { it.toPosts() }

    override suspend fun savePosts(posts: List<Post>) {
        postDao.makeDiff(
            BaseDiffCallback(
                oldList = postDao.getALlItems(),
                newList = posts.toEntities()
            )
        )
    }
}