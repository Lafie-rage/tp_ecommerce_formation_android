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
import com.example.tp_ecommerce_formation_android.ui.page.product.list.state.Product
import com.example.tp_ecommerce_formation_android.ui.page.product.list.state.ProductListState

@Composable
fun ProductListPage(
    onProductClicked: (Product) -> Unit,
    viewModel: ProductListViewModel = hiltViewModel(),
) {

    val state by viewModel.state

    when (state) {
        // Si l'état est Loading, on affiche un loader
        is ProductListState.Loading -> Box(
            // On ajoute une petit bordure en haut pour séparer le loader
            modifier = Modifier.padding(top = 16.dp),
            // On veut le loader en haut au centre de la page.
            contentAlignment = Alignment.TopCenter
        ) {
            CircularProgressIndicator()
        }

        is ProductListState.Success -> {
            val products = (state as ProductListState.Success).products
            if (products.isEmpty()) {
                // Pour améliorer l'UX, on affiche un message indiquant que la
                // liste est vide si c'est le cas
                Text(stringResource(R.string.empty_product_list))
            } else {
                // Sinon on affiche la liste
                Page(
                    productList = products,
                    onProductClicked = onProductClicked,
                )
            }
        }

        is ProductListState.Error -> {
            // A cause du delegate, il n'y a pas de smart cast de state en Error
            // Il faut donc faire le cast manuellement
            val message = (state as ProductListState.Error).message
            Toast.makeText(LocalContext.current, "Error due to : $message", Toast.LENGTH_SHORT)
                .show()
            // On affiche un message pour informer l'utilisateur de l'erreur
            Text(stringResource(R.string.error_while_loading_product_list))
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