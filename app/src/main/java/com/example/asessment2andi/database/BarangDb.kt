package com.example.asessment2andi.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.asessment2andi.model.Barang

@Database(entities = [Barang::class], version = 1, exportSchema = false)
abstract class BarangDb : RoomDatabase() {
    abstract val dao: BarangDao
    companion object {
        @Volatile
        private var INSTACE: BarangDb? = null
        fun getInstance(context: Context): BarangDb {
            synchronized(this) {
                var instance = INSTACE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BarangDb::class.java,
                        "barang.db"
                    ).build()
                    INSTACE = instance
                }
                return instance
            }
        }
    }
}