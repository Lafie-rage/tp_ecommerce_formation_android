package com.example.tp_ecommerce_formation_android.ui.page.product.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.util.UUID

class ProductListViewModelFactory(
    private val categoryId: String
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductListViewModel::class.java)) {
            return ProductListViewModel(UUID.fromString(categoryId)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}