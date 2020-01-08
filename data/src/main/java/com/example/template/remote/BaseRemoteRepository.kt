package com.example.template.remote

import retrofit2.Response

internal abstract class BaseRemoteRepository {
    fun <T, D> Response<T>.getData(mapFunction: (T) -> List<D>): List<D> {
        body() ?: return emptyList()
        return try {
            mapFunction(body()!!)
        } catch (cce: ClassCastException) {
            emptyList()
        }
    }
}