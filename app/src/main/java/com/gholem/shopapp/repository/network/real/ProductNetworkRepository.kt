package com.gholem.shopapp.repository.network.real

import com.gholem.shopapp.domain.model.ProductModel
import com.gholem.shopapp.domain.model.ProductModelData
import com.gholem.shopapp.repository.network.DataState
import com.gholem.shopapp.repository.network.ProductRepository
import com.gholem.shopapp.repository.network.api.ProductApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductNetworkRepository @Inject constructor(
    private val productApi: ProductApi,
) : ProductRepository {

    override suspend fun fetchListOfProducts(): Flow<DataState<ProductModelData>> = flow {
        emit(DataState.Loading)
        try {
            val listOfProductsFromAPI = productApi.getProductsFromAPI()
            val toModel =
                ProductModelData(listOfProductsFromAPI.map {
                    ProductModel(
                        it.id,
                        it.title,
                        it.image,
                        it.price,
                        it.category,
                        it.description,
                    )
                })
            emit(DataState.Success(toModel))

        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}