package com.example.tp_ecommerce_formation_android.ui.page.product.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.util.UUID

class ProductDetailsViewModelFactory(
    private val productId: String,
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductDetailsViewModel::class.java)) {
            return ProductDetailsViewModel(UUID.fromString(productId)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}