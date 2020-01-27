package com.example.template.di.module

import com.example.template.DomainFactory
import com.example.template.di.qualifiers.UserID
import com.example.template.di.scopes.FragmentScope
import com.example.template.posts.PostFragment
import com.example.template.posts.PostViewModelFactory
import com.example.template.useCases.PostUseCase
import dagger.Module
import dagger.Provides

@Module
class PostModule {
    @FragmentScope
    @Provides
    fun providePostUseCase() = DomainFactory.postUseCase

    @FragmentScope
    @Provides
    @UserID
    fun provideUserId(postFragment: PostFragment) = postFragment.userId

    @FragmentScope
    @Provides
    fun provideViewModelFactory(@UserID userId: Int, postUseCase: PostUseCase) =
        PostViewModelFactory(userId, postUseCase)
}