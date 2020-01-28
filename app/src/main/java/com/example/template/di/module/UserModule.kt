package com.example.template.di.module

import com.example.template.DomainFactory
import com.example.template.di.scopes.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class UserModule {
    @FragmentScope
    @Provides
    fun provideUserUseCase() = DomainFactory.userUseCase
}