import Libraries.AndroidX
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
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

    sourceSets {
        getByName("main").res.srcDirs(
            "src/main/res",
            "src/main/res/layouts/user",
            "src/main/res/layouts/post"
        )
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
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
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")

    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.material)
    implementation(Libraries.timber)
    implementation(Libraries.navigationUI)
    implementation(Libraries.navigationFragment)
    implementation(Libraries.koin)
    implementation("androidx.fragment:fragment-ktx:1.2.0")
    implementation("androidx.preference:preference-ktx:1.1.0")
    implementation("io.reactivex.rxjava2:rxjava:2.2.9")
    implementation("io.reactivex.rxjava2:rxandroid:2.0.1")
    implementation("io.reactivex.rxjava2:rxkotlin:2.1.0")
    implementation("android.arch.persistence.room:rxjava2:1.1.1")
    implementation("androidx.room:room-rxjava2:2.2.3")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.4.0")
    implementation("com.squareup.retrofit2:converter-gson:2.6.0")

    implementation("com.google.dagger:dagger:2.25.2")
    implementation("com.google.dagger:dagger-android-support:2.25.2")

    kapt("com.google.dagger:dagger-compiler:2.25.2")
    kapt("com.google.dagger:dagger-android-processor:2.25.2")

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.junitTestExt)
    androidTestImplementation(TestLibraries.espresso)
}