package com.example.tp_ecommerce_formation_android.ui.page.product.details

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tp_ecommerce_formation_android.R
import com.example.tp_ecommerce_formation_android.ui.component.shared.ErrorPage
import com.example.tp_ecommerce_formation_android.ui.component.shared.Loader
import com.example.tp_ecommerce_formation_android.ui.page.product.details.state.ProductDetails
import com.example.tp_ecommerce_formation_android.ui.page.product.details.state.ProductDetailsState
import com.example.tp_ecommerce_formation_android.ui.page.product.list.state.ProductListState
import java.text.NumberFormat
import java.util.UUID

@Composable
fun ProductDetailsPage(
    viewModel: ProductDetailsViewModel = hiltViewModel(),
) {
    val state by viewModel.state

    when (state) {
        is ProductDetailsState.Loading -> Loader()

        is ProductDetailsState.Success -> {
            val product = (state as ProductDetailsState.Success).product
            Page(
                product = product,
            )
        }

        is ProductDetailsState.Error -> {
            val message = (state as ProductDetailsState.Error).message
            ErrorPage(
                reason = message,
                userMessage = stringResource(R.string.error_while_loading_product),
            )
        }
    }
}

@Composable
fun Page(
    product: ProductDetails,
) {
    val price = NumberFormat.getCurrencyInstance().format(product.price)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f),
                painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                contentDescription = null
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(24.dp),
            ) {
                Column {
                    Text(
                        text = product.name,
                        style = MaterialTheme.typography.headlineSmall,
                    )
                    Text(
                        text = product.category,
                        style = MaterialTheme.typography.titleMedium,
                    )
                    Text(
                        text = price,
                        style = MaterialTheme.typography.titleSmall,
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {

                        }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_cart),
                            contentDescription = null
                        )
                        Text(text = stringResource(R.string.add_to_cart))
                    }
                    IconButton(onClick = {

                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star_outlined),
                            contentDescription = stringResource(R.string.add_to_favorite)
                        )
                    }
                }
            }
        }
        Text(
            text = product.description,
            style = MaterialTheme.typography.bodyMedium,
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                repeat(5) {
                    val resource = when {
                        product.averageRate >= it + 1 -> {
                            R.drawable.ic_star_filled
                        }

                        product.averageRate >= it + 0.5 -> {
                            R.drawable.ic_star_half_filled
                        }

                        else -> {
                            R.drawable.ic_star_outlined
                        }
                    }
                    Icon(
                        painter = painterResource(id = resource),
                        contentDescription = null,
                    )
                }
            }
            Text(
                text = stringResource(R.string.rate_count, product.averageRate, product.rateCount),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

@Composable
@Preview
fun ProductDetailsPagePreview() {
    Page(
        ProductDetails(
            id = 1,
            name = "T-shirt",
            description = "Un t-shirt classique en coton.",
            isAvailable = true,
            price = 19.99,
            averageRate = 4.5,
            rateCount = 10,
            category = "Vêtements",
        )
    )
}