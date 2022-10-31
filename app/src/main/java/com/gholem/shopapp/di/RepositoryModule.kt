package com.gholem.shopapp.di

import com.gholem.shopapp.repository.storage.BasketStorageRepository
import com.gholem.shopapp.repository.storage.BasketStorageRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindBasketStorageRepository(basketStorageRepositoryImpl: BasketStorageRepositoryImpl) : BasketStorageRepository
}