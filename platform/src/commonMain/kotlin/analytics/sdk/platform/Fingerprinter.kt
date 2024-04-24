package analytics.sdk.platform

interface Fingerprinter {
    suspend fun getData() : Map<String, String>
}