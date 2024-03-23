package com.prudhvir3ddy.earlyentrypoint_sample

import androidx.work.WorkManager
import javax.inject.Inject


class ToolsInitializerImpl @Inject constructor(
    private val workManager: WorkManager
) {

    fun initTools() {
        val workRequest = ExampleWorker.createOneTimeWorkRequest(0L)
        workManager.enqueue(workRequest)
    }
}