package com.example.cupid.di

import com.example.cupid.repository.FirebaseRepository
import com.example.cupid.repository.UserRepository
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object UserModule {
    @Provides
    @Singleton
    fun provideUserRepository(db: FirebaseFirestore): UserRepository {
        return FirebaseRepository(db)
    }
}