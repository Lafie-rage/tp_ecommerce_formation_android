package com.example.tp_ecommerce_formation_android.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.UUID

// Avec Entity, on indique que cette classe représente une table dans la BDD
// Room se chargera de transformer toutes les classes Entity pour qu'elles
// soient mappées avec les données de la BDD de leur table associée
@Entity(
    // Par défaut, la table porte le nom de la classe en camelCase
    // On le modifie pour qu'elle s'appelle simplement "products"
    tableName = "products",
    // On défini des indexes sur les colonnes permettant d'identifier
    // un (groupe de) produit(s)
    // N.B. pas besoin d'ajouter id, la PrimaryKey est indexée par défaut
    indices = [
        Index("remote_id"),
        Index("category_id"),
    ],
)
data class ProductEntity(
    // Pour gagner en rapidité de traitement, on préferera les ID au format Int ou Long
    // Même si SQLite serait gérer les UUID, les nombres présentent les avantages
    // d'être triables facilement (donc plus facile de déterminer leur position dans
    // une liste) et de demander moins d'espace de stockage
    // Ca augmentera donc la performance des indexes
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") // On redéfini le nom de la colonne en BDD pour qu'il soit "id"
    val localId: Int,
    // Comme pour le nom de la table, par défault les champs portent
    // le nom de la propriété en camelCase
    @ColumnInfo("remote_id")
    val remoteId: UUID,
    val name: String,
    val description: String,
    @ColumnInfo("is_available")
    val isAvailable: Boolean,
    val price: Double,
    @ColumnInfo("average_rate")
    val averageRate: Double,
    @ColumnInfo("rate_count")
    val rateCount: Int,
    @ColumnInfo("category_id")
    val categoryId: UUID,
)
