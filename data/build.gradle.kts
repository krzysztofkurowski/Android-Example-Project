import Libraries.AndroidX

plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion(AndroidSdk.compile)
    buildToolsVersion(BuildPlugins.buildToolsVersion)

    defaultConfig {
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "consumer-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libraries.kotlinStdLib)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.ktxCore)
    implementation(Libraries.timber)

    implementation(AndroidX.room)
    implementation(AndroidX.roomKtx)
    kapt(AndroidX.roomKapt)

    implementation(Libraries.moshi)
    kapt(Libraries.moshiKapt)

    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitCoroutines)
    implementation(Libraries.retrofitMoshi)
    implementation("io.reactivex.rxjava2:rxjava:2.2.9")
    implementation("io.reactivex.rxjava2:rxandroid:2.0.1")
    implementation("io.reactivex.rxjava2:rxkotlin:2.1.0")
    implementation("android.arch.persistence.room:rxjava2:1.1.1")
    implementation("androidx.room:room-rxjava2:2.2.3")
    implementation("com.squareup.retrofit2:adapter-rxjava:2.3.0")

    implementation(Libraries.okhttp)
    implementation(Libraries.okhttpInterceptor)

    implementation(Libraries.koin)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.junitTestExt)
    androidTestImplementation(TestLibraries.espresso)
}