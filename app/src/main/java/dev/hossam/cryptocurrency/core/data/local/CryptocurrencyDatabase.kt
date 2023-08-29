package dev.hossam.cryptocurrency.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.hossam.cryptocurrency.core.constant.Const
import dev.hossam.cryptocurrency.feature_crypto_details.data.local.CryptoDetailsDao
import dev.hossam.cryptocurrency.feature_crypto_details.data.local.CryptoDetailsEntity
import dev.hossam.cryptocurrency.feature_crypto_details.data.local.TagConverter
import dev.hossam.cryptocurrency.feature_crypto_details.data.local.TeamConverter
import dev.hossam.cryptocurrency.feature_cryptocurrencies.data.local.CryptocurrencyDao
import dev.hossam.cryptocurrency.feature_cryptocurrencies.data.local.CryptocurrencyEntity

@Database(entities = [CryptocurrencyEntity::class, CryptoDetailsEntity::class], exportSchema = false, version = Const.RoomUtil.VERSION)
@TypeConverters(TagConverter::class, TeamConverter::class)
abstract class CryptocurrencyDatabase : RoomDatabase() {

    abstract fun cryptocurrencyDao(): CryptocurrencyDao
    abstract fun cryptoDetailsDao(): CryptoDetailsDao

}