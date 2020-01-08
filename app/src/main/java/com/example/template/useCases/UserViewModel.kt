package com.example.template.useCases

import androidx.lifecycle.viewModelScope
import com.example.template.tools.base.BaseViewModel
import kotlinx.coroutines.launch

class UserViewModel(
    private val userRepository: UserUseCase
) : BaseViewModel() {

    val items = userRepository.getUsers()

    init {
        viewModelScope.launch {
            userRepository.refreshUsers()
        }
    }
}