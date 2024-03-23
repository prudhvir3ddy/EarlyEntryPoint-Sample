package com.prudhvir3ddy.earlyentrypoint_sample

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import java.util.concurrent.TimeUnit

@HiltWorker
class ExampleWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val workerDependency: SessionStorage
) : CoroutineWorker(appContext, workerParams) {


    override suspend fun doWork(): Result {
        workerDependency.printObjectName("EXAMPLE_WORKER")
        return Result.success()
    }

    companion object {
        fun createOneTimeWorkRequest(initialDelaySeconds: Long): OneTimeWorkRequest {

            return OneTimeWorkRequestBuilder<ExampleWorker>()
                .setInitialDelay(initialDelaySeconds, TimeUnit.SECONDS)
                .addTag("ExampleWorker")
                .build()
        }
    }


}