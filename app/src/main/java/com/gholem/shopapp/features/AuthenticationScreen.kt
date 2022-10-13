package com.gholem.shopapp.features

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.gholem.shopapp.R
import com.gholem.shopapp.ui.theme.Shapes
import com.gholem.shopapp.ui.theme.ShopAppTheme


@Composable
fun AuthenticationScrean(
    navController: NavHostController
) {
    Column(
        modifier = Modifier.padding(dimensionResource(R.dimen.default_padding)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        HeaderText()
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_header_to_email)))
        EmailTextField()
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_email_to_password)))
        PasswordTextField()
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_password_to_btn_login)))
        ButtonLogin()
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_default)))
        ButtonToRegister(onClick = {
            navController.navigate(route = ScreenNavigation.Registration.route)
        })

    }
}

@Composable
fun ButtonToRegister(onClick: () -> Unit) {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Haven't an account?")
        Text(
            "Sign Up",
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.clickable(onClick = onClick)
        )
    }
}

@Composable
fun ButtonLogin() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(
            vertical = dimensionResource(R.dimen.btn_vertical_padding),
            horizontal = dimensionResource(R.dimen.btn_horizontal_padding)
        ),
        shape = Shapes.large
    ) {
        Text("Login")
    }
}

@Composable
fun HeaderText() {
    Text(
        text = "Welcome,",
        fontWeight = FontWeight.Bold,
        fontSize = dimensionResource(R.dimen.header_text_font_size_first).value.sp
    )
    Spacer(Modifier.height(dimensionResource(R.dimen.spacer_header_text)))
    Text(
        text = "Sign in to continue",
        fontWeight = FontWeight.Bold,
        fontSize = dimensionResource(R.dimen.header_text_font_size_second).value.sp,
        color = Color.LightGray
    )
}

@Composable
fun PasswordTextField() {
    var passwordText by remember { mutableStateOf("") }

    OutlinedTextField(
        value = passwordText,
        onValueChange = { passwordText = it },
        label = { Text(text = "Password") },
        singleLine = true,
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_round_vpn_key_24),
                    contentDescription = null
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Go
        ),
        keyboardActions = KeyboardActions(onGo = {
            Log.d("qwe3", "!@#")
        })
    )
}

@Composable
fun EmailTextField() {
    var emailText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = emailText, onValueChange = { emailText = it },
        label = { Text(text = "Title") },
        singleLine = true,
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email Icon"
                )
            }
        },

        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Go
        ),
        keyboardActions = KeyboardActions(onGo = {
            Log.d("qwe3", "!@#")
        })
    )
}

@Preview(showBackground = true)
@Composable
fun AuthenticationScreenPreview() {
    ShopAppTheme {
        AuthenticationScrean(navController = rememberNavController())

    }
}