package com.example.tp_ecommerce_formation_android.data.repository

import com.example.tp_ecommerce_formation_android.data.local.dao.ProductDao
import com.example.tp_ecommerce_formation_android.data.model.ProductDto
import com.example.tp_ecommerce_formation_android.domain.mapper.toDto
import com.example.tp_ecommerce_formation_android.domain.mapper.toEntity
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(
    private val dao: ProductDao,
) {

    suspend fun getAll(): List<ProductDto> = dao.getAll()
        .map { it.toDto() }

    suspend fun getAllByCategoryId(categoryId: UUID): List<ProductDto> =
        dao.getByCategoryId(categoryId).map { it.toDto() }

    suspend fun getById(id: Int): ProductDto? = dao.getById(id)?.toDto()

    suspend fun upsert(product: ProductDto) = dao.upsert(product.toEntity())
}