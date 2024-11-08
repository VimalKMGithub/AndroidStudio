plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.ca02"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ca02"
        minSdk = 24
        targetSdk = 34
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
}

dependencies {
    // Existing dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Room Database dependencies
    implementation("androidx.room:room-runtime:2.5.0")
    kapt("androidx.room:room-compiler:2.5.0")

    // Room KTX for coroutines support
    implementation("androidx.room:room-ktx:2.5.0")  // <-- Add this line

    // Coroutines dependencies
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // RecyclerView dependency
    implementation("androidx.recyclerview:recyclerview:1.2.1")

    // ViewModel & LiveData dependencies
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0")
}