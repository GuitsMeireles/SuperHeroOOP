package com.oop.herosoop.network

import com.oop.herosoop.model.SuperHero
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {
    @GET("all.json")
    fun getAll() : Call<List<SuperHero>>
}