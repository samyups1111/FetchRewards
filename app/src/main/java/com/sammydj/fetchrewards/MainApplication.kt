package com.sammydj.fetchrewards

import android.app.Application
import android.content.Context
import com.sammydj.fetchrewards.database.MainDatabase
import com.sammydj.fetchrewards.network.Retrofit

class MainApplication: Application() {

    companion object {
        lateinit var appContext : Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

    // Using "by lazy" so that the variables are only instantiated when needed.

    private val retrofit by lazy { Retrofit() }
    private val database by lazy { MainDatabase.getDatabase(this) }
    val mainRepository by lazy { MainRepository(retrofit.fetchRewardsService, database.mainDao) }
}