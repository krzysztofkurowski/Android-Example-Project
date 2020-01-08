const val kotlinVersion = "1.3.61"

object BuildPlugins {

    const val buildToolsVersion = "29.0.2"

    object Versions {
        const val buildGradleVersion = "3.5.3"
        const val safeArgs = "1.0.0-alpha04"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildGradleVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val safeArgs = "android.arch.navigation:navigation-safe-args-gradle-plugin:${Versions.safeArgs}"
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
    const val safeArgsPlugin = "androidx.navigation.safeargs"
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
        const val navigation_component = "1.0.0"
        const val koin = "2.0.1"
        const val moshi = "1.8.0"
        const val retrofit = "2.6.0"
        const val retrofit_moshi = "2.5.0"
        const val retrofit_coroutines = "0.9.2"
        const val okhttp = "3.12.0"
        const val okhttpInterceptor = "3.11.0"
        const val coroutines = "1.3.3"
        const val glide = "4.10.0"
        const val lifecycleViewmodel = "2.2.0-rc03"
        const val room = "2.2.3"
        const val legacy = "1.0.0"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val material = "com.google.android.material:material:1.0.0"
    const val timber = "com.jakewharton.timber:timber:4.7.1"
    const val navigationFragment =
        "android.arch.navigation:navigation-fragment-ktx:${Libraries.Versions.navigation_component}"
    const val navigationUI =
        "android.arch.navigation:navigation-ui-ktx:${Libraries.Versions.navigation_component}"
    const val koin = "org.koin:koin-android:${Libraries.Versions.koin}"
    const val koinViewmodel = "org.koin:koin-android-viewmodel:${Libraries.Versions.koin}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Libraries.Versions.moshi}"
    const val moshiKapt = "com.squareup.moshi:moshi-kotlin-codegen:${Libraries.Versions.moshi}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Libraries.Versions.retrofit}"
    const val retrofitMoshi =
        "com.squareup.retrofit2:converter-moshi:${Libraries.Versions.retrofit_moshi}"
    const val retrofitCoroutines =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Libraries.Versions.retrofit_coroutines}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Libraries.Versions.okhttp}"
    const val okhttpInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Libraries.Versions.okhttpInterceptor}"
    const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Libraries.Versions.coroutines}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Libraries.Versions.coroutines}"
    const val glide = "com.github.bumptech.glide:glide:${Libraries.Versions.glide}"
    const val glideKapt = "com.github.bumptech.glide:compiler:${Libraries.Versions.glide}"


    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:${Libraries.Versions.appcompat}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
        const val lifecycleViewmodel =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Libraries.Versions.lifecycleViewmodel}"
        const val room = "androidx.room:room-runtime:${Libraries.Versions.room}"
        const val roomKapt = "androidx.room:room-compiler:${Libraries.Versions.room}"
        const val roomKtx = "androidx.room:room-ktx:${Libraries.Versions.room}"
        const val legacy = "androidx.legacy:legacy-support-v4:${Libraries.Versions.legacy}"
    }
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val testExt = "1.1.1"
        const val espresso = "3.2.0"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val junitTestExt = "androidx.test.ext:junit:${Versions.testExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}