package com.example.template.remote

import retrofit2.Response

internal abstract class BaseRemoteRepository {
    fun <T, D : Any> Response<T>.convertToOutput(mapFunction: (T) -> D): Output<D> {
        if (!isSuccessful)
            return Output.Error(ErrorEnum.NOT_SUCCESSFULLY)
        return try {
            val data = body()!!
            val mappedData = mapFunction(data)
            Output.Success(mappedData)
        } catch (cce: ClassCastException) {
            Output.Error(ErrorEnum.MAP_CAST_EXCEPTION)
        }
    }
}