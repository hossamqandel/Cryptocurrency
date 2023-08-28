package dev.hossam.cryptocurrency.core.constant

import dev.hossam.cryptocurrency.R

object Const {

    object WebUtil {
        const val BASE_URL = "https://api.coinpaprika.com"
        const val GET_ALL_CRYPTOCURRENCIES = "/v1/coins"
        const val GET_CRYPTOCURRENCY_DETAILS = "/v1/coins/{coinId}"
    }


    object RoomUtil {
        const val VERSION = 1
        const val DATABASE_NAME = "Cryptocurrency_Database"

        object Table {
            const val CRYPTOCURRENCY = "CryptocurrencyEntity"
        }
    }


    object PopMenu {
        val DESCENDING = R.id.item_descending
        val ASCENDING = R.id.item_ascending
    }
}