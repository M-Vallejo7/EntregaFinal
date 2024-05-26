plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.vallejo.entregafinal"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.vallejo.entregafinal"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Mis Implementaciones (5)
    // Scalable Size Unit (support for different screen sizes)
    implementation ("com.intuit.sdp:sdp-android:1.0.6")
    implementation ("com.intuit.ssp:ssp-android:1.0.6")
    // Rounded ImageView
    implementation ("com.makeramen:roundedimageview:2.3.0")
    // Animation LottieFiles
    implementation("com.airbnb.android:lottie:6.4.0")
    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:33.0.0"))
}