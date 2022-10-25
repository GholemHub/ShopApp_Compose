package com.gholem.shopapp.repository.network.api

import com.gholem.shopapp.repository.network.dto.product.ProductResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {
    @GET("/v2/exchanges")
    suspend fun getExchanges(): ProductResponse
}