package com.example.template.di

import com.example.template.useCases.PostUseCase
import com.example.template.useCases.PostUseCaseImpl
import com.example.template.useCases.UserUseCase
import com.example.template.useCases.UserUseCaseImpl
import org.koin.dsl.module

object DomainKoinModules {
    val domainModules = module {
        single<UserUseCase> { UserUseCaseImpl(get(), get()) }
        single<PostUseCase> { PostUseCaseImpl(get(), get()) }
    }
}