package com.timzowen.theandroidseries

import android.app.Application
import com.timzowen.theandroidseries.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MarsPhotoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MarsPhotoApplication)
            modules(appModule)
        }
    }
}