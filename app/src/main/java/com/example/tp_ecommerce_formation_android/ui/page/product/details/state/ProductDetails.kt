package com.example.tp_ecommerce_formation_android.ui.page.product.details.state

data class ProductDetails(
    val id: Int,
    val name: String,
    val description: String,
    val isAvailable: Boolean,
    val price: Double,
    val averageRate: Double,
    val rateCount: Int,
    val category: String,
)