package com.example.tp_ecommerce_formation_android.data.repository

import com.example.tp_ecommerce_formation_android.data.model.ProductDto
import com.example.tp_ecommerce_formation_android.data.source.ProductDataSource
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor() {

    fun getAll(): List<ProductDto> = ProductDataSource.getProducts()

    fun getAllByCategoryId(categoryId: UUID): List<ProductDto> =
        ProductDataSource.getProductsByCategoryId(categoryId)

    fun getById(id: UUID): ProductDto? = ProductDataSource.getProductById(id)
}