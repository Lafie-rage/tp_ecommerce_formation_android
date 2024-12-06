package com.example.tp_ecommerce_formation_android.ui.routing.navigation.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.tp_ecommerce_formation_android.ui.page.product.list.ProductListPage
import com.example.tp_ecommerce_formation_android.ui.routing.SearchRoutes
import java.util.UUID

fun NavGraphBuilder.createProductListNavigation(
    navigateToProductDetails: (Int) -> Unit,
) {
    composable<SearchRoutes.ProductListRoute> {
        ProductListPage(
            onProductClicked = { product ->
                navigateToProductDetails(product.id)
            }
        )
    }
}

fun NavController.navigateToProductList(categoryId: UUID) {
    // On définit notre destination, à la manière d'un Intent ou d'un action de Jetpack Navigation
    // On passe par les routes définies précédemment
    val route = SearchRoutes.ProductListRoute(categoryId.toString())

    // On appel la fonction navigate du navController pour lancer la navigation vers notre route
    // Le router cherchera ensuite dans les routes définies, un route répondant au type qu'on lui a donné.
    navigate(route)
}