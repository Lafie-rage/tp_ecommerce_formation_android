package com.example.tp_ecommerce_formation_android.domain.mapper

import com.example.tp_ecommerce_formation_android.data.model.ProductDto
import com.example.tp_ecommerce_formation_android.ui.page.home.state.LastPurchasedProduct
import com.example.tp_ecommerce_formation_android.ui.page.product.details.state.ProductDetails
import com.example.tp_ecommerce_formation_android.ui.page.product.list.state.Product

fun ProductDto.toProduct() = Product(
    id = id,
    name = name,
    description = description,
    isAvailable = isAvailable,
    price = price,
)

fun ProductDto.toProductDetails() = ProductDetails(
    id = id,
    name = name,
    description = description,
    isAvailable = isAvailable,
    price = price,
    averageRate = averageRate,
    rateCount = rateCount,
    category = category,
)

fun ProductDto.toLastPurchasedProduct() = LastPurchasedProduct(
    id = id,
    name = name,
)