plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.serialization)
}

android {
    namespace = "com.reyaz.islamiccalendar"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.reyaz.islamiccalendar"
        minSdk = 24
        targetSdk = 36
        versionCode = 3
        versionName = "1.2"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.datastore.core.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // OkHttp for network requests
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)


    // Coroutines for asynchronous tasks
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // datastore
    implementation(libs.androidx.datastore.preferences)

    // koin
    //you can use BOM-version to manage all Koin library versions. When using the BOM in your app, you don't need to add any version to the Koin library dependencies themselves. When you update the BOM version, all the libraries that you're using are automatically updated to their new versions.
    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.core.coroutines)

    //implementation("io.insert-koin:koin-androidx-startup")
    implementation(libs.koin.androidx.compose)
    implementation(libs.koin.androidx.compose.navigation)

    // ViewModel and Navigation
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.navigation.compose)

    // extended icon
//    implementation(libs.androidx.material.icons.extended)

    // worker
//    implementation(libs.androidx.work.runtime.ktx)
    // koin-Jetpack WorkManager
//    implementation(libs.koin.androidx.workmanager)

    // splash
//    implementation(libs.androidx.core.splashscreen)
    // date and time
    implementation(libs.kotlinx.datetime)

    // room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    implementation(libs.kotlinx.serialization.json)
}