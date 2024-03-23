package com.prudhvir3ddy.earlyentrypoint_sample

import android.app.Application
import android.util.Log
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.WorkManager
import dagger.hilt.InstallIn
import dagger.hilt.android.EarlyEntryPoint
import dagger.hilt.android.EarlyEntryPoints
import dagger.hilt.components.SingletonComponent

open class BaseApplication : Application(), Configuration.Provider {

    private val workerFactory by lazy { entryPoints().workerFactory() }

    // no @Inject, since Hilt "@CustomTestApplication does not support application classes (or super classes) with @Inject fields."
    // we make use of the "EntryPointAccessors-pattern" instead
    @EarlyEntryPoint
    @InstallIn(SingletonComponent::class)
    interface ApplicationEarlyEntryPoint {
        fun workerFactory(): HiltWorkerFactory
    }

    private fun entryPoints(): ApplicationEarlyEntryPoint =
        EarlyEntryPoints.get(this, ApplicationEarlyEntryPoint::class.java)

    override fun onCreate() {
        super.onCreate()
        val workRequest = ExampleWorker.createOneTimeWorkRequest(0L)
        WorkManager.getInstance(applicationContext).enqueue(workRequest)
    }


    override fun getWorkManagerConfiguration(): Configuration =
        Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .setMinimumLoggingLevel(Log.DEBUG)
            .build()

}