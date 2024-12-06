package com.example.tp_ecommerce_formation_android.ui.routing.navigation.search

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.tp_ecommerce_formation_android.ui.page.category.list.CategoryListPage
import com.example.tp_ecommerce_formation_android.ui.routing.SearchRoutes

fun NavGraphBuilder.createCategoryListNavigation(
    // L'action de navigation doit être transmise aux routes par le routeur
    navigateToProductList: (Int) -> Unit,
) {
    // On référence la SearchRoute comme type générique de la fonction composable
    // pour définir que le routeur doit afficher ce Composable lors que sa
    // "valeur" de destination est de type SearchRoutes.CategoryListRoute
    composable<SearchRoutes.CategoryListRoute> {
        CategoryListPage(
            onCategoryClicked = { category ->
                // On transforme notre onClick en action de navigation
                navigateToProductList(category.id)
            }
        )
    }
}