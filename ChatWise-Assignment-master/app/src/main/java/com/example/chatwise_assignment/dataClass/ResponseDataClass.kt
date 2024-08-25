package com.example.chatwise_assignment.dataClass

import com.example.chatwise_assignment.Product

data class responseDataClass(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)