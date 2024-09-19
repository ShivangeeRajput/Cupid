package com.example.cupid.di

import android.app.Application
import android.util.Log
import com.example.cupid.repository.UserRepository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class CupidApplicationClass : Application() {
      override fun onCreate() {
          super.onCreate()
          initLogging()
      }
    private fun initLogging() {

        Log.d("MyApp", "Logging initialized")
    }
}