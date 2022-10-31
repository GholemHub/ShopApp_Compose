package com.gholem.shopapp.presentation.util.authentication

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import com.gholem.shopapp.R
import com.gholem.shopapp.presentation.theme.Shapes


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
        Text("Login")

    }
}