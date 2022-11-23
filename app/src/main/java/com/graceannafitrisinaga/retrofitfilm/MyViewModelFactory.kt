//nama paket
package com.graceannafitrisinaga.retrofitfilm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//class ViewModelFactory yang menggunakan parameter konstruktor untuk mendapatkan repository yang ada pada class MainRepository
class MyViewModelFactory constructor(private val repository: MainRepository): ViewModelProvider.Factory {

    //menggunakan viewModel pada class T dengan membuat kelas model pada class T
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //mengembalikan viewModel yang ada di repository sebagai class T jika class model ditetapkan dari class MainViewModel java
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        //dijalankan ketika kondisi if terjadi masalah sehingga dapat menampilkan pesan ViewModel tidak ditemukan
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
