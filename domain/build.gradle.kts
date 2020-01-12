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
}

dependencies {
    implementation(project(":data"))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libraries.kotlinStdLib)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.ktxCore)
    implementation(Libraries.timber)
    implementation(Libraries.liveDataKtx)

    implementation(Libraries.koin)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.junitTestExt)
    androidTestImplementation(TestLibraries.espresso)
}
