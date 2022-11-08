package com.gholem.shopapp.presentation.util.registration

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.gholem.shopapp.R
import com.gholem.shopapp.presentation.theme.Shapes


@Composable
fun ButtonRegister() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(
            vertical = dimensionResource(R.dimen.btn_vertical_padding),
            horizontal = dimensionResource(R.dimen.btn_horizontal_padding)
        ),
        shape = Shapes.large
    ) {
        Text(stringResource(id = R.string.register))
    }
}