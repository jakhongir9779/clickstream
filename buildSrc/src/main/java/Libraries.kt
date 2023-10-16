import Libraries.Tests.Junit5.junit5
import Libraries.Tests.Mockito.mockito
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Libraries {

    const val cicerone = "com.github.terrakok:cicerone:${Versions.cicerone}"

    const val viewbindingPropertyDelegate =
        "com.github.kirich1409:viewbindingpropertydelegate:${Versions.viewBindingPropertyDelegateVersion}"

    const val redMadRobotInputMask =
        "com.github.RedMadRobot:input-mask-android:${Versions.redMadRobotInputMask}"
    const val lottie = "com.airbnb.android:lottie:${Versions.lottieVersion}"

    const val settings = "com.russhwolf:multiplatform-settings:${Versions.settings}"


    object Ktor {
        const val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
        const val clientCio = "io.ktor:ktor-client-cio:${Versions.ktor}"
        const val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
        const val clientContentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
        const val clientJson = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
    }

    object Google {
        private const val prefix = "com.google.android"

        const val flexBox = "$prefix.flexbox:flexbox:${Versions.Google.flexbox}"
        const val material = "$prefix.material:material:${Versions.Google.material}"

        object Services {
            private const val core = "$prefix.play:core:${Versions.Google.Services.playCore}"
            const val installreferrer =
                "com.android.installreferrer:installreferrer:${Versions.Google.Services.installreferrer}"
            const val gmsBase =
                "$prefix.gms:play-services-base:${Versions.Google.Services.playServicesBase}"
            const val gmsAds =
                "$prefix.gms:play-services-ads-identifier:${Versions.Google.Services.adsService}"
            private const val gmsMaps =
                "$prefix.gms:play-services-maps:${Versions.Google.Services.playServicesMaps}"
            private const val location =
                "$prefix.gms:play-services-location:${Versions.Google.Services.playServicesLocation}"
            private const val gmsAnalytics =
                "$prefix.gms:play-services-analytics:${Versions.Google.Services.playServicesAnalytics}"

            fun DependencyHandler.googleServices() {
                implementation(core)
                implementation(installreferrer)
                implementation(gmsBase)
                implementation(gmsAds)
                implementation(gmsAnalytics)
            }

            fun DependencyHandler.googleMaps() {
                implementation(gmsBase)
                implementation(gmsMaps)
                implementation(location)
            }
        }
    }

    object Glide {
        const val core = "com.github.bumptech.glide:glide:${Versions.Glide.core}"
        const val transformations =
            "jp.wasabeef:glide-transformations:${Versions.Glide.transformationsVersion}"
        const val complier = "com.github.bumptech.glide:compiler:${Versions.Glide.core}"

        fun DependencyHandler.glide() {
            implementation(core)
            implementation(transformations)
            kapt(complier)
        }
    }

    object Facebook {
        const val stetho = "com.facebook.stetho:stetho-okhttp3:${Versions.Facebook.stetho}"
        const val shimmer = "com.facebook.shimmer:shimmer:${Versions.Facebook.shimmer}"
        const val androidSdk =
            "com.facebook.android:facebook-android-sdk:${Versions.facebookSdkVersion}"
    }

    object SqlDelight {

        object Driver {
            const val android = "app.cash.sqldelight:android-driver:${Versions.sqlDelight}"
            const val native = "app.cash.sqldelight:native-driver:${Versions.sqlDelight}"
        }
    }

    object YandexMetrica {
        private const val core = "com.yandex.android:mobmetricalib:${Versions.YandexMetrica.core}"
        private const val pushLib =
            "com.yandex.android:mobmetricapushlib:${Versions.YandexMetrica.pushLib}"

        fun DependencyHandler.yandexMetrica() {
            implementation(core)
            implementation(pushLib)
        }
    }

    object Yandex {
        private const val mapKit = "com.yandex.android:maps.mobile:4.2.2-full"

        fun DependencyHandler.yandexMapKit() {
            implementation(mapKit)
        }
    }

    object Kotlin {

        private const val version = Versions.kotlin

        private const val std = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        private const val reflection = "org.jetbrains.kotlin:kotlin-reflect:$version"

        const val androidExtensionsRuntime =
            "org.jetbrains.kotlin:kotlin-android-extensions-runtime:${Versions.kotlin}"

        const val serialization =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.Kotlin.serialization}"

        fun DependencyHandler.kotlin() {
            implementation(std)
        }

        fun DependencyHandler.kotlinReflection() {
            implementation(reflection)
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
            implementation(AndroidX.scope)
            implementation(AndroidX.ext)
            implementation(AndroidX.viewModel)

            testImplementation(Test.koinTest)
            androidTestImplementation(Test.koinTest)
        }

        const val core = "io.insert-koin:koin-core:${Versions.koin}"
        const val java = "io.insert-koin:koin-java:${Versions.koin}"

        object AndroidX {
            const val scope = "io.insert-koin:koin-androidx-scope:${Versions.koin}"
            const val ext = "io.insert-koin:koin-androidx-ext:${Versions.koin}"
            const val viewModel = "io.insert-koin:koin-androidx-viewmodel:${Versions.koin}"
        }

        object Test {
            const val koinTest = "io.insert-koin:koin-test:${Versions.koin}"
        }

    }

    object AndroidX {

        const val appCompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appcompat}"
        const val annotation = "androidx.annotation:annotation:${Versions.AndroidX.annotation}"
        const val activity = "androidx.activity:activity:${Versions.AndroidX.activity}"
        const val recyclerView =
            "androidx.recyclerview:recyclerview:${Versions.AndroidX.recyclerview}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraintLayout}"
        const val coreCtx = "androidx.core:core-ktx:${Versions.AndroidX.coreKtx}"
        const val pagingRuntime =
            "androidx.paging:paging-runtime-ktx:${Versions.AndroidX.pagingRuntime}"

        const val preferenceKtx = "androidx.preference:preference-ktx:${Versions.preferenceKtx}"
        const val transition = "androidx.transition:transition:${Versions.AndroidX.transition}"
        const val browser = "androidx.browser:browser:${Versions.browserVersion}"
        const val legacySupport =
            "androidx.legacy:legacy-support-v4:${Versions.AndroidX.legacySupport}"
        const val archLifecycle = "android.arch.lifecycle:common-java8:${Versions.archLifecycle}"

        const val coordinator = "androidx.coordinatorlayout:coordinatorlayout:1.1.0"
        const val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.4.0"

        const val work = "androidx.work:work-runtime-ktx:${Versions.AndroidX.work}"
        const val workTesting = "androidx.work:work-testing:${Versions.AndroidX.work}"
        const val startup = "androidx.startup:startup-runtime:${Versions.AndroidX.startup}"

        fun DependencyHandler.androidX() {
            implementation(coreCtx)
            implementation(annotation)
            implementation(appCompat)
            implementation(constraintLayout)
            implementation(recyclerView)

            implementation(pagingRuntime)
            implementation(preferenceKtx)
            implementation(transition)
            implementation(browser)
            implementation(legacySupport)
            implementation(archLifecycle)

        }

        object Lifecycle {


            const val service =
                "androidx.lifecycle:lifecycle-service:${Versions.AndroidX.Lifecycle.core}"
            const val viewModelKtx =
                "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.Lifecycle.ktx}"
            const val runtimeKtx =
                "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.AndroidX.Lifecycle.ktx}"
            const val reactiveStreams =
                "androidx.lifecycle:lifecycle-reactivestreams:${Versions.AndroidX.Lifecycle.ktx}"
            const val commonJava8 =
                "androidx.lifecycle:lifecycle-common-java8:${Versions.AndroidX.Lifecycle.core}"

            fun DependencyHandler.lifecycle() {
                implementation(service)
                implementation(viewModelKtx)
                implementation(runtimeKtx)
                implementation(reactiveStreams)
                implementation(commonJava8)
            }

        }

        object Paging {
            private const val version = "3.1.1"
            private const val groupId = "androidx.paging"
            private const val runtime = "$groupId:paging-runtime-ktx:$version"

            fun DependencyHandler.paging() {
                implementation(runtime)
            }
        }

    }

    object Jetpack {

        object Compose {
            const val activityCompose =
                "androidx.activity:activity-compose:${Versions.Jetpack.Compose.activityCompose}"
            const val materialCompose =
                "androidx.compose.material:material:${Versions.Jetpack.Compose.materialCompose}"
            const val animation =
                "androidx.compose.animation:animation:${Versions.Jetpack.Compose.animation}"
            const val tooling = "androidx.compose.ui:ui-tooling:${Versions.Jetpack.Compose.tooling}"
            const val viewModel =
                "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Jetpack.Compose.viewModel}"
            const val accompanistTheme =
                "com.google.accompanist:accompanist-appcompat-theme:${Versions.Jetpack.Compose.accompanist}"
            const val placeholder =
                "com.google.accompanist:accompanist-placeholder:${Versions.Jetpack.Compose.accompanist}"
            const val flowLayout =
                "com.google.accompanist:accompanist-flowlayout:${Versions.Jetpack.Compose.accompanist}"
            const val constraint =
                "androidx.constraintlayout:constraintlayout-compose:${Versions.Jetpack.Compose.constraint}"
            const val coil = "io.coil-kt:coil-compose:${Versions.Jetpack.Compose.coil}"
            const val liveData =
                "androidx.compose.runtime:runtime-livedata:${Versions.Jetpack.Compose.liveData}"
            const val lifecycleRuntime =
                "androidx.lifecycle:lifecycle-runtime-compose:2.6.0-alpha03"

            fun DependencyHandler.compose() {
                implementation(activityCompose)
                implementation(materialCompose)
                implementation(animation)
                implementation(liveData)
                implementation(tooling)
                implementation(viewModel)
                implementation(accompanistTheme)
                implementation(flowLayout)
                implementation(constraint)
                implementation(coil)
                implementation(lifecycleRuntime)
            }

            fun DependencyHandler.coil() {
                implementation(coil)
            }
        }

    }

    object Network {
        const val gson =
            "com.squareup.retrofit2:converter-gson:${Versions.Network.retrofitGsonConverter}"

        object OkHttp {
            const val okHttpVersion = Versions.Network.okhttpVersion
            const val core = "com.squareup.okhttp3:okhttp:$okHttpVersion"
            const val logging = "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"

            fun DependencyHandler.okHttp() {
                implementation(core)
                implementation(logging)
            }
        }

        object Retrofit {
            private const val retrofitVersion = Versions.Network.retrofit
            private const val moshiVersion = Versions.Network.moshi

            const val core = "com.squareup.retrofit2:retrofit:$retrofitVersion"

            const val converterMoshi = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
            const val converterGson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"

            const val moshi = "com.squareup.moshi:moshi:$moshiVersion"
            const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion"
            const val moshiAdapters = "com.squareup.moshi:moshi-adapters:$moshiVersion"
            const val moshiReflect = "com.squareup.moshi:moshi-kotlin:$moshiVersion"

            const val moshixRuntime =
                "dev.zacsweers.moshix:moshi-sealed-runtime:${Versions.Network.moshiX}"
            const val moshixCodegen =
                "dev.zacsweers.moshix:moshi-sealed-codegen:${Versions.Network.moshiX}"

            const val adapterCoroutines =
                "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.Network.jakewhartonCoroutinesAdapter}"

            fun DependencyHandler.retrofit() {
                implementation(core)
                implementation(adapterCoroutines)
                implementation(converterMoshi)
                moshi()
            }

            fun DependencyHandler.moshi() {
                implementation(moshi)
                implementation(moshiAdapters)
                implementation(moshiReflect)
                kapt(moshiCodegen)
            }

            fun DependencyHandler.moshiX() {
                implementation(moshixRuntime)
                kapt(moshixCodegen)
            }
        }

        object Apollo {
            const val runtime =
                "com.apollographql.apollo3:apollo-runtime:${Versions.Network.apollo}"
            const val api = "com.apollographql.apollo3:apollo-api:${Versions.Network.apollo}"
            const val adapters =
                "com.apollographql.apollo3:apollo-adapters:${Versions.Network.apollo}"

            // The ApolloIdlingResource makes sure that your tests wait for your GraphQL queries to terminate before proceeding.
            const val idlingResource =
                "com.apollographql.apollo3:apollo-idling-resource:${Versions.Network.apollo}"

            fun DependencyHandler.apolloApi() {
                api(idlingResource)
                api(runtime)
                api(api)
            }
        }
    }

    object Logging {
        const val kermit = "co.touchlab:kermit:${Versions.Logging.kermit}"
        private const val anrWatchDog =
            "com.github.anrwatchdog:anrwatchdog:${Versions.Logging.anrWatchDog}"
        private const val leakCanary =
            "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanaryVersion}"

        fun DependencyHandler.kermit() {
            implementation(kermit)
        }

        fun DependencyHandler.anrWatchDog() {
            implementation(anrWatchDog)
        }

        fun DependencyHandler.leakCanary() {
            debugImplementation(leakCanary)
        }
    }

    object Firebase {
        private const val bom = "com.google.firebase:firebase-bom:${Versions.Firebase.BOM}"
        const val analytics = "com.google.firebase:firebase-analytics-ktx"
        const val config = "com.google.firebase:firebase-config-ktx"
        const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx"
        const val inappmessaging = "com.google.firebase:firebase-inappmessaging-display-ktx"
        const val messaging = "com.google.firebase:firebase-messaging-ktx"
        const val performance = "com.google.firebase:firebase-perf-ktx"

        fun DependencyHandler.firebaseBom() {
            implementation(platform(bom))
        }

        fun DependencyHandler.firebaseServices() {
            implementation(analytics)
            implementation(config)
            implementation(messaging)
            implementation(crashlytics)
            implementation(inappmessaging)
            implementation(performance)
        }

        fun DependencyHandler.firebaseConfig() {
            firebaseBom()
            implementation(config)
        }
    }

    object Tracker {
        private const val appsFlyer = "com.appsflyer:af-android-sdk:${Versions.Trackers.appsFlyer}"
        private const val adjust = "com.adjust.sdk:adjust-android:${Versions.Trackers.adjust}"

        fun DependencyHandler.trackers() {
            implementation(appsFlyer)
            implementation(adjust)
        }

        fun DependencyHandler.adjust() {
            implementation(adjust)
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
        const val hamcrest = "org.hamcrest:hamcrest-library:${Versions.Tests.hamcrest}"
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
        const val expekt = "com.winterbe:expekt:${Versions.Tests.expekt}"
        const val mockK = "io.mockk:mockk:${Versions.Tests.mockK}"
        const val robolectric = "org.robolectric:robolectric:4.4"
        const val robolectricAll = "org.robolectric:android-all:13-robolectric-9030017"
        const val allure =
            "io.qameta.allure:allure-kotlin-junit4:${Versions.Tests.allureKotlinVersion}"

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

        object Kaspresso {
            const val core =
                "com.kaspersky.android-components:kaspresso:${Versions.Tests.kaspresso}"
            const val allure =
                "com.kaspersky.android-components:kaspresso-allure-support:${Versions.Tests.kaspresso}"
            const val compose =
                "com.kaspersky.android-components:kaspresso-compose-support:${Versions.Tests.kaspresso}"

            fun DependencyHandler.kaspresso() {
                androidTestImplementation(core)
                androidTestImplementation(allure)
                androidTestImplementation(compose)
            }
        }

        object Perfeccionista {
            private const val utils =
                "io.perfeccionista.framework:utils:${Versions.Tests.perfeccionista}"
            private const val enviroment =
                "io.perfeccionista.framework:environment:${Versions.Tests.perfeccionista}"

            fun DependencyHandler.perfeccionista() {
                androidTestImplementation(utils)
                androidTestImplementation(enviroment)
            }
        }

        object AndroidX {
            const val monitor = "androidx.test:monitor:${Versions.Tests.androidX}"
            const val fragment = "androidx.fragment:fragment-testing:${Versions.Tests.fragment}"
            const val coreTesting = "androidx.arch.core:core-testing:${Versions.Tests.androidXCore}"

            object Compose {
                const val junit = "androidx.compose.ui:ui-test-junit4:1.0.1"
                const val manifest = "androidx.compose.ui:ui-test-manifest:1.0.1"
            }
        }
    }

    object RemoteConfigAnnotations {

        const val classIndex = "org.atteo.classindex:classindex:${Versions.classIndex}"

        fun DependencyHandler.remoteConfigAnnotations() {
            implementation(classIndex)
            kapt(classIndex)
        }

        fun DependencyHandler.remoteConfig() {
            implementation(project(":feature-remote-config"))
            implementation(classIndex)
            kapt(classIndex)
        }
    }

    object Crypto {
        const val tink = "com.google.crypto.tink:tink-android:${Versions.Crypto.tink}"
        const val joseJwt = "com.nimbusds:nimbus-jose-jwt:${Versions.Crypto.joseJwt}"
        const val lazySodium = "com.goterl:lazysodium-android:${Versions.Crypto.lazySodium}@aar"
        const val jna = "net.java.dev.jna:jna:${Versions.Crypto.jna}@aar"
    }

    object Analytics {
        const val clickstream = "analytics.sdk:clickstream:${Versions.Analytics.clickstream}"
        const val clickstreamTest =
            "analytics.sdk:clickstream-test:${Versions.Analytics.clickstreamTest}"
        const val clickstreamEventSenderTest =
            "analytics.sdk:clickstream-eventsender-test:${Versions.Analytics.clickstreamEventsenderTest}"
        const val composite = "analytics.sdk:composite:${Versions.Analytics.composite}"
        const val analyticstype = "analytics.sdk:analyticstype:${Versions.Analytics.analyticsType}"
        const val common = "analytics.sdk:common:${Versions.Analytics.common}"
        const val event = "analytics.sdk:event:${Versions.Analytics.event}"
        const val eventsender = "analytics.sdk:eventsender:${Versions.Analytics.eventsender}"
    }
}
