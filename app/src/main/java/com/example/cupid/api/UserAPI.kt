package com.example.cupid.api

import com.example.cupid.models.UserRequest
import com.example.cupid.models.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {
    @POST("/auth/signup")
    suspend fun signUp(@Body userRequest: UserRequest) : Response<UserResponse>

    @POST("/auth/login")
    suspend fun signIn(@Body userRequest: UserRequest) : Response<UserResponse>

    @POST("/auth/update")
    suspend fun update(@Body userRequest: UserRequest) : Response<UserResponse>
}