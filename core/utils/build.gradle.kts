plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.core.utils"
}

apply<MainGradlePlugin>()

dependencies {

    compose()
    hilt()
}