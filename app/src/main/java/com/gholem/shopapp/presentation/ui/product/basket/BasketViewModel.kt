package com.gholem.shopapp.presentation.ui.product.basket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gholem.shopapp.domain.model.ProductModel
import com.gholem.shopapp.presentation.ui.product.basket.domain.GetBasketListUseCase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@Module
@InstallIn(ViewModelComponent::class)
@HiltViewModel
class BasketViewModel @Inject constructor(
    private var getBasketListUseCase: GetBasketListUseCase
) : ViewModel() {

    var dataBasketList = mutableListOf<ProductModel>()

    fun generateList() {
        viewModelScope.launch {
            getBasketListUseCase.run(Unit).onEach {
                dataBasketList.add(it)
            }
        }
    }
}
