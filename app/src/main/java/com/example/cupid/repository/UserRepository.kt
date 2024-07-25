package com.example.cupid.repository

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class UserRepository private val db = FirebaseFirestore.getInstance()

suspend fun signUpUser(email: String, password: String): Result<String> {
    return try {
        val user = hashMapOf(
            "email" to email,
            "password" to password // For security reasons, ne
        )
        db.collection("users")
            .add(user)
            .await()
        Result.success("Sign Up Successful")
    } catch (e: Exception) {
        Result.failure(e)
    }
}