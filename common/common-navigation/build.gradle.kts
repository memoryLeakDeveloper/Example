plugins {
    `android-library`
    `kotlin-android`
    id("org.jetbrains.kotlin.plugin.serialization")
}

apply<MainGradlePlugin>()

android {
    namespace = "com.example.common.navigation"
}

dependencies {

    navigation()
    hilt()
    implementation(Dependencies.kotlinxSerialiation)

}