package com.gholem.shopapp.repository.storage

import com.gholem.shopapp.domain.model.ProductModel
import com.gholem.shopapp.repository.storage.dao.BasketDao
import com.gholem.shopapp.repository.storage.entity.BasketEntity
import javax.inject.Inject

class BasketStorageRepositoryImpl @Inject constructor(
    private val basketDao: BasketDao
) : BasketStorageRepository {
    override suspend fun insertItem(product: ProductModel) {
        basketDao.insertItem(BasketEntity.from(product))
    }

    override suspend fun getAll(): List<ProductModel> {
        val basketProducts = basketDao.getAll()

        return basketProducts.map { it.toModel() }
    }
}