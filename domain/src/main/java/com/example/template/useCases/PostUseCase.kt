package com.example.template.useCases

import com.example.template.cache.post.PostCacheRepository
import com.example.template.model.Post
import com.example.template.remote.Output
import com.example.template.remote.user.UserRemoteRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface PostUseCase {
    fun getPosts(userId: Int): Flowable<List<Post>>
    suspend fun refreshPosts(userId: Int)
}

internal class PostUseCaseImpl(
    private val remote: UserRemoteRepository,
    private val cache: PostCacheRepository
) : PostUseCase, BaseUseCase() {

    override fun getPosts(userId: Int): Flowable<List<Post>> = cache.getAllPosts(userId)

    override suspend fun refreshPosts(userId: Int) {
        withContext(Dispatchers.IO) {
            val postOutput = remote.getPosts(userId)
            if (postOutput is Output.Success)
                cache.savePosts(postOutput.data)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe()
        }
    }
}