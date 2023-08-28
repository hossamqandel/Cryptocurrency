package dev.hossam.cryptocurrency.feature_cryptocurrencies.presentation

import dev.hossam.cryptocurrency.feature_cryptocurrencies.data.dto.CryptocurrencyDTO
import java.util.Collections

data class CryptocurrencyState(
    val isLoading: Boolean = false,
    val cryptocurrencies: List<CryptocurrencyDTO> = Collections.emptyList(),
    val orderBy: OrderBy = OrderBy.Ascending
)
