package com.example.template.di

import com.example.template.DataComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.Koin
import org.koin.core.KoinComponent
import org.koin.dsl.koinApplication

abstract class DataKoinComponent : KoinComponent {

    private val dataKoin = koinApplication {
        androidContext(DataComponent.getAppContext())
        modules(DataKoinModules.dataModules)
    }

    override fun getKoin(): Koin {
        return dataKoin.koin
    }
}