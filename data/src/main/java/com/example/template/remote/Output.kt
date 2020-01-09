package com.example.template.remote

sealed class Output<out T : Any> {
    data class Success<out T : Any>(val data: T) : Output<T>()
    data class Error(val errorEnum: ErrorEnum) : Output<Nothing>()
}

enum class ErrorEnum {
    NOT_SUCCESSFULLY,
    MAP_CAST_EXCEPTION
}