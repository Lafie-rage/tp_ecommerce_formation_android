package com.example.tp_ecommerce_formation_android.ui.routing.navigation.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.tp_ecommerce_formation_android.ui.page.product.details.v2.ProductDetailsPage
import com.example.tp_ecommerce_formation_android.ui.routing.SearchRoutes
import java.util.UUID

fun NavGraphBuilder.createProductDetailsNavigation() {
    composable<SearchRoutes.ProductDetailsRoute> {
        ProductDetailsPage()
    }
}

fun NavController.navigateToProductDetails(productId: UUID) {
    navigate(SearchRoutes.ProductDetailsRoute(productId.toString()))
}