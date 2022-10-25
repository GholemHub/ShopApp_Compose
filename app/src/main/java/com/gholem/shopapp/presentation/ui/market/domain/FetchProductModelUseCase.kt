package com.gholem.shopapp.presentation.ui.market.domain

import com.gholem.shopapp.arch.usecase.UseCase
import com.gholem.shopapp.repository.network.DataState
import com.gholem.shopapp.repository.network.ProductRepository
import com.gholem.shopapp.repository.network.dto.product.ProductResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchProductModelUseCase @Inject constructor(
    private val productApiRepository: ProductRepository
) : UseCase<Unit, Flow<DataState<ProductResponse>>> {
    override suspend fun run(input: Unit): Flow<DataState<ProductResponse>> {

        return productApiRepository.genreList()
    }
}

