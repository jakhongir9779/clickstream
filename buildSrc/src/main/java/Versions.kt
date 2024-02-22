object Versions {

    // TODO Delete after all scripts migrated to Kotlin DSL
    val android = Android

    object Plugins {
        const val cacheFix = "2.5.5"
        const val nuStuderCredentials = "2.1"
        const val benManesDependencyUpdate = "0.42.0"
        const val swiftPackage = "2.2.1"

        object StatisAnalyze {
            const val detekt = "1.22.0"
            const val sonarQube = "3.4.0.2513"
            const val jacoco = "0.8.8"
        }
    }

    const val ktor = "2.3.2"
    const val googleServices = "4.3.10"
    const val gradlePlugin = "7.2.1"
    const val kotlin = "1.6.21"
    const val coroutines = "1.6.3"
    const val kotlinCompilerExtensionVersion = "1.2.0-beta03"

    const val classIndex = "3.11"

    // core
    const val preferenceKtx = "1.2.0"
    const val browserVersion = "1.4.0"
    const val archLifecycle = "1.1.1"

    // navigation
    const val cicerone = "6.6"

    object Network {
        const val retrofitGsonConverter = "2.9.0"
        const val retrofit = "2.9.0"
        const val moshi = "1.13.0"
        const val okhttpVersion = "4.9.0"
        const val apollo = "3.7.4"
        const val jakewhartonCoroutinesAdapter = "0.9.2"
        const val moshiX = "0.18.1"
    }

    // multithreading
    const val ankoVersion = "0.10.8"
    const val rxJavaVersion = "2.2.20"

    object Trackers {
        const val appsFlyer = "6.1.4"
        const val adjust = "4.33.0"
    }

    // kotlin
    object Kotlin {
        const val core = "1.9.20"
        const val serialization = "1.5.1"
    }

    // sqlDelight
    const val sqlDelight = "2.0.1"

    // design
    const val materialDesignVersion = "1.6.1"
    const val circleimageviewVersion = "3.1.0"
    const val exoplayerVersion = "2.18.0"
    const val androidSvgVersion = "1.4"
    const val progressbuttonVersion = "2.1.0"
    const val lottieVersion = "5.2.0"
    const val cachapaExpandableLayout = "2.9.2"
    const val pageindicatorviewVersion = "v.1.0.3"
    const val photoViewVersion = "2.3.0"
    const val multiTypeAdapterVersion = "4.3.0"
    const val redMadRobotInputMask = "6.1.0"

    // others
    const val leakcanaryVersion = "2.7"
    const val facebookSdkVersion = "14.0.0"
    const val viewBindingPropertyDelegateVersion = "1.5.6"

    const val koin = "2.2.2"

    // Very-very strange point is that this lib is used in the project only for converting Object to hexString with imports like:
    // import org.bson.types.ObjectId
    // todo: find a way to replace this preferably with native tools.
    const val mongodbDriverSyncVersion = "4.6.1"

    const val circularProgressBar = "3.1.0"

    const val settings = "1.0.0"

    object AndroidX {
        const val appcompat = "1.4.2"
        const val activity = "1.5.1"
        const val recyclerview = "1.3.0"
        const val annotation = "1.4.0"
        const val coreKtx = "1.3.2"
        const val pagingRuntime = "2.1.2"
        const val work = "2.8.1"
        const val constraintLayout = "1.1.3" // todo: DON'T upgrade this one until u check that it's OK on all the screens.
        const val transition = "1.4.1"
        const val legacySupport = "1.0.0"
        const val startup = "1.1.1"

        object Lifecycle {
            const val core = "2.2.0"
            const val ktx = "2.2.0"
        }
    }

    object Google {
        const val flexbox = "3.0.0"
        const val material = "1.2.1"

        object Services {
            const val playCore = "1.9.1"
            const val installreferrer = "2.2"
            const val playServicesBase = "18.0.1"
            const val adsService = "18.0.1"
            const val playServicesAnalytics = "18.0.1"
            const val playServicesLocation = "20.0.0"
            const val playServicesMaps = "18.0.2"
        }

        object PlayMarket {
            const val tripleTPlublisher = "3.8.1"
        }
    }

    object Facebook {
        const val stetho = "1.6.0"
        const val shimmer = "0.5.0"
    }

    object YandexMetrica {
        const val core = "5.2.0"
        const val pushLib = "2.2.0"
    }

    object Android {
        const val minSdkVersion = 23
        const val targetSdkVersion = 34
        const val compileSdkVersion = 34
        const val buildToolsVersion = "33.0.0"
    }

    object Ios {
        const val swiftToolsVersion = "5.3"
        const val targetPlatformVersion = "13"
    }

    object Firebase {
        const val BOM = "31.0.2"
        const val crashlytics = "2.9.0"
        const val performancePlugin = "1.4.1"
        const val appDistribution = "3.1.0"
    }

    object Glide {
        const val transformationsVersion = "4.3.0"
        const val core = "4.13.2"
    }

    object Jetpack {

        object Compose {
            const val accompanist = "0.28.0"
            const val activityCompose = "1.5.1"
            const val materialCompose = "1.2.1"
            const val animation = "1.2.1"
            const val tooling = "1.2.1"
            const val viewModel = "2.5.1"
            const val constraint = "1.0.1"
            const val coil = "2.2.1"
            const val liveData = "1.2.1"
        }
    }

    object Tests {
        const val junit = "4.13"
        const val junit5 = "5.7.1"
        const val junit5Android = "1.2.1"
        const val mockito = "4.6.1"
        const val mockitoKotlin = "4.0.0"
        const val hamcrest = "1.3"
        const val expekt = "0.5.0"
        const val mockK = "1.12.4"
        const val fragment = "1.4.1"
        const val kaspresso = "1.4.1"
        const val androidX = "1.4.0"
        const val androidXCore = "2.1.0"
        const val perfeccionista = "0.2.0-Beta"
        const val allureKotlinVersion = "2.2.7"
        const val allureGradlePluginVersion = "2.9.6"
        const val keTestsCommonsVersion = "1.3.38-SNAPSHOT"
    }

    object Logging {
        const val kermit = "2.0.2"
        const val anrWatchDog = "1.4.0"
    }

    object Crypto {
        const val tink = "1.7.0"
        const val joseJwt = "9.30.2"
        const val lazySodium = "5.1.0"
        const val jna = "5.8.0"
    }

    object Analytics {
        const val analyticsType = "1.0"
        const val common = "1.0"
        const val event = "1.0"
        const val eventSender = "1.0"
        const val clickstream = "1.0"
        const val database = "1.0"
        const val settings = "1.1"
        const val platform = "1.0"
        const val properties = "1.0"

        const val composite = "1.0"

        const val clickstreamTest = "1.0"
        const val clickstreamEventsenderTest = "1.0"
    }
}
