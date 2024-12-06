package com.example.tp_ecommerce_formation_android.data.model

import java.util.UUID

data class ProductDto(
    val id: Int,
    val name: String,
    val description: String,
    val isAvailable: Boolean,
    val price: Double,
    val averageRate: Double,
    val rateCount: Int,
    val categoryId: UUID,
)
