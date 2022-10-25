package com.gholem.moneylab.arch.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.gholem.shopapp.presentation.ui.market.MarketScreen

abstract class BaseFragment<VM : ViewModel>() : Fragment() {

    private var viewBinding: ViewBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupNavigation()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {

            setContent {
                init()
                //MarketScreen(listOfProduct)
            }
        }
    }

    @Composable
    abstract fun InitView()
    abstract fun init()
    abstract fun setupNavigation()
}