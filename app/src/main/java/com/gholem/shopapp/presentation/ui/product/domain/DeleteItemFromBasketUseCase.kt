package com.gholem.shopapp.presentation.ui.product.domain

import com.gholem.shopapp.arch.usecase.UseCase
import com.gholem.shopapp.repository.storage.BasketStorageRepository
import javax.inject.Inject

class DeleteItemFromBasketUseCase @Inject constructor(
    private val basketStorageRepository: BasketStorageRepository
) : UseCase<Int, Unit> {

    override suspend fun run(input: Int) {
        basketStorageRepository.deleteItem(input)
    }
}