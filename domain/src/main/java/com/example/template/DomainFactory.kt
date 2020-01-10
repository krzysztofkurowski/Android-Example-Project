package com.example.template

import com.example.template.di.DomainKoinComponent
import com.example.template.useCases.PostUseCase
import com.example.template.useCases.UserUseCase
import org.koin.core.inject

object DomainFactory : DomainKoinComponent() {
    val userUseCase: UserUseCase by inject()
    val postUseCase: PostUseCase by inject()
}