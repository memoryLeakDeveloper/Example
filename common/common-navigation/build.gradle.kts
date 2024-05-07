plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.example.common.navigation"
}

dependencies {

    navigation()
    hilt()

}