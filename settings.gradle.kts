pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "My App"
include(":core")
include(":common")
include(":common:common-ui")
include(":common:common-navigation")
include(":common:common-db")
include(":common:common-preferences")
include(":core:feature-api")
include(":core:utils")
include(":feature-search")
include(":feature-main")
include(":app")
include(":common:common-api")
