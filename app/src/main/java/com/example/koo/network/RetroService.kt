package com.example.koo.network

import com.example.koo.model.RecyclerList
import retrofit2.http.GET

interface RetroService {

    @GET("public/v1/posts")
    suspend fun getDataFromApi( ): RecyclerList
}