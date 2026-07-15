plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.gymrat"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.gymrat"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)

    // ConstraintLayout
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")

    // RecyclerView
    implementation("androidx.recyclerview:recyclerview:1.4.0")

    // CardView
    implementation("androidx.cardview:cardview:1.0.0")

    // Activity
    implementation("androidx.activity:activity:1.10.1")

    // Fragment
    implementation("androidx.fragment:fragment:1.8.9")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-livedata:2.9.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.9.2")

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}