package com.gholem.shopapp.arch.usecase

interface UseCase<IN : Any, OUT : Any> {

    suspend fun run(input: IN): OUT
}
interface UseCaseTwoParameters<IN : Any, IN2 : Any, OUT : Any>{
    suspend fun BiConsumer(input1: IN, input2: IN2): OUT
}