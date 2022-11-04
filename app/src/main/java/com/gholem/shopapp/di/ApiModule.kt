package com.gholem.shopapp.di

import android.content.Context
import android.content.SharedPreferences
import com.gholem.shopapp.repository.network.api.ProductApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideProductApiFirebase(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("products", Context.MODE_PRIVATE)
    }


    @Singleton
    @Provides
    fun provideProductApi(retrofit: Retrofit): ProductApi =
        retrofit.create(ProductApi::class.java)
}