package com.gholem.shopapp.arch.usecase

interface UseCase<IN : Any, OUT : Any> {

    suspend fun run(input: IN): OUT
}