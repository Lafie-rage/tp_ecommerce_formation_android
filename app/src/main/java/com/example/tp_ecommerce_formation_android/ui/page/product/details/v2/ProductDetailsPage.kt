package com.example.tp_ecommerce_formation_android.ui.page.product.details.v2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp_ecommerce_formation_android.R
import com.example.tp_ecommerce_formation_android.ui.page.product.details.state.ProductDetails
import java.text.NumberFormat
import java.util.UUID

@Composable
fun ProductDetailsPage(
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
    ProductDetailsPage(
        ProductDetails(
            id = UUID.randomUUID(),
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