package com.gholem.shopapp.arch.nav

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gholem.shopapp.presentation.features.RegistrationScreen
import com.gholem.shopapp.presentation.ui.market.BasketScreen
import com.gholem.shopapp.presentation.ui.market.MarketScreen
import com.gholem.shopapp.presentation.ui.market.SettingsScreen
import com.gholem.shopapp.presentation.util.authentication.AuthenticationScrean

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ScreenNavigation.Authentication.route
    ) {
        composable(route = ScreenNavigation.Authentication.route) {
            BackHandler(true) {}
            AuthenticationScrean(navController)
        }
        composable(route = ScreenNavigation.Registration.route) {

            RegistrationScreen(navController)
        }
        composable(route = ScreenNavigation.Market.route) {
            BackHandler(true) {}
            MarketScreen()
        }
        composable(route = ScreenNavigation.Basket.route) {
            BasketScreen()
        }
        composable(route = ScreenNavigation.Settings.route) {
            SettingsScreen()
        }
    }
}
