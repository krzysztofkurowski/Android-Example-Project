package com.example.template

import android.app.Application

object DomainComponent {
    fun init(application: Application) {
        DataComponent.init(application)
    }
}