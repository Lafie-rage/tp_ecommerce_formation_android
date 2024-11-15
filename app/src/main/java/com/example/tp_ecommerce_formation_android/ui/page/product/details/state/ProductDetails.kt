package com.example.tp_ecommerce_formation_android.ui.page.product.details.state

import java.util.UUID

data class ProductDetails(
    val id: UUID,
    val name: String,
    val description: String,
    val isAvailable: Boolean,
    val price: Double,
    val averageRate: Double,
    val rateCount: Int,
    val category: String,
)