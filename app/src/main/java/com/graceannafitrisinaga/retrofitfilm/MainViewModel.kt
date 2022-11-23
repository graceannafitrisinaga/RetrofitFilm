//nama paket
package com.graceannafitrisinaga.retrofitfilm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//class viewModel menggunakan parameter konstruktor repository yang menggunakan class MainRepository
class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    //membuat properti movieList menggunakan LiveData pada List Movie
    val movieList = MutableLiveData<List<Movie>>()
    
    //membuat pesan eror menggunakan LiveData dengan tipe data String
    val errorMessage = MutableLiveData<String>()

    //fungsi untuk mendapatkan semua movie
    fun getAllMovies() {

        //membuat response untuk mengambil semua movie yang ada di repository
        val response = repository.getAllMovies()
        response.enqueue(object : Callback<List<Movie>> {
            //fungsi untuk menampilkan list Movie jika properti response berhasil memanggil List movie
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                movieList.postValue(response.body())
            }

            //fungsi untuk memanggil List Movie dan jika terdapat masalah maka akan menampilkan pesan eror
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}
