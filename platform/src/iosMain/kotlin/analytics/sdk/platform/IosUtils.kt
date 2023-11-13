package analytics.sdk.platform

import analytics.sdk.platform.model.PlatformConnectionType
import analytics.sdk.platform.properties.EventPropertiesDelegate
import platform.Foundation.NSBundle
import platform.Foundation.NSDate
import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSOperationQueue
import platform.Foundation.NSTimeZone
import platform.Foundation.NSUUID.Companion.UUID
import platform.Foundation.localTimeZone
import platform.Foundation.timeIntervalSince1970
import platform.UIKit.UIApplicationDidEnterBackgroundNotification
import kotlin.time.Duration.Companion.milliseconds

class IosUtils : PlatformUtils {

    override fun initAllowed(): Boolean = true

    override fun getAppPackage(): String = NSBundle.mainBundle.bundleIdentifier ?: ""

    override fun getAppVersion(): String =
        NSBundle.mainBundle.infoDictionary?.get("CFBundleShortVersionString") as String? ?: ""

    override fun getTimezone(): String = NSTimeZone.localTimeZone.name

    override fun generateUUID(): String = UUID().UUIDString

    override fun generateTimestamp(): Long =
        NSDate().timeIntervalSince1970.milliseconds.inWholeMilliseconds

    override fun getConnectionType(): PlatformConnectionType = PlatformConnectionType.UNKNOWN

    override fun subscribeOnSessionUpdate(delegate: EventPropertiesDelegate) {
        NSNotificationCenter.defaultCenter.addObserverForName(
            UIApplicationDidEnterBackgroundNotification,
            null,
            NSOperationQueue.mainQueue
        ) {
            delegate.resetCounter()
        }
    }
}
