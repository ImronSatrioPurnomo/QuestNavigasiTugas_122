package com.example.questnavigasitugas_122.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.questnavigasitugas_122.model.Peserta

class PesertaViewModel : ViewModel() {

    // List penyimpanan peserta
    val daftar = mutableStateListOf<Peserta>()

    // Fungsi untuk menambah data
    fun add(p: Peserta) {
        daftar.add(p)
    }
}
