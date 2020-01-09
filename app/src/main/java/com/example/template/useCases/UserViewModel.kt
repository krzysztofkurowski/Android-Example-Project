package com.example.template.useCases

import com.example.template.tools.base.BaseViewModel

class UserViewModel(
    userRepository: UserUseCase
) : BaseViewModel() {

    val items = userRepository.getUsers()
}