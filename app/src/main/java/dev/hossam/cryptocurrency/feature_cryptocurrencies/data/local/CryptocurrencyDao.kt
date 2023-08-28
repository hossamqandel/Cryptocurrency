package dev.hossam.cryptocurrency.feature_cryptocurrencies.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.hossam.cryptocurrency.core.constant.Const

@Dao
interface CryptocurrencyDao {

    @Query("DELETE FROM ${Const.RoomUtil.Table.CRYPTOCURRENCY}")
    suspend fun deleteAllCryptocurrencies()

    @Insert
    suspend fun insertCryptocurrencies(cryptocurrencies: List<CryptocurrencyEntity>)

    @Query("SELECT * FROM ${Const.RoomUtil.Table.CRYPTOCURRENCY}")
    suspend fun getAllCryptocurrencies(): List<CryptocurrencyEntity>
}