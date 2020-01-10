package com.example.template.di

import com.example.template.DataFactory
import com.example.template.useCases.PostUseCase
import com.example.template.useCases.PostUseCaseImpl
import com.example.template.useCases.UserUseCase
import com.example.template.useCases.UserUseCaseImpl
import org.koin.dsl.module

internal object DomainKoinModules {
    val domainModules = listOf(useCaseModules(), dataRepositoryModules())

    private fun useCaseModules() = module {
        factory<UserUseCase> { UserUseCaseImpl(get(), get()) }
        factory<PostUseCase> { PostUseCaseImpl(get(), get()) }
    }

    private fun dataRepositoryModules() = module {
        single { DataFactory.userRemoteRepository }
        single { DataFactory.userCacheRepository }
        single { DataFactory.postCacheRepository }
    }
}