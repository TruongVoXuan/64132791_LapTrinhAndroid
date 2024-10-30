plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.recycleview"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.recycleview"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation("com.android.volley:volley:1.2.1") // Sửa đổi từ compile thành implementation
    implementation("androidx.recyclerview:recyclerview:1.2.1") // Cập nhật thư viện RecyclerView
    implementation("com.squareup.picasso:picasso:2.71828")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    implementation("com.github.bumptech.glide:glide:4.11.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.11.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    androidTestImplementation(libs.ext.junit)

    androidTestImplementation(libs.espresso.core)
}