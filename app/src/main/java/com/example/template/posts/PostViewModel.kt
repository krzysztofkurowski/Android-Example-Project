package com.example.template.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.template.model.Post
import com.example.template.tools.base.BaseViewModel
import com.example.template.useCases.PostUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostViewModel @Inject constructor(
    userId: Int,
    private val postUseCase: PostUseCase
) :
    BaseViewModel() {

    val items = MutableLiveData<List<Post>>()

    fun getItems(): LiveData<List<Post>> = items

    init {
        getPosts(userId)
        refreshPosts(userId)
    }

    private fun refreshPosts(userId: Int) {
        postUseCase.refreshPosts(userId)
    }

    private fun getPosts(userId: Int) {
        postUseCase
            .getPosts(userId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeBy {
                items.postValue(it)
            }.addTo(disposable)
    }

    override fun onCleared() {
        postUseCase.onCleared()
        super.onCleared()
    }
}