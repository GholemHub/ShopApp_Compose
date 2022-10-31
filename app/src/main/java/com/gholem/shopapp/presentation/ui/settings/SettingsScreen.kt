package com.gholem.shopapp.presentation.ui.market

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.gholem.shopapp.presentation.ui.settings.SettingsViewModel

@Composable
fun SettingsScreen() {
    val viewModel = hiltViewModel<SettingsViewModel>()

}