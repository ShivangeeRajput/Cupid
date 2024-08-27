package com.example.cupid.repository

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserRepository @Inject constructor(private val db: FirebaseFirestore) {
    suspend fun signUpUser(email: String, password: String): Result<String> {
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
    suspend fun saveUSer(email: String,password: String){
        Log.d("TAG","User saved in database")
    }
}
