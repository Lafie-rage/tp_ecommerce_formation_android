package com.example.tp_ecommerce_formation_android.data.source

import com.example.tp_ecommerce_formation_android.data.model.CategoryDto
import java.util.UUID

object CategoryDataSource {

    private val categories = listOf(
        CategoryDto(
            id = 1,
            name = "Vêtements"
        ),
        CategoryDto(
            id = 2,
            name = "Accessoires"
        ),
        CategoryDto(
            id = 3,
            name = "Chaussures"
        ),
        CategoryDto(
            id = 4,
            name = "Électroménager"
        ),
        CategoryDto(
            id = 5,
            name = "Livres"
        ),
        CategoryDto(
            id = 6,
            name = "Sports",
        ),
    )

    fun getCategories(): List<CategoryDto> {
        return categories
    }

}