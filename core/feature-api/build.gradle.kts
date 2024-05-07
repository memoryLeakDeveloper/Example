plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.example.feature.api"
}

dependencies {

    navigation()
    hilt()

}