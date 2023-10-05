package analytics.sdk.clickstream

import kotlin.random.Random

class ExponentialBackoffStrategy(
    private val maxRetries: Int,
    private val initialDelayMillis: Long,
) {
    private var retryCount = 0
    private var delayMillis = initialDelayMillis

    fun getMillis(): Long {
        if (retryCount > maxRetries) {
            retryCount = 0
            return 1000 * 60 * 60/*TimeUnit.HOURS.toMillis(1)*/
        }

        if (retryCount == 0) {
            return initialDelayMillis
        }

        val maxBackoffDelayMillis = initialDelayMillis.shl(maxRetries)
        if (delayMillis >= maxBackoffDelayMillis) {
            return maxBackoffDelayMillis
        }

        val jitter = Random.nextLong(0, delayMillis / 2)
        val backoffDelay = delayMillis + jitter

        delayMillis *= 2
        retryCount++

        return backoffDelay
    }

    fun dropBackoff() {
        retryCount = 0
        delayMillis = initialDelayMillis
    }
}
