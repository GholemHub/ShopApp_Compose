package com.gholem.shopapp.domain.model

data class ProductModel (
        val name: String,
        val id: Int
    )
data class ProductModelData(
    val list: List<ProductModel>
)