package com.example.tp_ecommerce_formation_android.data.source

import com.example.tp_ecommerce_formation_android.data.model.CategoryDto
import java.util.UUID

object CategoryDataSource {

    private val categories = listOf(
        CategoryDto(
            id = UUID.randomUUID(),
            name = "Vêtements"
        ),
        CategoryDto(
            id = UUID.randomUUID(),
            name = "Accessoires"
        ),
        CategoryDto(
            id = UUID.randomUUID(),
            name = "Chaussures"
        ),
        CategoryDto(
            id = UUID.randomUUID(),
            name = "Électroménager"
        ),
        CategoryDto(
            id = UUID.randomUUID(),
            name = "Livres"
        ),
        CategoryDto(
            id = UUID.randomUUID(),
            name = "Sports",
        ),
    )

    fun getCategories(): List<CategoryDto> {
        return categories
    }

    fun getById(id: UUID): CategoryDto? = categories.find { it.id == id }
}