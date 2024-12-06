package com.example.tp_ecommerce_formation_android.ui.page.product.list.state

sealed class ProductListState {
    // Lorsque les données sont en chargement...
    data object Loading : ProductListState()
    // Lorsqu'on a une réponse
    data class Success(val products: List<Product>) : ProductListState()
    // Si on a une erreur
    data class Error(val message: String) : ProductListState()
}