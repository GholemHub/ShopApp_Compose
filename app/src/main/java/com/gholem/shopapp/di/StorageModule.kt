package com.gholem.shopapp.di

import android.content.Context
import androidx.room.Room
import com.gholem.shopapp.repository.storage.ShopAppDatabase
import com.gholem.shopapp.repository.storage.dao.BasketDao
import com.gholem.shopapp.repository.storage.dao.TemplateDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {

    private const val DATABASE_NAME = "shopapp-db"

    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): ShopAppDatabase =
        Room.databaseBuilder(
            context,
            ShopAppDatabase::class.java,
            DATABASE_NAME
        ).build()

    @Provides
    fun provideTemplateDao(database: ShopAppDatabase): TemplateDao =
        database.templateDao()

    @Provides
    fun provideBasketDao(database: ShopAppDatabase): BasketDao =
        database.basketDao()

}