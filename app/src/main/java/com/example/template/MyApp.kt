package com.example.template

import com.example.template.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MyApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out MyApp> =
        DaggerAppComponent.factory().create(this)

    override fun onCreate() {
        super.onCreate()
        DomainComponent.init(this)
    }
}