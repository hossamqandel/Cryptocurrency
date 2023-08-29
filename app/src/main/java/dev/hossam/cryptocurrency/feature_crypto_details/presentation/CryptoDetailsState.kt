package dev.hossam.cryptocurrency.feature_crypto_details.presentation

import dev.hossam.cryptocurrency.feature_crypto_details.data.dto.TagDTO
import dev.hossam.cryptocurrency.feature_crypto_details.data.dto.TeamDTO
import java.util.Collections

data class CryptoDetailsState(
    val isLoading: Boolean = false,
    val name: String = "",
    val symbol: String = "",
    val description: String = "",
    val isActive: Boolean = false,
    val tags: List<TagDTO> = Collections.emptyList(),
    val team: List<TeamDTO> = Collections.emptyList(),
)
