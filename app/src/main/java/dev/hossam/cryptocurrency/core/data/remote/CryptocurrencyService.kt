package dev.hossam.cryptocurrency.core.data.remote

import dev.hossam.cryptocurrency.core.constant.Const
import dev.hossam.cryptocurrency.feature_cryptocurrencies.domain.model.Cryptocurrency
import retrofit2.http.GET

interface CryptocurrencyService {

    @GET(Const.WebUtil.GET_ALL_CRYPTOCURRENCIES)
    suspend fun getAllCryptocurrencies(): List<Cryptocurrency>
}