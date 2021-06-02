buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", version = Versions.kotlin))
        classpath(kotlin("serialization", version = Versions.kotlin))
        classpath("com.android.tools.build:gradle:${Versions.agp}")
        classpath("com.squareup.sqldelight:gradle-plugin:${Versions.sqlDelight}")
    }
}

group = Package.group
version = Package.versionName

plugins {
    id("com.diffplug.spotless").version(Versions.spotless)
}

allprojects {
    repositories {
        google()
        mavenCentral()
        Repositories.all.forEach {
            maven(it)
        }
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = Lang.jvmTarget
            allWarningsAsErrors = true
        }
    }
    apply(plugin = "com.diffplug.spotless")
    spotless {
        kotlin {
            target("**/*.kt")
            targetExclude("$buildDir/**/*.kt")
            targetExclude("bin/**/*.kt")
            ktlint(Versions.ktlint)
        }
        kotlinGradle {
            target("*.gradle.kts")
            ktlint(Versions.ktlint)
        }
    }
}
