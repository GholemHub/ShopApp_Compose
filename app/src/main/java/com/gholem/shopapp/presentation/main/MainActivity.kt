package com.gholem.shopapp.presentation.main

import android.annotation.SuppressLint
import android.graphics.drawable.VectorDrawable
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.gholem.shopapp.R
import com.gholem.shopapp.arch.nav.*
import com.gholem.shopapp.presentation.theme.ShopAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var navController: NavHostController
    private val viewModel: MainActivityViewModel by viewModels()

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        installSplashScreen().apply {
            setKeepOnScreenCondition { viewModel.isLoading.value }
        }
        setContent {
            ShopAppTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()

                navController = rememberNavController()
                SetupNavGraph(navController)


                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        AppBar(onNavigationClick = {
                            scope.launch { scaffoldState.drawerState.open() }
                        })
                    },
                    //drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                                MenuItem(
                                    id = "market",
                                    title = "Market",
                                    icon = painterResource(id = R.drawable.ic_baseline_shopping_cart_24)
                                ),
                                MenuItem(
                                    id = "settings",
                                    title = "Settings",
                                    icon = painterResource(id = R.drawable.ic_baseline_settings_24)
                                ),
                                MenuItem(
                                    id = "basket",
                                    title = "Basket",
                                    icon = painterResource(id = R.drawable.ic_baseline_shopping_basket_24)
                                )
                            ), onItemClick = {
                                when(it.id){
                                    "market" -> navController.navigate(route = ScreenNavigation.Market.route)
                                    "settings" -> navController.navigate(route = ScreenNavigation.Settings.route)
                                    "basket" -> navController.navigate(route = ScreenNavigation.Basket.route)
                                }
                                scope.launch { scaffoldState.drawerState.close() }
                                println("Clicked on ${it.title}")
                            }
                        )
                    }

                ) {

                }
//
            }
        }
    }
}