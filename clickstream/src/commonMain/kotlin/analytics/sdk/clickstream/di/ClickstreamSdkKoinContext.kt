package analytics.sdk.clickstream.di

import org.koin.core.KoinApplication
import org.koin.dsl.koinApplication

object ClickstreamSdkKoinContext {
    lateinit var koinApp: KoinApplication

    fun initKoin(additionalModules: KoinApplication.() -> Unit) = koinApplication {
        modules(CommonKoinModule, NetworkModule)
        additionalModules()
    }.apply {
        koinApp = this
    }

    val koin by lazy { koinApp.koin }
}