plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.example.feature.main"

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