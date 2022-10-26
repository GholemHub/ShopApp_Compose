package com.gholem.shopapp.repository.network.real

import com.gholem.shopapp.domain.model.ProductModel
import com.gholem.shopapp.domain.model.ProductModelData
import com.gholem.shopapp.repository.network.DataState
import com.gholem.shopapp.repository.network.ProductRepository
import com.gholem.shopapp.repository.network.api.ProductApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber.i
import javax.inject.Inject

class ProductNetworkRepository @Inject constructor(
    private val productApi: ProductApi,

    ) : ProductRepository {

    override suspend fun genreList(): Flow<DataState<ProductModelData>> = flow {
        emit(DataState.Loading)
        try {
            val genreResult = productApi.getExchanges()
            i("genreResult @@ ${genreResult}")
            val toModel =
                ProductModelData(genreResult.map{ ProductModel(it.title,it.id) })
            emit(DataState.Success(toModel))

        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}