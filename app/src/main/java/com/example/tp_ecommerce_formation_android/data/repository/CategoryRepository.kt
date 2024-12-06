package com.example.tp_ecommerce_formation_android.data.repository

import com.example.tp_ecommerce_formation_android.data.local.dao.CategoryDao
import com.example.tp_ecommerce_formation_android.data.model.CategoryDto
import com.example.tp_ecommerce_formation_android.domain.mapper.toDto
import com.example.tp_ecommerce_formation_android.domain.mapper.toEntity
import com.example.tp_ecommerce_formation_android.ui.page.category.list.state.Category
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryRepository @Inject constructor(
    private val dao: CategoryDao,
) {
    suspend fun getAll(): List<CategoryDto> = dao.getAll().map { it.toDto() }

    suspend fun upsert(category: CategoryDto) = dao.upsert(category.toEntity())
}