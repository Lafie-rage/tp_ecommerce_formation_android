package com.example.tp_ecommerce_formation_android.domain.mapper

import com.example.tp_ecommerce_formation_android.data.local.model.ProductEntity
import com.example.tp_ecommerce_formation_android.data.model.ProductDto
import com.example.tp_ecommerce_formation_android.data.source.CategoryDataSource.getCategoryById
import com.example.tp_ecommerce_formation_android.ui.page.home.state.LastPurchasedProduct
import com.example.tp_ecommerce_formation_android.ui.page.product.details.state.ProductDetails
import com.example.tp_ecommerce_formation_android.ui.page.product.list.state.Product

// region ENTITY -> DTO
fun ProductEntity.toDto() = ProductDto(
    id = localId,
    name = name,
    description = description,
    isAvailable = isAvailable,
    price = price,
    averageRate = averageRate,
    rateCount = rateCount,
    categoryId = categoryId,
)
// endregion

// region DTO -> STATE
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
    category = getCategoryById(categoryId)!!.name,
)

fun ProductDto.toLastPurchasedProduct() = LastPurchasedProduct(
    id = id,
    name = name,
)
// endregion