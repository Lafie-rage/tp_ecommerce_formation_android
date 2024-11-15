package com.example.tp_ecommerce_formation_android.data.source

import com.example.tp_ecommerce_formation_android.data.model.ProductDto
import java.util.UUID

object ProductDataSource {
    private val products = listOf(
        ProductDto(
            id = UUID.randomUUID(),
            name = "T-shirt",
            description = "Un t-shirt classique en coton.",
            isAvailable = true,
            price = 19.99,
            averageRate = 4.5,
            rateCount = 120,
            category = "Vêtements"
        ),
        ProductDto(
            id = UUID.randomUUID(),
            name = "Jean",
            description = "Un jean en denim confortable et élégant.",
            isAvailable = true,
            price = 49.99,
            averageRate = 4.2,
            rateCount = 85,
            category = "Vêtements"
        ),
        ProductDto(
            id = UUID.randomUUID(),
            name = "Sweat à capuche",
            description = "Un sweat à capuche confortable pour tous les jours.",
            isAvailable = false,
            price = 39.99,
            averageRate = 4.7,
            rateCount = 230,
            category = "Vêtements"
        ),
        ProductDto(
            id = UUID.randomUUID(),
            name = "Robe",
            description = "Une robe fluide et élégante.",
            isAvailable = true,
            price = 69.99,
            averageRate = 4.0,
            rateCount = 60,
            category = "Vêtements"
        ),
        ProductDto(
            id = UUID.randomUUID(),
            name = "Jupe",
            description = "Une jupe polyvalente pour toutes les occasions.",
            isAvailable = true,
            price = 34.99,
            averageRate = 3.8,
            rateCount = 45,
            category = "Vêtements"
        ),
        ProductDto(
            id = UUID.randomUUID(),
            name = "Pull",
            description = "Un pull chaud et élégant.",
            isAvailable = true,
            price = 59.99,
            averageRate = 4.6,
            rateCount = 180,
            category = "Vêtements"
        ),
        ProductDto(
            id = UUID.randomUUID(),
            name = "Veste",
            description = "Une veste légère à superposer.",
            isAvailable = false,
            price = 79.99,
            averageRate = 4.3,
            rateCount = 95,
            category = "Vêtements"
        ),
        ProductDto(
            id = UUID.randomUUID(),
            name = "Short",
            description = "Un short confortable pour l'été.",
            isAvailable = true,
            price = 24.99,
            averageRate = 3.9,
            rateCount = 55,
            category = "Vêtements"
        ),
        ProductDto(
            id = UUID.randomUUID(),
            name = "Chaussettes",
            description = "Un paquet de chaussettes confortables.",
            isAvailable = true,
            price = 9.99,
            averageRate = 4.1,
            rateCount = 75,
            category = "Accessoires"
        ),
        ProductDto(
            id = UUID.randomUUID(),
            name = "Chapeau",
            description = "Un chapeau élégant pour compléter votre look.",
            isAvailable = true,
            price = 14.99,
            averageRate = 4.4,
            rateCount = 110,
            category = "Accessoires"
        )
    )

    fun getProducts(): List<ProductDto> {
        return products
    }

}