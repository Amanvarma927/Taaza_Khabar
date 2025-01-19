plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
}

android {
    namespace = "com.a1developers.taazakhabar"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.a1developers.taazakhabar"
        minSdk = 24
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
    implementation(libs.androidx.datastore.preferences.core.jvm)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.transport.runtime)
    implementation(libs.support.annotations)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)
    implementation(libs.androidx.paging.compose.android)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.room.common)
    implementation(libs.androidx.core.animation)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.core.splashscreen)
//    implementation(libs.androidx.datastore.core)
//    implementation(libs.hilt.android)
//    kapt(libs.dagger.hilt.android.compiler)

//    kapt(libs.hilt.compiler.v255)
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")

    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("androidx.navigation:navigation-compose:2.6.0")
    implementation("androidx.compose.ui:ui:1.0.0")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.34.0")



    //Paging 3

    val paging_version = "3.2.0"
    implementation ("androidx.paging:paging-runtime:3.2.0")
    implementation ("androidx.paging:paging-compose:3.2.0-rc01")


    //Room
//    val room_version = "2.5.2"
    implementation ("androidx.room:room-runtime:2.6.1")
    kapt ("androidx.room:room-compiler:2.6.1")
    implementation ("androidx.room:room-ktx:2.6.1")



    //Compose Foundation
    implementation ("androidx.compose.foundation:foundation:1.4.3")

    //Coil
    implementation("io.coil-kt:coil-compose:2.4.0")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("com.valentinilk.shimmer:compose-shimmer:1.2.0")

    implementation("androidx.paging:paging-runtime:3.2.1")

}
// Allow references to generated code
kapt {
    correctErrorTypes = true
}