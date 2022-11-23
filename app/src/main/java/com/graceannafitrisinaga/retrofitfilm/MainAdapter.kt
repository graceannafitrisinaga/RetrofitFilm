//nama paket
package com.graceannafitrisinaga.retrofitfilm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.graceannafitrisinaga.retrofitfilm.databinding.AdapterMovieBinding

//class adapter untuk recyclerview untuk menyetel semua item ke dalam recyclerview
class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {

    //menggunakan properti movies untuk membuat MutableList Interface Movie
    var movies = mutableListOf<Movie>()

    //mengembalikan instance MutableList Interface Movie dan merefresh setiap perulangan item
    fun setMovieList(movies: List<Movie>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        //menggunakan LayoutInflater pada inflater untuk menghubungkan layout atau activity yang digunakan
        val inflater = LayoutInflater.from(parent.context)

        //menggunakan viewBinding pada inflater di adapter movie
        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    //menggunakan viewBinding untuk mengambil nama movie dan gambar movie pada class holder
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
       holder.binding.name.text = movie.name
        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)

    }

    //mengembalikan ukuran movie ketika menghitung item
    override fun getItemCount(): Int {
        return movies.size
    }
}

//class Holder yang menggunakan viewBinding pada Adapter dan RecyclerView
class MainViewHolder(val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {

}
