//nama paket
package com.graceannafitrisinaga.retrofitfilm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.graceannafitrisinaga.retrofitfilm.databinding.ActivityMainBinding

//class ini digunakan untuk mengamati respons dari API dan memperbarui UI
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    
    //menggunakan viewBinding
    private lateinit var binding: ActivityMainBinding

    //menggunakan viewModel yang ada pada class MainViewModel
    lateinit var viewModel: MainViewModel

    //menggunakan retrofitService yang ada di class RetrofitService
    private val retrofitService = RetrofitService.getInstance()
    
    //menggunakan adapter pada fungsi MainAdapter()
    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        //mendapatkan instance ActivityMainBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        
        //menggunakan properti root untuk menggunakan ViewBinding agar dapat meengakses komponen GUI
        setContentView(binding.root)

        //membuat instance ViewModel menggunakan ViewModelProvider yang mengambil class MainViewModel pada class MyViewModelFactory, MainRepository, dan retrofitrService
        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)

        //viewBinding menggunakan adapter di recyclerview
        binding.recyclerview.adapter = adapter

        //mengobserbasi viewModel yang akan menampilkan list movie menggunakan adapter
        viewModel.movieList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setMovieList(it)
        })

        //dijalankan apabila viewModel yang diobservasi eror
        viewModel.errorMessage.observe(this, Observer {

        })
        
        //memanggil API
        viewModel.getAllMovies()
    }
}
