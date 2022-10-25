package com.gholem.shopapp.presentation.ui.market.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.gholem.shopapp.domain.model.ProductModel

@Composable
fun ButtonToRegister(productModel: ProductModel) {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Haven't an account? ")
        Text(
            "${productModel.name}",
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.SemiBold,

            )
    }
}