package analytics.sdk.clickstream.di


import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

actual fun initKoin(additionalModules: KoinApplication.() -> Unit) = startKoin {
    modules(CommonKoinModule)
    additionalModules() // Additional configurations or modules
}