package dev.hossam.cryptocurrency.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.hossam.cryptocurrency.core.constant.Const
import dev.hossam.cryptocurrency.core.data.remote.CryptocurrencyService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WebServiceModule {

    @Provides
    @Singleton
    fun provideRetrofit(): CryptocurrencyService = Retrofit.Builder()
        .baseUrl(Const.WebUtil.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CryptocurrencyService::class.java)
}