package dev.hossam.cryptocurrency.feature_crypto_details.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CryptoDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCrypto(cryptoDetailsEntity: CryptoDetailsEntity)

    @Query("SELECT * FROM CryptoDetailsEntity WHERE id= :id")
    suspend fun getCryptoDetails(id: String): CryptoDetailsEntity?

}