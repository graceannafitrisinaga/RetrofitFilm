//nama paket
package com.graceannafitrisinaga.retrofitfilm

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//interface untuk definisi panggilan API
interface RetrofitService {

    //metode untuk mengambil file json bernama movielist.json
    @GET("movielist.json")
    //fungsi untuk mendapatkan seluruh movie dengan memanggil List Movie
    fun getAllMovies() : Call<List<Movie>>

    //instance retrofitService menggunakan retrofit
    companion object {

        //properti retrofitService pada class RetrofitService sama dengan null
        var retrofitService: RetrofitService? = null

        //fungsi untuk mendapatkan instance pada class RetrofitService
        fun getInstance() : RetrofitService {

            //jika properti retrofitService adalah null
            if (retrofitService == null) {
                //class Retrofit.builder yang menggunakan Builder API untuk memungkinkan penentuan titik akhir URL untuk operasi HTTP dan membuat Retrofitinstance baru. 
                val retrofit = Retrofit.Builder()
                    //API yang digunakan untuk mendapatkan daftar film
                    .baseUrl("https://howtodoandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                //retrofitService yang membuat retrofit pada class RetrofitService java
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            //mengembalikan retrofitService
            return retrofitService!!
        }
    }
}
