package com.example.tp_ecommerce_formation_android.data.model

data class ProductDto(
    val id: Int,
    val name: String,
    val description: String,
    val isAvailable: Boolean,
    val price: Double,
    val averageRate: Double,
    val rateCount: Int,
    val categoryId: Int,
)
