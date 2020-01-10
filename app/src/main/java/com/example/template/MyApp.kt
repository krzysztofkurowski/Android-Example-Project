package com.example.template

import android.app.Application
import com.example.template.di.DataKoinModules
import com.example.template.di.DomainKoinModules
import com.example.template.di.PresentationKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            //TODO add separation between modules for di
            modules(
                listOf(
                    PresentationKoinModules.presentationModule,
                    *DataKoinModules.dataModules,
                    DomainKoinModules.domainModules
                )
            )
        }
    }
}