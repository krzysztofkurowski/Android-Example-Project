package com.example.template.user

import com.example.template.tools.base.BaseViewModel
import com.example.template.useCases.UserUseCase

class UserViewModel(
    userRepository: UserUseCase
) : BaseViewModel() {

    val items = userRepository.getUsers()
}