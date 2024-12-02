package com.example.tp_ecommerce_formation_android.ui.routing

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.tp_ecommerce_formation_android.ui.routing.navigation.search.createCategoryListNavigation
import com.example.tp_ecommerce_formation_android.ui.routing.navigation.search.createProductListNavigation
import com.example.tp_ecommerce_formation_android.ui.routing.navigation.search.navigateToProductList

@Composable
fun Router() {
    // Puisque nous aurons besoin de la référence vers notre navController pour lancer les navigate
    // on la stock dans une variable au préalable.
    val navController = rememberNavController()

    // On n'oublie pas de transmettre le navController gardé en mémoire
    NavHost(navController = navController, startDestination = SearchRoutes.CategoryListRoute) {
        createCategoryListNavigation(
            // On utilise du déréférencement de méthode avec le ::
            // A la place de définir une lambda qui appel navigateToProductList
            // on transmet la référence de notre fonction.
            // On peut le faire car notre fonction est du même type que la lambda attendue.
            navigateToProductList = navController::navigateToProductList
        )

        createProductListNavigation {
            // On appellera la fonction de navigation vers ProductDetailsPage lorsqu'elle sera définie
        }
    }
}