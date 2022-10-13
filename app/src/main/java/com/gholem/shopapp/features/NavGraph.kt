package com.gholem.shopapp.features

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ScreenNavigation.Authentication.route
    ) {
        composable(route = ScreenNavigation.Authentication.route) {
            AuthenticationScrean(navController)
        }
        composable(route = ScreenNavigation.Registration.route) {
            RegistrationScreen(navController)
        }
    }
}