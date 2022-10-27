package com.gholem.shopapp.presentation.ui.market.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gholem.shopapp.domain.model.ProductModelData
import com.gholem.shopapp.presentation.ui.market.domain.FetchProductModelUseCase
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
    private val getProductListUseCase: FetchProductModelUseCase
) : ViewModel() {

    var dataStateProductList: MutableState<DataState<ProductModelData>> = mutableStateOf(DataState.Loading)

    fun genreList() {
        viewModelScope.launch {
            getProductListUseCase.run(Unit).onEach {
                dataStateProductList.value = it
            }.launchIn(viewModelScope)
        }
    }
}
