package com.example.tp_ecommerce_formation_android.ui.page.category.list.v2

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.tp_ecommerce_formation_android.data.source.CategoryDataSource
import com.example.tp_ecommerce_formation_android.domain.mapper.toCategory
import com.example.tp_ecommerce_formation_android.ui.component.category.CategoryItem
import com.example.tp_ecommerce_formation_android.ui.page.category.list.state.Category

@Composable
fun CategoryListPage(
    categoryList: List<Category>,
    onItemClicked: (Category) -> Unit,
) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
    ) {
        items(categoryList) { category ->
           CategoryItem(category) {
               onItemClicked(category)
           }
        }
    }
}

@Preview
@Composable
fun CategoryListPagePreview() {
    val context = LocalContext.current
    CategoryListPage(
        categoryList = CategoryDataSource.getCategories().map { it.toCategory() }
    ) {
        Toast.makeText(context, "Category clicked : ${it.name}", Toast.LENGTH_SHORT).show()
    }
}