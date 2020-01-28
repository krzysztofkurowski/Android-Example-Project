import Libraries.AndroidX

plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
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
    implementation(project(":data"))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libraries.kotlinStdLib)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.ktxCore)
    implementation(Libraries.timber)
    implementation(Libraries.liveDataKtx)
    implementation("io.reactivex.rxjava2:rxjava:2.2.9")
    implementation("io.reactivex.rxjava2:rxandroid:2.0.1")
    implementation("io.reactivex.rxjava2:rxkotlin:2.1.0")
    implementation("android.arch.persistence.room:rxjava2:1.1.1")
    implementation("androidx.room:room-rxjava2:2.2.3")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.4.0")
    implementation("com.squareup.retrofit2:converter-gson:2.6.0")

    implementation(Libraries.koin)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.junitTestExt)
    androidTestImplementation(TestLibraries.espresso)
}
