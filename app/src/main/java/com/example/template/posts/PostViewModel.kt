package com.example.template.posts

import com.example.template.tools.base.BaseViewModel
import com.example.template.useCases.PostUseCase
import javax.inject.Inject

class PostViewModel @Inject constructor(userId: Int, postUseCase: PostUseCase) :
    BaseViewModel() {

    val items = postUseCase.getPosts(userId)
}