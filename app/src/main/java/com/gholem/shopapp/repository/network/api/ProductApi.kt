package com.gholem.shopapp.repository.network.api

import retrofit2.http.GET

interface ProductApi {
    @GET("/products")
    suspend fun getExchanges(): ArrayList<ProductResponse>
}

