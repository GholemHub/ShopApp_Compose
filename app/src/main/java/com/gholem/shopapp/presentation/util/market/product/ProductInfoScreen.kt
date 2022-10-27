package com.gholem.shopapp.presentation.util.market.product

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.gholem.shopapp.R
import com.gholem.shopapp.domain.model.ProductModel
import com.gholem.shopapp.domain.model.ProductModelData
import com.gholem.shopapp.presentation.ui.market.viewmodel.ProductInfoViewModel
import com.gholem.shopapp.presentation.util.market.RoundImage
import com.gholem.shopapp.repository.network.DataState

@Composable
fun ProductInfoScreen(id: Int) {

    val viewModel = hiltViewModel<ProductInfoViewModel>()
    var productModel: ProductModel
    val dataStateProductList = viewModel.dataStateProductList.value
    LaunchedEffect(true) {
        viewModel.genreList()
    }

    if (dataStateProductList is DataState.Success<ProductModelData>) {
        productModel = dataStateProductList.data.list.first { it.id == id }
        Row(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.default_padding))
                .fillMaxSize()
                .background(Color.LightGray)
                .clickable {

                },

            horizontalArrangement = Arrangement.End,
        ) {
            Column(
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.default_padding))
                    .weight(3f)
                    .background(Color.Transparent),

                verticalArrangement = Arrangement.Top,
            ) {
                Row {
                    RoundImage(
                        productModel.image,
                        Modifier.size(dimensionResource(R.dimen.size_rounded_photo))
                    )
                    Text(text = productModel.name, color = Color.Black)
                }
                Text(
                    text = "Category: ${productModel.category}",
                    modifier = Modifier.padding(start = dimensionResource(R.dimen.default_padding)),
                    color = Color.Black
                )
                Text(
                    text = "\$: ${productModel.price}",
                    modifier = Modifier.padding(dimensionResource(R.dimen.default_padding)),
                    fontWeight = FontWeight.Bold,
                    fontSize = dimensionResource(R.dimen.price_text_font_size_first).value.sp,
                    color = Color.Blue
                )

                Text(
                    text = "Description: ${productModel.description}",
                    modifier = Modifier.padding(start = dimensionResource(R.dimen.default_padding)),
                    color = Color.Black
                )
            }

            Image(
                painter = rememberAsyncImagePainter(productModel.image),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .size(dimensionResource(R.dimen.spacer_header_to_email))
                    .background(Color.White)
                    .border(
                        BorderStroke(
                            dimensionResource(R.dimen.btn_horizontal_padding),
                            Color.Black
                        )
                    ),
            )
        }
    }
}
