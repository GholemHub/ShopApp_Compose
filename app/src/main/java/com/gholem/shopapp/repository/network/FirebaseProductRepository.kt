package com.gholem.shopapp.repository.network

import com.gholem.shopapp.domain.model.ProductModel

interface FirebaseProductRepository {
    fun getProducts(product: ProductModel?, result: (DataState<List<ProductModel>>) -> Unit)
}