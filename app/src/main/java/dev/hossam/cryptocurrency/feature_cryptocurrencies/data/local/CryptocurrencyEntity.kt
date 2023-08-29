package dev.hossam.cryptocurrency.feature_cryptocurrencies.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import dev.hossam.cryptocurrency.core.constant.Const

@Entity(tableName = Const.RoomUtil.Table.CRYPTOCURRENCY)
data class CryptocurrencyEntity(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: String,
    @SerializedName("cryptoName")
    val cryptoName: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("rank")
    val rank: Int
)
