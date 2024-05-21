buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Dependencies.hiltAgp)
        classpath(Dependencies.ktorSerialization)
    }
}

plugins {
    id("com.google.dagger.hilt.android") version (Versions.hilt) apply false
}