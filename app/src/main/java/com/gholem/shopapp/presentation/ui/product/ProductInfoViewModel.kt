package com.gholem.shopapp.presentation.ui.product

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gholem.shopapp.domain.model.ProductModel
import com.gholem.shopapp.domain.model.ProductModelData
import com.gholem.shopapp.presentation.ui.basket.domain.GetBasketListUseCase
import com.gholem.shopapp.presentation.ui.market.domain.FetchProductModelUseCase
import com.gholem.shopapp.presentation.ui.product.domain.DeleteItemFromBasketUseCase
import com.gholem.shopapp.presentation.ui.product.domain.InsertItemToBasketUseCase
import com.gholem.shopapp.repository.network.DataState
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@Module
@InstallIn(ViewModelComponent::class)
@HiltViewModel
class ProductInfoViewModel @Inject constructor(
    private val getProductListUseCase: FetchProductModelUseCase,
    private val insertItemToBasketUseCase: InsertItemToBasketUseCase,
    private var getBasketListUseCase: GetBasketListUseCase,
    private var deleteItemFromBasketUseCase: DeleteItemFromBasketUseCase
) : ViewModel() {

    var dataStateProductList: MutableState<DataState<ProductModelData>> =
        mutableStateOf(DataState.Loading)
    var dataBasketList = mutableListOf<ProductModel>()

    fun generateList() {
        viewModelScope.launch {
            getProductListUseCase.run(Unit).onEach {
                dataStateProductList.value = it
            }.launchIn(viewModelScope)
        }
    }

    fun getBasketList() {
        viewModelScope.launch {
            getBasketListUseCase.run(Unit).onEach {
                dataBasketList.add(it)
            }
        }
    }

    fun addProductToBasket(item: ProductModel) = viewModelScope.launch {
        insertItemToBasketUseCase.run(item)
    }

    fun deleteProductFromBasket(item: Int) = viewModelScope.launch {
        deleteItemFromBasketUseCase.run(item)
    }
}
