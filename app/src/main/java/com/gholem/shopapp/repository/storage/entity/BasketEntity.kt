package com.gholem.shopapp.repository.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gholem.shopapp.domain.model.ProductModel

@Entity(tableName = "basket_table")
class BasketEntity(
    val name: String,
    val image: String,
    val price: Double,
    val category: String,
    val description: String,
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
) {
    fun toModel(): ProductModel = ProductModel(
        id = id.toInt(),
        name = name,
        image = image,
        price = price,
        category = category,
        description = description,
    )

    companion object {

        fun from(productModel: ProductModel): BasketEntity =
            BasketEntity(
                id = productModel.id.toLong(),
                name = productModel.name,
                image = productModel.image,
                price = productModel.price,
                category = productModel.category,
                description = productModel.description,
            )
    }
}