package dev.hossam.cryptocurrency.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dev.hossam.cryptocurrency.feature_cryptocurrencies.data.repository.CryptocurrencyRepositoryImpl
import dev.hossam.cryptocurrency.feature_cryptocurrencies.domain.repository.CryptocurrencyRepository

@Module
@InstallIn(ViewModelScoped::class)
interface RepositoryModule {

    @Provides
    @Binds
    fun provideCryptocurrencyRepository(
        repo: CryptocurrencyRepositoryImpl
    ): CryptocurrencyRepository
}