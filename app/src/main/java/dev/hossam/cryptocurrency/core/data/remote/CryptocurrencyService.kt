package dev.hossam.cryptocurrency.core.data.remote

import dev.hossam.cryptocurrency.feature_cryptocurrencies.domain.model.Cryptocurrency
import retrofit2.http.GET

interface CryptocurrencyService {

    @GET
    suspend fun getAllCryptocurrencies(): List<Cryptocurrency>
}