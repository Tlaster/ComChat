import org.gradle.api.JavaVersion

object Package {
    const val group = "moe.tlaster"
    const val name = "ComChat"
    const val id = "$group.comchat"
    const val versionName = "1.0.0"
    const val versionCode = 1
}

object Lang {
    const val jvmTarget = "11"
    val java = JavaVersion.VERSION_11
}

object Versions {
    const val kotlin = "1.5.10"
    const val compose = "0.4.0"
    const val agp = "4.1.1"
    const val kotlinxSerialization = "1.2.0"
    const val sqlDelight = "1.5.0"
    const val ktor = "1.5.3"
    const val preCompose = "0.2.2"
    const val spotless = "5.12.5"
    const val ktlint = "0.41.0"

    const val junit = "4.13.2"
}

object Repositories {
    val all = listOf(
        "https://jitpack.io",
        "https://maven.pkg.jetbrains.space/public/p/compose/dev",
        "https://www.jetbrains.com/intellij-repository/releases",
        "https://jetbrains.bintray.com/intellij-third-party-dependencies",
    )
}

object AndroidSdk {
    const val min = 21
    const val compile = 30
    const val target = compile
}

object Deps {
    const val PreCompose = "moe.tlaster:precompose:${Versions.preCompose}"
}

object Test {
    const val junit = "junit:junit:${Versions.junit}"
}

object Ktor {
    val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    val clientWebSocket = "io.ktor:ktor-client-websockets:${Versions.ktor}"
    val clientJson = "io.ktor:ktor-client-json:${Versions.ktor}"
    val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
    val clientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
    val clientCIO = "io.ktor:ktor-client-cio:${Versions.ktor}"
    val clientIos = "io.ktor:ktor-client-ios:${Versions.ktor}"
}

object Serialization {
    val core = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinxSerialization}"
}

object SqlDelight {
    val runtime = "com.squareup.sqldelight:runtime:${Versions.sqlDelight}"
    val coroutineExtensions = "com.squareup.sqldelight:coroutines-extensions:${Versions.sqlDelight}"
    val androidDriver = "com.squareup.sqldelight:android-driver:${Versions.sqlDelight}"
    val sqlliteDriver = "com.squareup.sqldelight:sqlite-driver:${Versions.sqlDelight}"
}