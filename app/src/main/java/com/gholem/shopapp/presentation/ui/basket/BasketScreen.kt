package com.gholem.shopapp.presentation.ui.market

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.gholem.shopapp.presentation.ui.basket.BasketImage
import com.gholem.shopapp.presentation.ui.basket.BasketViewModel

@Composable
fun BasketScreen(navController: NavHostController) {
    val viewModel = hiltViewModel<BasketViewModel>()

    val dataStateBasketList = viewModel.dataBasketList
    LaunchedEffect(true) {
        viewModel.generateList()
    }
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            dataStateBasketList.map {
                BasketImage(it, navController)
            }
        }
    }
}