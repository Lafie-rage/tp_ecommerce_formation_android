package com.example.tp_ecommerce_formation_android.ui.component.product

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp_ecommerce_formation_android.R
import com.example.tp_ecommerce_formation_android.ui.page.product.list.state.Product
import java.text.NumberFormat
import java.util.UUID

@Composable
fun ProductItem(
    product: Product,
    onItemClicked: () -> Unit,
) {
    val formater = NumberFormat.getCurrencyInstance()
    val price = formater.format(product.price)

    val status = if (product.isAvailable) {
        stringResource(R.string.available)
    } else {
        stringResource(R.string.unavailable)
    }

    Row(
        modifier = Modifier
            .padding(16.dp)
            .height(120.dp)
            .fillMaxWidth()
            .clickable { onItemClicked() },
        // Défini un espacement de 16 DP entre chaques éléments de la Row
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        // Centre les éléments verticalement
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                // L'image fait 120 DP de hauteur
                .fillMaxHeight()
                // Avec un ratio hauteur/largeur de 1
                .aspectRatio(1f),
            // Avec painterResoource, on accède à un drawable
            painter = painterResource(id = android.R.drawable.ic_menu_gallery),
            // Avec stringResource on accède à une string resource
            // Le deuxième argument est dû à l'utilisation d'une chaîne formattée
            contentDescription = stringResource(R.string.product_image, product.name),
        )
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            // On utilise une Column ici pour regrouper le nom et la description dans un bloc
            // Ce bloc peut alors être espacé du prix et status grâce au SpaceBetween plus haut
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    // Double interpolation de chaîne de caractère
                    // Inutile d'utiliser une string resource ici puisqu'il n'y a pas de texte traductible
                    text = "$status • $price",
                    style = MaterialTheme.typography.bodySmall,
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = stringResource(R.string.next)
                )
            }
        }
    }
}

@Preview
@Composable
fun ProductItemPreview() {
    val context = LocalContext.current
    ProductItem(
        product = Product(
            id = UUID.randomUUID(),
            name = "T-shirt",
            description = "Un t-shirt classique en coton.",
            isAvailable = true,
            price = 19.99,
        )
    ) {
        Toast.makeText(context, "Product clicked", Toast.LENGTH_SHORT).show()
    }
}