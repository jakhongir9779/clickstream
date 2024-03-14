package analytics.sdk.clickstream.di

import org.koin.core.KoinApplication

expect fun initKoin(additionalModules: KoinApplication.() -> Unit = {}): KoinApplication
