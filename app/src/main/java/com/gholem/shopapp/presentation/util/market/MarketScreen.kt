package com.gholem.shopapp.presentation.ui.market

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.gholem.shopapp.repository.network.DataState
import com.gholem.shopapp.presentation.ui.market.viewmodel.MarketViewModel
import com.gholem.shopapp.repository.network.dto.product.ProductResponse
import timber.log.Timber.i

@Composable
fun MarketScreen() {
    val viewModel = hiltViewModel<MarketViewModel>()
    val genres = viewModel.genres.value
    LaunchedEffect(true) {
        viewModel.genreList()
    }

    i("MarketScreen @@ ${viewModel.genres.value}")

    LazyColumn (modifier = Modifier.fillMaxSize()){
        if (genres is DataState.Success<ProductResponse>) {
            item {
                genres.data.data.forEach { item ->
                    Text(text = item.name)
                }
            }
        }
    }
}