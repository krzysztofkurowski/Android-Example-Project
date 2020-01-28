package com.example.template.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.template.model.User
import com.example.template.tools.base.BaseViewModel
import com.example.template.useCases.UserUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class UserViewModel(
    private val userRepository: UserUseCase
) : BaseViewModel() {

    val items = MutableLiveData<List<User>>()

    fun getItems(): LiveData<List<User>> = items

    init {
        getUsers()
        refreshUsers()
    }

    private fun refreshUsers() {
        viewModelScope.launch {
            userRepository
                .refreshUser()
        }
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
}