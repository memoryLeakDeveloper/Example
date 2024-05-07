buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Dependencies.hiltAgp)
    }
}

plugins {
    id("com.google.dagger.hilt.android") version ("2.44") apply false
//    id("com.android.library") version "8.1.1" apply false
//    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}

