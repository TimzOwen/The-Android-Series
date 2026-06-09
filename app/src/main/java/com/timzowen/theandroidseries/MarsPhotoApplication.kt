package com.timzowen.theandroidseries

import android.app.Application
import com.timzowen.theandroidseries.data.AppContainer
import com.timzowen.theandroidseries.data.DefaultAppContainer

class MarsPhotoApplication: Application() {

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}