plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.prudhvir3ddy.earlyentrypoint_sample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.prudhvir3ddy.earlyentrypoint_sample"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.prudhvir3ddy.earlyentrypoint_sample.MyTestRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Dagger hilt
    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-android-compiler:2.50")

    androidTestImplementation("com.google.dagger:hilt-android-testing:2.50")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.50")

    // Activity-ktx
    implementation("androidx.activity:activity-ktx:1.8.2")

    // Workmanager
    implementation("androidx.work:work-runtime-ktx:2.8.0")

    // Workmanager hilt
    implementation("androidx.hilt:hilt-work:1.1.0")
    // When using Kotlin.
    kapt("androidx.hilt:hilt-compiler:1.1.0")
    kaptAndroidTest("androidx.hilt:hilt-compiler:1.1.0")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}