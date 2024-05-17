plugins {
    `android-library`
    `kotlin-android`
    id("org.jetbrains.kotlin.plugin.serialization")
}

apply<MainGradlePlugin>()

android {
    namespace = "com.example.feature.matches"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
}


dependencies {

    hilt()
    compose()
    navigation()

    commonNavigation()
    ktor()
    commonApi()
    commonUi()
}