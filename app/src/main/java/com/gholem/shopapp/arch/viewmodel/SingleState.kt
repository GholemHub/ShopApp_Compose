package com.gholem.shopapp.arch.viewmodel

class SingleState<out T>(
    private var state: T?
) {

    fun getAndForget(): T? = with(state) {
        this?.also {
            state = null
        }
    }
}