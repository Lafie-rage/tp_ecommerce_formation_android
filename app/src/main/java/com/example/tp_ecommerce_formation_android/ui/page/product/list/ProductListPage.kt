package com.example.tp_ecommerce_formation_android.ui.page.product.list

import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tp_ecommerce_formation_android.data.source.ProductDataSource
import com.example.tp_ecommerce_formation_android.domain.mapper.toProduct
import com.example.tp_ecommerce_formation_android.ui.component.product.ProductItem
import com.example.tp_ecommerce_formation_android.ui.page.product.list.state.Product

@Composable
fun ProductListPage(
    onProductClicked: (Product) -> Unit,
    viewModel: ProductListViewModel = hiltViewModel(),
) {

    val state by viewModel.state

    state.apply {
        Page(
            productList = products,
            onProductClicked = onProductClicked,
        )
    }
}

@Composable
private fun Page(
    productList: List<Product>,
    onProductClicked: (Product) -> Unit,
) {
    LazyColumn {
        items(productList) { product ->
            ProductItem(product) {
                onProductClicked(product)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductListPagePreview() {
    val context = LocalContext.current

    Page(
        productList = ProductDataSource.getProducts().map { it.toProduct() },
    ) {
        Toast.makeText(context, "Product clicked: ${it.name}", Toast.LENGTH_SHORT).show()
    }
}