package analytics.sdk.clickstream.interactors

import analytics.sdk.clickstream.Clickstream
import android.app.Activity
import android.app.Application.ActivityLifecycleCallbacks
import android.os.Build
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlin.math.acos

fun Clickstream.trackScreen(fragment: Fragment) {
    fragment.childFragmentManager.registerFragmentLifecycleCallbacks(
        object : FragmentManager.FragmentLifecycleCallbacks() {

            override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
                super.onFragmentCreated(fm, f, savedInstanceState)
            }


            override fun onFragmentPaused(fm: FragmentManager, f: Fragment) {
                super.onFragmentPaused(fm, f)
            }

            override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
                super.onFragmentResumed(fm, f)
            }

            override fun onFragmentStopped(fm: FragmentManager, f: Fragment) {
                super.onFragmentStopped(fm, f)
            }

        }, true
    )
}


fun Clickstream.trackScreen(activity: Activity) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        activity.registerActivityLifecycleCallbacks(
            object : ActivityLifecycleCallbacks {
                override fun onActivityCreated(p0: Activity, p1: Bundle?) {
                    TODO("Not yet implemented")
                }

                override fun onActivityStarted(p0: Activity) {
                    TODO("Not yet implemented")
                }

                override fun onActivityResumed(p0: Activity) {
                    TODO("Not yet implemented")
                }

                override fun onActivityPaused(p0: Activity) {
                    TODO("Not yet implemented")
                }

                override fun onActivityStopped(p0: Activity) {
                    TODO("Not yet implemented")
                }

                override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
                    // TODO
                }

                override fun onActivityDestroyed(p0: Activity) {
                    TODO("Not yet implemented")
                }

            }
        )
    }
}