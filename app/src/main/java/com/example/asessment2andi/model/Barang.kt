package com.example.asessment2andi.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "barang")
data class Barang (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nama: String,
    val ket: String,
    val stok: String,
)