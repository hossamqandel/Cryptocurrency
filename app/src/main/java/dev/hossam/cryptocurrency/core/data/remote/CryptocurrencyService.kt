package dev.hossam.cryptocurrency.core.data.remote

import dev.hossam.cryptocurrency.core.constant.Const
import dev.hossam.cryptocurrency.feature_crypto_details.domain.model.CryptocurrencyDetails
import dev.hossam.cryptocurrency.feature_cryptocurrencies.domain.model.Cryptocurrency
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptocurrencyService {

    @GET(Const.WebUtil.GET_ALL_CRYPTOCURRENCIES)
    suspend fun getAllCryptocurrencies(): List<Cryptocurrency>

    @GET(Const.WebUtil.GET_CRYPTOCURRENCY_DETAILS)
    suspend fun getCryptoDetails(
        @Path("coinId") coinId: String
    ): CryptocurrencyDetails
}