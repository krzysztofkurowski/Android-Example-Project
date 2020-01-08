package com.example.template.di

import com.example.template.posts.PostViewModel
import com.example.template.useCases.UserViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PresentationKoinModules {
    val presentationModule = module {
        viewModel { UserViewModel(get()) }
        viewModel { (userId: Int) ->  PostViewModel(userId, get()) }
    }
}