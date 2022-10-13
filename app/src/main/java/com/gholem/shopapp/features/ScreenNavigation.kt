package com.gholem.shopapp.features

sealed class ScreenNavigation(val route: String){
    object Authentication: ScreenNavigation(route = "authentication_screen")
    object Registration: ScreenNavigation(route = "registration_screen")
}
