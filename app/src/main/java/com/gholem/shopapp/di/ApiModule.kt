package com.gholem.shopapp.di

import com.gholem.shopapp.common.IsFake
import com.gholem.shopapp.repository.network.TemplateApiRepository
import com.gholem.shopapp.repository.network.api.TemplateApi
import com.gholem.shopapp.repository.network.fake.TemplateApiFakeRepository
import com.gholem.shopapp.repository.network.real.TemplateApiNetworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @IsFake
    fun provideIsFake() = false

    @Singleton
    @Provides
    fun provideTemplateApi(retrofit: Retrofit): TemplateApi =
        retrofit.create(TemplateApi::class.java)

    @Singleton
    @Provides
    fun provideTemplateApiRepository(
        @IsFake isFake: Boolean,
        templateApi: TemplateApi
    ): TemplateApiRepository =
        if (isFake) {
            TemplateApiFakeRepository()
        } else {
            TemplateApiNetworkRepository(templateApi)
        }
}