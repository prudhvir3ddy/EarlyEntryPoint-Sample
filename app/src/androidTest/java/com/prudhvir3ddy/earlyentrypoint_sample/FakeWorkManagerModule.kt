package com.prudhvir3ddy.earlyentrypoint_sample

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.WorkManager
import androidx.work.testing.WorkManagerTestInitHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [WorkManagerModule::class],
)
class FakeWorkManagerModule {

    @Provides
    @Singleton
    fun providesWorkManager(
        @ApplicationContext application: Context,
        workerFactory: HiltWorkerFactory,
    ): WorkManager {
        WorkManagerTestInitHelper.initializeTestWorkManager(
            application,
            Configuration.Builder()
                .setWorkerFactory(workerFactory)
                .setMinimumLoggingLevel(Log.DEBUG)
                .build(),
        )
        return WorkManager.getInstance(application)
    }
}
