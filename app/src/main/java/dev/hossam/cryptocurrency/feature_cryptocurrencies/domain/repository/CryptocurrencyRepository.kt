package dev.hossam.cryptocurrency.feature_cryptocurrencies.domain.repository

import dev.hossam.cryptocurrency.core.data.util.Resource
import dev.hossam.cryptocurrency.feature_cryptocurrencies.data.dto.CryptocurrencyDTO
import kotlinx.coroutines.flow.Flow

interface CryptocurrencyRepository {

    fun getAllCryptocurrencies(): Flow<Resource<List<CryptocurrencyDTO>>>
}