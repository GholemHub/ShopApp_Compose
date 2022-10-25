package com.gholem.shopapp.arch.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gholem.shopapp.presentation.features.AuthenticationScrean
import com.gholem.shopapp.presentation.features.RegistrationScreen
import com.gholem.shopapp.presentation.ui.market.MarketScreen

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
        composable(route = ScreenNavigation.Market.route) {
            MarketScreen()
        }
    }
}