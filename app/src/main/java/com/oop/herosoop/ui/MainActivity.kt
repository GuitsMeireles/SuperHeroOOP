package com.oop.herosoop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.oop.herosoop.databinding.ActivityMainBinding
import com.oop.herosoop.model.SuperHero
import com.oop.herosoop.network.Endpoint
import com.oop.herosoop.network.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
    }

    private fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://akabab.github.io/superhero-api/api/")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getAll()

        callback.enqueue(object : Callback<List<SuperHero>> {
            override fun onFailure(call: Call<List<SuperHero>>, t: Throwable) {
                Log.i("guits", "ERROR")
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<List<SuperHero>>,
                response: Response<List<SuperHero>>
            ) {
                //TODO: colocar Response no recyclerview
                Log.i("guits", "SUCESSO")
                Log.i("guits", response.body().toString())

                response.body()?.let {
                    setUpRecyclerView(it)
                }

            }
        })


    }

    private fun setUpRecyclerView(dataSet: List<SuperHero>) {
        val rcView = binding.rcView

        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = SuperHeroAdapter(dataSet)
    }
}