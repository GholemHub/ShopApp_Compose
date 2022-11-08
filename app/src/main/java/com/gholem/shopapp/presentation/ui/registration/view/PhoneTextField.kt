package com.gholem.shopapp.presentation.util.registration

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.gholem.shopapp.R

@Composable
fun PhoneTextField() {
    var phoneText by remember { mutableStateOf("") }

    OutlinedTextField(
        value = phoneText,
        onValueChange = { phoneText = it },
        label = { Text(text = stringResource(id = R.string.register)) },
        singleLine = true,
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Phone,
                    contentDescription = null
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Go
        ),
    )
}