package dev.hossam.cryptocurrency.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.hossam.cryptocurrency.core.constant.Const
import dev.hossam.cryptocurrency.core.data.local.CryptocurrencyDatabase
import dev.hossam.cryptocurrency.feature_crypto_details.data.local.CryptoDetailsDao
import dev.hossam.cryptocurrency.feature_cryptocurrencies.data.local.CryptocurrencyDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): CryptocurrencyDatabase =
        Room.databaseBuilder(
            context = context,
            klass = CryptocurrencyDatabase::class.java,
            name = Const.RoomUtil.DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun provideCryptocurrencyDao(database: CryptocurrencyDatabase): CryptocurrencyDao {
        return database.cryptocurrencyDao()
    }

    @Provides
    @Singleton
    fun provideCryptoDetailsDao(database: CryptocurrencyDatabase): CryptoDetailsDao {
        return database.cryptoDetailsDao()
    }
}

