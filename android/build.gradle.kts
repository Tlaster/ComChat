plugins {
    id("org.jetbrains.compose") version Versions.compose
    id("com.android.application")
    kotlin("android")
}

group = Package.group
version = Package.versionName

repositories {
    google()
}

dependencies {
    implementation(project(":common"))
}

android {
    compileSdkVersion(AndroidSdk.compile)
    defaultConfig {
        applicationId = Package.id
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = Package.versionCode
        versionName = Package.versionName
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = Lang.java
        targetCompatibility = Lang.java
    }
    kotlinOptions {
        jvmTarget = Lang.jvmTarget
    }
}
