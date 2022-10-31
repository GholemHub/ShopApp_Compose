package com.gholem.shopapp.repository.storage

import android.provider.ContactsContract.Data
import com.gholem.shopapp.domain.model.ProductModel
import com.gholem.shopapp.repository.network.DataState
import kotlinx.coroutines.flow.Flow

interface BasketStorageRepository {
    suspend fun insertItem(product: ProductModel)
    suspend fun getAll(): List<ProductModel>
}