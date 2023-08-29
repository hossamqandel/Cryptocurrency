package dev.hossam.cryptocurrency.feature_crypto_details.data.mapper

import dev.hossam.cryptocurrency.feature_crypto_details.data.dto.CryptocurrencyDetailsDTO
import dev.hossam.cryptocurrency.feature_crypto_details.data.dto.TagDTO
import dev.hossam.cryptocurrency.feature_crypto_details.data.dto.TeamDTO
import dev.hossam.cryptocurrency.feature_crypto_details.domain.model.CryptocurrencyDetails

fun CryptocurrencyDetails.responseToCryptoDetailsDTO(): CryptocurrencyDetailsDTO {
    return CryptocurrencyDetailsDTO(
        id = id,
        name = name,
        symbol = symbol,
        description = description,
        isActive = isActive,
        logo = logo,
        tags = tags.map { TagDTO(it.id, it.name) },
        team = team.map { TeamDTO(it.id, it.name, it.position) }
    )
}
