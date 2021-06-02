import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("kotlinx-serialization")
    id("org.jetbrains.compose") version Versions.compose
    id("com.android.library")
    id("com.squareup.sqldelight")
}

group = Package.group
version = Package.versionName

repositories {
    google()
}

kotlin {
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = Lang.jvmTarget
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                api(Deps.PreCompose)

                implementation(Ktor.clientCore)
                implementation(Ktor.clientWebSocket)
                implementation(Ktor.clientJson)
                implementation(Ktor.clientLogging)
                implementation(Ktor.clientSerialization)

                implementation(Serialization.core)

                implementation(SqlDelight.runtime)
                implementation(SqlDelight.coroutineExtensions)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Ktor.clientAndroid)
                implementation(SqlDelight.androidDriver)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(Test.junit)
            }
        }
        val desktopMain by getting {
            dependencies {
                implementation(Ktor.clientCIO)
                implementation(SqlDelight.sqlliteDriver)
            }
        }
        val desktopTest by getting
    }
}

android {
    compileSdkVersion(AndroidSdk.compile)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
    }
    compileOptions {
        sourceCompatibility = Lang.java
        targetCompatibility = Lang.java
    }
}

sqldelight {
    database("${Package.name}Database") {
        packageName = "moe.tlaster.comchat.common.db"
        sourceFolders = listOf("sqldelight")
    }
}