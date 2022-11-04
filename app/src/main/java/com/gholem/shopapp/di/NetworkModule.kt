package com.gholem.shopapp.di

import com.gholem.shopapp.repository.network.FirebaseProductRepository
import com.gholem.shopapp.repository.network.FirebaseProductRepositoryImpl
import com.gholem.shopapp.repository.network.ProductRepository
import com.gholem.shopapp.repository.network.api.ProductApi
import com.gholem.shopapp.repository.network.real.ProductNetworkRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.StorageReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideProductRepositoryFirebase(
        database: FirebaseFirestore,
        storageReference: StorageReference
    ): FirebaseProductRepository {
        return FirebaseProductRepositoryImpl(database,storageReference)
    }

    private const val BASE_URL = "https://fakestoreapi.com"

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

    @Singleton
    @Provides
    fun provideProductRepository(
        productApi: ProductApi,
    ): ProductRepository {
        return ProductNetworkRepository(
            productApi
        )
    }
}
