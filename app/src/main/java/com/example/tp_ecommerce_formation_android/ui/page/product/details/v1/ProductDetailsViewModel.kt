package com.example.tp_ecommerce_formation_android.ui.page.product.details.v1

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.example.tp_ecommerce_formation_android.data.repository.ProductRepository
import com.example.tp_ecommerce_formation_android.domain.mapper.toProductDetails
import com.example.tp_ecommerce_formation_android.ui.page.product.details.state.ProductDetailsState
import com.example.tp_ecommerce_formation_android.ui.routing.SearchRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: ProductRepository,
) : ViewModel() {

    private val navArgs = savedStateHandle.toRoute<SearchRoutes.ProductDetailsRoute>()
    private val productId = UUID.fromString(navArgs.productId)

    private val _state: MutableState<ProductDetailsState> = buildState()

    val state: State<ProductDetailsState>
        get() = _state

    private fun buildState(): MutableState<ProductDetailsState> = mutableStateOf(
        ProductDetailsState(repository.getById(productId)!!.toProductDetails())
    )
}