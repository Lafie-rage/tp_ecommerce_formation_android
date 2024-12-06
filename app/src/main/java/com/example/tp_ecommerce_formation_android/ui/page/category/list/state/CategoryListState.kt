package com.example.tp_ecommerce_formation_android.ui.page.category.list.state

sealed class CategoryListState {
    data object Loading : CategoryListState()
    data class Success(val categories: List<Category>) : CategoryListState()
    data class Error(val message: String) : CategoryListState()
}