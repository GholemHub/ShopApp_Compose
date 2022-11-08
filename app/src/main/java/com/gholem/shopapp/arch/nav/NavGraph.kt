package com.gholem.shopapp.arch.nav

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.gholem.shopapp.presentation.features.RegistrationScreen
import com.gholem.shopapp.presentation.ui.market.BasketScreen
import com.gholem.shopapp.presentation.ui.market.MarketScreen
import com.gholem.shopapp.presentation.ui.market.SettingsScreen
import com.gholem.shopapp.presentation.util.authentication.AuthenticationScrean
import com.gholem.shopapp.presentation.util.market.product.ProductInfoScreen
import timber.log.Timber.i

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
        composable(
            route = ScreenNavigation.Market.route,
        ) {
            BackHandler(true) {}
            MarketScreen(navController)
        }

        composable(route = ScreenNavigation.Basket.route) {
            BasketScreen(navController)
        }
        composable(route = ScreenNavigation.Settings.route) {
            SettingsScreen()
        }
        composable(
            route = ScreenNavigation.ProductInfo.route,
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        ) {
            //i("THE ID @@ ${it.arguments?.getInt("id").toString()}")
            it.arguments?.let { it1 -> ProductInfoScreen(it1.getInt("id")) }
        }
    }
}