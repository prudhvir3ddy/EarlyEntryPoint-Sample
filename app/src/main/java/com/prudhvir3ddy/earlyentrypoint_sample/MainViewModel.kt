package com.prudhvir3ddy.earlyentrypoint_sample

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sessionStorage: SessionStorage
) : ViewModel() {

    fun getSession() {
        sessionStorage.printObjectName("MainViewModel")
    }
}
