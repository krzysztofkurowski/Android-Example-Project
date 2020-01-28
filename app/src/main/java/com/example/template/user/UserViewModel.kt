package com.example.template.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.template.model.User
import com.example.template.tools.base.BaseViewModel
import com.example.template.useCases.UserUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserViewModel @Inject constructor(
private val userRepository: UserUseCase
) : BaseViewModel() {

    val items = MutableLiveData<List<User>>()

    fun getItems(): LiveData<List<User>> = items

    init {
        getUsers()
        refreshUsers()
    }

    private fun refreshUsers() {
        userRepository.refreshUser()
    }

    private fun getUsers() {
        userRepository
            .getUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeBy {
                items.postValue(it)
            }
    }

    override fun onCleared() {
        userRepository.onCleared()
        super.onCleared()
    }
}