package com.prudhvir3ddy.earlyentrypoint_sample

import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class EarlyEntryPointSample : BaseApplication(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    @Inject
    lateinit var toolsInitializer: ToolsInitializerImpl

    override fun onCreate() {
        super.onCreate()
        toolsInitializer.initTools()
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder().setWorkerFactory(workerFactory).apply {
            setMinimumLoggingLevel(android.util.Log.DEBUG)
        }.build()
    }

}