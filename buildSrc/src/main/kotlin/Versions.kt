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
        val appDistribution = "2.2.0"
    }

    object AndroidX {
        val material = "1.5.0"
        val constraintLayout = "2.1.3"
        val appCompatEmoji = "1.1.0"
        val appcompat = "1.4.1"
        val activity = "1.4.0"
        val fragment = "1.4.0"
        val navigation = "2.3.5"
        val annotation = "1.3.0"
        val recyclerView = "1.2.1"
        val coreKtx = "1.7.0"
        val room = "2.4.1"
        val viewPager2 = "1.0.0"

        val testsCore = "1.4.0"
        val testsRules = "1.4.0"
        val testsExt = "1.1.0"
        val collection = "1.2.0"
    }

    object ArchComponents {
        val archCore = "2.1.0"
        val lifecycle = "2.4.0"
        val paging = "3.1.0"
        val dataStore = "1.0.0"
    }

    val bom = "29.0.4"

    val gson = "2.8.6"
    val javax = "1"
    val json = "20210307"

    val kotlin = "1.6.0"
    val kotlinCoroutines = "1.6.0"

    val dagger = "2.40.5"
    val javaInject = "1"

    object Test {
        val espresso = "3.2.0"
        val mockk = "1.10.0"
        val robolectric = "4.6"
        val spek2 = "2.0.15"
    }

    object Mockito {
        val core = "3.3.3"
        val android = core
        val mockitoKotlin = "2.2.0"
    }

    object JUnit5 {
        val core = "5.7.0"
        val platformRunner = "1.7.0"
    }

    object CodeAnalyses {
        val detekt = "1.17.1"
        val ktlint = "0.41.0"
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
