package com.example.tp_ecommerce_formation_android.ui.page.product.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tp_ecommerce_formation_android.data.source.ProductDataSource
import com.example.tp_ecommerce_formation_android.domain.mapper.toProductDetails
import com.example.tp_ecommerce_formation_android.ui.page.product.details.state.ProductDetails
import java.util.UUID

class ProductDetailsViewModel(
    productId: UUID,
): ViewModel() {
    private val _state: MutableLiveData<ProductDetails> = MutableLiveData(
        ProductDataSource.getProductById(productId)!!.toProductDetails()
    )
    val state: MutableLiveData<ProductDetails>
        get() = _state
}