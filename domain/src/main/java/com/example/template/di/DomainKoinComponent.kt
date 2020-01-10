package com.example.template.di

import org.koin.core.Koin
import org.koin.core.KoinComponent
import org.koin.dsl.koinApplication

abstract class DomainKoinComponent : KoinComponent {

    private val domainKoin = koinApplication {
        modules(DomainKoinModules.domainModules)
    }

    override fun getKoin(): Koin {
        return domainKoin.koin
    }
}