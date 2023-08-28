package dev.hossam.cryptocurrency.feature_cryptocurrencies.presentation

sealed interface OrderBy {
    class Descending : OrderBy
    class Ascending : OrderBy
}