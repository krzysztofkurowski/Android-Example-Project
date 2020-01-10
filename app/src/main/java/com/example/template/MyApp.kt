package com.example.template

import android.app.Application
import com.example.template.di.PresentationKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        DomainComponent.init(this)

        startKoin {
            androidContext(this@MyApp)
            modules(
                PresentationKoinModules.presentationModule
            )
        }
    }
}