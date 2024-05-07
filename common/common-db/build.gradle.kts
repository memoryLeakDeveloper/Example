plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()


android {
    namespace = "com.example.common.db"
}

dependencies {
    hilt()

}