package com.example.template.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.template.useCases.PostUseCase
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class PostViewModelFactory @Inject constructor(
    private val userId: Int, private val postUseCase: PostUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostViewModel(userId, postUseCase) as T
    }
}