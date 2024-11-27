package com.example.tp_ecommerce_formation_android.ui.page.product.details.v1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.tp_ecommerce_formation_android.data.repository.ProductRepository
import com.example.tp_ecommerce_formation_android.domain.mapper.toProductDetails
import com.example.tp_ecommerce_formation_android.ui.page.product.details.state.ProductDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import java.util.UUID

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: ProductRepository,
): ViewModel() {

    private val productId = UUID.fromString(savedStateHandle.get<String>("productId")!!)

    private val _state: MutableLiveData<ProductDetails> = MutableLiveData(
        repository.getById(productId)!!.toProductDetails()
    )
    val state: MutableLiveData<ProductDetails>
        get() = _state
}