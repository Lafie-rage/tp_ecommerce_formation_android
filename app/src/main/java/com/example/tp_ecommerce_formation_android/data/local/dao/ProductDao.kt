package com.example.tp_ecommerce_formation_android.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp_ecommerce_formation_android.data.local.model.ProductEntity
import java.util.UUID

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    suspend fun getAll(): List<ProductEntity>

    @Query("SELECT * FROM products WHERE category_id = :categoryId")
    suspend fun getByCategoryId(categoryId: UUID): List<ProductEntity>

    @Query("SELECT * FROM products WHERE id = :id")
    suspend fun getById(id: Int): ProductEntity?

    // Update ou insert si l'objet existe déjà
    // On utilise @Insert pour créer un INSERT SQL
    // Avec le onConflict = OnConflictStrategy.REPLACE,
    // si l'objet existe déjà, il sera mis à jour
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(product: ProductEntity)
}