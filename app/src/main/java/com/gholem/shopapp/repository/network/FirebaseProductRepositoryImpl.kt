package com.gholem.shopapp.repository.network

import com.gholem.shopapp.domain.model.ProductModel
import com.gholem.shopapp.domain.model.ProductModelData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.StorageReference
import timber.log.Timber

class FirebaseProductRepositoryImpl(
    val database: FirebaseFirestore,
    val storageReference: StorageReference
) : FirebaseProductRepository{
    override fun getProducts(product: ProductModel?, result: (DataState<List<ProductModel>>) -> Unit) {
        database.collection("products")
            .get()
            .addOnSuccessListener {
                if (it.isEmpty) {
                    Timber.i("EMPTY@@${it}")
                } else {
                    val listOfProductModels = ArrayList<ProductModel>()

                    it.forEach { doc ->
                        val taskModel = doc.toObject(ProductModel::class.java)
                        listOfProductModels.add(taskModel)
                    }

                    result.invoke(
                        DataState.Success(listOfProductModels)
                    )
                    Timber.i("@@${listOfProductModels}")
                }
            }
            .addOnFailureListener {
            result.invoke(
                DataState.Error(
                    it
                )
            )
        }
    }

}