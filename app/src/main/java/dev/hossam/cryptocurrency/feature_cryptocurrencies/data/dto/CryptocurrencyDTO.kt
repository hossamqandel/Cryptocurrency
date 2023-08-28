package dev.hossam.cryptocurrency.feature_cryptocurrencies.data.dto

data class CryptocurrencyDTO(
    val id: String,
    val cryptoName: String,
    val symbol: String,
    val isActive: Boolean,
)
