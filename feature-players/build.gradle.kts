plugins {
    `android-library`
    `kotlin-android`
    id("org.jetbrains.kotlin.plugin.serialization")
}

apply<MainGradlePlugin>()


android {
    namespace = "com.example.feature.players"

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
    featureApi()
    commonNavigation()
    ktor()
    commonApi()
    commonUi()
}