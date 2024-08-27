package com.example.cupid

import android.app.Application
import com.example.cupid.repository.UserRepository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class CupidApplicationClass : Application() {
    @Inject
    lateinit var userRepository: UserRepository
    override fun onCreate() {
        super.onCreate()
        // Launching a coroutine here to call the suspend function
       CoroutineScope(Dispatchers.IO).launch{
           val result=userRepository.signUpUser("John@gmail.com","111111")
       }
    }
}