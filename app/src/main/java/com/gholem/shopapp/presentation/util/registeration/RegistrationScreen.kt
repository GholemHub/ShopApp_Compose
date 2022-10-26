package com.gholem.shopapp.presentation.features

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import com.gholem.shopapp.R
import com.gholem.shopapp.presentation.util.authentication.EmailTextField
import com.gholem.shopapp.presentation.util.authentication.PasswordTextField
import com.gholem.shopapp.presentation.util.registeration.ButtonRegister
import com.gholem.shopapp.presentation.util.registeration.PhoneTextField
import com.gholem.shopapp.presentation.util.registeration.RegistrationHeaderText

@Composable
fun RegistrationScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.padding(dimensionResource(R.dimen.default_padding)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        RegistrationHeaderText()
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