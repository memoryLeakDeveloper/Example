plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.foe.common.api"
}

dependencies {

    ktor()
    hilt()
}