package com.example.asessment2andi.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.asessment2andi.database.BarangDao
import com.example.asessment2andi.model.Barang
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val dao: BarangDao) : ViewModel() {

    fun insert (judul: String, desk: String, stok: String){
        val barang = Barang(
            nama = judul,
            ket = desk,
            stok = stok,
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(barang)
        }
    }
    suspend fun getBarang(id: Long): Barang?{
        return dao.getBarangById(id)
    }

    fun update(id: Long, nama: String, ket: String, stok: String){
        val barang = Barang(
            id = id,
            nama = nama,
            ket = ket,
            stok = stok
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(barang)
        }
    }

    fun delete(id: Long){
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}