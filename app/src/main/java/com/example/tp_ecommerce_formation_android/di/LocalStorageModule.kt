package com.example.tp_ecommerce_formation_android.di

import android.content.Context
import androidx.room.Room
import com.example.tp_ecommerce_formation_android.data.local.dao.ProductDao
import com.example.tp_ecommerce_formation_android.data.source.ShoppingDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// On définit le module Hilt
@Module
// On indique que ces instances sont à créer à l'échelle
// de l'application entière. Ce sont de vrais singletons.
@InstallIn(SingletonComponent::class)
object LocalStorageModule {

    // On indique à Hilt que cette instance doit être un Singleton
    @Singleton
    @Provides
    fun createDatabase(
        // Puisque notre instance est un Singleton de l'application entière
        // on utilise le contexte de l'application pour la créer.
        // Il existe aussi ActivityContext pour récupérer celui de l'Activity.
        @ApplicationContext context: Context
    ): ShoppingDatabase = Room.databaseBuilder(
            context,
            // La classe de la base de données
            ShoppingDatabase::class.java,
            // Le nom du fichier qui sera créé
            "shopping-db.db"
        ).build()

    @Singleton
    @Provides
    fun createProductDao(
        // En référençant ShoppingDatabase ici, Hilt sait qu'il doit
        // d'abord créer l'instance de ShoppingDatabase avant d'appeler
        // cette méthode pour lui donner.
        database: ShoppingDatabase
    ): ProductDao =  database.productDao()
}