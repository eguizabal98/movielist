plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.eem.data"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"${project.findProperty("BASE_URL")}\"")
            buildConfigField(
                "String",
                "API_READ_TOKEN",
                "\"${project.findProperty("API_READ_TOKEN")}\""
            )
            buildConfigField(
                "String",
                "IMAGES_ORIGINAL_BASE_URL",
                "\"${project.findProperty("IMAGES_ORIGINAL_BASE_URL")}\""
            )
        }
        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"${project.findProperty("BASE_URL")}\"")
            buildConfigField(
                "String",
                "API_READ_TOKEN",
                "\"${project.findProperty("API_READ_TOKEN")}\""
            )
            buildConfigField(
                "String",
                "IMAGES_ORIGINAL_BASE_URL",
                "\"${project.findProperty("IMAGES_ORIGINAL_BASE_URL")}\""
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Hilt
    implementation(libs.bundles.hilt.android)
    ksp(libs.hilt.compiler)
    ksp(libs.androidx.hilt.compiler)

    // OkHttp
    implementation(platform(libs.okhttp.bom))
    implementation(libs.logging.interceptor)
    implementation(libs.okhttp)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)

    // Gson
    implementation(libs.gson)

    // Room
    implementation(libs.androidx.room)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
    testImplementation(libs.androidx.room.testing)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Modules
    implementation(project(":domain"))
}