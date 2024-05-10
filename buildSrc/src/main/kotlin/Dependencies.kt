import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Dependencies {
    const val composeMaterial = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.composePreview}"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val composeAnimation = "androidx.compose.animation:animation:${Versions.composeAnimation}"
    const val composeBom = "androidx.compose:compose-bom:2024.05.00"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    const val ktorClient = "io.ktor:ktor-client-android:${Versions.ktor}"
    const val ktorClientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
    const val kotlinxSerialiation = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.ktorSerialization}"
    const val ktorClientLogging = "io.ktor:ktor-client-logging-jvm:${Versions.ktor}"
    const val ktorSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.navigationCompose}"
    const val hiltComposeNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.hiltComposeNavigation}"

    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
}

fun DependencyHandler.room() {
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)
}

fun DependencyHandler.ktor() {
    implementation(Dependencies.ktorClient)
    implementation(Dependencies.ktorClientSerialization)
    implementation(Dependencies.kotlinxSerialiation)
    implementation(Dependencies.ktorClientLogging)
}

fun DependencyHandler.compose() {
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeRuntime)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.coil)
    implementation(Dependencies.composeAnimation)
    implementation(platform(Dependencies.composeBom))

    debugImplementation(Dependencies.composeUiToolingPreview)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
}

fun DependencyHandler.navigation() {
    implementation(Dependencies.navigationCompose)
    implementation(Dependencies.hiltComposeNavigation)
}


fun DependencyHandler.commonUi() {
    implementation(project(":common:common-ui"))
}

fun DependencyHandler.commonApi() {
    implementation(project(":common:common-api"))
}

fun DependencyHandler.featureApi() {
    implementation(project(":core:feature-api"))
}

fun DependencyHandler.commonNavigation() {
    implementation(project(":common:common-navigation"))
}

fun DependencyHandler.featureSearch() {
    implementation(project(":feature-search"))
}

fun DependencyHandler.featureMain() {
    implementation(project(":feature-main"))
}

fun DependencyHandler.featureMatches() {
    implementation(project(":feature-matches"))
}

fun DependencyHandler.featurePlayers() {
    implementation(project(":feature-players"))
}

fun DependencyHandler.featurePlayerProfile() {
    implementation(project(":feature-player-profile"))
}
