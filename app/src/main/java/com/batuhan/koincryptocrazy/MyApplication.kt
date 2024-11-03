package com.batuhan.koincryptocrazy

import android.app.Application
import com.batuhan.koincryptocrazy.di.anotherModule
import com.batuhan.koincryptocrazy.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule, anotherModule)
        }
    }
}