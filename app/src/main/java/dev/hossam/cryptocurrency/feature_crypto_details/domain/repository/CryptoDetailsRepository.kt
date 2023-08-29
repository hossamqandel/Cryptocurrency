package dev.hossam.cryptocurrency.feature_crypto_details.domain.repository

import dev.hossam.cryptocurrency.core.data.util.Resource
import dev.hossam.cryptocurrency.feature_crypto_details.data.dto.CryptocurrencyDetailsDTO
import kotlinx.coroutines.flow.Flow

interface CryptoDetailsRepository {
    fun getCryptoDetailsById(id: String): Flow<Resource<CryptocurrencyDetailsDTO>>
}