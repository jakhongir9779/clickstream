import Libraries.Tests.Junit5.junit5
import Libraries.Tests.Mockito.mockito
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Libraries {

    const val settings = "com.russhwolf:multiplatform-settings:${Versions.settings}"


    object Ktor {
        const val core = "io.ktor:ktor-client-core:${Versions.ktor}"
        const val logging = "io.ktor:ktor-client-logging:${Versions.ktor}"
        const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
        const val json = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"

        object Engine {
            const val okHttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
            const val darwin = "io.ktor:ktor-client-darwin:${Versions.ktor}"
        }
    }

    object Google {
        private const val prefix = "com.google.android"

        object Services {
            const val gmsBase =
                "$prefix.gms:play-services-base:${Versions.Google.Services.playServicesBase}"
            const val gmsAds =
                "$prefix.gms:play-services-ads-identifier:${Versions.Google.Services.adsService}"

        }
    }

        object SqlDelight {

        object Driver {
            const val android = "app.cash.sqldelight:android-driver:${Versions.sqlDelight}"
            const val native = "app.cash.sqldelight:native-driver:${Versions.sqlDelight}"
        }
    }
    object Kotlin {

        private const val version = Versions.kotlin

        private const val std = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"

        const val serialization =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.Kotlin.serialization}"

        fun DependencyHandler.kotlin() {
            implementation(std)
        }

        object Coroutines {

            private const val version = Versions.coroutines

            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val jdk = "org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$version"

            fun DependencyHandler.coroutines() {
                implementation(core)
                implementation(android)
                implementation(jdk)
            }
        }

    }

    object Koin {

        fun DependencyHandler.koin() {
            implementation(core)
            implementation(android)
            testImplementation(test)
        }

        const val core = "io.insert-koin:koin-core:${Versions.koin}"
        const val test = "io.insert-koin:koin-test:${Versions.koin}"
        const val android = "io.insert-koin:koin-android:${Versions.koin}"

    }

    object AndroidX {

        const val annotation = "androidx.annotation:annotation:${Versions.AndroidX.annotation}"
        const val activity = "androidx.activity:activity:${Versions.AndroidX.activity}"
        const val work = "androidx.work:work-runtime-ktx:${Versions.AndroidX.work}"
        const val startup = "androidx.startup:startup-runtime:${Versions.AndroidX.startup}"

    }

    object Logging {
        const val kermit = "co.touchlab:kermit:${Versions.Logging.kermit}"

        fun DependencyHandler.kermit() {
            implementation(kermit)
        }
    }

    object Tests {

        fun DependencyHandler.testLibs() {
            mockito()
            junit5()

            testImplementation(junit)
            testImplementation(expekt)
            testImplementation(coroutines)
            testImplementation(mockK)
            testImplementation(robolectric)
            testImplementation(robolectricAll)
            testImplementation(androidJunit)

            androidTestImplementation(junit)
            androidTestImplementation(expekt)
            androidTestImplementation(coroutines)
            androidTestImplementation(core)
            androidTestImplementation(coreKtx)
        }

        const val core = "androidx.test:core:${Versions.Tests.androidX}"
        const val coreKtx = "androidx.test:core-ktx:${Versions.Tests.androidX}"
        const val junit = "junit:junit:${Versions.Tests.junit}"
        const val androidJunit = "androidx.test.ext:junit-ktx:1.1.3"
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
        const val expekt = "com.winterbe:expekt:${Versions.Tests.expekt}"
        const val mockK = "io.mockk:mockk:${Versions.Tests.mockK}"
        const val robolectric = "org.robolectric:robolectric:4.4"
        const val robolectricAll = "org.robolectric:android-all:13-robolectric-9030017"

        object Junit5 {
            const val core = "org.junit.jupiter:junit-jupiter-api:${Versions.Tests.junit5}"
            const val engine = "org.junit.jupiter:junit-jupiter-engine:${Versions.Tests.junit5}"
            const val vintage = "org.junit.vintage:junit-vintage-engine:${Versions.Tests.junit5}"
            const val android =
                "de.mannodermaus.junit5:android-test-core:${Versions.Tests.junit5Android}"
            const val runner =
                "de.mannodermaus.junit5:android-test-runner:${Versions.Tests.junit5Android}"

            fun DependencyHandler.junit5() {
                testImplementation(core)
                testRuntimeOnly(engine)
                testRuntimeOnly(vintage)

                androidTestImplementation(core)
                androidTestImplementation(android)
                androidTestRuntimeOnly(runner)
            }
        }

        object Mockito {

            const val kotlin = "org.mockito.kotlin:mockito-kotlin:${Versions.Tests.mockitoKotlin}"

            fun DependencyHandler.mockito() {
                testImplementation(kotlin)
            }
        }
    }

    object Analytics {
        const val group = "analytics.sdk"

        const val clickstream = "$group:${Artifacts.Analytics.clickstream}:${Versions.Analytics.clickstream}"
        const val clickstreamTest = "$group:clickstream-test:${Versions.Analytics.clickstreamTest}"
        const val clickstreamEventSenderTest = "$group:clickstream-eventsender-test:${Versions.Analytics.clickstreamEventsenderTest}"
        const val composite = "$group:composite:${Versions.Analytics.composite}"
        const val analyticsType = "$group:${Artifacts.Analytics.analyticsType}:${Versions.Analytics.analyticsType}"
        const val common = "$group:${Artifacts.Analytics.common}:${Versions.Analytics.common}"
        const val event = "$group:${Artifacts.Analytics.event}:${Versions.Analytics.event}"
        const val eventSender = "$group:${Artifacts.Analytics.eventSender}:${Versions.Analytics.eventSender}"
        const val database = "$group:${Artifacts.Analytics.database}:${Versions.Analytics.database}"
        const val settings = "$group:${Artifacts.Analytics.settings}:${Versions.Analytics.settings}"
        const val platform = "$group:${Artifacts.Analytics.platform}:${Versions.Analytics.platform}"
        const val platformAndroid = "$group:${Artifacts.Analytics.platform}-android:${Versions.Analytics.platform}"
        const val properties = "$group:${Artifacts.Analytics.properties}:${Versions.Analytics.properties}"
    }
}
