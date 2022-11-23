//nama paket
package com.graceannafitrisinaga.retrofitfilm

//class untuk menangani data dari API dengan menggunakan primary contructor dimana parameternya menggunakan hak akses private pada properti retrofitService yang memanggil kelas RetrofitService
class MainRepository constructor(private val retrofitService: RetrofitService) {

    //meneruskan instance retrofitService untuk melakukan panggilan jaringan
    fun getAllMovies() = retrofitService.getAllMovies()
}
