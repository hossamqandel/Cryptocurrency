package dev.hossam.cryptocurrency.feature_cryptocurrencies.presentation

sealed interface OrderBy {
    object Descending : OrderBy
    object Ascending : OrderBy
}