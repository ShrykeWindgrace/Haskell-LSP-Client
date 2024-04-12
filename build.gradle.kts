fun properties(key: String) = providers.gradleProperty(key)
fun environment(key: String) = providers.environmentVariable(key)

plugins {
    id("java") // Java support
    alias(libs.plugins.gradleIntelliJPlatformPlugin) // Gradle IntelliJ Platform Plugin
}

group = properties("pluginGroup").get()
version = properties("pluginVersion").get()

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

// Dependencies are managed with Gradle version catalog
// read more: https://docs.gradle.org/current/userguide/platforms.html#sub:version-catalog
dependencies {
    intellijPlatform {
        intellijIdeaUltimate("2024.1")
        instrumentationTools()
    }
}

// Configure Gradle IntelliJ Plugin
// read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellijPlatform {
    pluginConfiguration {
        name = properties("pluginName")
        version = properties("platformVersion")
        id = properties("pluginId")
        description = "Experimental support of Haskell via an LSP plugin"

        vendor {
            name = "ShrykeWindgrace"
            email = "shryke.windgrace@gmail.com"
            url = "https://github.com/ShrykeWindgrace"
        }
        ideaVersion {
            sinceBuild = properties("pluginSinceBuild")
            untilBuild = properties("pluginUntilBuild")
        }

        // Plugin Dependencies. Uses `platformPlugins` property from the gradle.properties file.
//        plugins = properties("platformPlugins").map { it.split(',').map(String::trim).filter(String::isNotEmpty) }
    }
    buildSearchableOptions = false
    instrumentCode = true
}

tasks {
    wrapper {
        gradleVersion = properties("gradleVersion").get()
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}