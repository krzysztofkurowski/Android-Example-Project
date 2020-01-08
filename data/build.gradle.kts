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
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
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

    implementation(Libraries.okhttp)
    implementation(Libraries.okhttpInterceptor)

    implementation(Libraries.koin)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.junitTestExt)
    androidTestImplementation(TestLibraries.espresso)
}