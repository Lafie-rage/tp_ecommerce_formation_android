package com.example.tp_ecommerce_formation_android.ui.page.category.list.v2

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tp_ecommerce_formation_android.data.source.CategoryDataSource
import com.example.tp_ecommerce_formation_android.domain.mapper.toCategory
import com.example.tp_ecommerce_formation_android.ui.component.category.CategoryItem
import com.example.tp_ecommerce_formation_android.ui.page.category.list.state.Category
import com.example.tp_ecommerce_formation_android.ui.page.category.list.v1.CategoryListViewModel

// Le Composable principal est simplement responsable de récupérer le viewModel
// et de transmettre le state décomposé au Composable Page
@Composable
fun CategoryListPage(
    onCategoryClicked: (Category) -> Unit,
    // Récupération du ViewModel via hiltViewModel() grâce à Hilt
    // On ne peut plus utiliser viewModel tout simplement
    viewModel: CategoryListViewModel = hiltViewModel(),
) {
    // On couple le state au Composable grâce à la délégation
    val state by viewModel.state

    state.apply {
        Page(
            categoryList = categories,
            onCategoryClicked = onCategoryClicked,
        )
    }
}

// Le composable Page affiche l'UI en fonction du state reçu
@Composable
private fun Page(
    categoryList: List<Category>,
    onCategoryClicked: (Category) -> Unit,
) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
    ) {
        items(categoryList) { category ->
            CategoryItem(category) {
                onCategoryClicked(category)
            }
        }
    }
}

// Dans la Preview, on utilise directement le state pour s'affranchir du ViewModel
@Preview
@Composable
fun CategoryListPagePreview() {
    val context = LocalContext.current
    Page(categoryList = CategoryDataSource.getCategories().map { it.toCategory() }) {
        Toast.makeText(context, "Category clicked : ${it.name}", Toast.LENGTH_SHORT).show()
    }
}