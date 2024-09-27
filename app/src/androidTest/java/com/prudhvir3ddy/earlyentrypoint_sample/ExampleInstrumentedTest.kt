package com.prudhvir3ddy.earlyentrypoint_sample

import androidx.hilt.work.HiltWorkerFactory
import androidx.test.core.app.ActivityScenario
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@HiltAndroidTest
class ExampleInstrumentedTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    @Inject
    lateinit var toolsInitializerImpl: ToolsInitializerImpl


    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun useAppContext() {
        toolsInitializerImpl.initTools()
        val activityScenario: ActivityScenario<MainActivity> =
            ActivityScenario.launch(MainActivity::class.java)

        // Context of the app under test.
//        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
//        assertEquals("com.prudhvir3ddy.earlyentrypoint_sample", appContext.packageName)
    }
}