package com.prudhvir3ddy.earlyentrypoint_sample

import android.app.Application
import android.util.Log
import androidx.work.Configuration

open class BaseApplication : Application(), Configuration.Provider {

    override fun getWorkManagerConfiguration(): Configuration =
        Configuration.Builder()
            .setMinimumLoggingLevel(Log.DEBUG)
            .build()

}