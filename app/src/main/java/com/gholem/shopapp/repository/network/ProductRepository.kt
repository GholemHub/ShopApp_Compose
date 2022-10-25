package com.gholem.shopapp.repository.network

import com.gholem.shopapp.repository.network.dto.product.ProductResponse
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun genreList(): Flow<DataState<ProductResponse>>
}