package com.example.template.useCases

import com.example.template.cache.post.PostCacheRepository
import com.example.template.model.Post
import com.example.template.remote.Output
import com.example.template.remote.user.UserRemoteRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

interface PostUseCase {
    fun getPosts(userId: Int): Flowable<List<Post>>
    fun refreshPosts(userId: Int)
    fun onCleared()
}

internal class PostUseCaseImpl(
    private val remote: UserRemoteRepository,
    private val cache: PostCacheRepository
) : PostUseCase, BaseUseCase() {

    override fun getPosts(userId: Int): Flowable<List<Post>> = cache.getAllPosts(userId)

    override fun refreshPosts(userId: Int) {
        remote
            .getPosts(userId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeBy {
                if (it is Output.Success)
                    savePosts(it.data)
            }.addTo(disposable)
    }

    private fun savePosts(posts: List<Post>) =
        cache
            .savePosts(posts)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe()
            .addTo(disposable)
}