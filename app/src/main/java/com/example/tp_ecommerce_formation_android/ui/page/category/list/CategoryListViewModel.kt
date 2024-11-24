package com.example.tp_ecommerce_formation_android.ui.page.category.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp_ecommerce_formation_android.data.source.CategoryDataSource
import com.example.tp_ecommerce_formation_android.domain.mapper.toCategory
import com.example.tp_ecommerce_formation_android.ui.page.category.list.state.Category

class CategoryListViewModel: ViewModel() {
    private val _state: MutableLiveData<List<Category>> =
        MutableLiveData(CategoryDataSource.getCategories().map { it.toCategory() })
    val state: LiveData<List<Category>>
        get() = _state

}