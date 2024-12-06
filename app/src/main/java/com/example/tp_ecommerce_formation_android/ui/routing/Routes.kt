package com.example.tp_ecommerce_formation_android.ui.routing

import kotlinx.serialization.Serializable

sealed class SearchRoutes {

    @Serializable
    data object CategoryListRoute: SearchRoutes()

    @Serializable
    data class ProductListRoute(
        val categoryId: Int,
    ): SearchRoutes()

    @Serializable
    data class ProductDetailsRoute(
        val productId: Int,
    ): SearchRoutes()
}
