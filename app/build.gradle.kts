plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    //id("org.jetbrains.kotlin.kapt")


    alias(libs.plugins.hilt)

    id("org.jetbrains.kotlin.kapt")

    id("com.google.devtools.ksp")

    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.petshopapptp3"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.petshopapptp3"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation("androidx.navigation:navigation-compose:2.7.3")
    implementation("androidx.compose.material:material:1.6.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("io.coil-kt:coil-compose:2.4.0")
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation(libs.coil)
    val roomVersion = "2.8.4"
    implementation("androidx.room:room-runtime:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    //implementation("androidx.room:room-runtime:2.6.1")
    //kapt("androidx.room:room-compiler:2.6.1")
    //implementation("androidx.room:room-ktx:2.6.1")
    implementation(libs.hilt)
    kapt(libs.hiltCompiler)
    //ksp(libs.hiltCompiler)

    implementation(libs.androidx.hilt.navigation.compose)

    // Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:34.5.0"))

    // Firestore (sin -ktx)
    implementation("com.google.firebase:firebase-firestore")

    // Recomendado para identificar usuario y guardar favoritos “por usuario”
    implementation("com.google.firebase:firebase-auth")

    // Para poder usar Task.await() con coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.10.2")
}