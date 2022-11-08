package com.gholem.shopapp.repository.storage

import com.gholem.shopapp.domain.model.ProductModel

interface BasketStorageRepository {
    suspend fun insertItem(product: ProductModel)
    suspend fun getAll(): List<ProductModel>
    suspend fun deleteItem(item: Int)
}