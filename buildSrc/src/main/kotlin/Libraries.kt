object Libraries {
    val AndroidX = AndroidXLibraries
    val ArchComponents = ArchitectureComponentsLibraries
    val Dagger = DaggerLibraries
    val JUnit5 = JUnit5Libraries
    val Kotlin = KotlinLibraries
    val Firebase = FirebaseLibraries
    val GradlePlugins = GradlePluginsLibraries
    val Mockito = MockitoLibraries
    val Spek2 = Spek2Libraries

    val json = "org.json:json:${Versions.json}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val mockk = "io.mockk:mockk:${Versions.Test.mockk}"
    val androidMockk = "io.mockk:mockk-android:${Versions.Test.mockk}"
    val espresso = "com.android.support.test.espresso:espresso-core:${Versions.Test.espresso}"
    val robolectric = "org.robolectric:robolectric:${Versions.Test.robolectric}"
    val javaxInject = "javax.inject:javax.inject:${Versions.javaInject}"
}

object AndroidXLibraries {
    val appCompatEmoji = "androidx.emoji:emoji-appcompat:${Versions.AndroidX.appCompatEmoji}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appcompat}"
    val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraintLayout}"
    val espressoIdlingResoources =
        "androidx.test.espresso:espresso-idling-resource:${Versions.Test.espresso}"
    val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.AndroidX.fragment}"
    val activityKtx = "androidx.activity:activity-ktx:${Versions.AndroidX.activity}"
    val annotation = "androidx.annotation:annotation:${Versions.AndroidX.annotation}"
    val coreKtx = "androidx.core:core-ktx:${Versions.AndroidX.coreKtx}"
    val testCore = "androidx.test:core:${Versions.AndroidX.testsCore}"
    val testRules = "androidx.test:rules:${Versions.AndroidX.testsRules}"
    val testExt = "androidx.test.ext:junit:${Versions.AndroidX.testsExt}"
    val collectionKtx = "androidx.collection:collection-ktx:${Versions.AndroidX.collection}"
    val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.AndroidX.navigation}"
    val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.AndroidX.navigation}"
    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.AndroidX.recyclerView}"
    val material = "com.google.android.material:material:${Versions.AndroidX.material}"
}

object ArchitectureComponentsLibraries {
    val coreTesting = "androidx.arch.core:core-testing:${Versions.ArchComponents.archCore}"
    val pagingRuntime = "androidx.paging:paging-runtime:${Versions.ArchComponents.paging}"
    val dataStoreProto = "androidx.datastore:datastore:${Versions.ArchComponents.dataStore}"
    val dataStorePreferences = "androidx.datastore:datastore-preferences:${Versions.ArchComponents.dataStore}"
    val lifecycleLivedataCore = "androidx.lifecycle:lifecycle-livedata-core:${Versions.ArchComponents.lifecycle}"
    val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata:${Versions.ArchComponents.lifecycle}"
    val lifecycleLivedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.ArchComponents.lifecycle}"
    val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ArchComponents.lifecycle}"
    val lifecycleViewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ArchComponents.lifecycle}"
    val lifecycleCompiler = "androidx.lifecycle:lifecycle-common-java8:${Versions.ArchComponents.lifecycle}"
    val lifecycleProcess = "androidx.lifecycle:lifecycle-process:${Versions.ArchComponents.lifecycle}"
    val lifecycleService = "androidx.lifecycle:lifecycle-service:${Versions.ArchComponents.lifecycle}"
}

object Javax {
    val inject = "javax.inject:javax.inject:${Versions.javax}"
}

object DaggerLibraries {
    val core = "com.google.dagger:dagger:${Versions.dagger}"
    val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
}

object JUnit5Libraries {
    val platformRunner =
        "org.junit.platform:junit-platform-runner:${Versions.JUnit5.platformRunner}"
    val jupiterApi = "org.junit.jupiter:junit-jupiter-api:${Versions.JUnit5.core}"
    val vintageEngine = "org.junit.vintage:junit-vintage-engine:${Versions.JUnit5.core}"
    val params = "org.junit.jupiter:junit-jupiter-params:${Versions.JUnit5.core}"
}

object KotlinLibraries {
    val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    val test = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
    val testJUnit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    val Coroutines = CoroutinesLibraries

    object CoroutinesLibraries {
        val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
        val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
        val debug = "org.jetbrains.kotlinx:kotlinx-coroutines-debug:${Versions.kotlinCoroutines}"
    }
}

object FirebaseLibraries {
    val bom = "implementation platform('com.google.firebase:firebase-bom:${Versions.bom}')"
    val messaging = "com.google.firebase:firebase-messaging-ktx"
    val analytics = "com.google.firebase:firebase-analytics-ktx"
    val crashlytics = "com.google.firebase:firebase-crashlytics-ktx"
    val crashlyticsNdk = "com.google.firebase:firebase-crashlytics-ndk"
}

object GradlePluginsLibraries {

    val crashlytics = "com.google.firebase:firebase-crashlytics-gradle:${Versions.GradlePlugins.crashlytics}"
    val appDistribution =
        "com.google.firebase:firebase-appdistribution-gradle:${Versions.GradlePlugins.appDistribution}"

    val buildTools = "com.android.tools.build:gradle:${Versions.GradlePlugins.buildTools}"
    val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val googleServices = "com.google.gms:google-services:${Versions.GradlePlugins.googleServices}"

    val androidJUnit5 =
        "de.mannodermaus.gradle.plugins:android-junit5:${Versions.GradlePlugins.androidJunit5}"
}

object MockitoLibraries {
    val core = "org.mockito:mockito-core:${Versions.Mockito.core}"
    val kotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.Mockito.mockitoKotlin}"
    val android = "org.mockito:mockito-android:${Versions.Mockito.android}"
}

object Spek2Libraries {
    val dslJsm = "org.spekframework.spek2:spek-dsl-jvm:${Versions.Test.spek2}"
    val runnerJUnit5 = "org.spekframework.spek2:spek-runner-junit5:${Versions.Test.spek2}"
}
