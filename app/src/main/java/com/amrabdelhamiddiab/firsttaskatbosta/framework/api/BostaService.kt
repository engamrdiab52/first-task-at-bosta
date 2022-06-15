package com.amrabdelhamiddiab.firsttaskatbosta.framework.api

import com.amrabdelhamiddiab.core.data.Album
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface BostaService {
    @GET("albums")
    suspend fun fetchAlbumsOfSingleUser(@Query("userId") userId: Long): List<Album>?


    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun create(): BostaService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(BostaService::class.java)
        }

    }

}