package com.gholem.shopapp.presentation.util.authentication

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gholem.shopapp.R
import com.gholem.shopapp.arch.nav.ScreenNavigation

@Preview
@Composable
fun AuthenticationScreanPreview() {
    AuthenticationScrean(rememberNavController())
}

@Composable
fun AuthenticationScrean(
    navController: NavController
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
        ButtonLogin(onClick = {
            navController.navigate(route = ScreenNavigation.Registration.route)
        })
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_default)))
        ButtonToRegister(onClick = {
            navController.navigate(route = ScreenNavigation.Market.route)
        })
    }
}
