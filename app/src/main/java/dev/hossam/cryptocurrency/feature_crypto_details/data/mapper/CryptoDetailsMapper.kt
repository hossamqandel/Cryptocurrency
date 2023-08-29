package dev.hossam.cryptocurrency.feature_crypto_details.data.mapper

import dev.hossam.cryptocurrency.feature_crypto_details.data.dto.CryptocurrencyDetailsDTO
import dev.hossam.cryptocurrency.feature_crypto_details.data.dto.TagDTO
import dev.hossam.cryptocurrency.feature_crypto_details.data.dto.TeamDTO
import dev.hossam.cryptocurrency.feature_crypto_details.data.local.CryptoDetailsEntity
import dev.hossam.cryptocurrency.feature_crypto_details.domain.model.CryptocurrencyDetails

fun CryptocurrencyDetails.responseToCryptoDetailsDTO(): CryptocurrencyDetailsDTO {
    return CryptocurrencyDetailsDTO(
        id = id,
        name = name,
        symbol = symbol,
        description = description,
        isActive = isActive,
        logo = logo,
        rank = rank,
        tags = tags.map { TagDTO(it.id, it.name) },
        team = team.map { TeamDTO(it.id, it.name, it.position) }
    )
}

fun CryptoDetailsEntity.toCryptoDetailsDTO(): CryptocurrencyDetailsDTO {
    return CryptocurrencyDetailsDTO(
        id,
        name,
        symbol,
        description,
        isActive,
        logo,
        rank,
        tags,
        team
    )
}

fun CryptocurrencyDetailsDTO.toCryptoDetailsEntity(): CryptoDetailsEntity {
    return CryptoDetailsEntity(
        id,
        name,
        symbol,
        description,
        isActive,
        logo,
        rank,
        tags,
        team
    )
}
