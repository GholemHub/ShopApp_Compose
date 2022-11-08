package com.gholem.shopapp.presentation.ui.market

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.gholem.shopapp.domain.model.ProductModelData
import com.gholem.shopapp.presentation.util.market.MarketItem
import com.gholem.shopapp.repository.network.DataState

@Composable
fun MarketScreen(navController: NavHostController) {
    val viewModel = hiltViewModel<MarketViewModel>()
    val dataStateProductList = viewModel.dataStateProductList.value
    LaunchedEffect(true) {
        viewModel.genreList()
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        if (dataStateProductList is DataState.Success<ProductModelData>) {
            item {
                dataStateProductList.data.list.map {
                    MarketItem(it, navController)
                }
            }
        }
    }
}