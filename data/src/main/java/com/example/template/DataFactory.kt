package com.example.template

import com.example.template.cache.post.PostCacheRepository
import com.example.template.cache.user.UserCacheRepository
import com.example.template.di.DataKoinComponent
import com.example.template.remote.user.UserRemoteRepository
import org.koin.core.inject

object DataFactory : DataKoinComponent() {
    val userRemoteRepository: UserRemoteRepository by inject()
    val userCacheRepository: UserCacheRepository by inject()
    val postCacheRepository: PostCacheRepository by inject()
}