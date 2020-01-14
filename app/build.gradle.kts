import Libraries.AndroidX
import java.io.FileInputStream
import java.util.*

plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.safeArgsPlugin)
}

android {
    compileSdkVersion(AndroidSdk.compile)
    buildToolsVersion(BuildPlugins.buildToolsVersion)

    defaultConfig {
        applicationId = "com.example.template"
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        dataBinding.isEnabled = true
    }

    signingConfigs {
        val keystorePropertiesFile = rootProject.file("app/cert/keystore.properties")
        val keystoreProperties = Properties()
        keystoreProperties.load(FileInputStream(keystorePropertiesFile))

        create("release") {
            keyAlias = keystoreProperties["keyAlias"].toString()
            keyPassword = keystoreProperties["keyPassword"].toString()
            storeFile = file(keystoreProperties["storeFile"].toString())
            storePassword = keystoreProperties["storePassword"].toString()
        }

        getByName("debug") {
            storeFile = rootProject.file("app/cert/debug-key.jks")
            storePassword = "test123"
            keyAlias = "test123"
            keyPassword = "test123"
        }
    }

    buildTypes {
        getByName("debug") {
            signingConfig = signingConfigs.getByName("debug")
        }

        getByName("release") {
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(AndroidX.appCompat)
    implementation(AndroidX.ktxCore)
    implementation(AndroidX.constraintLayout)
    implementation(AndroidX.recyclerView)
    implementation(AndroidX.lifecycleViewmodel)

    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.material)
    implementation(Libraries.timber)
    implementation(Libraries.navigationUI)
    implementation(Libraries.navigationFragment)

    implementation(Libraries.koin)
    implementation(Libraries.koinViewmodel)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.junitTestExt)
    androidTestImplementation(TestLibraries.espresso)
}