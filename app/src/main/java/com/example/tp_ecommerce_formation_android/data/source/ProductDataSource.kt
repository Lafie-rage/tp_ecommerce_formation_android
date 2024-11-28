package com.example.tp_ecommerce_formation_android.data.source

import com.example.tp_ecommerce_formation_android.ui.page.product.list.state.Product

object ProductDataSource {
    private val products = listOf(
        Product(
            name = "T-shirt",
            description = "Un t-shirt classique en coton.",
            isAvailable = true,
            price = 19.99
        ),
        Product(
            name = "Jean",
            description = "Un jean en denim confortable et élégant.",
            isAvailable = true,
            price = 49.99
        ),
        Product(
            name = "Sweat à capuche",
            description = "Un sweat à capuche confortable pour tous les jours.",
            isAvailable = false,
            price = 39.99
        ),
        Product(
            name = "Robe",
            description = "Une robe fluide et élégante.",
            isAvailable = true,
            price = 69.99
        ),
        Product(
            name = "Jupe",
            description = "Une jupe polyvalente pour toutes les occasions.",
            isAvailable = true,
            price = 34.99
        ),
        Product(
            name = "Pull",
            description = "Un pull chaud et élégant.",
            isAvailable = true,
            price = 59.99
        ),
        Product(
            name = "Veste",
            description = "Une veste légère à superposer.",
            isAvailable = false,
            price = 79.99
        ),
        Product(
            name = "Short",
            description = "Un short confortable pour l'été.",
            isAvailable = true,
            price = 24.99
        ),
        Product(
            name = "Chaussettes",
            description = "Un paquet de chaussettes confortables.",
            isAvailable = true,
            price = 9.99
        ),
        Product(
            name = "Chapeau",
            description = "Un chapeau élégant pour compléter votre look.",
            isAvailable = true,
            price = 14.99
        )
    )

    fun getProducts(): List<Product> {
        return products
    }

}