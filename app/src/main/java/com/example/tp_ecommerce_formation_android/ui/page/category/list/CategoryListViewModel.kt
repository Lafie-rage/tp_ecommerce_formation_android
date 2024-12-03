package com.example.tp_ecommerce_formation_android.ui.page.category.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.tp_ecommerce_formation_android.data.repository.CategoryRepository
import com.example.tp_ecommerce_formation_android.domain.mapper.toCategory
import com.example.tp_ecommerce_formation_android.ui.page.category.list.state.CategoryListState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryListViewModel @Inject constructor(
    private val repository: CategoryRepository,
) : ViewModel() {
    // Notre référence interne du state, elle est modifiable.
    private val _state: MutableState<CategoryListState> = buildState()

    // Notre state exposé à l'extérieur comme non modifiable
    val state: State<CategoryListState>
        get() = _state

    /**
     * Construit le state de notre view à partir de la liste des catégories du mock
     */
    private fun buildState(): MutableState<CategoryListState> =
        mutableStateOf(
            repository.getAll()
                .map { category -> category.toCategory() }
                .let { categories -> CategoryListState(categories) }
        )
}