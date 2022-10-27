package com.gholem.shopapp.presentation.util.market

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.gholem.shopapp.R
import com.gholem.shopapp.domain.model.ProductModel

@Composable
fun MarketItem(productModel: ProductModel) {

    Row(
        modifier = Modifier
            .padding(dimensionResource(R.dimen.default_padding))
            .fillMaxSize()
            .background(Color.LightGray),

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
                    productModel.image, Modifier.size(dimensionResource(R.dimen.size_rounded_photo))
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
        }

        Image(
            painter = rememberAsyncImagePainter(productModel.image),
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
                .size(dimensionResource(R.dimen.spacer_header_to_email))
                .background(Color.White)
                .border(BorderStroke(dimensionResource(R.dimen.btn_horizontal_padding), Color.Black)),
        )
    }
}

@Composable
fun RoundImage(
    image: String, modifier: Modifier = Modifier
) {
    Image(
        painter = rememberAsyncImagePainter(image),
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = dimensionResource(R.dimen.padding_image), color = Color.LightGray, shape = CircleShape
            )

            .padding(dimensionResource(R.dimen.btn_horizontal_padding))
            .clip(CircleShape)
    )
}
