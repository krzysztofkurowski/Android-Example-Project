package com.example.template

import android.app.Application

object DataComponent {

    private lateinit var application: Application

    fun init(application: Application) {
        this.application = application
    }

    fun getAppContext() = application
}