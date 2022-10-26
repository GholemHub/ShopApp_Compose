package com.gholem.shopapp.repository.network

import com.gholem.shopapp.domain.model.ProductModelData
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun fetchListOfProductsFromAPI(): Flow<DataState<ProductModelData>>
}