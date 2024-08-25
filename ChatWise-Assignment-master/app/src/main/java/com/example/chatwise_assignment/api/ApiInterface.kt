package com.example.chatwise_assignment.api

import com.example.chatwise_assignment.dataClass.responseDataClass
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/products")
    fun getData(): Call<responseDataClass>
}