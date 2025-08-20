package com.nadim.android.newsapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.Forest.plant

@HiltAndroidApp
class NewsApp: Application() {
    companion object {
        const val TAG = "NA - "
    }

    override fun onCreate() {
        super.onCreate()
        plant(object: Timber.DebugTree() {
            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                super.log(priority, "${TAG}${tag}", message, t)
            }

            override fun createStackElementTag(element: StackTraceElement): String? {
                return String.format(
                    "%s:%s:%s",
                    element.methodName,
                    element.lineNumber,
                    super.createStackElementTag(element)
                )
            }
        })
    }
}