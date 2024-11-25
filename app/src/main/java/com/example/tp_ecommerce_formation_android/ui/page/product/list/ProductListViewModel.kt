package com.example.tp_ecommerce_formation_android.ui.page.product.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.tp_ecommerce_formation_android.data.repository.ProductRepository
import com.example.tp_ecommerce_formation_android.domain.mapper.toProduct
import com.example.tp_ecommerce_formation_android.ui.page.product.list.state.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: ProductRepository,
) : ViewModel() {

    private val categoryId = UUID.fromString(savedStateHandle.get<String>("categoryId")!!)

    private val _state: MutableLiveData<List<Product>> =
        MutableLiveData(repository.getAllByCategoryId(categoryId)
            .map { it.toProduct() })
    val state: LiveData<List<Product>>
        get() = _state

}