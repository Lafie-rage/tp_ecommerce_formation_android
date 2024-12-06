package com.example.tp_ecommerce_formation_android.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(
    tableName = "category",
)
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val localId: Int,
    @ColumnInfo("remote_id")
    val remoteId: UUID,
    val name: String,
)
