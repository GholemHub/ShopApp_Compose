package com.gholem.shopapp.arch.nav

sealed class ScreenNavigation(val route: String){
    object Authentication: ScreenNavigation(route = "authentication_screen")
    object Registration: ScreenNavigation(route = "registration_screen")
    object Market: ScreenNavigation(route = "market_screen")
    object Settings: ScreenNavigation(route = "settings_screen")
    object Basket: ScreenNavigation(route = "basket_screen")
    object CreateProduct: ScreenNavigation(route = "create_product_screen")
    object ProductInfo: ScreenNavigation(route = "product_info_screen/{id}"){
        fun passId(id: Int): String{
            return "product_info_screen/$id"
        }
    }
}
