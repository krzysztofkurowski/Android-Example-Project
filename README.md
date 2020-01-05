# Android Project Template
![Build status](https://img.shields.io/github/workflow/status/AdrianKuta/Android-Project-Template/Android%20CI?style=plastic)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://github.com/AdrianKuta/Design-Patterns-Kotlin/blob/master/LICENSE)

This repository is my foundations for Clean Architecture project.
With build gradle in Kotlin DSL instead of Groovy.

## Clean Architecture layers

Project is divided into 3 modules/layers:
- [Presentation Layer](#presentation-layer) (app module)
- [Domain Layer](#domain-layer) (domain module)
- [Data layer](#data-layer) (data module)

<p align="center">
<img src="https://github.com/AdrianKuta/Android-Project-Template/blob/master/readme/Clean%20Architecture.png" width=400>
</p>

Each upper layer should communicate with lower layer via provided interfaces.

> I usually use isolated dependency injection for each clean architecture layer.

Dividing project into layers(modules) can slightly improve build process. Because if we made changes in one layer we can avoid recompiling other layers.

### Presentation Layer

Presents data to a screen and handle user interactions. If we change implementation of our UI it would not affect other layers.

### Domain Layer

Contains business logic. Provides interfaces exposed to Presentation Layer without showing implementation. If we update our business logic it won't affect our presentation layer.

### Data Layer

Access, retrieve and manage application data. It should contains e.g. Room's DAOs, Retrofit's Services etc.

## Kotlin DSL

Project contains `buildSrc` directory with `Dependecies.kt`. Dependecies file will be common for each clean architecture layer, preventing from dependencies version conflict. 
 


```kotlin
import Libraries.Versions.appcompat

const val kotlinVersion = "1.3.61"

object BuildPlugins {

    const val buildToolsVersion = "29.0.2"

    object Versions {
        const val buildGradleVersion = "3.5.3"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildGradleVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"

}

object AndroidSdk {
    const val min = 23
    const val compile = 29
    const val target = compile
}

object Libraries {
    private object Versions {
        const val appcompat = "1.1.0"
        const val constraintLayout = "1.1.3"
        const val ktx = "1.1.0"
    }

    const val kotlinStdLib     = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val material         = "com.google.android.material:material:1.0.0"
    const val timber           = "com.jakewharton.timber:timber:4.7.1"


    object AndroidX {
        const val appCompat        = "androidx.appcompat:appcompat:$appcompat"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val ktxCore          = "androidx.core:core-ktx:${Versions.ktx}"
        const val recyclerView     = "androidx.recyclerview:recyclerview:1.1.0"
    }
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val testExt = "1.1.1"
        const val espresso = "3.2.0"
    }
    const val junit4     = "junit:junit:${Versions.junit4}"
    const val junitTestExt    = "androidx.test.ext:junit:${Versions.testExt}"
    const val espresso   = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}
```
