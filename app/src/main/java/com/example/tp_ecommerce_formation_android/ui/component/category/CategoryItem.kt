package com.example.tp_ecommerce_formation_android.ui.component.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp_ecommerce_formation_android.R
import com.example.tp_ecommerce_formation_android.ui.page.category.list.state.Category
import java.util.UUID

@Composable
fun CategoryItem(
    category: Category,
    onItemClicked: () -> Unit = {},
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .background(MaterialTheme.colorScheme.surfaceContainerLow)
            .clickable { onItemClicked() },
        shape = MaterialTheme.shapes.medium,
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = category.name,
                style = MaterialTheme.typography.titleMedium,
            )
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(android.R.drawable.ic_menu_gallery),
                contentDescription = stringResource(R.string.category_image, category.name)
            )
        }
    }
}

@Composable
@Preview
fun CategoryItemPreview() {
    CategoryItem(
        category = Category(
            id = UUID.randomUUID(),
            name = "Catégorie 1",
        )
    )
}