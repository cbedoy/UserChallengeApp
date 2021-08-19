package com.challenge.userchallegeapp

import android.app.Application
import com.challenge.userchallegeapp.feature.module.userListModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ChallengeApplication : Application()  {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ChallengeApplication)
            modules(listOf(
                userListModule
            ))
        }
    }
}