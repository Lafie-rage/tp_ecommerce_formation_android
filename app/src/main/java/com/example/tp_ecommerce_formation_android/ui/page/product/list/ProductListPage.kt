package com.example.tp_ecommerce_formation_android.ui.page.product.list

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tp_ecommerce_formation_android.R
import com.example.tp_ecommerce_formation_android.data.source.ProductDataSource
import com.example.tp_ecommerce_formation_android.domain.mapper.toProduct
import com.example.tp_ecommerce_formation_android.ui.component.product.ProductItem
import com.example.tp_ecommerce_formation_android.ui.component.shared.ErrorPage
import com.example.tp_ecommerce_formation_android.ui.component.shared.Loader
import com.example.tp_ecommerce_formation_android.ui.page.product.list.state.Product
import com.example.tp_ecommerce_formation_android.ui.page.product.list.state.ProductListState

@Composable
fun ProductListPage(
    onProductClicked: (Product) -> Unit,
    viewModel: ProductListViewModel = hiltViewModel(),
) {

    val state by viewModel.state

    when (state) {
        is ProductListState.Loading -> Loader()

        is ProductListState.Success -> {
            val products = (state as ProductListState.Success).products
            if (products.isEmpty()) {
                Text(stringResource(R.string.empty_product_list))
            } else {
                Page(
                    productList = products,
                    onProductClicked = onProductClicked,
                )
            }
        }

        is ProductListState.Error -> {
            val message = (state as ProductListState.Error).message
            ErrorPage(
                reason = message,
                userMessage = stringResource(R.string.error_while_loading_product_list),
            )
        }
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