package com.example.cupid.models

data class UserRequest(
    val email: String,
    val mobile: String,
    val password: String,
    val username: String
)