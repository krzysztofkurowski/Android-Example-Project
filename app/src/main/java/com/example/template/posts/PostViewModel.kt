package com.example.template.posts

import androidx.lifecycle.viewModelScope
import com.example.template.tools.base.BaseViewModel
import com.example.template.useCases.PostUseCase
import kotlinx.coroutines.launch

class PostViewModel(private val userId: Int, private val postUseCase: PostUseCase) :
    BaseViewModel() {

    val items = postUseCase.getPosts(userId)

    init {
        viewModelScope.launch {
            postUseCase.refreshPosts(userId)
        }
    }
}