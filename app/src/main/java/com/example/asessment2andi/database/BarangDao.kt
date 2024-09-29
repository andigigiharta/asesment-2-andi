package com.example.asessment2andi.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.asessment2andi.model.Barang
import kotlinx.coroutines.flow.Flow

@Dao
interface BarangDao {
    @Insert
    suspend fun insert(barang: Barang)
    @Update
    suspend fun update(barang: Barang)
    @Query("SELECT * FROM barang ORDER BY stok DESC")
    fun getBarang(): Flow<List<Barang>>
    @Query("SELECT * FROM barang WHERE id = :id")
    suspend fun getBarangById(id: Long): Barang?
    @Query("DELETE FROM barang WHERE id = :id")
    suspend fun deleteById(id: Long)
}