package com.gholem.shopapp.presentation.ui.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.gholem.shopapp.R
import com.gholem.shopapp.domain.model.ProductModel

@Composable
fun BasketImage(
    productModel: ProductModel,
    navController: NavHostController
) {
    Row(
        modifier = Modifier
            .padding(top = dimensionResource(R.dimen.spacer_default)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(productModel.image),
            contentDescription = null,
            modifier = Modifier
                .size(dimensionResource(R.dimen.spacer_header_to_email))
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .border(
                    width = dimensionResource(R.dimen.padding_image),
                    color = Color.LightGray,
                    shape = CircleShape
                )
                .padding(dimensionResource(R.dimen.btn_horizontal_padding))
                .clip(CircleShape)
                .background(Color.White)
        )
        Text(
            text = "Title: ${productModel.name}",
            modifier = Modifier.padding(start = dimensionResource(R.dimen.default_padding)),
            color = Color.Black
        )
    }
}