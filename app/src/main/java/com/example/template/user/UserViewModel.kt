package com.example.template.user

import com.example.template.tools.base.BaseViewModel
import com.example.template.useCases.UserUseCase
import javax.inject.Inject

class UserViewModel @Inject constructor(
    userRepository: UserUseCase
) : BaseViewModel() {

    val items = userRepository.getUsers()
}