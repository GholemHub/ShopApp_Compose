package com.gholem.shopapp.presentation.util.authentication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.gholem.shopapp.R

@Composable
fun ButtonToRegister(onClick: () -> Unit) {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Text(text = stringResource(id = R.string.button_register))
        Text(
            stringResource(id = R.string.sign_up),
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.clickable(onClick = onClick)
        )
    }
}