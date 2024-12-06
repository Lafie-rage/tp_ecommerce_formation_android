package com.example.tp_ecommerce_formation_android.ui.page.category.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp_ecommerce_formation_android.data.repository.CategoryRepository
import com.example.tp_ecommerce_formation_android.data.source.CategoryDataSource
import com.example.tp_ecommerce_formation_android.domain.mapper.toCategory
import com.example.tp_ecommerce_formation_android.ui.page.category.list.state.CategoryListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryListViewModel @Inject constructor(
    private val repository: CategoryRepository,
) : ViewModel() {
    private val _state: MutableState<CategoryListState> = mutableStateOf(CategoryListState.Loading)

    val state: State<CategoryListState>
        get() = _state

    init {
        viewModelScope.launch {
            CategoryDataSource.getCategories().forEach { category ->
                repository.upsert(category)
            }

            _state.value = repository.getAll()
                    .map { category -> category.toCategory() }
                    .let { categories -> CategoryListState.Success(categories) }
        }
    }
}