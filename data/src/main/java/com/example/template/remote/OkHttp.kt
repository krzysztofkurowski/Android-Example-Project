package com.example.template.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

internal object OkHttp {

    fun getClient(vararg interceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder().apply {
            interceptor.forEach {
                addInterceptor(it)
            }
        }.build()

    fun getLogsInterceptor() =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
}

