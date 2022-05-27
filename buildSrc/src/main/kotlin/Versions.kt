@file:Suppress("MayBeConstant")

import org.gradle.api.JavaVersion

object Versions {

    val Android = AndroidVersions
    val CodeAnalyse = CodeAnalyses

    object GradlePlugins {
        val crashlytics = "2.3.0"
        val buildTools = "7.0.4"
        val googleServices = "4.3.10"

        val androidJunit5 = "1.8.2.0"
        val appDistribution = "3.0.2"
    }

    object AndroidX {
        val activity = "1.6.0-alpha04"
        val annotation = "1.4.0-beta01"
        val appcompat = "1.6.0-alpha04"
        val appCompatEmoji = "1.2.0-alpha03"
        val collection = "1.2.0"
        val constraintLayout = "2.2.0-alpha01"
        val fragment = "1.5.0-rc01"
        val material = "1.6.0"
        val navigation = "2.5.0-rc01"
        val recyclerView = "1.3.0-alpha02"
        val coreKtx = "1.9.0-alpha04"
        val room = "2.5.0-alpha01"
        val viewPager2 = "1.1.0-beta01"

        val testsCore = "1.4.0"
        val testsRules = "1.4.0"
        val testsExt = "1.1.0"
    }

    object ArchComponents {
        val archCore = "2.1.0"
        val lifecycle = "2.4.1"
        val paging = "3.1.1"
        val dataStore = "1.0.0"
    }

    val bom = "30.1.0"

    val gson = "2.9.0"
    val javax = "1"
    val json = "20220320"

    val kotlin = "1.6.21"
    val kotlinCoroutines = "1.6.1"

    val dagger = "2.42"
    val javaInject = "1"

    object Test {
        val espresso = "3.4.0"
        val mockk = "1.12.4"
        val robolectric = "4.8.1"
        val spek2 = "2.0.18"
    }

    object Mockito {
        val core = "4.5.1"
        val android = core
        val mockitoKotlin = "2.2.0"
    }

    object JUnit5 {
        val core = "5.7.0"
        val platformRunner = "1.7.0"
    }

    object CodeAnalyses {
        val detekt = "1.20.0"
        val ktlint = "0.45.2"
    }
}

object AndroidVersions {
    val buildToolsVersion = "30.0.3"

    val compileSdkVersion = 31
    val minSdkVersion = 23
    val targetSdkVersion = 31

    // compiler versions
    @Suppress("unused")
    val javaVersion = JavaVersion.VERSION_1_8
}
