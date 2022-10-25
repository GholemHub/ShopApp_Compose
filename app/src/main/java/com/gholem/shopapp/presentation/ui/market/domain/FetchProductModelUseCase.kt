package com.gholem.shopapp.presentation.ui.market.domain

import com.gholem.shopapp.arch.usecase.UseCase
import com.gholem.shopapp.domain.model.ProductModel
import com.gholem.shopapp.domain.model.ProductModelData
import com.gholem.shopapp.repository.network.DataState
import com.gholem.shopapp.repository.network.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchProductModelUseCase @Inject constructor(
    private val productApiRepository: ProductRepository
) : UseCase<Unit, Flow<DataState<ProductModelData>>> {
    override suspend fun run(input: Unit): Flow<DataState<ProductModelData>> {

        return productApiRepository.genreList()
    }
}

