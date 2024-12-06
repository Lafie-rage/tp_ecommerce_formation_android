package com.example.tp_ecommerce_formation_android.domain.mapper

import com.example.tp_ecommerce_formation_android.data.local.model.CategoryEntity
import com.example.tp_ecommerce_formation_android.data.model.CategoryDto
import com.example.tp_ecommerce_formation_android.ui.page.category.list.state.Category
import java.util.UUID

// region ENTITY -> DTO
fun CategoryEntity.toDto() = CategoryDto(
    id = localId,
    name = name,
)
// endregion

// region DTO -> ENTITY
fun CategoryDto.toEntity() = CategoryEntity(
    localId = id,
    remoteId = UUID.randomUUID(),
    name = name,
)
// endregion

// region DTO -> STATE
fun CategoryDto.toCategory() = Category(
    id = id,
    name = name,
)
// endregion