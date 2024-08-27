package com.example.cupid.repository

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

interface UserRepository {
    suspend fun signUpUser(email: String, password: String): Result<String>
    suspend fun saveUser(email: String, password: String)
}


@Singleton
class FirebaseRepository @Inject constructor(private val db: FirebaseFirestore) : UserRepository {

    override suspend fun signUpUser(email: String, password: String): Result<String> {
        return try {
            val user = hashMapOf(
                "email" to email,
                "password" to password
            )
            db.collection("users")
                .add(user)
                .await()
            Result.success("Sign Up Successful")
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun saveUser(email: String, password: String) {
        Log.d("TAG", "User saved in database")
    }
}