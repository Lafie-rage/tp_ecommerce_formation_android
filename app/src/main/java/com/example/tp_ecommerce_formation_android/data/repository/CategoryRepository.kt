package com.example.tp_ecommerce_formation_android.data.repository

import com.example.tp_ecommerce_formation_android.data.model.CategoryDto
import com.example.tp_ecommerce_formation_android.data.source.CategoryDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryRepository @Inject constructor() {
    fun getAll(): List<CategoryDto> = CategoryDataSource.getCategories()
}