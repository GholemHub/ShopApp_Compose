package com.gholem.shopapp.presentation.ui.create_product

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gholem.shopapp.domain.model.ProductModel
import com.gholem.shopapp.repository.network.DataState
import com.gholem.shopapp.repository.network.FirebaseProductRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@Module
@InstallIn(ViewModelComponent::class)
@HiltViewModel
class CreateProductViewModel @Inject constructor(
    private val getProvideProductRepository: FirebaseProductRepository
) : ViewModel() {

    var products: MutableState<DataState<List<ProductModel>>> =
        mutableStateOf(DataState.Loading)

    fun getProducts(product: ProductModel?) {
        viewModelScope.launch {
            products.value = DataState.Loading
            product?.let { getProvideProductRepository.addProduct(it) { products.value = it } }
        }
    }
}