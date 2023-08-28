package dev.hossam.cryptocurrency.feature_cryptocurrencies.data.mapper

import dev.hossam.cryptocurrency.feature_cryptocurrencies.data.dto.CryptocurrencyDTO
import dev.hossam.cryptocurrency.feature_cryptocurrencies.data.local.CryptocurrencyEntity
import dev.hossam.cryptocurrency.feature_cryptocurrencies.domain.model.Cryptocurrency

fun List<Cryptocurrency>.toCryptocurrenciesDTO(): List<CryptocurrencyDTO> {
    return map { it.toCryptocurrencyDTO() }
}

fun List<CryptocurrencyDTO>.toCryptocurrenciesEntity(): List<CryptocurrencyEntity> {
    return map { it.toCryptocurrencyEntity() }
}

fun List<CryptocurrencyEntity>.toCryptocurrenciesDTO(): List<CryptocurrencyDTO> {
    return map { it.toCryptocurrencyDTO() }
}


fun CryptocurrencyDTO.toCryptocurrencyEntity(): CryptocurrencyEntity {
    return CryptocurrencyEntity(
        id = id,
        cryptoName = cryptoName,
        symbol = symbol,
        isActive = isActive
    )
}

fun CryptocurrencyEntity.toCryptocurrencyDTO(): CryptocurrencyDTO {
    return CryptocurrencyDTO(
        id = id,
        cryptoName = cryptoName,
        symbol = symbol,
        isActive = isActive
    )
}

fun Cryptocurrency.toCryptocurrencyDTO(): CryptocurrencyDTO {
    return CryptocurrencyDTO(
        id = id,
        cryptoName = name,
        symbol = symbol,
        isActive = isActive
    )
}