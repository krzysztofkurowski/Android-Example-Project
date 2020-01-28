package com.example.template.remote

import io.reactivex.Observable
import retrofit2.Response

internal abstract class BaseRemoteRepository {
    fun <T, D : Any> Observable<Response<T>>.convertToOutput(mapFunction: (T) -> D): Observable<Output<D>> =
        this.map {
            if (!it.isSuccessful)
                Output.Error(ErrorEnum.NOT_SUCCESSFULLY)
            else {
                try {
                    val data = it.body()!!
                    val mappedData = mapFunction(data)
                    Output.Success(mappedData)
                } catch (cce: ClassCastException) {
                    Output.Error(ErrorEnum.MAP_CAST_EXCEPTION)
                }
            }
        }
}