package com.example.tp_ecommerce_formation_android.domain.mapper

import com.example.tp_ecommerce_formation_android.data.model.CategoryDto
import com.example.tp_ecommerce_formation_android.ui.page.category.list.state.Category

fun CategoryDto.toCategory() = Category(
    id = id,
    name = name,
)