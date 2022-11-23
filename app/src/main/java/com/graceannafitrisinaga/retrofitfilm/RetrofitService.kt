//nama paket
package com.graceannafitrisinaga.retrofitfilm

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//interface untuk definisi panggilan API
interface RetrofitService {

    @GET("movielist.json")
    fun getAllMovies() : Call<List<Movie>>

    //instance retrofitService menggunakan retrofit
    companion object {

        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    //API yang digunakan untuk mengambil data
                    .baseUrl("https://howtodoandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}
