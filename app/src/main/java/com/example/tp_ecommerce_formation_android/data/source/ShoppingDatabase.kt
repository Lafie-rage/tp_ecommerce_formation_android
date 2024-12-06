package com.example.tp_ecommerce_formation_android.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tp_ecommerce_formation_android.data.local.dao.ProductDao
import com.example.tp_ecommerce_formation_android.data.local.model.ProductEntity

// On annote cette classe avec @Database
@Database(
    // On références toutes nos entities
    entities = [ProductEntity::class],
    version = 1
)
abstract class ShoppingDatabase: RoomDatabase() {

    // Dans cette classe, on définit les méthodes abstraites
    // qui permettent d'accéder à l'instance de nos DAO
    abstract fun productDao(): ProductDao
}