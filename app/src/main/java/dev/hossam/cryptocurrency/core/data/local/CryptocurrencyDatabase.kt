package dev.hossam.cryptocurrency.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.hossam.cryptocurrency.core.constant.Const
import dev.hossam.cryptocurrency.feature_cryptocurrencies.data.local.CryptocurrencyDao
import dev.hossam.cryptocurrency.feature_cryptocurrencies.data.local.CryptocurrencyEntity

@Database(entities = [CryptocurrencyEntity::class], exportSchema = false, version = Const.RoomUtil.VERSION)
abstract class CryptocurrencyDatabase : RoomDatabase() {

    abstract fun cryptocurrencyDao(): CryptocurrencyDao

}