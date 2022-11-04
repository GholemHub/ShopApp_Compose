package com.gholem.shopapp.presentation.util.registration

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.gholem.shopapp.R

@Composable
fun RegistrationHeaderText() {
    Text(
        text = stringResource(id = R.string.welcome),
        fontWeight = FontWeight.Bold,
        fontSize = dimensionResource(R.dimen.header_text_font_size_first).value.sp
    )
    Spacer(Modifier.height(dimensionResource(R.dimen.spacer_header_text)))
    Text(
        text = stringResource(id = R.string.please_signup),
        fontWeight = FontWeight.Bold,
        fontSize = dimensionResource(R.dimen.header_text_font_size_second).value.sp,
        color = Color.LightGray
    )
}