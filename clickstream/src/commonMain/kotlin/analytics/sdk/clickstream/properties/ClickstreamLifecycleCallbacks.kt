package analytics.sdk.clickstream.properties

import android.app.Activity
import android.app.ActivityManager
import android.app.Application
import android.content.ComponentName
import android.content.Context
import android.os.Bundle

internal class ClickstreamLifecycleCallbacks(
    private val context: Context,
    private val updateSessionId: UpdateSessionId,
    private val updateCounter: UpdateCounter,
) : Application.ActivityLifecycleCallbacks {

    override fun onActivityResumed(activity: Activity) {
        if (isApplicationBroughtToBackground()) {
            updateCounter.resetCounter()
            updateSessionId.updateSessionId()
        }
    }
    override fun onActivityPaused(activity: Activity) = Unit
    override fun onActivityStopped(activity: Activity) = Unit
    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) = Unit
    override fun onActivityDestroyed(activity: Activity) = Unit
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) = Unit
    override fun onActivityStarted(activity: Activity) = Unit

    private fun isApplicationBroughtToBackground(): Boolean {
        val am: ActivityManager =
            context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val tasks: List<ActivityManager.RunningTaskInfo> = am.getRunningTasks(1)
        if (tasks.isNotEmpty()) {
            val topActivity: ComponentName? = tasks.firstOrNull()?.topActivity
            if (!topActivity?.packageName.equals(context.packageName)) {
                return true
            }
        }
        return false
    }
}
