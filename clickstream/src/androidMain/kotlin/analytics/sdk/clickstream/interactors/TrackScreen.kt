package analytics.sdk.clickstream.interactors

import analytics.sdk.clickstream.Clickstream
import analytics.sdk.clickstream.domain.model.ScreenLifecycleState
import android.app.Activity
import android.app.Application.ActivityLifecycleCallbacks
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun Clickstream.trackScreen(fragment: Fragment) {
    fragment.childFragmentManager.registerFragmentLifecycleCallbacks(
        object : FragmentManager.FragmentLifecycleCallbacks() {


            override fun onFragmentPaused(fm: FragmentManager, f: Fragment) {
                super.onFragmentPaused(fm, f)
                sendScreenLifecycleChange(
                    fragment::class.java.name,
                    ScreenLifecycleState.DISAPPEARED
                )
            }

            override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
                super.onFragmentResumed(fm, f)
                sendScreenLifecycleChange(fragment::class.java.name, ScreenLifecycleState.APPEARED)
            }

        }, true
    )
}


fun Clickstream.trackScreen(activity: Activity) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        activity.registerActivityLifecycleCallbacks(
            object : ActivityLifecycleCallbacks {
                override fun onActivityResumed(p0: Activity) {
                    sendScreenLifecycleChange(p0::class.java.name, ScreenLifecycleState.APPEARED)
                }

                override fun onActivityPaused(p0: Activity) {
                    sendScreenLifecycleChange(p0::class.java.name, ScreenLifecycleState.DISAPPEARED)
                }

                override fun onActivityStarted(p0: Activity) {}
                override fun onActivityStopped(p0: Activity) {}
                override fun onActivityDestroyed(p0: Activity) {}
                override fun onActivityCreated(p0: Activity, p1: Bundle?) {}
                override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {}
            }
        )
    }
}