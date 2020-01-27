package com.example.template.di.module

import com.example.template.MainActivity
import com.example.template.di.scopes.ActivityScope
import com.example.template.di.scopes.FragmentScope
import com.example.template.posts.PostFragment
import com.example.template.user.UserFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @FragmentScope
    @ContributesAndroidInjector(modules = [UserModule::class])
    abstract fun bindUserFragment(): UserFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [PostModule::class])
    abstract fun bindPostFragment(): PostFragment
}