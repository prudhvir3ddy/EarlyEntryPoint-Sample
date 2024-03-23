package com.prudhvir3ddy.earlyentrypoint_sample

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class EarlyEntryPointSample : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory


    override val workManagerConfiguration =
        Configuration.Builder().setWorkerFactory(workerFactory).apply {
            setMinimumLoggingLevel(android.util.Log.DEBUG)
        }.build()
}