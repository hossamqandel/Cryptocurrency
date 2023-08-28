package dev.hossam.cryptocurrency.feature_cryptocurrencies.domain.model

import com.google.gson.annotations.SerializedName

data class Cryptocurrency(
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("type")
    val type: String
)
