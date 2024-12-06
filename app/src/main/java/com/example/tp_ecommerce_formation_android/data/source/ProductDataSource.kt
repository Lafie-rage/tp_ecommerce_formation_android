package com.example.tp_ecommerce_formation_android.data.source

import com.example.tp_ecommerce_formation_android.data.model.ProductDto
import com.example.tp_ecommerce_formation_android.data.source.CategoryDataSource.getCategories
import java.util.UUID

object ProductDataSource {
    private val products = listOf(
        // Vétements
        ProductDto(
            id = 1,
            name = "T-shirt",
            description = "Un t-shirt classique en coton.",
            isAvailable = true,
            price = 19.99,
            averageRate = 4.5,
            rateCount = 120,
            categoryId = getCategories()[0].id,
        ),
        ProductDto(
            id = 2,
            name = "Jean",
            description = "Un jean en denim confortable et élégant.",
            isAvailable = true,
            price = 49.99,
            averageRate = 4.2,
            rateCount = 85,
            categoryId = getCategories()[0].id
        ),
        ProductDto(
            id = 3,
            name = "Sweat à capuche",
            description = "Un sweat à capuche confortable pour tous les jours.",
            isAvailable = false,
            price = 39.99,
            averageRate = 4.7,
            rateCount = 230,
            categoryId = getCategories()[0].id
        ),
        ProductDto(
            id = 4,
            name = "Robe",
            description = "Une robe fluide et élégante.",
            isAvailable = true,
            price = 69.99,
            averageRate = 4.0,
            rateCount = 60,
            categoryId = getCategories()[0].id
        ),
        ProductDto(
            id = 5,
            name = "Jupe",
            description = "Une jupe polyvalente pour toutes les occasions.",
            isAvailable = true,
            price = 34.99,
            averageRate = 3.8,
            rateCount = 45,
            categoryId = getCategories()[0].id
        ),
        ProductDto(
            id = 6,
            name = "Pull",
            description = "Un pull chaud et élégant.",
            isAvailable = true,
            price = 59.99,
            averageRate = 4.6,
            rateCount = 180,
            categoryId = getCategories()[0].id
        ),
        ProductDto(
            id = 7,
            name = "Veste",
            description = "Une veste légère à superposer.",
            isAvailable = false,
            price = 79.99,
            averageRate = 4.3,
            rateCount = 95,
            categoryId = getCategories()[0].id
        ),
        ProductDto(
            id = 8,
            name = "Short",
            description = "Un short confortable pour l'été.",
            isAvailable = true,
            price = 24.99,
            averageRate = 3.9,
            rateCount = 55,
            categoryId = getCategories()[0].id
        ),
        ProductDto(
            id = 9,
            name = "T-shirt",
            description = "Un t-shirt classique en coton.",
            isAvailable = true,
            price = 19.99,
            averageRate = 4.5,
            rateCount = 120,
            categoryId = getCategories()[0].id
        ),
        ProductDto(
            id = 10,
            name = "Jean",
            description = "Un jean en denim confortable et élégant.",
            isAvailable = true,
            price = 49.99,
            averageRate = 4.2,
            rateCount = 85,
            categoryId = getCategories()[0].id
        ),

        // Accessoires
        ProductDto(
            id = 11,
            name = "Chaussettes",
            description = "Un paquet de chaussettes confortables.",
            isAvailable = true,
            price = 9.99,
            averageRate = 4.1,
            rateCount = 75,
            categoryId = getCategories()[1].id
        ),
        ProductDto(
            id = 12,
            name = "Chapeau",
            description = "Un chapeau élégant pour compléter votre look.",
            isAvailable = true,
            price = 14.99,
            averageRate = 4.4,
            rateCount = 110,
            categoryId = getCategories()[1].id
        ),
        ProductDto(
            id = 13,
            name = "Montre",
            description = "Une montre élégante et pratique.",
            isAvailable = true,
            price = 99.99,
            averageRate = 4.8,
            rateCount = 200,
            categoryId = getCategories()[1].id
        ),
        ProductDto(
            id = 14,
            name = "Sac à main",
            description = "Un sac à main élégant pour toutes vos affaires.",
            isAvailable = true,
            price = 149.99,
            averageRate = 4.6,
            rateCount = 180,
            categoryId = getCategories()[1].id
        ),

        // Chaussures
        ProductDto(
            id = 15,
            name = "Chaussures de sport",
            description = "Des chaussures idéales pour courir ou marcher.",
            isAvailable = true,
            price = 89.99,
            averageRate = 4.5,
            rateCount = 250,
            categoryId = getCategories()[2].id
        ),
        ProductDto(
            id = 16,
            name = "Sandales",
            description = "Des sandales légères parfaites pour l'été.",
            isAvailable = true,
            price = 39.99,
            averageRate = 4.0,
            rateCount = 100,
            categoryId = getCategories()[2].id
        ),
        // Livres
        ProductDto(
            id = 17,
            name = "Roman policier",
            description = "Un roman captivant plein de suspense.",
            isAvailable = true,
            price = 14.99,
            averageRate = 4.7,
            rateCount = 320,
            categoryId = getCategories()[4].id
        ),
        ProductDto(
            id = 18,
            name = "Livre de cuisine",
            description = "Un livre rempli de recettes délicieuses.",
            isAvailable = true,
            price = 29.99,
            averageRate = 4.5,
            rateCount = 140,
            categoryId = getCategories()[4].id
        ),
        // Sports
        ProductDto(
            id = 19,
            name = "Ballon de football",
            description = "Un ballon de football de haute qualité.",
            isAvailable = true,
            price = 19.99,
            averageRate = 4.6,
            rateCount = 180,
            categoryId = getCategories()[5].id
        ),
        ProductDto(
            id = 20,
            name = "Tapis de yoga",
            description = "Un tapis de yoga confortable et antidérapant.",
            isAvailable = true,
            price = 24.99,
            averageRate = 4.8,
            rateCount = 220,
            categoryId = getCategories()[5].id
        )
    )

    fun getProducts(): List<ProductDto> {
        return products
    }
}