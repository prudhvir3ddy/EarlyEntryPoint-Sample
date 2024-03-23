package com.prudhvir3ddy.earlyentrypoint_sample

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionStorage @Inject constructor() {

    fun printObjectName(tag: String) {
        Log.d("SessionStorage $tag", this.hashCode().toString())
    }
}