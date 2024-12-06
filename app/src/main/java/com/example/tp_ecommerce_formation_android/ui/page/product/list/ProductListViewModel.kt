package com.example.tp_ecommerce_formation_android.ui.page.product.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.tp_ecommerce_formation_android.data.repository.ProductRepository
import com.example.tp_ecommerce_formation_android.data.source.ProductDataSource
import com.example.tp_ecommerce_formation_android.domain.mapper.toProduct
import com.example.tp_ecommerce_formation_android.ui.page.product.list.state.ProductListState
import com.example.tp_ecommerce_formation_android.ui.routing.SearchRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: ProductRepository,
) : ViewModel() {

    // On récupère la route que nous avons utilisé pour arriver dans la ProductListPage
    private val navArgs = savedStateHandle.toRoute<SearchRoutes.ProductListRoute>()
    // On peut ensuite la "décortiquer" pour récupérer notre categoryId
    private val categoryId = UUID.fromString(navArgs.categoryId)

    private val _state: MutableState<ProductListState> = mutableStateOf(ProductListState.Loading)

    val state: State<ProductListState>
        get() = _state

    init {
        viewModelScope.launch {
            // On lance d'abord le prepopulate
            ProductDataSource.getProducts().forEach { product ->
                repository.upsert(product)
            }

            delay(1_000)

            _state.value = repository.getAllByCategoryId(categoryId)
                .map { product -> product.toProduct() }
                .let { products -> ProductListState.Success(products) }
        }
    }
}