package com.gholem.shopapp.repository.network.real

import com.gholem.shopapp.repository.network.DataState
import com.gholem.shopapp.repository.network.ProductRepository
import com.gholem.shopapp.repository.network.api.ProductApi
import com.gholem.shopapp.repository.network.dto.product.ProductResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductNetworkRepository @Inject constructor(
    private val productApi: ProductApi,

) : ProductRepository {

    override suspend fun genreList(): Flow<DataState<ProductResponse>> = flow {
        emit(DataState.Loading)
        try {
            val genreResult = productApi.getExchanges()
            emit(DataState.Success(genreResult))

        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}