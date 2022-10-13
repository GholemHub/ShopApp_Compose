package com.gholem.shopapp.features

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.gholem.shopapp.R
import com.gholem.shopapp.ui.theme.Shapes

@Composable
fun RegistrationScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.padding(dimensionResource(R.dimen.default_padding)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        RegisterationHeaderText()
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_header_to_email)))
        EmailTextField()
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_email_to_password)))
        PhoneTextField()
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_email_to_password)))
        PasswordTextField()
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_password_to_btn_login)))
        ButtonRegister()
    }
}

@Composable
fun RegisterationHeaderText() {
    Text(
        text = "Welcome,",
        fontWeight = FontWeight.Bold,
        fontSize = dimensionResource(R.dimen.header_text_font_size_first).value.sp
    )
    Spacer(Modifier.height(dimensionResource(R.dimen.spacer_header_text)))
    Text(
        text = "Please signup",
        fontWeight = FontWeight.Bold,
        fontSize = dimensionResource(R.dimen.header_text_font_size_second).value.sp,
        color = Color.LightGray
    )
}

@Composable
fun PhoneTextField() {
    var phoneText by remember { mutableStateOf("") }

    OutlinedTextField(
        value = phoneText,
        onValueChange = { phoneText = it },
        label = { Text(text = "Phone") },
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
        Text("Register")
    }
}

@Composable
@Preview(showBackground = true)
fun RegistrationScreenPreview() {
    RegistrationScreen(rememberNavController())
}