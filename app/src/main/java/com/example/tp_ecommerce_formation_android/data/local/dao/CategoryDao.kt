package com.example.tp_ecommerce_formation_android.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp_ecommerce_formation_android.data.local.model.CategoryEntity

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category")
    suspend fun getAll(): List<CategoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(categoryEntity: CategoryEntity)
}