package com.prudhvir3ddy.earlyentrypoint_sample

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

class MyTestRunner : AndroidJUnitRunner() {
    override fun newApplication(
        cl: ClassLoader,
        appName: String,
        context: Context
    ): Application {
        return super.newApplication(
            cl, TestApplication_Application::class.java.name, context
        )
    }
}