package com.example.tp_ecommerce_formation_android.ui.page.product.details.state

sealed class ProductDetailsState{
    data object Loading : ProductDetailsState()
    data class Success(val product: ProductDetails) : ProductDetailsState()
    data class Error(val message: String) : ProductDetailsState()
}
