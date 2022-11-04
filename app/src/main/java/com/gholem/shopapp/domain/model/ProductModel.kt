package com.gholem.shopapp.domain.model

data class ProductModel(
    val id: Int = 0,
    val name: String = "",
    val image: String = "",
    val price: Double = 0.0,
    val category: String = "",
    val description: String = "",
)