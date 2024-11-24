package com.example.tp_ecommerce_formation_android.ui.page.product.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp_ecommerce_formation_android.data.source.ProductDataSource
import com.example.tp_ecommerce_formation_android.domain.mapper.toProduct
import com.example.tp_ecommerce_formation_android.ui.page.product.list.state.Product
import java.util.UUID

class ProductListViewModel(
    categoryId: UUID,
) : ViewModel() {
    private val _state: MutableLiveData<List<Product>> =
        MutableLiveData(ProductDataSource.getProductsByCategoryId(categoryId)
            .map { it.toProduct() })
    val state: LiveData<List<Product>>
        get() = _state

}