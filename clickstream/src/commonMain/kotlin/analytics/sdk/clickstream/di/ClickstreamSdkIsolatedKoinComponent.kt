package analytics.sdk.clickstream.di

import org.koin.core.Koin
import org.koin.core.component.KoinComponent

abstract class ClickstreamSdkIsolatedKoinComponent : KoinComponent {
    override fun getKoin(): Koin = ClickstreamSdkKoinContext.koin
}