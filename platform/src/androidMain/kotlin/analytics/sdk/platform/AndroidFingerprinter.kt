package analytics.sdk.platform

import android.content.Context
import com.fingerprintjs.android.fingerprint.DeviceIdResult
import com.fingerprintjs.android.fingerprint.FingerprinterFactory
import com.fingerprintjs.android.fingerprint.info_providers.SensorData
import com.fingerprintjs.android.fingerprint.signal_providers.StabilityLevel
import com.fingerprintjs.android.fingerprint.tools.hashers.Hasher
import com.fingerprintjs.android.fingerprint.tools.hashers.MurMur3x64x128Hasher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume

class AndroidFingerprinter(context: Context) : Fingerprinter {
    private val fingerprinter = FingerprinterFactory.create(context)
    private val version = com.fingerprintjs.android.fingerprint.Fingerprinter.Version.V_5

    override suspend fun getData(): Map<String, String> {
        val fingerprint = fingerprinter.getFingerprint(version = version)

        val deviceId = fingerprinter.getDeviceId(version = version)

        val signals = withContext(Dispatchers.IO) {
            fingerprinter.getFingerprintingSignalsProvider()?.getSignalsMatching(
                version = version,
                stabilityLevel = StabilityLevel.OPTIMAL
            ).orEmpty()
        }

        val result = mutableMapOf("fingerprint" to fingerprint)
        result["deviceId"] = deviceId.deviceId
        result["androidId"] = deviceId.androidId
        result["gsfId"] = deviceId.gsfId
        result["mediaDrmId"] = deviceId.mediaDrmId

        signals.forEach {
            val data = when (it.value) {
                is List<*> -> {
                    val res = (it.value as List<*>).map { signalValue ->
                        if (signalValue is SensorData) {
                            "${signalValue.vendorName}:${signalValue.sensorName}"
                        } else {
                            signalValue.toString()
                        }
                    }

                    res.toString()
                }

                else -> {
                    it.value.toString()
                }
            }

            result[it::class.java.simpleName] = data
        }



        return result
    }
}

suspend fun com.fingerprintjs.android.fingerprint.Fingerprinter.getFingerprint(
    version: com.fingerprintjs.android.fingerprint.Fingerprinter.Version,
    stabilityLevel: StabilityLevel = StabilityLevel.OPTIMAL,
    hasher: Hasher = MurMur3x64x128Hasher(),
): String {
    return suspendCancellableCoroutine { cancellableContinuation ->
        this.getFingerprint(
            version = version,
            stabilityLevel = stabilityLevel,
            hasher = hasher,
            listener = { cancellableContinuation.resume(it) }
        )

    }
}

suspend fun com.fingerprintjs.android.fingerprint.Fingerprinter.getDeviceId(version: com.fingerprintjs.android.fingerprint.Fingerprinter.Version): DeviceIdResult {
    return suspendCancellableCoroutine { cancellableContinuation ->
        this.getDeviceId(
            version = version,
            listener = { cancellableContinuation.resume(it) }
        )
    }
}