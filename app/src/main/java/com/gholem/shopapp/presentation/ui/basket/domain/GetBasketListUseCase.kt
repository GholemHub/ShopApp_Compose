package com.gholem.shopapp.presentation.ui.basket.domain

import com.gholem.shopapp.arch.usecase.UseCase
import com.gholem.shopapp.domain.model.ProductModel
import com.gholem.shopapp.domain.model.ProductModelData
import com.gholem.shopapp.repository.network.DataState
import com.gholem.shopapp.repository.storage.BasketStorageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBasketListUseCase @Inject constructor(
    private val repository: BasketStorageRepository
) : UseCase<Unit, List<ProductModel>> {

    override suspend fun run(input: Unit): List<ProductModel> = repository.getAll()
}