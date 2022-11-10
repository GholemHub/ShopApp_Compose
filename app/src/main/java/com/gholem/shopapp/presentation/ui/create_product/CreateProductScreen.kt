package com.gholem.shopapp.presentation.ui.create_product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gholem.shopapp.R
import com.gholem.shopapp.arch.nav.ScreenNavigation
import com.gholem.shopapp.domain.model.ProductModel
import com.gholem.shopapp.presentation.theme.Shapes

@Composable
fun CreateProductScreen(
    navController: NavController
) {

    val viewModel = hiltViewModel<CreateProductViewModel>()

    LaunchedEffect(true) {
        viewModel.getProducts(null)
    }

    Column(
        modifier = Modifier
            .padding(dimensionResource(R.dimen.default_padding))
            .background(Color.Transparent),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var titleText by remember { mutableStateOf("") }
        TextField(
            value = titleText,
            onValueChange = { titleText = it },
            label = { Text(text = "Title") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Go
            ), modifier = Modifier.fillMaxWidth()
        )
        var categoryText by remember { mutableStateOf("") }
        TextField(
            value = categoryText,
            onValueChange = { categoryText = it },
            label = { Text(text = "Category") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Go
            ), modifier = Modifier.fillMaxWidth()
        )
        var priceText by remember { mutableStateOf("") }
        TextField(
            value = priceText,
            onValueChange = { priceText = it },
            label = { Text(text = "Price") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Go
            ), modifier = Modifier.fillMaxWidth()
        )
        var descriptionText by remember { mutableStateOf("") }
        TextField(
            value = descriptionText,
            onValueChange = { descriptionText = it },
            label = { Text(text = "Description") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Go
            ), modifier = Modifier.fillMaxWidth()
        )
        var imageLink by remember { mutableStateOf("") }
        TextField(
            value = imageLink,
            onValueChange = { imageLink = it },
            label = { Text(text = "Image link") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Go
            ), modifier = Modifier.fillMaxWidth()
        )
        ButtonLogin(onClick = {
            viewModel.getProducts(
                ProductModel(
                    System.currentTimeMillis().toInt(),
                    titleText,
                    imageLink,
                    priceText.toDouble(),
                    categoryText,
                    descriptionText
                )
            )
            navController.navigate(route = ScreenNavigation.Market.route)
        })
    }
}

@Composable
fun ButtonLogin(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(
            vertical = dimensionResource(R.dimen.btn_vertical_padding),
            horizontal = dimensionResource(R.dimen.btn_horizontal_padding)
        ),
        shape = Shapes.large
    ) {
        Text("Create")
    }
}