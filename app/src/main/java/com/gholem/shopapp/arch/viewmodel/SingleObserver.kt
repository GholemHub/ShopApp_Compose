package com.gholem.shopapp.arch.viewmodel

import androidx.lifecycle.Observer

class SingleObserver<T>(
    private val onStateChanged: (T) -> Unit
) : Observer<SingleState<T>> {

    override fun onChanged(state: SingleState<T>?) {
        state?.getAndForget()?.let(onStateChanged)
    }
}