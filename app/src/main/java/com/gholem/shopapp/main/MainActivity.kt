package com.gholem.shopapp.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.gholem.shopapp.features.SetupNavGraph
import com.gholem.shopapp.ui.theme.ShopAppTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShopAppTheme {
                navController = rememberNavController()
                SetupNavGraph(navController)
            }
        }
    }
}