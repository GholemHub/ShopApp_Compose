package com.gholem.shopapp.domain.model

import androidx.annotation.DrawableRes

data class TransactionCategoryModel(
    val categoryName: String,
    @DrawableRes val image: Int,
    val id: Long? = null
)