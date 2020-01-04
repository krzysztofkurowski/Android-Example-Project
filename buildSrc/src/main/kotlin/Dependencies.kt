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
