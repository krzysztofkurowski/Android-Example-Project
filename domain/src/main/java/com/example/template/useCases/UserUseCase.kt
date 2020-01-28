package com.example.template.useCases

import com.example.template.cache.user.UserCacheRepository
import com.example.template.model.User
import com.example.template.remote.Output
import com.example.template.remote.user.UserRemoteRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

interface UserUseCase {
    fun getUsers(): Flowable<List<User>>
    fun refreshUser(): Disposable
    fun onCleared()
}

internal class UserUseCaseImpl(
    private val remote: UserRemoteRepository,
    private val cache: UserCacheRepository
) : UserUseCase, BaseUseCase() {

    override fun getUsers() = cache.getAllUsers()

    override fun refreshUser() =
        remote
            .getUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeBy {
                if (it is Output.Success)
                    saveUsers(it.data)
            }.addTo(disposable)

    private fun saveUsers(users: List<User>) =
        cache
            .saveUsers(users)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe()
            .addTo(disposable)
}