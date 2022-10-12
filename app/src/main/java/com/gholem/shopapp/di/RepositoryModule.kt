package com.gholem.shopapp.di

import com.gholem.shopapp.repository.storage.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindTemplateStorageRepository(templateStorageRepositoryImpl: TemplateStorageRepositoryImpl): TemplateStorageRepository
}