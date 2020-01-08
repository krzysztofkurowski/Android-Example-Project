package com.example.template.remote

import com.example.template.remote.user.UserInterface
import okhttp3.OkHttpClient

internal object ApiUtils {

    private const val URL_TO_API = "https://jsonplaceholder.typicode.com"

    fun getUserInterface(okHttpClient: OkHttpClient): UserInterface =
        Retrofit.getClient(okHttpClient, URL_TO_API)
            .create(UserInterface::class.java)
}