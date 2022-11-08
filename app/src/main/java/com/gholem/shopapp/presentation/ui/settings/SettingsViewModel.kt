package com.gholem.shopapp.presentation.ui.settings

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@Module
@InstallIn(ViewModelComponent::class)
@HiltViewModel
class SettingsViewModel @Inject constructor(
) : ViewModel() {

}
