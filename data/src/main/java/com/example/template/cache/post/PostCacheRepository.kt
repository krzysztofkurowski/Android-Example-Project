package com.example.template.cache.post

import com.example.template.cache.model.toPosts
import com.example.template.model.Post
import com.example.template.model.toEntities
import io.reactivex.Completable
import io.reactivex.Flowable

interface PostCacheRepository {
    fun getAllPosts(userId: Int): Flowable<List<Post>>
    fun savePosts(posts: List<Post>): Completable
}

internal class PostCacheRepositoryImpl(private val postDao: PostDao) : PostCacheRepository {
    override fun getAllPosts(userId: Int): Flowable<List<Post>> =
        postDao.getPosts(userId).map { it.toPosts() }


    override fun savePosts(posts: List<Post>): Completable =
        postDao.insert(posts.toEntities())
}