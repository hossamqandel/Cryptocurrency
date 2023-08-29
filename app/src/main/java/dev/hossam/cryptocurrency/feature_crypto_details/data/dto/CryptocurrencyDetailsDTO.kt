package dev.hossam.cryptocurrency.feature_crypto_details.data.dto

data class CryptocurrencyDetailsDTO(
    val id: String,
    val name: String,
    val symbol: String,
    val description: String,
    val isActive: Boolean,
    val logo: String,
    val tags: List<TagDTO>,
    val team: List<TeamDTO>
)

data class TagDTO(
    val id: String,
    val name: String
)

data class TeamDTO(
    val id: String,
    val name: String,
    val position: String
)
