package com.example.tp_ecommerce_formation_android.ui.page.product.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.tp_ecommerce_formation_android.data.repository.ProductRepository
import com.example.tp_ecommerce_formation_android.domain.mapper.toProductDetails
import com.example.tp_ecommerce_formation_android.ui.page.product.details.state.ProductDetailsState
import com.example.tp_ecommerce_formation_android.ui.routing.SearchRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: ProductRepository,
) : ViewModel() {

    private val navArgs = savedStateHandle.toRoute<SearchRoutes.ProductDetailsRoute>()
    private val productId = navArgs.productId

    private val _state: MutableState<ProductDetailsState> = mutableStateOf(ProductDetailsState.Loading)

    val state: State<ProductDetailsState>
        get() = _state

    init {
        viewModelScope.launch {
            delay(1_000)

            _state.value = ProductDetailsState.Success(repository.getById(productId)!!.toProductDetails())
        }

    }
}