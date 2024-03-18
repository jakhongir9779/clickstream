package analytics.sdk.clickstream.di


import org.koin.core.KoinApplication

actual fun initKoin(additionalModules: KoinApplication.() -> Unit) =
    ClickstreamSdkKoinContext.initKoin {
        additionalModules() // Additional configurations or modules
    }