package com.gholem.shopapp.arch.nav

sealed class ScreenNavigation(val route: String){
    object Authentication: ScreenNavigation(route = "authentication_screen")
    object Registration: ScreenNavigation(route = "registration_screen")
    object Market: ScreenNavigation(route = "market_screen")
}