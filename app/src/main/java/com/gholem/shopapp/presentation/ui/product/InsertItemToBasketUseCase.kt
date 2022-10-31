package com.gholem.shopapp.presentation.ui.product

import com.gholem.shopapp.arch.usecase.UseCase
import com.gholem.shopapp.domain.model.ProductModel
import com.gholem.shopapp.domain.model.ProductModelData
import com.gholem.shopapp.repository.network.DataState
import com.gholem.shopapp.repository.network.ProductRepository
import com.gholem.shopapp.repository.storage.BasketStorageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InsertItemToBasketUseCase  @Inject constructor(
    private val basketStorageRepository: BasketStorageRepository
) : UseCase<ProductModel, Unit> {

    override suspend fun run(input: ProductModel){
        basketStorageRepository.insertItem(input)
    }
}
