package com.example.template.di

import com.example.template.cache.DatabaseClient
import com.example.template.cache.MyDatabase
import com.example.template.cache.post.PostCacheRepository
import com.example.template.cache.post.PostCacheRepositoryImpl
import com.example.template.cache.user.UserCacheRepository
import com.example.template.cache.user.UserCacheRepositoryImpl
import com.example.template.remote.ApiUtils
import com.example.template.remote.OkHttp
import com.example.template.remote.user.UserRemoteRepository
import com.example.template.remote.user.UserRemoteRepositoryImpl
import com.example.template.remote.user.UserService
import com.example.template.remote.user.UserServiceImpl
import okhttp3.Interceptor
import org.koin.dsl.module

internal object DataKoinModules {

    val dataModules = listOf(
        remoteModules(),
        cacheModules(),
        repoModules()
    )

    private fun remoteModules() = module {
        single<Interceptor> { OkHttp.getLogsInterceptor() }
        single { OkHttp.getClient(get()) }
        single { ApiUtils.getUserInterface(get()) }
        single<UserService> { UserServiceImpl(get()) }
    }

    private fun cacheModules() = module {
        single { DatabaseClient.getInstance(get()) }
        single { get<MyDatabase>().getUserDao() }
        single { get<MyDatabase>().getPostsDao() }
    }

    private fun repoModules() = module {
        single<UserRemoteRepository> { UserRemoteRepositoryImpl(get()) }
        single<UserCacheRepository> { UserCacheRepositoryImpl(get()) }
        single<PostCacheRepository> { PostCacheRepositoryImpl(get()) }
    }
}