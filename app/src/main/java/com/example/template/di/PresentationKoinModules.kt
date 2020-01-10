package com.example.template.di

import com.example.template.DomainFactory
import com.example.template.posts.PostViewModel
import com.example.template.user.UserViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PresentationKoinModules {
    val presentationModule = listOf(useCaseModules(), viewModelModules())

    private fun useCaseModules() = module {
        factory { DomainFactory.userUseCase }
        factory { DomainFactory.postUseCase }
    }

    private fun viewModelModules() = module {
        viewModel { UserViewModel(get()) }
        viewModel { (userId: Int) -> PostViewModel(userId, get()) }
    }
}