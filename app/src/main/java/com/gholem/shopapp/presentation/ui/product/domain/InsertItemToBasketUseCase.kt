package com.gholem.shopapp.presentation.ui.product.domain

import com.gholem.shopapp.arch.usecase.UseCase
import com.gholem.shopapp.domain.model.ProductModel
import com.gholem.shopapp.repository.storage.BasketStorageRepository
import javax.inject.Inject

class InsertItemToBasketUseCase @Inject constructor(
    private val basketStorageRepository: BasketStorageRepository
) : UseCase<ProductModel, Unit> {

    override suspend fun run(input: ProductModel) {
        basketStorageRepository.insertItem(input)
    }
}
